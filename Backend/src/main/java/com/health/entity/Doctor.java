package com.health.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctors")
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
    
	public Doctor(Long userId, User user, String licenseNumber, String clinicAddress, int yearsOfExperience,
			String bio) {
		super();
		this.userId = userId;
		this.user = user;
		this.licenseNumber = licenseNumber;
		this.clinicAddress = clinicAddress;
		this.yearsOfExperience = yearsOfExperience;
		this.bio = bio;
	}
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
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

    
}

