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

import com.example.demo.domain.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = URLMapping.ADD_USER, method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = URLMapping.GET_ALL, method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@RequestMapping(value = URLMapping.DELETE_USER, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {

		User user = userService.getById(id);

		if (user == null) {
			logger.info("user with given id does not exists");
			throw new UserNotFoundException("user  zxcfgggggwtw eg agg  with  " + id + "  does'nt exist");
		} else {
			userService.delete(id);
			String str = "User with id " + id + " deleted";
			logger.debug(str);
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}

	@RequestMapping(value = URLMapping.UPDATE_USER, method = RequestMethod.POST)
	public ResponseEntity<Void> updateUser(@RequestBody User user) {

		User existingUser = userService.getById(user.getId());
		if (existingUser == null) {
			throw new UserNotFoundException("user with does'nt exist");

		} else {
			userService.save(user);
			logger.info("++++++++++++++++++++++++++values inserted++++++++++++++++++++");
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = URLMapping.FETCH_USER, method = RequestMethod.GET)

	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		if (user == null) {
			logger.info("User with given id " + id + " does not exists");
			throw new UserNotFoundException("user with" + id + "does'nt exist");
			// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found User:");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
