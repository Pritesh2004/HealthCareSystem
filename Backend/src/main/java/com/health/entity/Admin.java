package com.health.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
	
	 	@Id
	    private Long userId;

	    @OneToOne
	    @MapsId
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    private String gender;
	    private String position;
	    
		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Admin(Long userId, User user, String gender, String position) {
			super();
			this.userId = userId;
			this.user = user;
			this.gender = gender;
			this.position = position;
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
