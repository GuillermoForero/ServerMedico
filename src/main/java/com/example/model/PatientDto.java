package com.example.model;

import java.sql.Date;

public class PatientDto {
	
	private String idDto;
	
	
	private String nameDto;
	
	
	private String lastnameDto;
	
	
	private Date birthdayDto;
	
	
	private Boolean isTreatmentDto;
	
	
	private Double moderatingFeeValueDto;
	
	private Date nextDateDto;
	
	private String codeDoctorDto;


	private Doctor doctorDto;


	public String getIdDto() {
		return idDto;
	}


	public void setIdDto(String idDto) {
		this.idDto = idDto;
	}


	public String getNameDto() {
		return nameDto;
	}


	public void setNameDto(String nameDto) {
		this.nameDto = nameDto;
	}


	public String getLastnameDto() {
		return lastnameDto;
	}


	public void setLastnameDto(String lastnameDto) {
		this.lastnameDto = lastnameDto;
	}


	public Date getBirthdayDto() {
		return birthdayDto;
	}


	public void setBirthdayDto(Date birthdayDto) {
		this.birthdayDto = birthdayDto;
	}


	public Boolean getIsTreatmentDto() {
		return isTreatmentDto;
	}


	public void setIsTreatmentDto(Boolean isTreatmentDto) {
		this.isTreatmentDto = isTreatmentDto;
	}


	public Double getModeratingFeeValueDto() {
		return moderatingFeeValueDto;
	}


	public void setModeratingFeeValueDto(Double moderatingFeeValueDto) {
		this.moderatingFeeValueDto = moderatingFeeValueDto;
	}


	public Date getNextDateDto() {
		return nextDateDto;
	}


	public void setNextDateDto(Date nextDateDto) {
		this.nextDateDto = nextDateDto;
	}


	public String getCodeDoctorDto() {
		return codeDoctorDto;
	}


	public void setCodeDoctorDto(String codeDoctorDto) {
		this.codeDoctorDto = codeDoctorDto;
	}


	public Doctor getDoctorDto() {
		return doctorDto;
	}


	public void setDoctorDto(Doctor doctorDto) {
		this.doctorDto = doctorDto;
	}
	
	

}
