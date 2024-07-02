package com.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.dto.AdminDto;
import com.health.dto.DoctorDto;
import com.health.entity.Admin;
import com.health.entity.Doctor;
import com.health.entity.Specialization;
import com.health.service.AdminService;
import com.health.service.DoctorService;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    
	
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private DoctorService doctorService;
    
    //to create admin
    @PostMapping("/")
    public ResponseEntity<?> saveAdmin(@RequestBody AdminDto dto) {
        try {
            Admin admin = adminService.saveAdmin(dto.toEntity());
            return new ResponseEntity<>(admin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save admin: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveDoctor")
    public ResponseEntity<?> saveDoctor(@RequestBody DoctorDto dto) {
        try {
            Doctor doctor = doctorService.saveDoctor(dto);
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save doctor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/addSpec")
    public ResponseEntity<?> addSpecialization(@RequestBody Specialization spec) {
        try {
            Specialization newSpec = adminService.addSpecialization(spec);
            return new ResponseEntity<>(newSpec, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add specialization: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getAllSpec")
    public ResponseEntity<?> getAllSpec() {
        try {
            List<Specialization> specs = adminService.getAllSpecializations();
            return new ResponseEntity<>(specs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve specializations: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getAdmin/{userId}")
    public ResponseEntity<?> getAdmin(@PathVariable Long userId) {
        try {
            Admin admin = adminService.getAdmin(userId);
            if (admin != null) {
                return new ResponseEntity<>(admin, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Admin not found for id: " + userId, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve admin: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
