package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

	Specialization findBySpecializationName(String name);
}
