package com.example.demo.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String phoneNumber;

	private String gender;

	private String address;

	@OneToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "user_id", nullable = false)
	public User user;

	public UserProfile() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProfile(String phoneNumber, String gender, Date dateOfBirth, String address, User user) {
		super();
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.user = user;
	}
}
