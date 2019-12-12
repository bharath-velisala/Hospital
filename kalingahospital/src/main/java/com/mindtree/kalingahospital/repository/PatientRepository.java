package com.mindtree.kalingahospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.kalingahospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
