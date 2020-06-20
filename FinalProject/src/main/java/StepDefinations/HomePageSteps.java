package StepDefinations;

import BaseCucumber.BaseTest;
import PageClassesCucumber.BookshelvesPageCucumber;
import PageClassesCucumber.HomePageCucumber;
import PageClassesCucumber.StudyChairsPageCucumber;
import cucumber.api.java.en.Then;

public class HomePageSteps  extends BaseTest{

	HomePageCucumber homepage = new HomePageCucumber();
	BookshelvesPageCucumber bookshelves;
	StudyChairsPageCucumber studychairs;
	
	
	@Then("^user open the bookshelves page$")
	public void user_open_the_bookshelves_page() {
		bookshelves = homepage.getBookShelves();
	}
	
	@Then("^user open the chairs page$")
	public void user_open_the_chairs_page() {
	     studychairs = homepage.getStudyChairs();
	}


}
