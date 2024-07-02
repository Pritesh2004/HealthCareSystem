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

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User saveUser(User user) throws Exception {
    	
        // Check if user with the same email already exists
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new Exception("User already present with username: " + user.getEmail());
        }

        // Encode the password before saving
        user.setPassword(encoder.encode(user.getPassword()));

        // Save the user details
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }
}
