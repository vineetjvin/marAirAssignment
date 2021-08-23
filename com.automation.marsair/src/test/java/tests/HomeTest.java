package tests;

import org.testng.annotations.Test;

import com.MarsAir.org.BaseClass;

import pages.HomePage;


public class HomeTest extends BaseClass{
	
	public static final String validPromocode = "AA1-AAA-113";
	public static final String invalidPromocode = "AA2-AAA-113";

	HomePage homePage; 

	@Test
	public void verifySearchWithValidDates(){
		homePage = new HomePage(driver);
		homePage
		.selectGivenDepartureDate("July")
		.selectGivenReturnDate("December (two years from now)")
		.enterGivenPromo("AA1-AAA-113")
		.clickSearchButton()
		.verifySearchResultIsDisplayed()
		.verifyPromoCodeIsAppliedSuccessfully(validPromocode)
		.verifySeatsAvailableMessageIsDisplayed()
		.verifyCallMarsAirMessageIsDisplayed()
		.clickBackLinkText()
		.verifyUserisOnHomePage();
	}


	@Test
	public void verifySearchWithInValidDates(){
		homePage = new HomePage(driver);
		homePage
		.selectGivenDepartureDate("July")
		.selectGivenReturnDate("July")
		.enterGivenPromo("AA1-AAA-113")
		.clickSearchButton()
		.verifySearchResultIsDisplayed()
		.verifyPromoCodeMessageIsNotDisplayed()
		.verifyInvalidDatesMessageIsDisplayed()
		.clickBackLinkText()
		.verifyUserisOnHomePage();
	}



}
