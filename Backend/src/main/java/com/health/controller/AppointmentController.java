package com.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.health.dto.AppointmentDto;
import com.health.dto.AppointmentStatus;
import com.health.dto.UpdateStatusDto;
import com.health.entity.Appointment;
import com.health.service.AppointmentService;

@RestController
@RequestMapping("appointment")
@CrossOrigin("*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/")
    public ResponseEntity<?> bookAppointment(@RequestBody AppointmentDto dto) {
        try {
            Appointment appointment = appointmentService.saveAppointment(dto);
            return new ResponseEntity<>(appointment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to book appointment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByUserId/{user_id}")
    public ResponseEntity<?> getAppointmentByUserId(@PathVariable Long user_id) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByUserId(user_id);
            return new ResponseEntity<>(appointments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to get appointments by user ID: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByDoctorId/{doctor_id}")
    public ResponseEntity<?> getAppointmentByDoctorId(@PathVariable Long doctor_id) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctor_id);
            return new ResponseEntity<>(appointments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to get appointments by doctor ID: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateStatus/{appointmentId}")
    public ResponseEntity<?> updateAppointmentStatus(@PathVariable Long appointmentId, @RequestBody UpdateStatusDto status) {
        try {
            Appointment updatedAppointment = appointmentService.updateAppointmentStatus(appointmentId, AppointmentStatus.fromString(status.getStatus()));
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update appointment status: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAppointment/{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentId) {
        try {
            appointmentService.deleteAppointment(appointmentId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete appointment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
