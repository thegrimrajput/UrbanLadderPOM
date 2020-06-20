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

public class LoginUnitTest extends BaseTestClass{
	

	LandingPage landingpage;
	HomePage homepage;
	Bookshelves bookshelves; 
	StudyChairs chairs;
	
	
	
	@Test(dataProvider ="getTestData")
	
	public void SystemTest1(Hashtable <String,String> testData)  
	{
		logger = report.createTest("Login Unit Test  : Chrome ");	
		invokeBrowser("chrome");
		landingpage = OpenApplication();
		homepage =landingpage.doLogin(testData.get("UserId"), testData.get("Password"));
			
	}
	 
	
	@Test(dataProvider= "getTestData" ,enabled =false)
	public void SystemTest2(Hashtable <String,String> testData)
	{
		logger = report.createTest("Login Unit Test : Opera ");
		invokeBrowser("opera");
		landingpage = OpenApplication();
		homepage =landingpage.doLogin(testData.get("UserId"), testData.get("Password"));
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		return TestDataProvider.getTestData("UrbanLadderTestData.xlsx", "Urbanladderlogintest", "UrbanLadderLogin");
	}
}
