package StepDefinations;

import BaseCucumber.BaseTest;
import PageClassesCucumber.HomePageCucumber;
import PageClassesCucumber.LandingPageCucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class LandingPageSteps extends BaseTest {

	@Before
	public void invokeBrowser() {
		BaseTest.initBrowser();
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
	public LandingPageCucumber landingpage ;
	public HomePageCucumber homepage;
	

	@Given("^user is on application landing page$")
	public void user_is_on_application_landing_page() {
		String url = prop.getProperty("applicationUrl");
		driver.get(url);
		landingpage = new LandingPageCucumber();
		checkPageLoaded();
	}
	
	@Then("^user verifies it is on application landing page$")
	public void user_verifies_it_is_on_application_home_page() {
		String expectedTitle = "Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder";
		Assert.assertEquals(expectedTitle, landingpage.getTitle());
	}

	@Then("^user enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) {
		landingpage.doLogin(username, password);
		checkPageLoaded();
	}
	
	
	@Then("^user verifies sign in is successfull or not$")
	public void user_verifies_sign_in_is_successfull_or_not() {
		String expectedTitle = "Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder";
		try
		{
			Assert.assertEquals(expectedTitle, landingpage.getTitle());
		}
		catch(Exception e)
		{
			reportFail("Username or Password is incorrect");
		}
	}

}
