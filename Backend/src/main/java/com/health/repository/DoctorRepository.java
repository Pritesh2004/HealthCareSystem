package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
