package com.mindtree.kalingahospital.service.impl;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingahospital.dto.DoctorDto;
import com.mindtree.kalingahospital.dto.PatientDto;
import com.mindtree.kalingahospital.entity.Doctor;
import com.mindtree.kalingahospital.entity.Patient;
import com.mindtree.kalingahospital.repository.DoctorRepository;
import com.mindtree.kalingahospital.repository.PatientRepository;
import com.mindtree.kalingahospital.service.DoctorService;
@Service
public class DoctorServiceimpl implements DoctorService{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	ModelMapper modelMapper=new ModelMapper();
	@Override
	public PatientDto assignPatient(String doctorName, String patientName) {
		List<Patient> patients=patientRepository.findAll();
		List<Doctor> doctors=doctorRepository.findAll();
		Patient patient=new Patient();
		Doctor doctor = new Doctor();
		int p=0,d=0;
		
		for (Patient patient1 : patients) 
		{
			if(patient1.getPatientName().equals(patientName))
			{
				p=1;
				patient=patient1;
				break;
			}
		}
		//if(p==1)
		
		for (Doctor doctor1 : doctors) 
		{
			if(doctor1.getDoctorName().equals(doctorName))
			{
				doctor=doctor1;
			}
		}
		doctor.setSalary(doctor.getSalary()+patient.getBillAmount());
		patient.setDoctor(doctor);
		patientRepository.save(patient);
		return null;

	}
	@Override
	public List<DoctorDto> getAllDoctors() {
		List<Doctor> doctors=doctorRepository.findAll();
		List<DoctorDto> doctorDto= doctors.stream().map(e->convertEntityToDto(e)).collect(Collectors.toList());
		List<DoctorDto> doctorDto1=new ArrayList<>();
		for (DoctorDto doctorDto2 : doctorDto) 
		{
			DoctorDto doctor=new DoctorDto();
			doctor.setDoctorId(doctorDto2.getDoctorId());
			doctor.setDoctorName(doctorDto2.getDoctorName());
			doctor.setSalary(doctorDto2.getSalary());
			doctor.setExperience(doctorDto2.getExperience());
			doctorDto1.add(doctor);
			
		}
		return doctorDto1;
		
	}
	
	
		private DoctorDto convertEntityToDto(Doctor doctor) {
		
		return modelMapper.map(doctor,DoctorDto.class);
				
	}
		public List<DoctorDto> getDoctorbyPatient() {
			
				List<Doctor> doctors=doctorRepository.findAll();
				List<DoctorDto> doctorDto= doctors.stream().map(e->convertEntityToDto(e)).collect(Collectors.toList());
				List<DoctorDto> doctorDto1;
				for (DoctorDto doctorDto2 : doctorDto) 
				{
					int count=0;
					for(Patient patient:doctorDto2.getPatients())
					{
						count++;
					}
					if(count>3)
					{
						DoctorDto doctor=new DoctorDto();
						doctor.setDoctorId(doctorDto2.getDoctorId());
						doctor.setDoctorName(doctorDto2.getDoctorName());
						doctor.setSalary(doctorDto2.getSalary());
						doctor.setExperience(doctorDto2.getExperience());
						doctorDto.add(doctor);
						
					}
				}
				return doctorDto;
		}
		@Override
		public List<DoctorDto> getDoctor() {
			List<Doctor> doctors=doctorRepository.findAll();
			File file=new File("D://shyam//file.txt");
			try {
				FileWriter e=new FileWriter(file);
				
				for (Doctor doctor : doctors) 
				{
				e.write(""+doctor);
				e.write("\n");
				
				}
				e.close();
			} 
			
			catch (IOException e1)
			{
				System.out.println(e1);
			}
			return  doctors.stream().map(e->convertEntityToDto(e)).collect(Collectors.toList());
			
		}
}
