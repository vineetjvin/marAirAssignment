package tests;

import org.testng.annotations.Test;

import com.MarsAir.org.BaseClass;

import pages.HomePage;


public class HomeTest extends BaseClass{

  HomePage homePage; 

  @Test
  public void searchTrip(){
      homePage = new HomePage(driver);
      homePage
              .selectGivenDepartureDate("July")
              .selectGivenReturnDate("July")
              .enterGivenPromo("AA1-AAA-113")
              .clickSearchButton();



  }



}
