package com.health.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dto.DoctorDto;
import com.health.dto.Role;
import com.health.entity.Doctor;
import com.health.entity.DoctorSpecialization;
import com.health.entity.Specialization;
import com.health.entity.User;
import com.health.helper.DoctorServiceException;
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

    public Doctor saveDoctor(DoctorDto dto) throws DoctorServiceException {
        try {
            User user = createUserFromDto(dto);
            User savedUser = userService.saveUser(user);

            Doctor doctor = createDoctorFromDto(dto, savedUser);
            Doctor savedDoctor = doctorRepository.save(doctor);

            Specialization specialization = findSpecialization(dto.getSpecializationId());
            saveDoctorSpecialization(savedDoctor, specialization);

            return savedDoctor;
        } catch (Exception e) {
            throw new DoctorServiceException("Error saving doctor: " + e.getMessage(), e);
        }
    }

    private User createUserFromDto(DoctorDto dto) {
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(Role.DOCTOR);
        return user;
    }

    private Doctor createDoctorFromDto(DoctorDto dto, User savedUser) {
        Doctor doctor = new Doctor();
        doctor.setUser(savedUser);
        doctor.setLicenseNumber(dto.getLicenseNumber());
        doctor.setClinicAddress(dto.getClinicAddress());
        doctor.setYearsOfExperience(dto.getYearsOfExperience());
        doctor.setBio(dto.getBio());
        return doctor;
    }

    private Specialization findSpecialization(Long specializationId) {
        return specializationRepository.findById(specializationId)
                .orElseThrow(() -> new RuntimeException("Specialization not found with ID: " + specializationId));
    }

    private void saveDoctorSpecialization(Doctor doctor, Specialization specialization) {
        DoctorSpecialization doctorSpecialization = new DoctorSpecialization();
        doctorSpecialization.setDoctor(doctor);
        doctorSpecialization.setSpecialization(specialization);
        doctorSpecializationRepository.save(doctorSpecialization);
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
