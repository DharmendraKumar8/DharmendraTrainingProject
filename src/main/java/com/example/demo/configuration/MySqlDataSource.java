package com.example.demo.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MySqlDataSource {
	@Autowired
	private EnvConfiguration envConfig;

	public DataSource datasource() {
		PoolProperties poolproperties = new PoolProperties();
		poolproperties.setUrl(envConfig.getMySqlDBUrl());
		poolproperties.setDriverClassName(envConfig.getMySqlDBDriver());
		poolproperties.setUsername(envConfig.getMySqlDBUser());
		poolproperties.setPassword(envConfig.getMySqlDBPassword());
		poolproperties.setJmxEnabled(true);
		poolproperties.setTestWhileIdle(true);
		poolproperties.setTestOnBorrow(true);

		DataSource dataSource = new DataSource();
		dataSource.setPoolProperties(poolproperties);

		return dataSource;
	}
}
