package com.health.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.health.dto.DoctorDto;
import com.health.dto.Role;
import com.health.entity.Doctor;
import com.health.entity.DoctorSpecialization;
import com.health.entity.Specialization;
import com.health.entity.User;
import com.health.helper.DoctorServiceException;
import com.health.helper.UserNotFoundException;
import com.health.repository.DoctorRepository;
import com.health.repository.DoctorSpecializationRepository;
import com.health.repository.SpecializationRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public Doctor saveDoctor(DoctorDto dto) throws DoctorServiceException {
        try {
        	
        	User exist = userService.findUserByEmail(dto.getEmail());
        	System.out.println(exist.toString());
            if (exist != null) {
                throw new UserNotFoundException("User already present with email: " + dto.getEmail());
            }
            
        	//set user
        	User user  = new User();
        	user.setEmail(dto.getEmail());
            user.setPassword(encoder.encode(dto.getPassword()));
        	user.setFirstName(dto.getFirstName());
        	user.setLastName(dto.getLastName());
        	user.setPhoneNumber(dto.getPhoneNumber());
        	user.setRole(Role.DOCTOR);
        	
        	//set doctor
        	Doctor doctor = new Doctor();
        	doctor.setBio(dto.getBio());
        	doctor.setClinicAddress(dto.getClinicAddress());
        	doctor.setLicenseNumber(dto.getLicenseNumber());
        	doctor.setYearsOfExperience(dto.getYearsOfExperience());
        	doctor.setUser(user);
        	
        	//get specialization
        	Specialization specialization =  specializationRepository.findById(dto.getSpecializationId())
            .orElseThrow(() -> new RuntimeException("Specialization not found with ID: " + dto.getSpecializationId()));
        	
        	//set DoctorSpecialization
        	DoctorSpecialization doctorSpecialization = new DoctorSpecialization();
            doctorSpecialization.setDoctor(doctor);
            doctorSpecialization.setSpecialization(specialization);
            
            doctor.setDoctorSpecializations(Set.of(doctorSpecialization));

            return doctorRepository.save(doctor);
            
        } catch (Exception e) {
            throw new DoctorServiceException("Error saving doctor: " + e.getMessage(), e);
        }
    }

    public Doctor getDoctor(Long userId) {
        return doctorRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found for id: " + userId));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<DoctorSpecialization> getAllDoctorSpecializations() {
        return doctorSpecializationRepository.findAll();
    }

    public DoctorSpecialization getSpecializationByDoctorId(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));
        return doctorSpecializationRepository.findByDoctor(doctor);
    }
}
