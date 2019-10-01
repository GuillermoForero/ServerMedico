package com.example.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MedicalAppointment;
import com.example.model.MedicalInString;
import com.example.service.IMedicalAppointmentService;

@RestController
@RequestMapping("/medicalappointment")
@CrossOrigin(origins = "http://localhost:4200")
public class RestControllerMedicalAppointment {

	@Autowired
	IMedicalAppointmentService medicalAppointmentServices;
	
	@PostMapping
	public void createMedicalAppointment(@RequestBody MedicalInString medicalAppointment) {
		medicalAppointmentServices.createMedicalAppointment(medicalAppointment);
		
	}
	
	@GetMapping
	public List<MedicalAppointment> getMedicalAppointments(){
		return medicalAppointmentServices.getMedicalApointments();
	}
	
	
	@GetMapping("/doctor/{code}")
	public List<MedicalAppointment> getMedicalAppointmentsDoctor(@PathVariable("code") String code) {
		return medicalAppointmentServices.getMedicalAppointmentsDoctor(code);	
	}
	@GetMapping("/patient/{id}")
	public List<MedicalAppointment> getMedicalAppointmentsPatient(@PathVariable("id") String id) {
		return medicalAppointmentServices.getMedicalAppointmentsPatient(id);	
	}

	@PutMapping
	public void updateMedicalAppointment(@RequestBody 	MedicalInString medicalAppointment) {
		medicalAppointmentServices.updateMedicalAppointment(medicalAppointment);
	}

	@DeleteMapping(value = "/{code}")
	public void deleteMedicalAppointmentsDoctor(@PathVariable("code") String code) {
		medicalAppointmentServices.deleteMedicalAppointmentsDoctor(code);
	}
}
