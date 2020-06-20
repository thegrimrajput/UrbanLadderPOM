package TestCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClasses.Bookshelves;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.StudyChairs;
import utilities.TestDataProvider;
import baseClasses.BaseTestClass;

public class LoginChairsIntegrationTest extends BaseTestClass{
	LandingPage landingpage;
	HomePage homepage;
	StudyChairs chairs;
	
	@Test(dataProvider ="getAwsTestData")
	public void LoginChairsIntegrationTest1(Hashtable <String,String> testData){
		logger = report.createTest("Picking up bookshelves and chairs : Chrome ");	
		invokeBrowser("chrome");
		landingpage = OpenApplication();
		homepage =landingpage.doLogin(testData.get("UserId"), testData.get("Password"));
		chairs = homepage.getStudyChairs();
		chairs.getChairs();
		chairs.getChairData();
	}
	
	
	@Test(dataProvider= "getAwsTestData")
	public void  LoginChairsIntegrationTest2(Hashtable <String,String> testData){
		logger = report.createTest("Picking up bookshelves and chairs : Opera ");	
		invokeBrowser("opera");
		landingpage = OpenApplication();
		homepage =landingpage.doLogin(testData.get("UserId"), testData.get("Password"));
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
