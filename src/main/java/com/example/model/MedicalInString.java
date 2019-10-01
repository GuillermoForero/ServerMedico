package com.example.model;

import java.sql.Date;



public class MedicalInString {

	
	private String idMedicalAppointment;
	
	
	private Date date;
	
	
	private String doctor;
	
	private String patient;

	public String getIdMedicalAppointment() {
		return idMedicalAppointment;
	}

	public void setIdMedicalAppointment(String idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	


}

