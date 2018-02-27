package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Role;

public interface ActivityRepository extends JpaRepository<Activity, Serializable> {

	Activity findByHandlerMethodName(String methodName);

	Activity findByActivityName(String activityName);

	Activity findByActivityId(Long id);

	Activity findByRoleListAndActivityId(Role role, Long id);
	
	List<Activity> findByRoleList(Role role);

	Activity findByRoleListAndActivityName(Role role, String activityName);

}
