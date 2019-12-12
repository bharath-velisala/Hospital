package com.mindtree.kalingahospital.service;

import java.util.List;
import java.util.Set;

import com.mindtree.kalingahospital.dto.DoctorDto;
import com.mindtree.kalingahospital.dto.PatientDto;

public interface DoctorService {

	PatientDto assignPatient(String doctorName, String patientName);

	List<DoctorDto> getAllDoctors();

	List<DoctorDto> getDoctorbyPatient();

	List<DoctorDto> getDoctor();

}
