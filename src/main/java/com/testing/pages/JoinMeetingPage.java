package com.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.keywords.UIKeywords;

public class JoinMeetingPage {
	UIKeywords keyword = UIKeywords.getInstance();

	@FindBy(css = "div.joinmeeting")
	public WebElement quickJoinMeetingTitle;

	public JoinMeetingPage() {
		PageFactory.initElements(keyword.driver, this);
	}

	public String getQuickJoinMeetingTitle() {
		return quickJoinMeetingTitle.getText();
	}
	
//	public By quickJoinMeetingTitle = By.cssSelector("div#navbarContent li:nth-child(1)");
//
//	public String getQuickJoinMeetingTitle() {
//		return keyword.driver.findElement(quickJoinMeetingTitle).getText();
//	}

}
