package com.example.service;

import java.util.List;

import com.example.model.Patient;

public interface IPatientService {

public abstract void createPatient(Patient patient, String codeDoctor);
	
	public abstract List<Patient> getPatients();
	
	public abstract Patient getPatient(String id);
	
	public abstract void updatePatient(Patient patient);
	
	public abstract void deletePatient(String id);
}
