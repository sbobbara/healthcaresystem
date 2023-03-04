package com.cg.health.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.health.dto.Appointment;
import com.cg.health.dto.DiagnosticDetails;
import com.cg.health.dto.Test;
import com.cg.health.dto.User;
import com.cg.health.entity.AppointmentDetails;
import com.cg.health.entity.Diagnostic;
import com.cg.health.entity.TestDetails;
import com.cg.health.entity.UserDetails;

@Component
public class DiagnosticUtil {

	public static DiagnosticDetails toDetails(Diagnostic diagnostic) {
		DiagnosticDetails details = null;
		details = new DiagnosticDetails(diagnostic.getCentreId(), diagnostic.getCentreName());
		return details;
	}

	public List<DiagnosticDetails> toDetails(List<Diagnostic> diaList) {
		List<DiagnosticDetails> details = new ArrayList<>();
		for(Diagnostic diagnostic : diaList) {
			DiagnosticDetails dd = toDetails(diagnostic);
			details.add(dd);
		}
		return details;
	}

	public User toDetails1(UserDetails ud) {
		User user = null;
		user = new User(ud.getUserId(),ud.getUseremail(),
				ud.getPassword(),ud.getUsername(),
				ud.getContactNo(),ud.getGender(),ud.getAge(),ud.getRole());

		return user;
	}

	public Appointment toDetails2(AppointmentDetails ad) {
		Appointment appointment = null;
		appointment = new Appointment(ad.getAppointmentId(),
				ad.getDatetime(),ad.getApproved());
		return appointment;
	}
	public static AppointmentDetails toDetails3(AppointmentDetails appointment) {
		AppointmentDetails appointment2 = null;
		appointment2 = new AppointmentDetails(appointment.getAppointmentId(),
				       appointment.getDatetime(),
				       appointment.getApproved());
		return appointment2;
	}

//	public Test toDetails(TestDetails tes) {
//		Test test = null;
//		test = new Test(tes.getTestId(),tes.getTestName());
//			return test;
//	}

}
