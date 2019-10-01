package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Doctor;
import com.example.repository.IDoctorRepository;

@Service
public class DoctorServiceImp implements IDoctorService{

	@Autowired
	private IDoctorRepository repo;
	
	
	@Override
	public void createDoctor(Doctor doctor) {
		repo.save(doctor);
		
	}

	@Override
	public List<Doctor> getDoctors() {
		return repo.findAll();
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		repo.save(doctor);
		
	}

	@Override
	public void deleteDoctor(String code) {
		repo.deleteById(code);
		
	}

	@Override
	public Doctor getDoctor(String code) {
		List<Doctor> doctors= repo.findAll();
		for(Doctor doctor: doctors) {
			if(doctor.getCode().equals(code)) {
				return doctor;
			}
		}
		return null;
	}


}
