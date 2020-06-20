package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class HomePage extends PageBaseClass{
	
	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
	}
	
	@FindBy(xpath="//div[@id='topnav_wrapper']/ul/li[5]")
	WebElement storageLink;
	
	@FindBy(xpath="//div[@id='topnav_wrapper']/ul/li[5]/div/div/ul/li/ul/li/a[1]")
	WebElement bookshelvesLink;
	
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]/span")
	WebElement studyLink;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]/div/div/ul/li[2]/ul/li[1]/a/span")
	WebElement chairs;
	
	public Bookshelves getBookShelves(){
		
		logger.log(Status.INFO,"Opening the bookshelves page");
		Actions action = new Actions(driver);
		action.moveToElement(storageLink).build().perform();
		bookshelvesLink.click();
		checkPageLoaded();
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	    Bookshelves bookshelves = new Bookshelves(driver,logger);
	    PageFactory.initElements(driver, bookshelves);
	    return bookshelves;
	}
	
	public StudyChairs getStudyChairs() {
		 Actions action = new Actions(driver);
		 action.moveToElement(studyLink).build().perform();
		 chairs.click();
		 StudyChairs studychairs = new StudyChairs(driver,logger);
		 PageFactory.initElements(driver, studychairs);
		 return studychairs;
	}
	
	
	
	
}
