package StepDefinations;

import BaseCucumber.BaseTest;
import PageClassesCucumber.StudyChairsPageCucumber;
import cucumber.api.java.en.Then;

public class StudyChairsSteps extends BaseTest{
	
	StudyChairsPageCucumber studychair = new StudyChairsPageCucumber();
	
	@Then("^user clicks on the top three chairs$")
	public void user_clicks_on_the_top_three_chairs() {
		studychair.getChairs();
	}

	@Then("^user gets the data of top three chairs and store it in Excel sheet$")
	public void user_gets_the_data_of_top_three_chairs_and_store_it_in_Excel_sheet() {
		studychair.getChairData();
	}

}
