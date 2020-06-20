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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import utilities.DateUtils;

public class StudyChairs extends PageBaseClass{
	
	Map<String, Object[]> data; 
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("top five chairs");
	
	public StudyChairs(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
		data = new TreeMap<String,Object[]>();
		data.put("0", new Object []{"Name","Price"});
	}
	
	
	String name= null;
	String price = null;
	Set<String> windowIDs ;
	
	//*********************** Link of top 3 chairs ******************
	
	@FindBy(xpath="//*[@id='content']/div[4]/div/ul/li[1]/div/a")
	WebElement chair1;
	
	@FindBy(xpath="//*[@id='content']/div[4]/div/ul/li[2]/div/a/img")
	WebElement chair2;
	
	@FindBy(xpath="//*[@id='content']/div[4]/div/ul/li[3]/div/a/img")
	WebElement chair3;
	
	//************************ Name elements for chairs *************
	@FindBy(xpath="//*[@id='product-show']/div[1]/h1")
	WebElement firstChairName;
	
	@FindBy(xpath="//*[@id='product-show']/div[1]/h1")
	WebElement secondChairName;
	
	@FindBy(xpath="//*[@id='product-show']/div[1]/h1")
	WebElement thirdChairName;
	
	//********************* Price elements for chairs ******************
	
	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement firstChairPrice;  
	
	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div") 
	WebElement secondChairPrice; 
	
	@FindBy(xpath="//*[@class='buy_details clearfix  current']/div/div/div[1]/div")
	WebElement thirdChairPrice;
	
	
	//****************** Functions *******************
	
	public void getChairs() {
		chair1.click();
		chair2.click();
		chair3.click();
		windowIDs = driver.getWindowHandles();
	}
	
	public void getChairData() {
		Iterator<String> itr = windowIDs.iterator();
		String mainpage = itr.next();
		String firstChairPage = itr.next();
		String secondChairPage = itr.next();
		String thirdChairPage = itr.next();
		
		for(int i =0;i<3;i++)
		{
			if(i==0)
			{
				logger.log(Status.INFO,"Switching to first chair page ");
				driver.switchTo().window(firstChairPage);
				logger.log(Status.PASS,"Switched to first chair page ");
				logger.log(Status.INFO, "Getting the name of the chair");
				name =firstChairName.getText();
				logger.log(Status.PASS, "Name : "+name +" found.");
				logger.log(Status.INFO, "Getting the prize of the chair.");
				price =firstChairPrice.getText();
				logger.log(Status.PASS, "Price is: "+ price);
				data.put("1",new Object[] {name,price});
				logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
				driver.close();
				logger.log(Status.INFO, "First chair page closed succseefully");
				logger.log(Status.INFO,"Switching back to the main page window");
				driver.switchTo().window(mainpage);
				logger.log(Status.PASS, "Successfull");
			}
			
			else if(i==1)
			{
				logger.log(Status.INFO,"Switching to second chair page ");
				driver.switchTo().window(secondChairPage);
				logger.log(Status.PASS,"Switched to second chair page ");
				logger.log(Status.INFO, "Getting the name of the chair");
				name =secondChairName.getText();
				logger.log(Status.PASS, "Name : "+name +" found.");
				logger.log(Status.INFO, "Getting the prize of the chair.");
				price =secondChairPrice.getText();
				logger.log(Status.PASS, "Price is: "+ price);
				data.put("2",new Object[] {name,price});
				logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
				driver.close();
				logger.log(Status.INFO, "Second chair page closed succseefully");
				logger.log(Status.INFO,"Switching back to the main page window");
				driver.switchTo().window(mainpage);
				logger.log(Status.PASS, "Successfull");
			}
			
			else 
			{
				logger.log(Status.INFO,"Switching to third chair page ");
				driver.switchTo().window(thirdChairPage);
				logger.log(Status.PASS,"Switched to third chair page ");
				logger.log(Status.INFO, "Getting the name of the chair");
				name =thirdChairName.getText();
				logger.log(Status.PASS, "Name : "+name +" found.");
				logger.log(Status.INFO, "Getting the prize of the chair.");
				price =thirdChairPrice.getText();
				logger.log(Status.PASS, "Price is: "+ price);
				data.put("3",new Object[] {name,price});
				logger.log(Status.PASS, "Data entered in Excel sheet successfully.");
				driver.close();
				logger.log(Status.INFO, "Third chair page closed succseefully");
				logger.log(Status.INFO,"Switching back to the main page window");
				driver.switchTo().window(mainpage);
				logger.log(Status.PASS, "Successfull");
			}
			
			
			
			
	}
		Set<String> set =data.keySet();
		int rownum=0;
		for(String key : set)  //0
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
			String fileName = "Top_Three_Chairs" +DateUtils.getTimeStamp()+".xlsx";
			FileOutputStream writeFile = new FileOutputStream(System.getProperty("user.dir") +"/ChairsOutputFiles/"+fileName);
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
}
