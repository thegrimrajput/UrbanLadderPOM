package PageClasses;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import utilities.DateUtils;

public class Bookshelves extends PageBaseClass{

	
	Map<String,Object[]> data;
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Top five");
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public Bookshelves(WebDriver driver, ExtentTest logger){
		super(driver,logger);
		data= new TreeMap<String,Object[]>();
		data.put("0",new Object[] {"Name","Price"});
	}
	String name = null;
	String price = null;
	Set<String> windowIDs;
	
	@FindBy(xpath="//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[1]")
	WebElement priceButton;
	
	@FindBy(xpath="//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[1]/div")
	WebElement sliderA;
	
	@FindBy(xpath="//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div")
	WebElement sliderB;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]")
	WebElement  storageTypeButton;
	
	@FindBy(id="filters_storage_type_Open")
	WebElement openStorage;
	
	//***************** BookShelves Pages ***************
	@FindBy(xpath="//*[@id='content']/div[4]/ul/li[1]/div/a")
	WebElement bookshelve1;
	
	@FindBy(xpath="//*[@id='content']/div[4]/ul/li[2]/div/a")
	WebElement bookshelve2;
	
	@FindBy(xpath="//*[@id='content']/div[4]/ul/li[3]/div/a")
	WebElement bookshelve3;
	
	@FindBy(xpath="//*[@id='content']/div[4]/ul/li[4]/div/a")
	WebElement bookshelve4;
	
	@FindBy(xpath="//*[@id='content']/div[4]/ul/li[5]/div/a")
	WebElement bookshelve5;
	
	//********** BookShelves name *************
	
	@FindBy(xpath ="//*[@id=\"product-show\"]/div[1]/h1")
	WebElement firstBookshelfName;
	
	@FindBy(xpath ="//*[@id='product-show']/div[1]/h1") 
	WebElement secondBookshelfName;
	
	@FindBy(xpath ="//*[@id='product-show']/div[1]/h1") 
	WebElement thirdBookshelfName;
	

	@FindBy(xpath ="//*[@id='product-show']/div[1]/h1") 
	WebElement fourthBookshelfName;

	@FindBy(xpath ="//*[@id='product-show']/div[1]/h1") 
	WebElement fifthBookshelfName;
	
	
	//************* Bookshelves prize ************
	
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
	
	@FindBy(xpath="//*[@id=\"breadcrumbs\"]/ul/li[1]/a")
	WebElement home;
	
	public void selectPriceRange(){
		
		getTitle("Bookshelf: Buy Latest Bookshelves Online in India At Best Prices - Urban Ladder");
		logger.log(Status.INFO,"Clicking on the price button to select range ");
		priceButton.click();
		logger.log(Status.PASS, "Price button clicked successfully");
		
		//********** For sliding the slider *************
		logger.log(Status.INFO, "Selecting the price range of 1000 - 150000");
		wait.until(ExpectedConditions.visibilityOf(sliderA));
	    Actions move = new Actions(driver);
	    move.dragAndDropBy(sliderA,0, 0).click();
	    move.build().perform();
	    move.dragAndDropBy(sliderB, -206, 0).click();
	    move.build().perform();
	    wait.until(ExpectedConditions.visibilityOf(storageTypeButton));
	    logger.log(Status.PASS, "Price range selected successfully");
	    
	    /*try {
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	 public void selectStorageType(){
	     JavascriptExecutor js = (JavascriptExecutor)driver;
		 logger.log(Status.INFO,"Selecting storage type: Open ");
		 Actions action = new Actions(driver);
		 action.moveToElement(storageTypeButton).build().perform();
		 js.executeScript("arguments[0].click();", openStorage);
		 logger.log(Status.PASS,"Storage type selected: Open");
		 wait.until(ExpectedConditions.visibilityOf(bookshelve1));
		 
	    }
	 
	 public void getTopFiveBoohshelves(){
		 bookshelve1.click();
		 bookshelve2.click();
		 bookshelve3.click();
		 bookshelve4.click();
		 bookshelve5.click();
		 windowIDs = driver.getWindowHandles();
		 
	 }
	 
	 public void getDetailsBookshelves(){
		 Iterator<String> itr = windowIDs.iterator();   //Iterator to iterate over the windowIDs which are sotred in set 
			String mainpageId = itr.next(); 
			String FirstPageClass = itr.next();
			String SecondPageClass = itr.next();
			String ThirdPageClass = itr.next();
			String FourthPageClass = itr.next();
			String FifthPageClass = itr.next();
			
			for(int i =0;i<5;i++)
			{
				if(i==0)
				{
					logger.log(Status.INFO,"Switching to first Bookshlef page ");
					driver.switchTo().window(FirstPageClass);
					logger.log(Status.PASS,"Switched to first bookshef page ");
					logger.log(Status.INFO, "Getting the name of the bookshelf");
					name =firstBookshelfName.getText();
					logger.log(Status.PASS, "Name : "+name +" found.");
					logger.log(Status.INFO, "Getting the prize of the bookshelf.");
					price =firstBookshelfPrice.getText();
					logger.log(Status.PASS, "Price is: "+ price);
					data.put("1",new Object[] {name,price});
					logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
					driver.close();
					logger.log(Status.INFO, "First bookshelf page closed succseefully");
					logger.log(Status.INFO,"Switching back to the main page window");
					driver.switchTo().window(mainpageId);
					logger.log(Status.PASS, "Successfull");
				}
				
				else if(i==1)
				{
					logger.log(Status.INFO,"Switching to second Bookshlef page ");
					driver.switchTo().window(SecondPageClass);
					logger.log(Status.PASS,"Switched to second bookshef page ");
					logger.log(Status.INFO, "Getting the name of the bookshelf");
					name =secondBookshelfName.getText();
					logger.log(Status.PASS, "Name : "+name +" found.");
					logger.log(Status.INFO, "Getting the prize of the bookshelf.");
					price =secondBookshelfPrice.getText();
					logger.log(Status.PASS, "Price is: "+ price);
					data.put("2",new Object[] {name,price});
					logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
					driver.close();
					logger.log(Status.INFO, "Second bookshelf page closed succseefully");
					logger.log(Status.INFO,"Switching back to the main page window");
					driver.switchTo().window(mainpageId);
					logger.log(Status.PASS, "Successfull");
				}
				
				else if(i==2)
				{
					logger.log(Status.INFO,"Switching to third Bookshlef page ");
					driver.switchTo().window(ThirdPageClass);
					logger.log(Status.PASS,"Switched to third bookshef page ");
					logger.log(Status.INFO, "Getting the name of the bookshelf");
					name =thirdBookshelfName.getText();
					logger.log(Status.PASS, "Name : "+name +" found.");
					logger.log(Status.INFO, "Getting the prize of the bookshelf.");
					price =thirdBookshelfPrice.getText();
					logger.log(Status.PASS, "Price is: "+ price);
					data.put("3",new Object[] {name,price});
					logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
					driver.close();
					logger.log(Status.INFO, "Third bookshelf page closed succseefully");
					logger.log(Status.INFO,"Switching back to the main page window");
					driver.switchTo().window(mainpageId);
					logger.log(Status.PASS, "Successfull");
				}
				
				else if(i==3)
				{
					logger.log(Status.INFO,"Switching to fourth Bookshlef page ");
					driver.switchTo().window(FourthPageClass);
					logger.log(Status.PASS,"Switched to fourth bookshef page ");
					logger.log(Status.INFO, "Getting the name of the bookshelf");
					name =fourthBookshelfName.getText();
					logger.log(Status.PASS, "Name : "+name +" found.");
					logger.log(Status.INFO, "Getting the prize of the bookshelf.");
					price =fourthBookshelfPrice.getText();
					logger.log(Status.PASS, "Price is: "+ price);
					data.put("4",new Object[] {name,price});
					logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
					driver.close();
					logger.log(Status.INFO, "Fourth bookshelf page closed succseefully");
					logger.log(Status.INFO,"Switching back to the main page window");
					driver.switchTo().window(mainpageId);
					logger.log(Status.PASS, "Successfull");
				}
				else
				{
					logger.log(Status.INFO,"Switching to fifth Bookshlef page ");
					driver.switchTo().window(FifthPageClass);
					logger.log(Status.PASS,"Switched to fifth bookshef page ");
					logger.log(Status.INFO, "Getting the name of the bookshelf");
					name =fifthBookshelfName.getText();
					logger.log(Status.PASS, "Name : "+name +" found.");
					logger.log(Status.INFO, "Getting the prize of the bookshelf.");
					price =fifthBookshelfPrice.getText();
					logger.log(Status.PASS, "Price is: "+ price);
					data.put("5",new Object[] {name,price});
					logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
					driver.close();
					logger.log(Status.INFO, "Fifth bookshelf page closed succseefully");
					logger.log(Status.INFO,"Switching back to the main page window");
					driver.switchTo().window(mainpageId);
					logger.log(Status.PASS, "Successfull");
				}
			}
			
			
			Set<String> set =data.keySet();
			int rownum=0;
			for(String key : set)
			{
				Row row = sheet.createRow(rownum++);
				Object[] dataValue = data.get(key);
				int cellnum =0;
				for(Object value : dataValue)
				{
					Cell cell = row.createCell(cellnum++);
					if(value instanceof String)
					{
						cell.setCellValue((String) value);
					}
					else
					{
						cell.setCellValue((Double) value);
					}
					
				}
			}
			
			
			try {
				String fileName = "Top_five_bookshelves" +DateUtils.getTimeStamp()+".xlsx";
				FileOutputStream writeFile = new FileOutputStream(System.getProperty("user.dir") +"/BookshelveOutputFiles/"+fileName);
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
	 
	 public HomePage goToHomePage(){
		 isAvailable(home,20);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", home);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 HomePage homepage = new HomePage(driver,logger);
		 PageFactory.initElements(driver, homepage);
		 return homepage;
	 }
	 
	 
	 
	 
	 
}
