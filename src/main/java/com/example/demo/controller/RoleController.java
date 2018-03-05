package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Role;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.RoleService;
import com.example.demo.util.Activity;
import com.example.demo.util.ResponseHandler;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@RestController
@EnableSwagger2
public class RoleController {

	
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleService roleService;
	

	@RequestMapping(value = URLMapping.ADD_ROLE, method = RequestMethod.POST)
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		roleService.save(role);
		logger.debug("Added ");
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
	
	
	
	
	
	@RequestMapping(value = URLMapping.UPDATE_ROLE,method = RequestMethod.PUT)
	public ResponseEntity<Void> updateRole(@RequestBody Role role) {
		Role existingRole = roleService.getById(role.getId());
		if (existingRole == null) {
					logger.debug("Employee with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			roleService.save(role);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
	@Activity
	@RequestMapping(value = URLMapping.ACTIVATE_OR_DEACTIVATE_ROLE, method = RequestMethod.POST)
	public ResponseEntity<Object> changeStatus(@RequestBody Map<String, String> data) {
		Map<String, Object> result = null;
		try {
			result = roleService.changeStatus(data);
			if(result.get("isSuccess").equals(true)){
			return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get("message").toString(), result);
			}
			else
				return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get("message").toString(), result);		
		} catch (Exception e) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
		}
	}
	
	
	
	@Activity
	@RequestMapping(value=URLMapping.GET_ALL_ROLES,method=RequestMethod.GET)
	public ResponseEntity<List<Role>> getAllRoles() {
		
		List<Role> roles = roleService.getAll();
		if (roles.isEmpty()) {
			logger.debug("Employees does not exists");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
		String str2=Arrays.toString(roles.toArray());
		logger.debug("Found Employees");
		logger.debug("roles");
		logger.debug(str2);
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value=URLMapping.FETCH_ROLE,method=RequestMethod.GET)
	
	public ResponseEntity<Role> getRole(@RequestParam(value="id") Long id) {
		Role role = roleService.getById(id);
		if (role == null) {
					logger.debug("Role with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
				logger.debug("Found Role:");
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value=URLMapping.DELETE_ROLE,method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
		Role role = roleService.getById(id);
		if (role == null) {
					logger.debug("Employee with  given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			roleService.delete(id);
			logger.debug("Employee with given id has been deleted");
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
}

