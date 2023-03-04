package com.cg.health.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.health.dto.Userlogin;
import com.cg.health.entity.AppointmentDetails;
import com.cg.health.entity.Diagnostic;
import com.cg.health.entity.UserDetails;
import com.cg.health.exception.AuthenticationFailedException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(DiagnosticServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DiagnosticServiceTest {
	@Autowired
	private DiagnosticServiceImpl dService;
//	private 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}
    
	@Test
	void testAdd() {
		Diagnostic det = new Diagnostic("2345","Hospital");
		String centerName = dService.add(det);
		assertEquals("Hospital",centerName);
	}

	@Test
	void testDelete() {
		Diagnostic det = new Diagnostic("12345","Healthcare");
		String centerName = dService.Delete(det);
		assertEquals("Healthcare",centerName);
	}
	
	@Test
	void testLogin() throws AuthenticationFailedException {
		Userlogin userLogin = new Userlogin("1234","sandy1");
		String log = dService.login(userLogin);
		assertEquals("customer",log);
		
	}

	@Test
	void testLogout() throws AuthenticationFailedException {
		Userlogin userLogin = new Userlogin("1234","sandy1");
		String log = dService.logout(userLogin);
		assertEquals("1234",log);
	}

	@Test
	void testFindAll() {
		List<Diagnostic> dia = dService.findAll();
		assertEquals(2, dia.size());
	}

	@Test
	void testRegister() {
		UserDetails userdetails =new UserDetails("1235","keerthi@gmail.com",
				"keerthi1","Keerthi",6281229234L,"Female",
				"22","customer");
		UserDetails user = dService.register(userdetails);
		assertEquals(userdetails.getUsername(),user.getUsername());
	}

	@Test
	void testMakeAppointment() {
		AppointmentDetails appointmentdetails=new AppointmentDetails(2005L,
				 new Date(),true);
		AppointmentDetails appoint = dService.makeAppointment(appointmentdetails);
		assertEquals(appointmentdetails.getAppointmentId(), appoint.getAppointmentId());
		
	}

	@Test
	void testFindById() {
		Long appointmentId = 12L;
		AppointmentDetails details = dService.findById(appointmentId);
		assertEquals(appointmentId, details.getAppointmentId());
	}
}	
