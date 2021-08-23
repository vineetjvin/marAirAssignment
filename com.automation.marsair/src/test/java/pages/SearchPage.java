package pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MarsAir.org.PageActions;

public class SearchPage extends PageActions{ WebDriver driver;

public static final String invalidDateMessage = "Unfortunately, this schedule is not possible. Please try again.";
public static final String SeatsAvailable = "Seats available!";
public static final String callMarsAir = "Call now on 0800 MARSAIR to book!";

public SearchPage( WebDriver driver){
	System.out.print("driver: " + driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	//  PageFactory.initElements(this.driver, this);
}

@FindBy(xpath = "//h2")
private WebElement searchresultHeading;

@FindBy(className = "promo_code")
private WebElement promoCodeMessage;

@FindBy(id = "content")
private  WebElement searchContent;

@FindBy(xpath = "//*[@id='content']//p[text()='${text}']")
private  WebElement SearchResultMessage;

@FindBy(linkText = "Back")
private  WebElement backLink;


public SearchPage verifySearchResultIsDisplayed() {
	assertTrue(searchContent.isDisplayed());
	return this;
}

public SearchPage verifyPromoCodeIsAppliedSuccessfully(String promocode) {
	assertTrue(promoCodeMessage.getText().contains(promocode));
	return this;
}

public SearchPage verifyPromoCodeMessageIsNotDisplayed() {
	assertFalse(promoCodeMessage.isDisplayed());
	return this;
}

public SearchPage verifySeatsAvailableMessageIsDisplayed() {
	assertTrue(searchContent.getText().contains(SeatsAvailable));
	return this;
}

public SearchPage verifyCallMarsAirMessageIsDisplayed() {
	assertTrue(searchContent.getText().contains(callMarsAir));
	return this;
}

public SearchPage verifyInvalidDatesMessageIsDisplayed() {
	assertTrue(searchContent.getText().contains(invalidDateMessage));
	return this;
}


public HomePage clickBackLinkText() {
	backLink.click();
	return new HomePage(driver);
}


}
