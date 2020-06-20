package baseClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.DateUtils;

public class PageBaseClass extends BaseTestClass
{
	
	
	public PageBaseClass(WebDriver driver, ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	public void getTitle(String expectedTitle)
	{
		try {
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		reportPass("Actual title: "+ driver.getTitle() + " matched with expected.");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}

	
	
	public void reportFail(String reportMessage) {
		//System.out.println("Inside the report failed method ");
		logger.log(Status.FAIL, reportMessage);
		takeScreenShotOnFailure();
		Assert.fail(reportMessage);
	}

	public void reportPass(String reportMessage) {
		logger.log(Status.PASS, reportMessage);
	}

	public void takeScreenShotOnFailure() {

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver; // Class helps us to take screenshot takesScreenShot
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE); // Creates file for that screenshot. File is
																			// in binary form here.
		File destinationFile = new File(
				System.getProperty("user.dir") + "/Screenshot/" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/Screenshot/" + DateUtils.getTimeStamp() + ".png"); // To store
																											// the final
																											// screenshot
																											// into the
																											// screenshot
																											// folder
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public  void checkPageLoaded()   //To check the whole page is loaded fully before using WebElements
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		for(int i =0;i<25;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(js.executeScript("return document.readyState").toString().equals("complete"))
			{
				break;
			}
			
		}
	}
	
	public void isVisible(WebElement element)   //For login functions
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		}
		catch(Exception e)
		{
			reportFail("Email or password incorrect");
		}
		
	}

	public void isAvailable(WebElement element,int time)  //To wait until the element is visible
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
		
	}

}
