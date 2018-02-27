package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long activityId;
	private String activityName;

	private boolean isActive;
	private String handlerMethodName;

	public Activity() {
	}

	public Activity(String activityName, boolean isActive, String handlerMethodName) {

		this.activityName = activityName;
		this.isActive = isActive;
		this.handlerMethodName = handlerMethodName;
	}

	@ManyToMany(mappedBy = "activities")
	@JsonIgnore
	private List<Role> roleList;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public String getHandlerMethodName() {
		return handlerMethodName;
	}

	public void setHandlerMethodName(String handlerMethodName) {
		this.handlerMethodName = handlerMethodName;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
