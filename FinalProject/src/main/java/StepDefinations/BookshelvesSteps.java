package StepDefinations;


import BaseCucumber.BaseTest;
import PageClassesCucumber.BookshelvesPageCucumber;
import cucumber.api.java.en.Then;

public class BookshelvesSteps extends BaseTest{

	BookshelvesPageCucumber  bookshelves = new BookshelvesPageCucumber();

	@Then("^user selects the price range$")
	public void user_selects_the_price_range_of() {
		bookshelves.selectPriceRange();
	}

	@Then("^user selects the storage type as Open$")
	public void user_selects_the_storage_type_as_Open() {
		bookshelves.selectStorageType();
	}

	@Then("^user clicks on the top five bookshelves$")
	public void user_clicks_on_the_top_five_bookshelves() {
		bookshelves.getTopFiveBoohshelves();
	}

	@Then("^user gets the data of top five bookshelves and store it in Excel sheet$")
	public void user_gets_the_data_of_top_five_bookshelves_and_store_it_in_Excel_sheet() {
		bookshelves.getDetailsBookshelves();
	}
	
	@Then("^user goes back to the homeoage$")
	public void user_goes_back_to_the_homeoage() {
		bookshelves.goToHomePage();
	}


}
