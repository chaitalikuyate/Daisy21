package com.testing.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.keywords.UIKeywords;

public class WaitFor {
	private static final WebDriverWait wait;

	static {
		wait = new WebDriverWait(UIKeywords.getInstance(). driver, (10));
		wait.pollingEvery(Duration.ofMillis(500));
	}

	public static void visibilityOfElement(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

	public static void stalenessOfElement(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));

	}

	public static void elementToBeClickable(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method waits for element to be clickable. Max timeout is 30 seconds
	 * which is not configuration.
	 * 
	 * @param element
	 */
	public static void elementToBeClickable(WebElement element) {
		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
