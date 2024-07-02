package com.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.UserQuery;

public interface UserQueryRepository extends JpaRepository<UserQuery, Long>{

}
