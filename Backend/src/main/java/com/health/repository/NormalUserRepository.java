package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.NormalUser;

public interface NormalUserRepository extends JpaRepository<NormalUser, Long> {
	
	
}
