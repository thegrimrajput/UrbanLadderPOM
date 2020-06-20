package TestCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClasses.Bookshelves;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.StudyChairs;
import baseClasses.BaseTestClass;
import utilities.TestDataProvider;


public class SystemTest extends BaseTestClass
{
	
	LandingPage landingpage;
	HomePage homepage;
	Bookshelves bookshelves; 
	StudyChairs chairs;
	
	
	
	@Test(dataProvider ="getAwsTestData")
	
	public void SystemTest1(Hashtable <String,String> testData)  
	{
		logger = report.createTest("Picking up bookshelves and chairs : Chrome ");	
		invokeBrowser("chrome");
		landingpage = OpenApplication();
		homepage =landingpage.doLogin(testData.get("UserId"), testData.get("Password"));
		bookshelves =homepage.getBookShelves();
		bookshelves.selectPriceRange();
		bookshelves.selectStorageType();
		bookshelves.getTopFiveBoohshelves();
		bookshelves.getDetailsBookshelves();
		homepage =bookshelves.goToHomePage();
		chairs = homepage.getStudyChairs();
		chairs.getChairs();
		chairs.getChairData();
		
	}
	
	
	@Test(dataProvider= "getAwsTestData", enabled =  true)
	public void SystemTest2(Hashtable <String,String> testData)
	{
		logger = report.createTest("Picking up bookshelves and chairs: Opera ");
		invokeBrowser("opera");
		landingpage = OpenApplication();
		homepage =landingpage.doLogin(testData.get("UserId"), testData.get("Password"));
		bookshelves =homepage.getBookShelves();
		bookshelves.selectPriceRange();
		bookshelves.selectStorageType();
		bookshelves.getTopFiveBoohshelves();
		bookshelves.getDetailsBookshelves();
		homepage =bookshelves.goToHomePage();
		chairs = homepage.getStudyChairs();
		chairs.getChairs();
		chairs.getChairData();
		
	}
	
	@DataProvider
	public Object[][] getAwsTestData()
	{
		return TestDataProvider.getTestData("AWSLoginData.xlsx", "AWSLoginTest", "AWS Login");
	}
}