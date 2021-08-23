package com.MarsAir.org;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver driver;
	static Logger log = LogManager.getLogger(DriverFactory.class.getName());

	public static WebDriver getDriver(String browserName) {

		//		 ------CHROME SPECIFIC CAPABILITITES------
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
			log.info("chromedriver initialized !!");
		}

		//		 ------FIREFOX SPECIFIC CAPABILITITES------
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ File.separator + "drivers" + File.separator + "geckodriver");
			driver = new FirefoxDriver();
			log.info("Firefox Driver initialized !!");


		}

		return driver;

	}

}
