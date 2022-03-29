package com.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.keywords.UIKeywords;

public class HostMeeting {

	UIKeywords keyword = UIKeywords.getInstance();

	@FindBy(css = "h1.set-sharingmade")
	public WebElement hostMeeting;

	public HostMeeting() {
		PageFactory.initElements(keyword.driver, this);
	}

	public String getHostMeeting() {
		return hostMeeting.getText();
	}

} 
