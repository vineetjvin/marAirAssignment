package com.MarsAir.org;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageActions extends Wait{

	//WebDriverWait wait = new WebDriverWait (driver, TimeUnit.SECONDS );

	WebDriver driver;
	static Logger log = LogManager.getLogger(PageActions.class.getName());


	//	public PageActions (AppiumDriver<WebElement> driver) {
	//		this.driver = driver;
	//	}


	protected WebElement element(WebElement ele, String replacement) {

		String tokens[] = ele.toString().split(":");

		String strategy = tokens[0].substring(tokens[0].lastIndexOf(".") +1);

		String locator = tokens[1].substring(1, tokens[1].length()-2);

		locator = locator.replaceAll("\\$\\{.*?\\}", replacement);

		ele = getElement(strategy, locator);

		return ele;
	}

	private WebElement getElement(String strategy, String locator) {
		WebElement element = null;

		switch(strategy) {
		case "classname":
			element	= (WebElement) BaseClass.driver.findElement(By.className(locator));
			return element;		

		case "id":
			element	= (WebElement) BaseClass.driver.findElement(By.id(locator));
			return element;	

		case "name":
			element	= (WebElement) BaseClass.driver.findElement(By.name(locator));
			return element;	

		case "xpath":
			element	= (WebElement) BaseClass.driver.findElement(By.xpath(locator));
			return element;	

		}

		return element;
	}

	protected void clickElement(WebElement ele, String replacement) {

		element(ele, replacement).click();
		log.info("clicked element "+ele);
	}


	protected void clickElement(WebElement ele) {
		ele.click();
		log.info("clicked element "+ele);
	}


	protected void type(WebElement ele, String text) {
		clear(ele);
		ele.sendKeys(text);
		log.info("Typed "+ text+" into element "+ele);



	}


	private void clear(WebElement ele) {
		ele.clear();
		log.info("Cleared element "+ele);
	}





	


}
