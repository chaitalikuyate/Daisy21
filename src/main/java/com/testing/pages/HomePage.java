package com.testing.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testing.keywords.UIKeywords;

public class HomePage {
	UIKeywords keyword = UIKeywords.getInstance();

	@FindBy(css = "div#navbarContent li:nth-child(1)")
	public WebElement joinMeetingTab;

	@FindBy(css = "div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement> infoLinks;

	public HomePage() {
		PageFactory.initElements(keyword.driver, this);
	}

	public void clickOnJoinMeetingTab() {
		joinMeetingTab.click();
	}

	@FindBy(css = "div#navbarContent li:nth-child(2)")
	public WebElement hostMeeting;

	public void clickOnHostMeeting() {
		hostMeeting.click();
	}

	@FindBy(css = "div#navbarContent li:nth-child(3)")
	public WebElement contactSale;

	public void clickOnContactSale() {
		contactSale.click();
	}
	
	public List<WebElement> getAllLinks() {
		return keyword.driver.findElements(By.tagName("a"));

	}

	public void getTextOfInfoLinks() {
		Iterator<WebElement> itr = infoLinks.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		
		
	}

}
