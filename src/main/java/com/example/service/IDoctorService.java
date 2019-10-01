package com.example.service;

import java.util.List;

import com.example.model.Doctor;

public interface IDoctorService {

	public abstract void createDoctor(Doctor doctor);
	
	public abstract List<Doctor> getDoctors();
	
	public abstract Doctor getDoctor(String code);
	
	public abstract void updateDoctor(Doctor doctor);
	
	public abstract void deleteDoctor(String code);
}
