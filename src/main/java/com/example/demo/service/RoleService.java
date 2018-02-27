package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RoleRepository;

import com.example.demo.constants.Message;
import com.example.demo.domain.Role;

@Service
public class RoleService {

	private static Logger logger = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MessageService messageService;

	public Role save(Role role) {
		return roleRepository.save(role);
	}

	public Map<String, Object> changeStatus(Map<String, String> data) {

		Map<String, Object> result = new HashMap<>();
		Boolean isSuccess = false;
		try {
			Long id = Long.parseLong(data.get("id"));
			Boolean isActive = Boolean.parseBoolean(data.get("isActive"));
			if (id != null) {
				Role role = roleRepository.findById(id);
				if (role != null && role.getActive() != isActive) {
					role.setActive(isActive);
					roleRepository.save(role);
					logger.info("Role updated successfully");
					isSuccess = true;
					result.put(Message.MSG, messageService.getMessage(Message.SUCCESS));
				} else {
					result.put(Message.MSG, messageService.getMessage(Message.ALREADY_EXIST));
				}
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			result.put(Message.MSG, messageService.getMessage(Message.INTERNAL_SERVER_ERROR));
		}
		result.put("isSuccess", isSuccess);
		return result;
	}

	public Role getById(Long id) {
		return roleRepository.findOne(id);
	}

	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	public void delete(Long id) {
		roleRepository.delete(id);

	}

}
