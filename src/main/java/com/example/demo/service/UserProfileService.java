package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.UserProfile;
import com.example.demo.repository.UserProfileRepository;
@Service
public class UserProfileService {
	@Autowired
	private UserProfileRepository userProfileRepository;
	public void addUserProfile(UserProfile userProfile) {
			userProfileRepository.save(userProfile);
		}
	public List<UserProfile> getUserProfiles() {
		return userProfileRepository.findAll();
	}
	public UserProfile getById(Long id) {
		return userProfileRepository.findOne(id);
	}
	public void delete(Long id) {
		userProfileRepository.delete(id);
		
	}
	}


