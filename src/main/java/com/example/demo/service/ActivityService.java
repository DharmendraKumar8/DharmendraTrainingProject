package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.constants.Message;
import com.example.demo.domain.Activity;
import com.example.demo.domain.Role;
import com.example.demo.dto.RoleActivityDTO;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.RoleRepository;

@Service
public class ActivityService {

	private static Logger logger = LoggerFactory.getLogger(ActivityService.class);
    
	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private MessageService messageService;

	@Autowired
	private RoleRepository roleRepository;

	private ActivityService() {
	}

	public Map<String, Object> assignActivities(RoleActivityDTO dto) {

		Map<String, Object> result = new HashMap<>();
		List<Activity> activities = new ArrayList<>();
		Boolean isSuccess = false;
		Long roleId = dto.getRoleId();
		Long[] dtoActivities = dto.getActivities();
		if (roleId != null && dtoActivities != null) {
			Role role = roleRepository.findById(roleId);

			try {
				for (Long activityId : dtoActivities) {
					Activity activity = activityRepository.findByActivityId(activityId);

					if (activity == null) {
						logger.info("No such activity found");
						result.put("error", activityId);
						result.put(Message.MSG, messageService.getMessage(Message.ERROR));
						result.put("isSuccess", isSuccess);
						return result;
					}
					activities.add(activity);
				}
				role.setActivities(activities);
				roleRepository.save(role);
				logger.info("activities assigned successfully");
				isSuccess = true;
				result.put(Message.MSG, messageService.getMessage(Message.SUCCESS));
			} catch (Exception e) {
				logger.warn(e.getMessage());
				result.put(Message.MSG, messageService.getMessage(Message.INTERNAL_SERVER_ERROR));
			}
		} else {
			logger.info("Invalid data");
			result.put(Message.MSG, messageService.getMessage(Message.INVALID_INPUTS));
		}
		result.put("isSuccess", isSuccess);
		return result;
	}

	public void addActivity(Activity activity) {
		activityRepository.save(activity);
	}

	public List<Activity> getActivities() {

		return activityRepository.findAll();

	}

	public Activity getById(Long id) {
		return activityRepository.findOne(id);
	}

	public void delete(Long id) {
		activityRepository.delete(id);
	}

	public void save(Activity activity) {
		activityRepository.save(activity);

	}
}
