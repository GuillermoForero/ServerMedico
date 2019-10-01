package com.example.demo;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.model.Doctor;
import com.example.model.DoctorDto;
import com.example.repository.IDoctorRepository;
import com.example.rest.RestControllerDoctors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDoctor {
	
	@Autowired 
	IDoctorRepository doctorRepository;
	@Autowired
	RestControllerDoctors restControllerDoctors;
 
	
	@Test
    public void testIsEmpt2() {
		assertEquals(0, doctorRepository.count());
    }

	@Test
	@Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testIsEmpty() {
		assertEquals(1, doctorRepository.count());
    }
	@Test
	@Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindId() {
    	DoctorDto doctorDto = new DoctorDto();
    	doctorDto.setCodeDto("qwerty");
    	doctorDto.setConsultingRoomDto("P30");
    	doctorDto.setHomeDto(false);
    	doctorDto.setSpecialityDto("Transito");
    	doctorDto.setYearsOfExperienceDto(40f);
    	Doctor doctor2 = doctorRepository.findById(doctorDto.getCodeDto()).orElseThrow();
    	assertEquals(doctorDto.getCodeDto(), doctor2.getCode());
    	assertEquals(doctorDto.getConsultingRoomDto(), doctor2.getConsultingRoom());
        assertEquals(doctorDto.getHomeDto(), doctor2.getHome());
        assertEquals(doctorDto.getSpecialityDto(), doctor2.getSpeciality());
        assertEquals(doctorDto.getYearsOfExperienceDto(), doctor2.getYearsOfExperience());
    }
	
    @Test
    @Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testInsert() {
    	/* 
    	DoctorDto doctor = new DoctorDto();
    	doctor.setCodeDto("12345678");
    	doctor.setConsultingRoomDto("A555");
    	doctor.setHomeDto(true);
    	doctor.setSpecialityDto("zxcvbn");
    	doctor.setYearsOfExperienceDto(90f);
    	*/
    	DoctorDto doctorDto = new DoctorDto();
    	doctorDto.setCodeDto("qwerty");
    	doctorDto.setConsultingRoomDto("P30");
    	doctorDto.setHomeDto(false);
    	doctorDto.setSpecialityDto("Transito");
    	doctorDto.setYearsOfExperienceDto(40f);
    	restControllerDoctors.insertDoctor(doctorDto);
    	Doctor doctor2 = doctorRepository.findById(doctorDto.getCodeDto()).orElseThrow();
    	assertEquals(doctorDto.getCodeDto(), doctor2.getCode());
        assertEquals(doctorDto.getConsultingRoomDto(), doctor2.getConsultingRoom());
        assertEquals(doctorDto.getHomeDto(), doctor2.getHome());
        assertEquals(doctorDto.getSpecialityDto(), doctor2.getSpeciality());
        assertEquals(doctorDto.getYearsOfExperienceDto(), doctor2.getYearsOfExperience());
    }


    @Test
    @Sql(scripts = "createdoctor.sql")
    @Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testget() {
    	DoctorDto doctor = new DoctorDto();
    	doctor.setCodeDto("qwerty");
    	doctor.setConsultingRoomDto("P30");
    	doctor.setHomeDto(false);
    	doctor.setSpecialityDto("Transito");
    	doctor.setYearsOfExperienceDto(40f);
    	Doctor doctor2 = restControllerDoctors.geDoctor(doctor.getCodeDto());
    	assertEquals(doctor.getCodeDto(), doctor2.getCode());
        assertEquals(doctor.getConsultingRoomDto(), doctor2.getConsultingRoom());
        assertEquals(doctor.getHomeDto(), doctor2.getHome());
        assertEquals(doctor.getSpecialityDto(), doctor2.getSpeciality());
        assertEquals(doctor.getYearsOfExperienceDto(), doctor2.getYearsOfExperience());
    }
    @Test
    @Sql(scripts = "createdoctor.sql")
    @Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdate() {
    	DoctorDto doctor = new DoctorDto();
    	doctor.setCodeDto("qwerty");
    	doctor.setConsultingRoomDto("P40");
    	doctor.setHomeDto(true);
    	doctor.setSpecialityDto("Transito1");
    	doctor.setYearsOfExperienceDto(40f);
    	assertEquals(1, doctorRepository.count());
    	restControllerDoctors.modifyDoctor(doctor);
    	Doctor doctor2 = doctorRepository.findById(doctor.getCodeDto()).orElseThrow();
    	assertEquals(doctor.getCodeDto(), doctor2.getCode());
        assertEquals(doctor.getConsultingRoomDto(), doctor2.getConsultingRoom());
        assertEquals(doctor.getHomeDto(), doctor2.getHome());
        assertEquals(doctor.getSpecialityDto(), doctor2.getSpeciality());
        assertEquals(doctor.getYearsOfExperienceDto(), doctor2.getYearsOfExperience());
    }
    @Test
    @Sql(scripts = "createdoctor.sql")
    public void testDelete() {
    	DoctorDto doctor = new DoctorDto();
    	doctor.setCodeDto("qwerty");
    	assertEquals(1, doctorRepository.count());
    	restControllerDoctors.deleteDoctor(doctor.getCodeDto());
    	assertEquals(0, doctorRepository.count());
    }
}