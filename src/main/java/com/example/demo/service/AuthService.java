package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Security;
import com.example.demo.domain.User;
import com.example.demo.repository.SecurityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.ResponseHandler;

@Service
public class AuthService {
	private static Logger LOGGER = LoggerFactory.getLogger(AuthService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityRepository securityRepository;
	@Autowired
	JavaMailSender javamailsender;

	public ResponseEntity<Object> signUp(User user) {
		Map<String, Object> res = new HashMap<>();
		User userexist = userRepository.findByEmail(user.getEmail());
		if (userexist == null) {
			user.setPassword(user.getPassword());
			User savedUser = userRepository.save(user);
			res.put("firstName", savedUser.getFirstName());
			res.put("lastName", savedUser.getLastName());
			res.put("email", savedUser.getEmail());
			Long userId = user.getId();
			Security security = new Security();
			security.setConfirmationToken(UUID.randomUUID().toString());
			security.setPassword(user.getPassword());
			security.setUserId(userId);
			security.setEmail(user.getEmail());
			security.setOtp(generateOTP("12568543"));
			securityRepository.save(security);
			SimpleMailMessage registrationEmail = new SimpleMailMessage();

			registrationEmail.setTo(user.getEmail());

			registrationEmail.setSubject("Registration Confirmation");

			registrationEmail.setText("Your otp is: " + security.getOtp()
					+ "To confirm your e-mail address, please click the link below:\n"
					+ "http://localhost:1119/api-accounts/v1/verification?token=" + security.getConfirmationToken());
			System.out.println("registrationEmail" + registrationEmail);
			javamailsender.send(registrationEmail);
			LOGGER.info("User is created successfully " + res);
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "User is created successfully", savedUser);
		} else {
			LOGGER.info("Use different email,user with same email exists");
			return ResponseHandler.invalidResponse(HttpStatus.OK, false,
					"Use different email,user with same email exists");
		}
	}

	public ResponseEntity<Object> verifyEmail(String token) {
		Boolean isVerified;
		Security user = securityRepository.findByConfirmationToken(token);
		if (user == null) {
			isVerified = false;
			LOGGER.info("No token found");
			return ResponseHandler.invalidResponse(HttpStatus.OK, isVerified, "No token found");
		} else if (user.getConfirmationToken().equals(token)) {
			isVerified = true;
			user.setEmailVerified(true);
			securityRepository.save(user);
			LOGGER.info("Email verified successfully for email id :: " + user.getEmail());
			return ResponseHandler.generateVerificationResponse(HttpStatus.OK, isVerified,
					"Email verified successfully");
		} else {
			isVerified = false;
			LOGGER.info("No token found");
			return ResponseHandler.invalidResponse(HttpStatus.OK, isVerified, "no token found");
		}
	}

	public int generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return otp;
	}
}
