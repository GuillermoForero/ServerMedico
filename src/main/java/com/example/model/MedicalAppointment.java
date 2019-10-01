package com.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicalAppointment {

	@Id
	private String idMedicalAppointment;
	
	@Column(name="next_date")
	private Date nextDate;
	
	@ManyToOne
	@JoinColumn(name = "code")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Patient patient;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getIdMedicalAppointment() {
		return idMedicalAppointment;
	}

	public void setIdMedicalAppointment(String idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}

	public Date getDate() {
		return nextDate;
	}

	public void setDate(Date date) {
		this.nextDate = date;
	}
	
	
	
	
	
	
	
	
}
