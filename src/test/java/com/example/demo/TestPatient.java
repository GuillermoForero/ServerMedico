package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Patient;
import com.example.model.PatientDto;
import com.example.repository.IPatientRepository;
import com.example.rest.RestControllerPatients;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPatient {

	@Autowired 
	IPatientRepository patientRepository;
	@Autowired
	RestControllerPatients restControllerPatients;
 
	@Test
	@Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "createpatient.sql")
	@Sql(scripts = "deletepatient.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testIsEmpty() {
		assertEquals(1, patientRepository.count());
    }
	@Test
    public void testIsEmpt2() {
		assertEquals(0, patientRepository.count());
    }

	@Test
	@Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "createpatient.sql")
	@Sql(scripts = "deletepatient.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindId() {
    	PatientDto patient= new PatientDto();
    	patient.setIdDto("asdf");
    	Patient patient2= patientRepository.findById(patient.getIdDto()).orElseThrow();
    	assertEquals(patient.getIdDto(), patient2.getId());
    }
	
    @Test
    @Sql(scripts = "deletepatient.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testInsert() {
    	PatientDto patientDto = new PatientDto();
    	patientDto.setNameDto("Guillermo");
    	patientDto.setLastnameDto("Forero");
    	Date fecha2= new Date(1569560400000l);
    	patientDto.setBirthdayDto(fecha2);
    	patientDto.setModeratingFeeValueDto(45d);
    	patientDto.setIdDto("asdf");
    	patientDto.setCodeDoctorDto("qwerty");
    	patientDto.setIsTreatmentDto(true);
    	restControllerPatients.insertPatient(patientDto);
    	Patient patient = patientRepository.findById(patientDto.getIdDto()).orElseThrow();
    	assertEquals(patientDto.getIdDto(), patient.getId());
    	assertEquals(1569560400000l, patient.getBirthday().getTime());
    	assertEquals(patientDto.getIsTreatmentDto(), patient.getIsTreatment());
    	assertEquals(patientDto.getLastnameDto(), patient.getLastname());
    	assertEquals(patientDto.getModeratingFeeValueDto(), patient.getModeratingFeeValue());
    	assertEquals(patientDto.getNameDto(), patient.getName());
    	assertEquals(patientDto.getCodeDoctorDto(), patient.getCodeDoctor());
    }


    @Test
	@Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "createpatient.sql")
	@Sql(scripts = "deletepatient.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testget() {
    	PatientDto patientDto = new PatientDto();
    	patientDto.setNameDto("Guillermo");
    	patientDto.setLastnameDto("Forero");
    	Date fecha2= new Date(1569560400000l);
    	patientDto.setBirthdayDto(fecha2);
    	patientDto.setModeratingFeeValueDto(45d);
    	patientDto.setIdDto("asdf");
    	patientDto.setCodeDoctorDto("qwerty");
    	patientDto.setIsTreatmentDto(true);
    	Patient patient = restControllerPatients.getPatient(patientDto.getIdDto());
    	assertEquals(patientDto.getIdDto(), patient.getId());
    	assertEquals(1569560400000l, patient.getBirthday().getTime());
    	assertEquals(patientDto.getIsTreatmentDto(), patient.getIsTreatment());
    	assertEquals(patientDto.getLastnameDto(), patient.getLastname());
    	assertEquals(patientDto.getModeratingFeeValueDto(), patient.getModeratingFeeValue());
    	assertEquals(patientDto.getNameDto(), patient.getName());
    	assertEquals(patientDto.getCodeDoctorDto(), patient.getDoctor().getCode());
    }
    @Test
    @Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "createpatient.sql")
	@Sql(scripts = "deletepatient.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdate() {
    	PatientDto patientDto = new PatientDto();
    	patientDto.setNameDto("Guillermo");
    	patientDto.setLastnameDto("Forero");//perro
    	Date fecha2= new Date(1569560400000l);
    	patientDto.setBirthdayDto(fecha2);
    	patientDto.setModeratingFeeValueDto(45d);
    	patientDto.setIdDto("asdf");
    	patientDto.setCodeDoctorDto("qwerty");
    	patientDto.setIsTreatmentDto(true);
    	assertEquals(1, patientRepository.count());
    	restControllerPatients.modifyPatient(patientDto);
    	Patient patient = patientRepository.findById(patientDto.getIdDto()).orElseThrow();
    	assertEquals(patientDto.getIdDto(), patient.getId());
    	assertEquals(1569560400000l, patient.getBirthday().getTime());
    	assertEquals(patientDto.getIsTreatmentDto(), patient.getIsTreatment());
    	assertEquals(patientDto.getLastnameDto(), patient.getLastname());
    	assertEquals(patientDto.getModeratingFeeValueDto(), patient.getModeratingFeeValue());
    	assertEquals(patientDto.getNameDto(), patient.getName());
    	assertEquals(patientDto.getCodeDoctorDto(), patient.getCodeDoctor());
    }
    @Test
    @Sql(scripts = "createdoctor.sql")
	@Sql(scripts = "createpatient.sql")
	@Sql(scripts = "deletedoctor.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
    public void testDelete() {
    	PatientDto patientDto = new PatientDto();
    	patientDto.setNameDto("Guillermo");
    	patientDto.setLastnameDto("Forero");
    	Calendar fecha = new GregorianCalendar();
    	fecha.set(2019, 8, 27);
    	Date fecha2= new Date(fecha.getTime().getTime());
    	patientDto.setBirthdayDto(fecha2);
    	patientDto.setModeratingFeeValueDto(45d);
    	patientDto.setIdDto("asdf");
    	patientDto.setCodeDoctorDto("qwerty");
    	patientDto.setIsTreatmentDto(true);
    	assertEquals(1, patientRepository.count());
    	restControllerPatients.deletePatient(patientDto.getIdDto());
    	assertEquals(0, patientRepository.count());
    }
}
