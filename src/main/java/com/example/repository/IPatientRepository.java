package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, String>{


}
