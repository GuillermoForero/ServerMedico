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
import com.example.model.Patient;
import com.example.model.PatientDto;
import com.example.service.IPatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class RestControllerPatients {
	@Autowired
	private IPatientService patientServices;
	
	@GetMapping
	public List<Patient> getPatients(){
		return patientServices.getPatients();
	}
	
	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") String id){
		return patientServices.getPatient(id);
	}
	
	
	@PostMapping
	public void insertPatient(@RequestBody PatientDto patientDto) {
		String codeDoctor = "xd";
		Patient patient = new Patient();
		patient.setBirthday(patientDto.getBirthdayDto());
		patient.setCodeDoctor(patientDto.getCodeDoctorDto());
		patient.setId(patientDto.getIdDto());
		patient.setIsTreatment(patientDto.getIsTreatmentDto());
		patient.setLastname(patientDto.getLastnameDto());
		patient.setModeratingFeeValue(patientDto.getModeratingFeeValueDto());
		patient.setName(patientDto.getNameDto());
		patient.setNextDate(patientDto.getNextDateDto());
		patientServices.createPatient(patient, codeDoctor);
	}
	
	@PutMapping
	public void modifyPatient(@RequestBody PatientDto patientDto) {
		Patient patient = new Patient();
		patient.setBirthday(patientDto.getBirthdayDto());
		patient.setCodeDoctor(patientDto.getCodeDoctorDto());
		patient.setId(patientDto.getIdDto());
		patient.setIsTreatment(patientDto.getIsTreatmentDto());
		patient.setLastname(patientDto.getLastnameDto());
		patient.setModeratingFeeValue(patientDto.getModeratingFeeValueDto());
		patient.setName(patientDto.getNameDto());
		patient.setNextDate(patientDto.getNextDateDto());
		patientServices.updatePatient(patient);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePatient(@PathVariable("id") String id) {
		patientServices.deletePatient(id);
	}
}
