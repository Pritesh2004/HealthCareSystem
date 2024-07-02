package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dto.AppointmentDto;
import com.health.dto.AppointmentStatus;
import com.health.entity.Appointment;
import com.health.entity.Doctor;
import com.health.entity.NormalUser;
import com.health.repository.AppointmentRepository;
import com.health.repository.DoctorRepository;
import com.health.repository.NormalUserRepository;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailSenderService emailService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NormalUserRepository normalUserRepository;

    public Appointment saveAppointment(AppointmentDto dto) throws Exception {
    	
        NormalUser user = normalUserRepository.findById(dto.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Doctor doctor = doctorRepository.findById(dto.getDoctor_id())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment existingAppointment = appointmentRepository.findByDoctorAndAppointmentDateAndAppointmentTime(doctor, dto.getAppointmentDate(), dto.getAppointmentTime());

        if (existingAppointment != null) {
            throw new Exception("Appointment already present");
        }

        String emailBody = buildAppointmentRegisteredEmail(user, doctor, dto);
        emailService.sendEmail(user.getUser().getEmail(), "Appointment Registered", emailBody);

        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setBookingDate(dto.getBookingDate());
        appointment.setStatus(AppointmentStatus.PENDING);
        appointment.setReason(dto.getReason());

        return appointmentRepository.save(appointment);
    }

    private String buildAppointmentRegisteredEmail(NormalUser user, Doctor doctor, AppointmentDto dto) {
        return "Dear " + user.getUser().getFirstName() + " " + user.getUser().getLastName() + ",\n\n" +
                "Your appointment with Dr. " + doctor.getUser().getFirstName() + " " + doctor.getUser().getLastName() + " on " + dto.getAppointmentDate() +
                " has been registered. Please wait for the doctor's approval.\n\n" +
                "Thank you for choosing our services.\n\n" +
                "Best regards,\n" +
                "Health Care";
    }

    public List<Appointment> getAppointmentsByUserId(Long userId) {
        return appointmentRepository.findByUserUserId(userId);
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorUserId(doctorId);
    }

    public Appointment updateAppointmentStatus(Long appointmentId, AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found for id: " + appointmentId));

        String emailBody = null;
        switch (status) {
            case ACCEPTED:
                emailBody = buildAppointmentAcceptedEmail(appointment);
                emailService.sendEmail(appointment.getUser().getUser().getEmail(), "Appointment Accepted", emailBody);
                break;
            case REJECTED:
                emailBody = buildAppointmentRejectedEmail(appointment);
                emailService.sendEmail(appointment.getUser().getUser().getEmail(), "Appointment Rejected", emailBody);
                break;
            case CANCELLED:
                emailBody = buildAppointmentCancelledEmail(appointment);
                emailService.sendEmail(appointment.getDoctor().getUser().getEmail(), "Appointment Canceled by User", emailBody);
                break;
        }

        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    private String buildAppointmentAcceptedEmail(Appointment appointment) {
        return "Dear " + appointment.getUser().getUser().getFirstName() + " " + appointment.getUser().getUser().getLastName() + ",\n\n" +
                "We are pleased to inform you that your appointment with Dr. " + appointment.getDoctor().getUser().getFirstName() + " " + appointment.getDoctor().getUser().getLastName() +
                " on " + appointment.getAppointmentDate() + " has been accepted.\n\n" +
                "Please ensure to be available at the scheduled time.\n\n" +
                "Thank you for choosing our services.\n\n" +
                "Best regards,\n" +
                "Health Care";
    }

    private String buildAppointmentRejectedEmail(Appointment appointment) {
        return "Dear " + appointment.getUser().getUser().getFirstName() + " " + appointment.getUser().getUser().getLastName() + ",\n\n" +
                "We regret to inform you that your appointment with Dr. " + appointment.getDoctor().getUser().getFirstName() + " " + appointment.getDoctor().getUser().getLastName() +
                " on " + appointment.getAppointmentDate() + " has been rejected.\n\n" +
                "Please contact our office to reschedule or for further assistance.\n\n" +
                "We apologize for any inconvenience this may cause.\n\n" +
                "Best regards,\n" +
                "Health Care";
    }

    private String buildAppointmentCancelledEmail(Appointment appointment) {
        return "Dear Dr. " + appointment.getDoctor().getUser().getFirstName() + " " + appointment.getDoctor().getUser().getLastName() + ",\n\n" +
                "We would like to inform you that your appointment with " + appointment.getUser().getUser().getFirstName() + " " + appointment.getUser().getUser().getLastName() +
                " on " + appointment.getAppointmentDate() + " has been canceled by the user.\n\n" +
                "Please update your schedule accordingly.\n\n" +
                "Thank you for your understanding.\n\n" +
                "Best regards,\n" +
                "Health Care";
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
