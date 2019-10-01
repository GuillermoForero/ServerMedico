package com.example.service;

import java.util.List;

import com.example.model.MedicalAppointment;
import com.example.model.MedicalInString;

public interface IMedicalAppointmentService {

	public abstract void createMedicalAppointment(MedicalInString medicalInString);
	
	public abstract List<MedicalAppointment> getMedicalApointments();
	
	public abstract List<MedicalAppointment> getMedicalAppointmentsDoctor(String code);
	
	public abstract List<MedicalAppointment> getMedicalAppointmentsPatient(String id);
	
	public abstract void updateMedicalAppointment(MedicalInString medicalInString);
	
	public abstract void deleteMedicalAppointmentsDoctor(String code);

}
