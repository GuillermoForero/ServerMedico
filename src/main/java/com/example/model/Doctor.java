package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="speciality", length = 100)
	private String speciality;
	
	@Column(name="yearsOfExperience")
	private Float yearsOfExperience;
	
	@Column(name="consultingRoom", length = 100)
	private String consultingRoom;
	
	@Column(name="home")
	private Boolean home;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Float getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getConsultingRoom() {
		return consultingRoom;
	}
	public void setConsultingRoom(String consultingRoom) {
		this.consultingRoom = consultingRoom;
	}
	public Boolean getHome() {
		return home;
	}
	public void setHome(Boolean home) {
		this.home = home;
	}
	
	
	
	
	
	 
}
