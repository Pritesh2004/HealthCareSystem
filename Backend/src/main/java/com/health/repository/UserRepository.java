package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
