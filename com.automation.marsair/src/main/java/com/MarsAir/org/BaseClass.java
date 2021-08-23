package com.MarsAir.org;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.PropertyReader;

public class BaseClass {


	protected static WebDriver driver;
	static Logger log = LogManager.getLogger(BaseClass.class.getName());
	String configFile = "config.properties";

	@BeforeSuite
	public void beforeSuite() {
		log.info("Hello from Mars!!");

	}



	@BeforeTest
	@Parameters({"browserName"})
	public void setup(@Optional("chrome")String browserName){

		log.info("browser: "+ browserName);

		driver = DriverFactory.getDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@AfterMethod
	public void closeApp() {
		driver.close();
		log.info("Closing Browser");
	}

	@BeforeMethod
	public void launchApp() {
		String appUrl = PropertyReader.getProperty(configFile, "baseUrl");
		driver.get(appUrl);
		log.info("Launching browser with app url: "+ appUrl);
	}



	@AfterSuite (alwaysRun = true)
	public void teardown() {

		driver.quit();
		log.info("Good Bye!!");
	}


}
