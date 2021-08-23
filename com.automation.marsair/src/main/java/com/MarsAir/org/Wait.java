package com.MarsAir.org;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	static Logger log = LogManager.getLogger(Wait.class.getName());
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, 60);
	
	public void hardWait(int seconds) {
		try {
			log.info("Entering hardwait for "+seconds+" second(s)");
			Thread.sleep(seconds*1000);
			log.info("Exiting hardwait");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void waitForInvisibilityOfElement(WebElement ele) {
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	protected void waitForVisibilityOfElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	
	protected void waitForElementTobeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}


}
