package com.mindtree.kalingahospital.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Doctor {
	@Id
	@Column(name="doctor_id")
	private int doctorId;
	@Column(name="doctor_name")
	private String doctorName;
	@Column(name="experience")
	private int experience;
	@Column(name="salary")
	private double salary;
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Patient> patients;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public Doctor() {
		super();
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", experience=" + experience
				+ ", salary=" + salary + ", patients=" + patients + "]";
	}
	
	
	

}
