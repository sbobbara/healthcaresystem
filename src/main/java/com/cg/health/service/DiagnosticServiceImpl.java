package com.cg.health.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.health.dao.AppointmentDao;
import com.cg.health.dao.DiagnosticDao;
import com.cg.health.dao.LoginDao;
import com.cg.health.dao.Logout;
import com.cg.health.dao.TestDao;
import com.cg.health.dto.Userlogin;
import com.cg.health.entity.AppointmentDetails;
import com.cg.health.entity.Diagnostic;
import com.cg.health.entity.TestDetails;
import com.cg.health.entity.UserDetails;
import com.cg.health.exception.AuthenticationFailedException;
import com.cg.health.exception.UserAlreadyExistsException;
import com.cg.health.exception.UserNotFoundException;


@Service
@Transactional
public class DiagnosticServiceImpl implements DiagnosticService {
	@Autowired
	private DiagnosticDao ddao;
	@Autowired
	private LoginDao lDao;
	@Autowired
	private Logout logDao;
	@Autowired
	private AppointmentDao appDao;
	@Autowired
	private TestDao testDao;
	
	private Logger logger = LoggerFactory.getLogger(DiagnosticServiceImpl.class);

	/**
	 * Adding diagnostic center by Admin
	 * @param diagnostic Center to be added
	 * @return center Name
	 */
	@Override
	public String add(Diagnostic diagnostic) {
		logger.info("Center_Id : "+diagnostic.getCentreId());
		Diagnostic dia = ddao.save(diagnostic);
		return diagnostic.getCentreName();
		//logger.error(diagnostic);
	}
	/**
	 * Deleting Diagnostic Centre by Admin
	 * @param Diagnostic center to be deleted
	 * @return Centre Name
	 */
	@Override
	public String Delete(Diagnostic userDetails) {
		Optional<Diagnostic> op = ddao.findById(userDetails.getCentreId());
		if(op.isPresent()) {
			ddao.delete(userDetails);
		}
		else {
			throw new UserNotFoundException("Centre was not available");
		}
		return userDetails.getCentreName();
		
		}
	/**
	 * Adding Test Details by admin
	 * @param Test to be Added.
	 * @return Test Name
	 */
	@Override
	public String add(TestDetails test) {
		TestDetails test1 = testDao.save(test);
		return test.getTestName();
	}
	
	/** 
	 * Deleting Test Details by Admin
	 * @param Test to be deleted
	 * @Return Test Id
	 */
	
	@Override
	public String Delete(TestDetails testdetails) {
		Optional<TestDetails> op = testDao.findById(testdetails.getTestId());
		if(op.isPresent()) {
			testDao.delete(testdetails);
		}
		else {
			throw new UserNotFoundException("Test is not in this center.");
		}
		return testdetails.getTestId();
		
	}

	/**
	 * Loging in 
	 * @param User details for log in
	 * @return Role (admin or customer)
	 */
	@Override
	public String login(Userlogin userLogin) throws AuthenticationFailedException {
		String name = "";
		Optional<UserDetails> op = lDao.findById(userLogin.getUserId());
        if(!op.isPresent()){
            throw new AuthenticationFailedException("No User found for userId="+userLogin.getUserId());
        }
		UserDetails ulogin = op.get();
		if(!userLogin.getPassword().equals(ulogin.getPassword())) {
            throw new AuthenticationFailedException("Authentification failed for userId="+userLogin.getUserId());
		}
		name = ulogin.getRole();
		return name;
	}
	
	/**
	 * Log out 
	 * @param User Details for log out
	 * @return User Id
	 */
	@Override
	public String logout(Userlogin userLogin) throws AuthenticationFailedException {
		String name = "";
		Optional<UserDetails> opl = logDao.findById(userLogin.getUserId());
		if(!opl.isPresent()) {
			throw new AuthenticationFailedException("No User found for userId="+userLogin.getUserId());
		}
		UserDetails ulogout = opl.get();
		if(!userLogin.getPassword().equals(ulogout.getPassword())) {
            throw new AuthenticationFailedException("Authentification failed for userId="+userLogin.getUserId());
		}
		name = ulogout.getUserId();
		return name;
	}
	/**
	 * Finding all the Diagonstic details
	 * @return List of Diagnostic details
	 */

	@Override
	public List<Diagnostic> findAll() {
		List<Diagnostic> diaList = ddao.findAll();
		return diaList;
	}
	/**
	 * Register the User
	 * @param User Details to register
	 * @return User details
	 */
	@Override
	public UserDetails register(UserDetails userdetails) {
		boolean exists=userdetails.getUserId()!=null && lDao.existsById(userdetails.getUserId());
        if(exists){
            throw new UserAlreadyExistsException("User already exists for id="+userdetails.getUserId());
        }
        userdetails = lDao.save(userdetails);
        //System.out.println("returning saved stud: " + userDetails);
        return userdetails;
	}
	/**
	 * Making Appointment for Customer
	 * @param Appointment details
	 * @return Appointment details
	 */
	@Override
	public AppointmentDetails makeAppointment(AppointmentDetails appointmentdetails) {
	boolean exist = appointmentdetails.getAppointmentId()!=null && appDao.existsById(appointmentdetails.getAppointmentId());
	if(exist) {
		throw new UserAlreadyExistsException("Appointment already exists for id="+appointmentdetails.getAppointmentId());
	}
	appointmentdetails = appDao.save(appointmentdetails);
	
		return appointmentdetails;
	}
	
	/**
	 * Finding Appointment deatils using Appointment Id
	 * @param Appointment Id
	 * @return Appointment
	 */
	@Override
	public AppointmentDetails findById(Long appointmentId) {
		System.out.println("Appointment id : "+ appointmentId);
		Optional<AppointmentDetails> optional = appDao.findById(appointmentId);
		if(!optional.isPresent()) {
			System.out.println("***error***");
			throw new UserNotFoundException("Appointment cannot found for id = "+ appointmentId);
			
		}
		AppointmentDetails appointment = optional.get();
		System.out.println("Appointmnet is : "+ appointment);
		
		return appointment ;
	}
}

	