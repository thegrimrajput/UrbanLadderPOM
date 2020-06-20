package baseClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.LandingPage;
import utilities.ExtentReportManager;

public class BaseTestClass 
{
	
	public  WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	
	public void invokeBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				driver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.opera.driver",System.getProperty("user.dir") +"/Drivers/operadriver");
				driver = new OperaDriver();
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, e.getMessage());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void flushReports()
	{
		report.flush();
	}
	
	public LandingPage OpenApplication()
	{
		logger.log(Status.INFO,"Opening the website");
		String url = "https://www.urbanladder.com/";
		driver.get(url); 
		try
		{
		Assert.assertEquals(driver.getTitle(),"Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder");

		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		logger.log(Status.PASS, "Opened Urban Ladder Successfully");
		LandingPage landingpage = new LandingPage(driver,logger);
		PageFactory.initElements(driver, landingpage);
		return landingpage;
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
