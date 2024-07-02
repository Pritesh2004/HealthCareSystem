package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Long>{

}
