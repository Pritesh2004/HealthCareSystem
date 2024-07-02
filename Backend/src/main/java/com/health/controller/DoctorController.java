package com.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.entity.Doctor;
import com.health.entity.DoctorSpecialization;
import com.health.service.DoctorService;

@RestController
@RequestMapping("doctor")
@CrossOrigin("*")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/getAllDoc")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		try {
			List<Doctor> doctors = doctorService.getAllDoctors();
			return ResponseEntity.ok(doctors);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getAllDoctorSpecializations")
	public ResponseEntity<List<DoctorSpecialization>> getAllDoctorSpecializations(){
		try {
			List<DoctorSpecialization> doctorSpecs = doctorService.getAllDoctorSpecializations();
			return ResponseEntity.ok(doctorSpecs);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getSpecializationByDoctorId/{doctor_id}")
	public ResponseEntity<?> getSpecializationByDoctorId(@PathVariable Long doctor_id){
		try {
			DoctorSpecialization doctorSpec = doctorService.getSpecializationByDoctorId(doctor_id);
			if (doctorSpec != null) {
				return ResponseEntity.ok(doctorSpec);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getDoctorById/{userId}")
	public ResponseEntity<?> getDoctorById(@PathVariable Long userId){
		try {
			Doctor doctor = doctorService.getDoctor(userId);
			if (doctor != null) {
				return ResponseEntity.ok(doctor);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
