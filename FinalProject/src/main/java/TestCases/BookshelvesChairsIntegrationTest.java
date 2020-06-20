package TestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import PageClasses.Bookshelves;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import PageClasses.StudyChairs;
import baseClasses.BaseTestClass;

public class BookshelvesChairsIntegrationTest extends BaseTestClass {
	LandingPage landingpage;
	HomePage homepage;
	Bookshelves bookshelves; 
	StudyChairs chairs;
	
	
	
	@Test
	public void BookshelvesChairsIntegrationTest1()  
	{
		logger = report.createTest("Picking up bookshelves and chairs : Chrome ");	
		invokeBrowser("chrome");
		landingpage = OpenApplication();
		homepage =landingpage.cancelLogin();
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
	
	@Test
	public void BookshelvesChairsIntegrationTest2()  
	{
		logger = report.createTest("Picking up bookshelves and chairs : Opera");	
		invokeBrowser("opera");
		landingpage = OpenApplication();
		homepage =landingpage.cancelLogin();
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
}
