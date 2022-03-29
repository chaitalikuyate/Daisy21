package com.testing.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contain UI keyword which are applicable for WebElements and
 * general actions This is a singleton class. To create object of this class,
 * use {@code getInstance()} method
 * 
 * @author chaitali kuyate
 *
 */

public class UIKeywords {
	public RemoteWebDriver driver = null;

	private static UIKeywords uikeywords;
	static {
		uikeywords = new UIKeywords();
	}

	public static UIKeywords getInstance() {
		return uikeywords;
	}

	/**
	 * this keyword is used to launch specified browser.
	 * 
	 * <ul>
	 * <li>chrome</li>
	 * <li>firefox</li>
	 * <li>ie</li>
	 * 
	 * @param browserName
	 */

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver();

		} else {
			System.err.println("Invalid browser name" + browserName);
		}
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("linktext")) {
			element = driver.findElement(By.linkText(locatorValue));
		}
		return element;
	}

	public void dropDown(WebElement element, String textToEnter) {
		Select sel = new Select(element);
		element.click();
	}

	/**
	 * In next version of framework, this method will be deleted. Instead you can use enterText(String object, String textToEnter)
	 * this method is there but not in use
	 * @param locatorType
	 * @param locatorValue
	 * @param textToEnter
	 */
	@Deprecated
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void switchToFrameAt(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	private void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public String getTitleOfPage() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void enterText(String object, String textToEnter) {
		String[] parts = object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);;
	}

}
