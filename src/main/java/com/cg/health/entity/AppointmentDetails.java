package com.cg.health.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class AppointmentDetails {
	@Id
	private Long appointmentId; 
	private Date datetime; 
	private boolean approved;
	public AppointmentDetails() {
	}
	public AppointmentDetails(Long appointmentId, Date datetime, boolean approved) {
		super();
		this.appointmentId = appointmentId;
		this.datetime = datetime;
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "AppointmentDetails [appointmentId=" + appointmentId + ", datetime=" + datetime + ", approved="
				+ approved + "]";
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
	
	

}
