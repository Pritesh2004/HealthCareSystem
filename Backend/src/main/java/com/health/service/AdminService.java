package com.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dto.Role;
import com.health.entity.Admin;
import com.health.entity.Specialization;
import com.health.entity.User;
import com.health.repository.AdminRepository;
import com.health.repository.SpecializationRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private UserService userService;

    public Admin saveAdmin(Admin admin) throws Exception {
    	
        // Set role for the user associated with admin
        admin.getUser().setRole(Role.ADMIN);

        // Save the user details and get the saved entity
        User savedUser = userService.saveUser(admin.getUser());

        // Set the saved user to the admin entity
        admin.setUser(savedUser);

        // Save the admin entity and return the saved instance
        return adminRepository.save(admin);
    }

    public Admin getAdmin(Long userId) {
        return adminRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found for id: " + userId));
    }

    public Specialization addSpecialization(Specialization spec) {
        return specializationRepository.save(spec);
    }

    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }
}
