package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, String> {

}
