package com.testing.config;

import com.testing.util.ReadProperties;

public class Application {

	private static final String FILEPATH = "/src/main/resources/application.properties";

	public String getBrowser() {
		return ReadProperties.getProperty(FILEPATH, "Chrome");
	}

	public String getAppUrl() {
		return ReadProperties.getProperty(FILEPATH, "daisy.dev.app.url");
	}
	
	public void getDbUrl() {

	}
	
	public void getUserName() {

	}
	
	public void getPassword() {
  
	}

}
