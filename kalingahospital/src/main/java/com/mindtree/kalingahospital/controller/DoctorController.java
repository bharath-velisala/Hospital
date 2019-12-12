package com.mindtree.kalingahospital.controller;


import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingahospital.dto.DoctorDto;
import com.mindtree.kalingahospital.dto.PatientDto;

import com.mindtree.kalingahospital.service.DoctorService;


@RestController
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@GetMapping(path = "assignpatient/{doctorName}/{patientName}")
	
	public PatientDto assignPatient(@PathVariable String doctorName, @PathVariable String patientName)
	{
		
		
		return doctorService.assignPatient(doctorName,patientName);
		
	}
	@GetMapping(path="getalldoctors")
	public List<DoctorDto> getAllDoctors()
	{
		List<DoctorDto> doctors=doctorService.getAllDoctors();
		Collections.sort(doctors);
		return doctors;
		
	}
	@GetMapping(path="doctorbypatientcount")
	public List<DoctorDto> getDoctorsBypatient()
	{
		List<DoctorDto> doctors=doctorService.getDoctorbyPatient();
		Collections.sort(doctors, DoctorDto.expCompare);
		return doctors;
		
	}
	@GetMapping(path="insertintofile")
	public List<DoctorDto> getDoctors()
	{
		

		List<DoctorDto> doctors=doctorService.getDoctor();
	
		
		return doctors;
		
	}
	
}



