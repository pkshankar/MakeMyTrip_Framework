package com.qa.mmt.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.mmt.locations.FileLocation;
import com.qa.mmt.testdata.TestData;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(FileLocation.CONFIG_FILE_LOCATION);
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void initialization() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", FileLocation.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", FileLocation.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();

		} else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", FileLocation.INTERNET_EXPLORER_DRIVER_PATH);
			driver = new InternetExplorerDriver();

		} else {

			System.out.println("PLEASE ENTER CORRECT BROWSER NAME IN CONFIG.PROPERTIES FILE");
			System.out.println("ACCEPTED BROWSERS ARE : CHROME, FIREFOX AND INTERNET EXPLORER");
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestData.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestData.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

}
