package com.cg.health.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.health.dto.Appointment;
import com.cg.health.dto.CreateDiagnosticRequest;
import com.cg.health.dto.CreateTestRequest;
import com.cg.health.dto.CreateUserAppointment;
import com.cg.health.dto.CreateUserRequest;
import com.cg.health.dto.DiagnosticDetails;
import com.cg.health.dto.Test;
import com.cg.health.dto.User;
import com.cg.health.dto.Userlogin;
//import com.cg.health.dto.ViewAppointment;
import com.cg.health.entity.AppointmentDetails;
import com.cg.health.entity.Diagnostic;
import com.cg.health.entity.TestDetails;
import com.cg.health.entity.UserDetails;
import com.cg.health.exception.AuthenticationFailedException;
import com.cg.health.exception.NotLoggedInException;
import com.cg.health.exception.UserNotFoundException;
import com.cg.health.service.DiagnosticService;
import com.cg.health.util.DiagnosticUtil;

/** 
 * 
 * @author Teju
 *Mapping requestData into the defined the requestMethods.
 */
@RestController       
@RequestMapping("/healthcare")
public class DiagnosticController {
	@Autowired
	private DiagnosticService service;
	@Autowired
	private DiagnosticUtil diagnosticUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add_center")
	public String add(@RequestBody CreateDiagnosticRequest requestData,HttpServletRequest request) throws NotLoggedInException {
		System.out.println("received : "+ requestData);
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		System.out.println(userName);
		if(userName==null) {
			throw new NotLoggedInException("You have not logged in");
		}
		
		String role = (String) session.getAttribute("role");
		if(!role.equals("admin")) {
			throw new UserNotFoundException("You are not authorized to add the centre.");
		}
		
			//DiagonsticDetails diadetails = null;
		Diagnostic diagnostic = new Diagnostic(requestData.getCentreId(), 
				requestData.getCentreName());
		String dia = service.add(diagnostic);
		//diadetails = diagnosticUtil.toDetails(dia);
		return "Centre is Added.";
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add_test")
	public String add(@RequestBody CreateTestRequest requestData,HttpServletRequest request) throws NotLoggedInException {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if(userName==null) {
			throw new NotLoggedInException("You have not logged in");
		}
		
		String Role = (String) request.getSession().getAttribute("role");
		if(!Role.equals("admin")) {
			throw new UserNotFoundException("You are not authorized to add the centre.");
		}
		else {
		Test testdetails = null;
		TestDetails test = new TestDetails(requestData.getTestId(),requestData.getTestName());
		String tes = service.add(test);
		//testdetails = diagnosticUtil.toDetails(tes);
		return "Test is added.";
		}
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@DeleteMapping("/remove_test")
	public String Delete(@RequestBody TestDetails testdetails, HttpServletRequest request) throws NotLoggedInException {
		
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if(userName==null) {
			throw new NotLoggedInException("You have not logged in");
		}
		
		String Role = (String) request.getSession().getAttribute("role");
		if(!Role.equals("admin")) {
			throw new UserNotFoundException("You are not authorized to delete the test.");
		}
		else {
		HttpSession session = request.getSession();
		String role=service.Delete(testdetails);
		session.setAttribute("user", testdetails.getTestId());
		session.setAttribute("role", role);
		return "Test is Deleted and Test_Id is : " + role;
		}
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@DeleteMapping("/delete_center")
	public String Delete(@RequestBody Diagnostic userDetails, HttpServletRequest request) throws NotLoggedInException {
		
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if(userName==null) {
			throw new NotLoggedInException("You have not logged in");
		}
		
		String Role = (String) request.getSession().getAttribute("role");
		if(!Role.equals("admin")) {
			throw new UserNotFoundException("You are not authorized to delete the centre.");
		}
		else {
		HttpSession session = request.getSession();
		String role=service.Delete(userDetails);
		session.setAttribute("user", userDetails.getCentreId());
		session.setAttribute("role", role);
		return "Center is Deleted and Center_Id is :"+role;
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/view_appointment/{appointmentId}")
	public AppointmentDetails viewAppointment(@PathVariable("appointmentId") Long appointmentId, HttpServletRequest request) throws NotLoggedInException {
		System.out.println("Enter Appointment id: " + appointmentId);
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if(userName==null) {
			throw new NotLoggedInException("You have not logged in");
		}
		
		String Role = (String) request.getSession().getAttribute("role");
		if(!Role.equals("admin")) {
			throw new UserNotFoundException("You are not authorized to View the Appointment List.");
		}
		else {
		AppointmentDetails appointment = service.findById(appointmentId);
		AppointmentDetails details = DiagnosticUtil.toDetails3(appointment);
		System.out.println("Details of Booked Appointment :" + details);
		return details;
		}
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public User register(@RequestBody CreateUserRequest requestData) {
		User user = null;
		UserDetails userdetails = new UserDetails(requestData.getUserId(),requestData.getUseremail(),
				requestData.getPassword(),requestData.getUsername(),
				requestData.getContactNo(),requestData.getGender(),requestData.getAge(),requestData.getRole());
		UserDetails ud = service.register(userdetails);
		user = diagnosticUtil.toDetails1(ud);
		return user;
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/make_appointment")
	
	public Appointment makeAppointment(@RequestBody CreateUserAppointment requestData, HttpServletRequest request) throws NotLoggedInException {
		String userName = (String) request.getSession().getAttribute("user");
		System.out.println(userName);
		if(userName==null) {
			throw new NotLoggedInException("You have not logged in");
		}
		
		String Role = (String) request.getSession().getAttribute("role");
		if(!Role.equals("customer")) {
			throw new UserNotFoundException("You are not authorized to make the Appointment.");
		}
		else {
		Appointment appoint = null;
		AppointmentDetails appointmentdetails = new AppointmentDetails(requestData.getAppointmentId(),
				requestData.getDatetime(),requestData.getApproved());
		AppointmentDetails ad = service.makeAppointment(appointmentdetails);
		appoint = diagnosticUtil.toDetails2(ad);
		return appoint;
		}
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login")
	public String login(@RequestBody Userlogin userLogin, HttpServletRequest request) throws AuthenticationFailedException {
		HttpSession session = request.getSession();
		System.out.println(session);
		String role = service.login(userLogin);
		session.setAttribute("user", userLogin.getUserId());
		session.setAttribute("role", role);
		return "You have successfully logged in as : "+role;
	}
	
	@GetMapping("/Center_Details")
	public List<DiagnosticDetails> findAll() {
		List<Diagnostic> diaList = service.findAll();
		List<DiagnosticDetails> details = diagnosticUtil.toDetails(diaList);
		return details;
		}
	
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(@RequestBody Userlogin userLogin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String name = (String) attrNames.nextElement();
			System.out.println(name);
			String uName = (String) session.getAttribute(name);
			System.out.println(uName);
			if(uName.equals(userLogin.getUserId())) {
				System.out.println("invalidating session..."+uName);
				session.invalidate();
				return "You have successfully logged out "+userLogin.getUserId();
			}
		}
		return "You are not loged in.";
	}
	


}