package com.mindtree.kalingahospital.dto;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.kalingahospital.entity.Doctor;
import com.mindtree.kalingahospital.entity.Patient;

public class DoctorDto implements Comparable<DoctorDto> {
	
		private int doctorId;
		private String doctorName;
		private int experience;
		private double salary;
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
		public DoctorDto() {
			super();
		}
		@Override
		public int compareTo(DoctorDto arg) {
			
			return (int) (this.getSalary()- arg.getSalary());
		}
		
		public static Comparator<DoctorDto> expCompare = new Comparator<DoctorDto>() {
			@Override
			public int compare(DoctorDto arg0, DoctorDto arg1) {
				// TODO Auto-generated method stub
				return (arg1.getExperience()-arg0.getExperience());
			}

	    };
		
}
