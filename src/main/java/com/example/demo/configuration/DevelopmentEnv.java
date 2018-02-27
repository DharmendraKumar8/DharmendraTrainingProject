package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;

public class DevelopmentEnv implements EnvConfiguration {

	@Value("${spring.datasource.url}")
	private String mySqlDBUrl;

	@Value("${spring.datasource.username}")
	private String mySqlDBUser;

	@Value("${spring.datasource.password}")
	private String mySqlDBPassword;

	@Value("${spring.datasource.db.driver}")
	private String mySqlDBDriver;

	@Override
	public String getEnvironment() {
		return "Dev Environment";
	}

	@Override
	public String getMySqlDBUrl() {
		return mySqlDBUrl;
	}

	@Override
	public String getMySqlDBUser() {
		return mySqlDBUser;
	}

	@Override
	public String getMySqlDBPassword() {
		return mySqlDBPassword;
	}

	@Override
	public String getMySqlDBDriver() {
		return mySqlDBDriver;
	}

	@Override
	public String[] getControllerPackages() {

		return new String[] {};
	}

}
