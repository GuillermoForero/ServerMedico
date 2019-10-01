package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Doctor;
import com.example.repository.IDoctorRepository;

@Controller
public class DemoController {

	@Autowired
	private IDoctorRepository doctorRepository;
	
	@GetMapping("/greetingp")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Pedro") String name, Model model) {
        model.addAttribute("name", name);
        Doctor entity = new Doctor();
        doctorRepository.save(entity);
        return "greeting"; 
    }
}