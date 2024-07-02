package com.health.entity;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DoctorSpecializations")
public class DoctorSpecialization {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorSpecializationId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

	public DoctorSpecialization(Long doctorSpecializationId, Doctor doctor, Specialization specialization) {
		super();
		this.doctorSpecializationId = doctorSpecializationId;
		this.doctor = doctor;
		this.specialization = specialization;
	}

	public DoctorSpecialization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDoctorSpecializationId() {
		return doctorSpecializationId;
	}

	public void setDoctorSpecializationId(Long doctorSpecializationId) {
		this.doctorSpecializationId = doctorSpecializationId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	

    
}
