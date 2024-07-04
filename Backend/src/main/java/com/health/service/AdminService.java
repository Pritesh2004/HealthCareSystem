package com.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.health.dto.Role;
import com.health.entity.Admin;
import com.health.entity.Specialization;
import com.health.entity.User;
import com.health.helper.UserNotFoundException;
import com.health.repository.AdminRepository;
import com.health.repository.SpecializationRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private UserService userService;

    @Autowired
    private SpecializationRepository specializationRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

   
    public Admin saveAdmin(Admin admin) throws Exception {
    	
    	User exist = userService.findUserByEmail(admin.getUser().getEmail());
        if (exist != null) {
            throw new UserNotFoundException("User already present with email: " + admin.getUser().getEmail());
        }
    	
        admin.getUser().setRole(Role.ADMIN);
        
        admin.getUser().setPassword(encoder.encode(admin.getUser().getPassword()));

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
