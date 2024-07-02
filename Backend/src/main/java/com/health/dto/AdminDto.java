package com.health.dto;

import com.health.entity.Admin;
import com.health.entity.User;

public class AdminDto {

    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String position;
    
    
    public Admin toEntity() {
    	
    	 User user = new User();
	        
	        user.setPassword(this.password);
	        user.setEmail(this.email);
	        user.setFirstName(this.firstName);
	        user.setLastName(this.lastName);
	        user.setPhoneNumber(this.phoneNumber);
	        
	     Admin admin = new Admin();
	     admin.setGender(this.gender);
	     admin.setPosition(this.position);
	     admin.setUser(user);
    	
    	return admin;
    }
    
	public AdminDto() {
		super();
	}
	public AdminDto( String password, String email, String firstName, String lastName,
			String phoneNumber, String gender, String position) {
		super();
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.position = position;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
    
    
}
