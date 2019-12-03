package com.qa.mmt.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.mmt.base.TestBase;
import com.qa.mmt.pages.HomePage;
import com.qa.mmt.testdata.TestData;
import com.qa.mmt.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		homePage = new HomePage();

	}

	@Test
	public void test() throws InterruptedException {

		homePage.clickFlights();
		homePage.clickRoundTrip();
		homePage.clickFromCity();
		homePage.selectFromCity(TestData.FROM_CITY);
		homePage.selectToCity(TestData.TO_CITY);
		homePage.selectFromDate();
		homePage.selectToDate();
		homePage.clickSearch();
		//TestUtil.pageLoadTimeout(TestData.PAGE_LOADTIMEOUT_ON_SEARCH_CLICK);
		//homePage.scrollPageDown();
		homePage.scrollDown();
		System.out.println("TOTAL NUMBER OF DEPARTUTRE FLIGHTS " + homePage.countDepartureFlight());
		System.out.println("TOTAL NUMBER OF RETURN FLIGHTS " + homePage.countReturnFlight());

	}

}
