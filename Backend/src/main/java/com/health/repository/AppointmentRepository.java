package com.health.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.entity.Appointment;
import com.health.entity.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUserUserId(Long userId);
    List<Appointment> findByDoctorUserId(Long doctorId);
    
	Appointment findByDoctorAndAppointmentDateAndAppointmentTime(Doctor doctor, Date appointmentDate, String appointmentTime);
}
