package com.testing.uitest.homepagetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.testing.config.BaseClass;
import com.testing.keywords.UIKeywords;
import com.testing.util.Locator;
import com.testing.util.WaitFor;

public class SignupPageTests extends BaseClass {
	private static final Logger LOG = Logger.getLogger(SignupPageTests.class);
	UIKeywords keyword = UIKeywords.getInstance();

	@Test
	public void validateFullNameFieldForCorrectInput() {
		keyword.launchUrl("http://www.ijmeet.com");
		LOG.info("URl is launch");
		keyword.click("css", "li:nth-child(5) a.nav-link");
		LOG.info("Click on registration button");
		keyword.enterText(Locator.SIGNUP_FULLNAME, "chaitali landge");
		keyword.enterText(Locator.SIGNUP_COMPANYNAME, "Testing Shastra");
		keyword.enterText(Locator.SIGNUP_EMAIL, "chaitali1landge23@gmail.com");
		keyword.enterText(Locator.SIGNUP_CONTACT, "8208831046");
		keyword.enterText(Locator.SIGNUP_PASSWORD, "Chaitali@123");

		keyword.switchToFrameAt(0);
		LOG.info("Switch inside a frame");
		WaitFor.elementToBeClickable(keyword.getWebElement("css", "div.recaptcha-checkbox-border"));
		keyword.click("css","div.recaptcha-checkbox-border");
		keyword.switchToDefaultContent();
		LOG.info("Jumped back from frame");
		keyword.click("css","button[type='submit']");
		String actualUrl = keyword.getCurrentUrl(); 
		Assert.assertTrue(actualUrl.contains("dashboard"));
	}
}
