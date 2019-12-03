package com.qa.mmt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.mmt.base.TestBase;
import com.qa.mmt.testdata.TestData;
import com.qa.mmt.util.TestUtil;

public class HomePage extends TestBase {

//	@FindBy(xpath = "//iframe[@name='notification-frame-b8a49a11']")
//	WebElement popUpImg;
//
//	@FindBy(xpath = "//a[@id='webklipper-publisher-widget-container-notification-close-div']")
//	WebElement closeImg;

	@FindBy(xpath = "//li[@data-cy='menu_Flights']")
	WebElement flightsLink;

	@FindBy(xpath = "//li[@data-cy='roundTrip']")
	WebElement roundTrip;

	@FindBy(xpath = "//label[@for='fromCity']")
	WebElement fromCity;

	@FindBy(xpath = "//label[@for='toCity']")
	WebElement toCity;

	@FindBy(xpath = "//div[@id='react-autowhatever-1']")
	WebElement listBox;

	@FindBy(xpath = "//a[text()='Search']")
	WebElement searchLink;

	@FindBy(xpath = "//p[text()='Departure Flight']/parent::div/parent::div/following-sibling::div/descendant::label[starts-with(@for,'split_0')]")
	List<WebElement> departureFlight;

	@FindBy(xpath = "//p[text()='Return Flight']/parent::div/parent::div/following-sibling::div/descendant::label[starts-with(@for,'split_1')]")
	List<WebElement> returnFlight;

	// @FindBy(xpath="//p[text()='Return
	// Flight']/ancestor::div[@id='rt-domrt-jrny']/child::div/following-sibling::div/descendant::span[@class='splitVw-inner']")

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

//	public boolean isPopUpDisplayed() {
//
//		return popUpImg.isDisplayed();
//	}
//
//	public void switchToFrame() {
//
//		TestUtil.switchTo(popUpImg, driver);
//	}
//
//	public void clickClose() {
//
//		TestUtil.clickOn(closeImg);
//	}

	public void clickFlights() {

		TestUtil.clickOn(flightsLink);
	}

	public void clickRoundTrip() {

		TestUtil.clickOn(roundTrip);
	}

	public void clickFromCity() {

		TestUtil.clickOn(fromCity);
	}

//	public void clickToCity() {
//
//		TestUtil.clickOn(toCity);
//	}

	public void selectFromCity(String fromCity) {

		TestUtil.clickOn(driver
				.findElement(By.xpath("//div[@id='react-autowhatever-1' and @role='listbox']/descendant::div[text()="
						+ "'" + fromCity + "'" + "]")));
	}

	public void selectToCity(String toCity) {

		TestUtil.clickOn(driver
				.findElement(By.xpath("//div[@id='react-autowhatever-1' and @role='listbox']/descendant::div[text()="
						+ "'" + toCity + "'" + "]")));
	}

	public String getFromDate() {

		return TestUtil.getCurrentDate();
	}

	public String getToDate() {

		return TestUtil.getFutureDate(TestData.ADD_DAYS);
	}

	public void selectFromDate() {

		TestUtil.clickOn(driver
				.findElement(By.xpath("//div[@role='gridcell' and @aria-label=" + "'" + getFromDate() + "'" + "]")));
	}

	public void selectToDate() {

		TestUtil.clickOn(driver
				.findElement(By.xpath("//div[@role='gridcell' and @aria-label=" + "'" + getToDate() + "'" + "]")));
	}

	public void clickSearch() {

		TestUtil.clickOn(searchLink);

	}

	public int countDepartureFlight() {

		return departureFlight.size();
	}

	public int countReturnFlight() {

		return returnFlight.size();
	}

//	public void scrollPageDown() {
//
//		TestUtil.scrollDown();
//	}
//
//	public void scrollPageDownByJs() {
//
//		TestUtil.scrollDownByJs();
//	}

	public void scrollDown() {

		if (departureFlight.size() > returnFlight.size()) {

			while (departureFlight.iterator().hasNext()) {

				departureFlight.iterator().next();
				TestUtil.scrollDownByJs();
			}
		} else {

			//System.out.println("INSIDE ELSE");
			//System.out.println(returnFlight.get(returnFlight.size() - 1).isDisplayed());
			while (returnFlight.get(returnFlight.size() - 1).isDisplayed()) {
				
				//System.out.println(returnFlight.get(returnFlight.size() - 1));
				//departureFlight.iterator().next();
				//System.out.println("test");
				TestUtil.scrollDownByJs();

			}
		}
	}

}
