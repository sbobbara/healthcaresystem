package com.cg.health.dto;

import java.util.Date;

public class Appointment {
	private Long appointmentId; 
	private Date datetime; 
	private boolean approved;
	
	public Appointment(Long appointmentId, Date datetime, boolean approved) {
		super();
		this.appointmentId = appointmentId;
		this.datetime = datetime;
		this.approved = approved;
	}
	public Appointment() {
		
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public boolean getApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", datetime=" + datetime + ", approved=" + approved
				+ "]";
	}
		
}
