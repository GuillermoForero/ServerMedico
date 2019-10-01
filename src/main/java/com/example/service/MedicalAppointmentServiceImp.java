package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Doctor;
import com.example.model.MedicalAppointment;
import com.example.model.MedicalInString;
import com.example.model.Patient;
import com.example.repository.IDoctorRepository;
import com.example.repository.IPatientRepository;
import com.example.repository.ImedicalAppointmentRepository;

@Service
public class MedicalAppointmentServiceImp implements IMedicalAppointmentService{

	@Autowired
	private ImedicalAppointmentRepository repo;
	@Autowired
	private IPatientRepository repoPac;
	@Autowired
	private IDoctorRepository repoDoc; 

	@Override
	public List<MedicalAppointment> getMedicalAppointmentsDoctor(String code) {
		List<MedicalAppointment> medicalAppointmentsDoctor = new ArrayList<>();
		List<MedicalAppointment> medicalAppointments = repo.findAll();
		for(MedicalAppointment medicalAppointment: medicalAppointments) {
			if(medicalAppointment.getDoctor().getCode().equals(code)) {
				medicalAppointmentsDoctor.add(medicalAppointment);
			}
		}
		return medicalAppointmentsDoctor;
		}

	@Override
	public List<MedicalAppointment> getMedicalAppointmentsPatient(String id) {
		List<MedicalAppointment> medicalAppointmentsPatient = new ArrayList<>();
		List<MedicalAppointment> medicalAppointments = repo.findAll();
		for(MedicalAppointment medicalAppointment: medicalAppointments) {
			if(medicalAppointment.getPatient().getId().equals(id)) {
				medicalAppointmentsPatient.add(medicalAppointment);
			}
		}
		return medicalAppointmentsPatient;
	}

	@Override
	public void updateMedicalAppointment(MedicalInString medicalInString) {
		createMedicalAppointment(medicalInString);
		
	}

	@Override
	public void deleteMedicalAppointmentsDoctor(String code) {
		List<MedicalAppointment> medicalAppointments = repo.findAll();
		for(MedicalAppointment medicalAppointment: medicalAppointments) {
			if(medicalAppointment.getDoctor().getCode().equals(code)) {
				repo.deleteById(medicalAppointment.getIdMedicalAppointment());
			}
		}
		
	}

	@Override
	public void createMedicalAppointment(MedicalInString medicalInString) {

		
		MedicalAppointment medicalAppointment = new MedicalAppointment();

		List<Doctor> doctors= repoDoc.findAll();
		for(Doctor doctor: doctors) {
			if(doctor.getCode().equals(medicalInString.getDoctor())) {
				medicalAppointment.setDoctor(doctor);
			}
		}
		List<Patient> patients = repoPac.findAll();
		
		for(Patient patient: patients) {
			if(patient.getId().equals(medicalInString.getPatient())) {
				medicalAppointment.setPatient(patient);
			}
		}
		medicalAppointment.setIdMedicalAppointment(medicalInString.getIdMedicalAppointment());
		medicalAppointment.setDate(medicalInString.getDate());
		repo.save(medicalAppointment);
		
	}

	@Override
	public List<MedicalAppointment> getMedicalApointments() {
		
		return repo.findAll();
	}

}
