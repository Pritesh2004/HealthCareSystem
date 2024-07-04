package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.health.entity.User;
import com.health.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
   

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
