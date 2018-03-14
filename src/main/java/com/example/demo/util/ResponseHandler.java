package com.example.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	static String timeStamp = "timestamp";
	static String status = "status";
	static String isSuccess = "isSuccess";
	static String message = "message";
	static String data = "data";
	static String token = "token";

	private ResponseHandler() {
	}

	public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error, String message,
			Object responseObj) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("timestamp", new Date());
			map.put("status", status.value());
			map.put("isSuccess", error);
			map.put("message", message);
			map.put("data", responseObj);

			return new ResponseEntity<>(map, status);
		} catch (Exception e) {
			map.clear();
			map.put("timestamp", new Date());
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put("isSuccess", false);
			map.put("message", e.getMessage());
			map.put("data", null);
			return new ResponseEntity<>(map, status);
		}
	}

	public static ResponseEntity<Object> invalidResponse(HttpStatus stat, boolean error, String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put(status, stat.value());
			map.put(isSuccess, error);
			map.put(message, msg);
			return new ResponseEntity<Object>(map, stat);
		} catch (Exception e) {
			map.clear();
			map.put(timeStamp, new Date());
			map.put(status, HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put(isSuccess, false);
			map.put(message, e.getMessage());
			map.put(data, null);
			return new ResponseEntity<Object>(map, stat);
		}
	}

	public static ResponseEntity<Object> generateVerificationResponse(HttpStatus stat, boolean error, String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put(timeStamp, new Date());
			map.put(status, stat.value());
			map.put(isSuccess, error);
			map.put(message, msg);

			return new ResponseEntity<Object>(map, stat);
		} catch (Exception e) {
			map.clear();
			map.put(timeStamp, new Date());
			map.put(status, HttpStatus.INTERNAL_SERVER_ERROR.value());
			map.put(isSuccess, false);
			map.put(message, e.getMessage());
			map.put(data, null);
			return new ResponseEntity<Object>(map, stat);
		}
	}

}
