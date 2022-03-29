package com.testing.uitest.homepagetest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testing.config.BaseClass;
import com.testing.keywords.UIKeywords;
import com.testing.pages.HomePage;
import com.testing.pages.HostMeeting;
import com.testing.pages.JoinMeetingPage;

//ThreadLocal
/**
 * 
 * @author chaitali kuyate
 * 
 */
public class HomePageTest extends BaseClass {
	UIKeywords keyword = UIKeywords.getInstance();

	@Test
	public void verofyTitleOfHomePage() {
		String expectedTitle = "IJmeet";
		Assert.assertEquals(keyword.driver.getTitle(), expectedTitle);
	}

	@Test
	public void verifyIfUserRedirectsToJoinMeetingPage() {
		HomePage home = PageFactory.initElements(keyword.driver, HomePage.class);
		home.clickOnJoinMeetingTab();
		JoinMeetingPage joinMeeting = PageFactory.initElements(keyword.driver, JoinMeetingPage.class);
		String actual = joinMeeting.getQuickJoinMeetingTitle();
		Assert.assertTrue(actual.contains("Quick"));
	}

	@Test
	public void verifyIfUserRedirectToHostMeeting() {
		HomePage home = PageFactory.initElements(keyword.driver, HomePage.class);
		home.clickOnHostMeeting();
		HostMeeting host = PageFactory.initElements(keyword.driver, HostMeeting.class);
		String actual = host.getHostMeeting();
		Assert.assertTrue(actual.contains("Screen"));
	}

	@Test
	public void validateAllLinksOfHomePage() throws MalformedURLException, IOException {
		HomePage home = new HomePage();
		List<WebElement> links = home.getAllLinks();
		Iterator<WebElement> itr = links.iterator();
		while (itr.hasNext()) {
			String url = itr.next().getAttribute("href");
			HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();
			int code = con.getResponseCode();
			System.out.println("Url: "+url+"status code: "+code);
			Assert.assertFalse(code>400, "Link is broken:"+ url);
			if (code >= 400) {
				System.out.println("Links is broken:" + url);
			}
		}

	}

	@Test
	public void printAllInfoLinks() {
		HomePage home = new HomePage();
		home.getTextOfInfoLinks();
	}
	
	

}
