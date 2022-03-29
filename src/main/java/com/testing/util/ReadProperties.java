package com.testing.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.testing.config.BaseClass;

public class ReadProperties extends BaseClass {
	public static String getProperty(String fileName, String key) {
		String dir = System.getProperty("user.dir");
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(dir + fileName);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * This method return the value of locator mentioned in ObjectReository
	 * 
	 * @param key
	 */

	public static String getObject(String key) {
		return getProperty("/src/main/resources/ObjectRepository.properties", key);
	}

}
