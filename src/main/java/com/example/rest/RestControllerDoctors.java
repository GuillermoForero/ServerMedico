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
import com.example.model.Doctor;
import com.example.model.DoctorDto;
import com.example.service.IDoctorService;


@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:4200")
public class RestControllerDoctors {

	@Autowired
	private IDoctorService doctorServices;
	
	@GetMapping
	public List<Doctor> listar(){
		return doctorServices.getDoctors();
	}
	@GetMapping("/{code}")
	public Doctor geDoctor(@PathVariable("code") String code){
		return doctorServices.getDoctor(code);
	}
	
	
	@PostMapping
	public void insertDoctor(@RequestBody DoctorDto doctor) {
		Doctor doctorInserted = new Doctor();
		doctorInserted.setCode(doctor.getCodeDto());
		doctorInserted.setConsultingRoom(doctor.getConsultingRoomDto());
		doctorInserted.setHome(doctor.getHomeDto());
		doctorInserted.setSpeciality(doctor.getSpecialityDto());
		doctorInserted.setYearsOfExperience(doctor.getYearsOfExperienceDto());
		doctorServices.createDoctor(doctorInserted);
	}
	
	@PutMapping
	public void modifyDoctor(@RequestBody DoctorDto doctor) {
		Doctor doctorInserted = new Doctor();
		doctorInserted.setCode(doctor.getCodeDto());
		doctorInserted.setConsultingRoom(doctor.getConsultingRoomDto());
		doctorInserted.setHome(doctor.getHomeDto());
		doctorInserted.setSpeciality(doctor.getSpecialityDto());
		doctorInserted.setYearsOfExperience(doctor.getYearsOfExperienceDto());
		doctorServices.updateDoctor(doctorInserted);
	}
	
	@DeleteMapping(value = "/{code}")
	public void deleteDoctor(@PathVariable("code") String code) {
		doctorServices.deleteDoctor(code);
	}
	
	
}
