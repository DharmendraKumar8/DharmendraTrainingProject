package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.UserProfile;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.UserProfileService;

@RestController
public class UserProfileController {
	private static Logger logger = LoggerFactory.getLogger(UserProfileController.class);
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = URLMapping.ADD_PROFILE, method = RequestMethod.POST)
	public void addActivity(@RequestBody UserProfile userProfile) {
		userProfileService.addUserProfile(userProfile);
	}

	@RequestMapping(value = URLMapping.GET_ALL_PROFILE, method = RequestMethod.GET)
	public ResponseEntity<List<UserProfile>> getUserProfiles() {
		List<UserProfile> userProfiles = userProfileService.getUserProfiles();
		if (userProfiles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userProfiles, HttpStatus.OK);

	}

	@RequestMapping(value = URLMapping.DELETE_PROFILE, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserProfile(@PathVariable("id") Long id) {

		UserProfile userProfile = userProfileService.getById(id);

		if (userProfile == null) {
			logger.debug("Profile with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userProfileService.delete(id);
			String str = "User with id " + id + " deleted";
			logger.info(str);
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}

	@RequestMapping(value = URLMapping.UPDATE_PROFILE, method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUserProfile(@RequestBody UserProfile userProfile) {

		UserProfile existingUserProfile = userProfileService.getById(userProfile.getId());
		if (existingUserProfile == null) {
			String str = "Employee with id " + userProfile.getId() + " does not exists";
			logger.info(str);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userProfileService.addUserProfile(userProfile);
			logger.info("++++++++++++++++++++++++++values inserted++++++++++++++++++++");
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = URLMapping.FETCH_PROFILE, method = RequestMethod.GET)
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable("id") Long id) {
		UserProfile userProfile = userProfileService.getById(id);
		if (userProfile == null) {
			logger.debug("User Profile with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found User Profile:");
		return new ResponseEntity<>(userProfile, HttpStatus.OK);
	}
}
