package com.health.dto;


public class DoctorDto {

    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String licenseNumber;
    private String clinicAddress;
    private int yearsOfExperience;
    private String bio;
    private Long specializationId;
    
    
    
	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DoctorDto( String password, String email, String firstName, String lastName,
			String phoneNumber, String licenseNumber, String clinicAddress, int yearsOfExperience,
			String bio, Long specializationId) {
		super();
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.licenseNumber = licenseNumber;
		this.clinicAddress = clinicAddress;
		this.yearsOfExperience = yearsOfExperience;
		this.bio = bio;
		this.specializationId = specializationId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public Long getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Long specializationId) {
		this.specializationId = specializationId;
	}
	    
		
}
