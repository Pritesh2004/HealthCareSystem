package com.health.dto;

import java.util.Date;

public class AppointmentDto {
	
	private Long doctor_id;
	private Long user_id;
	private Date appointmentDate;
    private String appointmentTime;
    private Date bookingDate;
    private String reason;
    
	public AppointmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AppointmentDto(Long doctor_id, Long user_id, Date appointmentDate, String appointmentTime, Date bookingDate,
			String reason) {
		super();
		this.doctor_id = doctor_id;
		this.user_id = user_id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.bookingDate = bookingDate;
		this.reason = reason;
	}
	public Long getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
    
    

}
