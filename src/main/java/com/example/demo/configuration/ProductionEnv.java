package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;

public class ProductionEnv implements EnvConfiguration {

	@Value("${spring.datasource.url.pro}")
	private String mySqlDBUrl;

	@Value("${spring.datasource.user.pro}")
	private String mySqlDBUser;

	@Value("${spring.datasource.password.pro}")
	private String mySqlDBPassword;

	@Value("${spring.datasource.db.driver}")
	private String mySqlDBDriver;

	@Value("${scaffold.server.app.url.stage}")//changed
	private String appUrl;

	@Value("${accounts.package.controller}")
	private String[] controllerPackages;

	@Override
	public String getEnvironment() {
		return "Pro Environment";
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
	public String getAppUrl() {
		return appUrl;
	}

	@Override
	public String[] getControllerPackages() {
		return controllerPackages;
	}

}
