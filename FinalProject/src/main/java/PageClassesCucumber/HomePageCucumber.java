package PageClassesCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import BaseCucumber.BaseTest;
import PageClasses.Bookshelves;
import PageClasses.StudyChairs;

public class HomePageCucumber extends BaseTest {

	// **************************** WebElements for HomePageCucumber
	

	@FindBy(xpath = "//div[@id='topnav_wrapper']/ul/li[5]")
	WebElement storageLink;

	@FindBy(xpath = "//div[@id='topnav_wrapper']/ul/li[5]/div/div/ul/li/ul/li/a[1]")
	WebElement bookshelvesLink;

	@FindBy(xpath = "//*[@id='topnav_wrapper']/ul/li[6]/span")
	WebElement studyLink;

	@FindBy(xpath = "//*[@id='topnav_wrapper']/ul/li[6]/div/div/ul/li[2]/ul/li[1]/a/span")
	WebElement chairs;

	// *********************** Functions for HomePageCucumber 
	public HomePageCucumber() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public BookshelvesPageCucumber getBookShelves() {

		Actions action = new Actions(driver);
		action.moveToElement(storageLink).build().perform();
		bookshelvesLink.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BookshelvesPageCucumber();
	}

	
	
	  public StudyChairsPageCucumber getStudyChairs() 
	  { 
		  Actions action = new Actions(driver);
		  action.moveToElement(studyLink).build().perform();
		  chairs.click();
		  return new StudyChairsPageCucumber();
	  }
	 

}
