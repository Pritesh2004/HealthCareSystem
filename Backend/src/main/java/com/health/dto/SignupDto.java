package com.health.dto;

import com.health.entity.NormalUser;
import com.health.entity.User;

public class SignupDto {

	  private String password;
	    private String email;
	    private String firstName;
	    private String lastName;
	    
	      
	    public NormalUser toEntity() {
	    	
	        User user = new User();
	        
	        user.setPassword(this.password);
	        user.setEmail(this.email);
	        user.setFirstName(this.firstName);
	        user.setLastName(this.lastName);
	        
	        NormalUser normalUser = new NormalUser();
	        normalUser.setUser(user);
	       

	        return normalUser;
	    }


		public SignupDto() {
			super();
			// TODO Auto-generated constructor stub
		}


		public SignupDto(String password, String email, String firstName, String lastName) {
			super();
			this.password = password;
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
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
	    
	    

}
