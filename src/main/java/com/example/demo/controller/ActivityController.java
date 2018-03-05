package com.example.demo.controller;

import java.util.List;
import java.util.Map;

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

import com.example.demo.domain.Activity;
import com.example.demo.dto.RoleActivityDTO;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.ActivityService;
import com.example.demo.util.ResponseHandler;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@RestController
public class ActivityController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	ActivityService activityService;

	/**
	 * @param dto
	 * @return
	 */

	@RequestMapping(value = URLMapping.ASSIGN_ACTIVITIES, method = RequestMethod.PUT)
	public ResponseEntity<Object> assignActivities(@RequestBody RoleActivityDTO dto) {
		Map<String, Object> result = null;
		try {
			result = activityService.assignActivities(dto);
			if (result.get("isSuccess").equals(true)) {
				return ResponseHandler.generateResponse(HttpStatus.OK, true, result.get("message").toString(), result);
			} else
				return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, result.get("message").toString(),
						result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage(), result);
		}

	}

	@RequestMapping(value = URLMapping.ADD_ACTIVITY, method = RequestMethod.POST)
	public void addActivity(@RequestBody com.example.demo.domain.Activity activity) {
		activityService.addActivity(activity);
	}

	@RequestMapping(value = URLMapping.GET_ACTIVITIES, method = RequestMethod.GET)
	public ResponseEntity<List<Activity>> getActivities() {
		List<Activity> activities = activityService.getActivities();
		if (activities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(activities, HttpStatus.OK);

	}

	@RequestMapping(value = URLMapping.DELETE_ACTIVITY, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteActivity(@PathVariable("id") Long id) {

		Activity activity = activityService.getById(id);

		if (activity == null) {
			logger.debug("Activity with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			activityService.delete(id);
			String str="Employee with id "+id+" deleted";
			logger.debug(str);
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}

	@RequestMapping(value = URLMapping.UPDATE_ACTIVITY, method = RequestMethod.PUT)
	public ResponseEntity<Void> updateActivity(@RequestBody Activity activity) {

		Activity existingActivity = activityService.getById(activity.getActivityId());
		if (existingActivity == null) {
			String str="Employee with id " + activity.getActivityId() + " does not exists";
			logger.debug(str);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			activityService.save(activity);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

}
