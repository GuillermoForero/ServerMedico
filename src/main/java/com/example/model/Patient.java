package com.example.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient {

	@Id
	@Column(name="id_patient")
	private String id;
	
	@Column(name="name_patient")
	private String name;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="isTreatment")
	private Boolean isTreatment;
	
	@Column(name="moderatingFeeValue")
	private Double moderatingFeeValue;
	
	@Column(name="nextDate")
	private Date nextDate;
	
	private String codeDoctor;

	@ManyToOne
	@JoinColumn(name = "code")
	private Doctor doctor;
	
	
	public String getCodeDoctor() {
		return codeDoctor;
	}

	public void setCodeDoctor(String codeDoctor) {
		this.codeDoctor = codeDoctor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getIsTreatment() {
		return isTreatment;
	}

	public void setIsTreatment(Boolean isTreatment) {
		this.isTreatment = isTreatment;
	}

	public Double getModeratingFeeValue() {
		return moderatingFeeValue;
	}

	public void setModeratingFeeValue(Double moderatingFeeValue) {
		this.moderatingFeeValue = moderatingFeeValue;
	}

	public Date getNextDate() {
		return nextDate;
	}

	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
}
