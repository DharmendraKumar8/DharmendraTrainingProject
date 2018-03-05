package com.example.demo.configuration;

public interface EnvConfiguration {
	String getEnvironment();

	String getMySqlDBUrl();

	String getMySqlDBUser();

	String getMySqlDBPassword();

	String getMySqlDBDriver();

	String[] getControllerPackages();

	String getAppUrl();

}
