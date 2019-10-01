package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.MedicalAppointment;

public interface ImedicalAppointmentRepository extends JpaRepository<MedicalAppointment, String>{

}
