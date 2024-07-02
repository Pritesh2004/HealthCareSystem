package com.health.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="user_queries")
public class UserQuery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
	
	private String name;
	
	private String subject;
	
	private String queries;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public UserQuery(Long id,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,
			String name, String subject, String queries) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.subject = subject;
		this.queries = queries;
	}

	public UserQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQueries() {
		return queries;
	}

	public void setQueries(String queries) {
		this.queries = queries;
	}





}
