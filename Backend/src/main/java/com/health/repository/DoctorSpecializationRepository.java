package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.Doctor;
import com.health.entity.DoctorSpecialization;

public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, Long> {
	
	DoctorSpecialization findByDoctor(Doctor doctor);
}
