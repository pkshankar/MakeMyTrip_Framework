package com.qa.mmt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.mmt.base.TestBase;

public class TestUtil extends TestBase {

	public static void switchTo(WebElement element) {

		driver.switchTo().frame(element);

	}

	public static void clickOn(WebElement element) {

		element.click();
	}

	public static String getCurrentDate() {

		String formatDate = null;

		Calendar calendar = Calendar.getInstance();
		if (calendar.get(Calendar.DATE) < 10) {

			formatDate = "E MMM" + " " + "0" + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);

		} else {

			formatDate = "E MMM" + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
		return simpleDateFormat.format(calendar.getTime());

	}

	public static String getFutureDate(int noOfDaysToAdd) {

		String formatDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, noOfDaysToAdd);

		if (calendar.get(Calendar.DATE) < 10) {

			formatDate = "E MMM" + " " + "0" + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);

		} else {

			formatDate = "E MMM" + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR);
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
		return simpleDateFormat.format(calendar.getTime());

	}

//	public static void scrollDown() {
//
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.END).perform();
//
//	}

	public static void pageLoadTimeout(long timeoutTime) {

		driver.manage().timeouts().pageLoadTimeout(timeoutTime, TimeUnit.SECONDS);
	}

	public static void scrollDownByJs() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
