package PageClassesCucumber;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseCucumber.BaseTest;
import PageClasses.HomePage;
import utilities.DateUtils;

public class BookshelvesPageCucumber extends BaseTest {

	// ******************* Important variables for putting data in Excel sheet
	// **************

	Map<String, Object[]> data;
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Top five");
	String name = null;
	String price = null;
	Set<String> windowIDs;

	// ******************** WebElements for BookshelvePageCucumber *****************
	@FindBy(xpath = "//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[1]")
	WebElement priceButton;

	@FindBy(xpath = "//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[1]/div")
	WebElement sliderA;

	@FindBy(xpath = "//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div")
	WebElement sliderB;

	@FindBy(xpath = "//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]")
	WebElement storageTypeButton;

	@FindBy(id = "filters_storage_type_Open")
	WebElement openStorage;

	// ***************** BookShelves Pages ***************
	@FindBy(xpath = "//*[@id='content']/div[4]/ul/li[1]/div/a")
	WebElement bookshelve1;

	@FindBy(xpath = "//*[@id='content']/div[4]/ul/li[2]/div/a")
	WebElement bookshelve2;

	@FindBy(xpath = "//*[@id='content']/div[4]/ul/li[3]/div/a")
	WebElement bookshelve3;

	@FindBy(xpath = "//*[@id='content']/div[4]/ul/li[4]/div/a")
	WebElement bookshelve4;

	@FindBy(xpath = "//*[@id='content']/div[4]/ul/li[5]/div/a")
	WebElement bookshelve5;

	// ********** BookShelves name *************

	@FindBy(xpath = "//*[@id=\"product-show\"]/div[1]/h1")
	WebElement firstBookshelfName;

	@FindBy(xpath = "//*[@id='product-show']/div[1]/h1")
	WebElement secondBookshelfName;

	@FindBy(xpath = "//*[@id='product-show']/div[1]/h1")
	WebElement thirdBookshelfName;

	@FindBy(xpath = "//*[@id='product-show']/div[1]/h1")
	WebElement fourthBookshelfName;

	@FindBy(xpath = "//*[@id='product-show']/div[1]/h1")
	WebElement fifthBookshelfName;

	// ************* Bookshelves prize ************

	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement firstBookshelfPrice;

	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement secondBookshelfPrice;

	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement thirdBookshelfPrice;

	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement fourthBookshelfPrice;

	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement fifthBookshelfPrice;

	@FindBy(xpath = "//*[@id=\"breadcrumbs\"]/ul/li[1]/a")
	WebElement home;

	// ********************************* Function for BookshelvesPageCucumber
	// ********************

	public BookshelvesPageCucumber() {
		PageFactory.initElements(driver, this);
		data = new TreeMap<String, Object[]>();
		data.put("0", new Object[] { "Name", "Price" });
	}

	public void selectPriceRange() {

		priceButton.click();

		// ********** For sliding the slider *************
		Actions move = new Actions(driver);
		move.dragAndDropBy(sliderA, 0, 0).click();
		move.build().perform();

		move.dragAndDropBy(sliderB, -206, 0).click();
		move.build().perform();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectStorageType() {

		storageTypeButton.click();
		Actions action = new Actions(driver);
		action.moveToElement(openStorage).build().perform();

	}

	public void getTopFiveBoohshelves() {
		bookshelve1.click();
		bookshelve2.click();
		bookshelve3.click();
		bookshelve4.click();
		bookshelve5.click();
		windowIDs = driver.getWindowHandles();

	}

	public void getDetailsBookshelves() {
		Iterator<String> itr = windowIDs.iterator(); // Iterator to iterate over the windowIDs which are sotred in set
		String mainpageId = itr.next();
		String FirstPageClass = itr.next();
		String SecondPageClass = itr.next();
		String ThirdPageClass = itr.next();
		String FourthPageClass = itr.next();
		String FifthPageClass = itr.next();

		for (int i = 0; i < 5; i++) {
			if (i == 0) {

				driver.switchTo().window(FirstPageClass);
				name = firstBookshelfName.getText();
				price = firstBookshelfPrice.getText();
				data.put("1", new Object[] { name, price });
				driver.close();
				driver.switchTo().window(mainpageId);
			}

			else if (i == 1) {

				driver.switchTo().window(SecondPageClass);
				name = secondBookshelfName.getText();
				price = secondBookshelfPrice.getText();
				data.put("2", new Object[] { name, price });
				driver.close();
				driver.switchTo().window(mainpageId);
			}

			else if (i == 2) {

				driver.switchTo().window(ThirdPageClass);
				name = thirdBookshelfName.getText();
				price = thirdBookshelfPrice.getText();
				data.put("3", new Object[] { name, price });
				driver.close();
				driver.switchTo().window(mainpageId);
			}

			else if (i == 3) {

				driver.switchTo().window(FourthPageClass);
				name = fourthBookshelfName.getText();
				price = fourthBookshelfPrice.getText();
				data.put("4", new Object[] { name, price });
				driver.close();
				driver.switchTo().window(mainpageId);

			} else {

				driver.switchTo().window(FifthPageClass);
				name = fifthBookshelfName.getText();
				price = fifthBookshelfPrice.getText();
				data.put("5", new Object[] { name, price });
				driver.close();
				driver.switchTo().window(mainpageId);
			}
		}

		Set<String> set = data.keySet();
		int rownum = 0;
		for (String key : set) {
			Row row = sheet.createRow(rownum++);
			Object[] dataValue = data.get(key);
			int cellnum = 0;
			for (Object value : dataValue) {
				Cell cell = row.createCell(cellnum++);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else {
					cell.setCellValue((Double) value);
				}

			}
		}

		try {
			String fileName = "Top_five_bookshelves" + DateUtils.getTimeStamp() + ".xlsx";
			FileOutputStream writeFile = new FileOutputStream(
					System.getProperty("user.dir") + "/BookshelveOutputFileCucumber/" + fileName);
			try {
				workbook.write(writeFile);
				writeFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HomePageCucumber goToHomePage(){
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", home);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePageCucumber();
	 }

}
