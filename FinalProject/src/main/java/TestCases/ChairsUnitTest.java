package TestCases;


import org.testng.annotations.Test;

import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.StudyChairs;
import baseClasses.BaseTestClass;

public class ChairsUnitTest  extends  BaseTestClass{
	

	LandingPage landingpage;
	HomePage homepage;
	StudyChairs chairs;
	
	@Test
	public void ChairsTest1()  
	{
		logger = report.createTest("Picking up bookshelves and chairs : Chrome ");	
		invokeBrowser("chrome");
		landingpage = OpenApplication();
		homepage =landingpage.cancelLogin();
		chairs = homepage.getStudyChairs();
		chairs.getChairs();
		chairs.getChairData();		
	}
	
	@Test
	public void ChairsTest2()  {
		logger = report.createTest("Picking up bookshelves and chairs : Opera ");	
		invokeBrowser("opera");
		landingpage = OpenApplication();
		homepage =landingpage.cancelLogin();
		chairs = homepage.getStudyChairs();
		chairs.getChairs();
		chairs.getChairData();
	}
}
