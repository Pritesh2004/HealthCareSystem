package com.health.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctors")
@JsonIgnoreProperties({"doctorSpecializations"})
public class Doctor {
	
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String licenseNumber;
    private String clinicAddress;
    private int yearsOfExperience;
    private String bio;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DoctorSpecialization> doctorSpecializations;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long userId, User user, String licenseNumber, String clinicAddress, int yearsOfExperience, String bio,
			Set<DoctorSpecialization> doctorSpecializations) {
		super();
		this.userId = userId;
		this.user = user;
		this.licenseNumber = licenseNumber;
		this.clinicAddress = clinicAddress;
		this.yearsOfExperience = yearsOfExperience;
		this.bio = bio;
		this.doctorSpecializations = doctorSpecializations;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Set<DoctorSpecialization> getDoctorSpecializations() {
		return doctorSpecializations;
	}

	public void setDoctorSpecializations(Set<DoctorSpecialization> doctorSpecializations) {
		this.doctorSpecializations = doctorSpecializations;
	}
    
    
}

