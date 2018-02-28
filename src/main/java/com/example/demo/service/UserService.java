package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	//private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;

	public void addUser(User user) {
		
		userRepository.save(user);
	}

	public List<User> getUsers() {

		return userRepository.findAll();

	}

	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

	public void save(User user) {
		userRepository.save(user);

	}
}
