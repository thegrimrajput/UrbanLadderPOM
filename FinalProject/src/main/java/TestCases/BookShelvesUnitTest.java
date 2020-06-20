package TestCases;
import org.testng.annotations.Test;

import PageClasses.Bookshelves;
import PageClasses.HomePage;
import PageClasses.LandingPage;
import baseClasses.BaseTestClass;

public class BookShelvesUnitTest extends BaseTestClass {
	LandingPage landingpage;
	HomePage homepage;
	Bookshelves bookshelves; 
	
	@Test
	public void BookshelvesUnitTest1()  {
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
	}
	
	@Test
	public void BookshelvesUnitTest2()
	{
		logger = report.createTest("Picking up bookshelves and chairs: Opera ");
		invokeBrowser("opera");
		landingpage = OpenApplication();
		homepage =landingpage.cancelLogin();
		bookshelves =homepage.getBookShelves();
		bookshelves.selectPriceRange();
		bookshelves.selectStorageType();
		bookshelves.getTopFiveBoohshelves();
		bookshelves.getDetailsBookshelves();
		homepage =bookshelves.goToHomePage();
		
	}
	
}
