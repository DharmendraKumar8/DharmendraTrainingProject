package com.example.demo.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GenerationType;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	private String Name;
	private String email;
	private String password;

	@OneToOne(mappedBy = "user")
		public UserProfile userProfile;

	public User() {
	}

	public User(String name, String email, String password) {
		super();
		Name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
