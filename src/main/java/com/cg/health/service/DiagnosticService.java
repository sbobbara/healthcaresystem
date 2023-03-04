package com.cg.health.service;

import java.util.List;

import com.cg.health.dto.Userlogin;
import com.cg.health.entity.AppointmentDetails;
import com.cg.health.entity.Diagnostic;
import com.cg.health.entity.TestDetails;
import com.cg.health.entity.UserDetails;
import com.cg.health.exception.AuthenticationFailedException;


public interface DiagnosticService {
	
	/**
	 * Adding diagnostic center 
	 * @param diagnostic to be added.
	 * @return center Name
	 */
	
	String add(Diagnostic diagnostic);

	List<Diagnostic> findAll();

	UserDetails register(UserDetails userDetails);

	String login(Userlogin userLogin) throws AuthenticationFailedException;

    String logout(Userlogin userLogin) throws AuthenticationFailedException;

	AppointmentDetails makeAppointment(AppointmentDetails appointmentdetails);

	AppointmentDetails findById(Long appointmentId);

	//Diagnostic delete(Diagnostic diagnostic);

	String Delete(Diagnostic userDetails);

	//Test add(Test test);

	String add(TestDetails test);

	String Delete(TestDetails testdetails);
	

}
