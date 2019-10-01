package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.repository.IDoctorRepository;
import com.example.repository.IPatientRepository;

@Service
public class PatientServiceImp implements IPatientService{

	@Autowired
	private IPatientRepository repo;
	@Autowired
	private IDoctorRepository repoDoc;

	@Override
	public void createPatient(Patient patient, String codeDoctor) {
		List<Doctor> doctors= repoDoc.findAll();
		for(Doctor doctor: doctors) {
			if(doctor.getCode().equals(patient.getCodeDoctor())) {
				patient.setDoctor(doctor);
			}
		}
		repo.save(patient);
		
	}

	@Override
	public List<Patient> getPatients() {
		return repo.findAll();
	}

	@Override
	public void updatePatient(Patient patient) {
		repo.save(patient);
	}

	@Override
	public void deletePatient(String id) {
		repo.deleteById(id);
	}

	@Override
	public Patient getPatient(String id) {
		List<Patient> patients = repo.findAll();
		
		for(Patient patient: patients) {
			if(patient.getId().equals(id)) {
				return patient;
			}
		}
		return null;
	}


}
