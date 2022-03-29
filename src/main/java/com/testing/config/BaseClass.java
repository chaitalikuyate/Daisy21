package com.testing.config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testing.keywords.UIKeywords;
import com.testing.util.TestListener;

public class BaseClass {

	private static final Logger LOG = Logger.getLogger(BaseClass.class);
	UIKeywords keyword = UIKeywords.getInstance();
	public WebDriver driver;

//	@Parameters("browser-name")
//	@BeforeMethod //Test/
//	public void setUp() {
//		Application app = new Application();
//		keyword.openBrowser(app.getBrowser());
//		this.driver = keyword.getDriver();
//		driver.get(app.getAppUrl());
//		LOG.info("browser is launch ");
	@BeforeMethod
	public void setup(@Optional String browserName) {
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
		driver.get("https://www.ijmeet.com");
		LOG.info("browser is launch ");
		Application app = new Application();
		if (browserName == null) {
			browserName = app.getBrowser();
		}
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
		driver.get(app.getAppUrl());
	}

	public void tearDown() {
		keyword.quitBrowser();
		LOG.info("browser is quite ");

	}

}
