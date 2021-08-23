package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.MarsAir.org.PageActions;

public class HomePage extends PageActions{ WebDriver driver;

public HomePage( WebDriver driver){
	System.out.print("driver: " + driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	//  PageFactory.initElements(this.driver, this);
}

@FindBy(xpath = "//*[@type='submit']")
private WebElement searchButton;

@FindBy(id = "departing")
private WebElement departureDrpDwn;

@FindBy(id = "returning")
private  WebElement returnDrpDwn;

@FindBy(id = "promotional_code")
private  WebElement promoInput;


public HomePage selectGivenDepartureDate(String departureDate){
	Select s = new Select(departureDrpDwn);
	s.selectByVisibleText(departureDate);
	return this;
}

public HomePage selectGivenReturnDate(String returnDate){
	Select s = new Select(returnDrpDwn);
	s.selectByVisibleText(returnDate);
	return this;
}

public HomePage clickSearchButton(){
	searchButton.click();
	return this;
}

public HomePage enterGivenPromo(String promocode){
	promoInput.sendKeys(promocode);
	return this;
}




}
