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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseCucumber.BaseTest;
import utilities.DateUtils;

public class StudyChairsPageCucumber extends BaseTest {
	
	
	//************************ Important variables in StudyChairsPageCucumber  *****************************
	Map<String, Object[]> data; 
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("top five chairs");
	String name= null;
	String price = null;
	Set<String> windowIDs ;
	
	//************************ WebElements for ChairsPageCucumber ******************
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
	
	//********************************** Functions for StudyChairsPageCucumber ********************
	
	public StudyChairsPageCucumber() {		
		PageFactory.initElements(driver, this);
		data = new TreeMap<String, Object[]>();
		data.put("0", new Object[] { "Name", "Price" });
	}
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
				driver.switchTo().window(firstChairPage);			
				name =firstChairName.getText();
				price =firstChairPrice.getText();
				data.put("1",new Object[] {name,price});
				driver.close();
				driver.switchTo().window(mainpage);
			}
			
			else if(i==1)
			{
				driver.switchTo().window(secondChairPage);
				name =secondChairName.getText();
				price =secondChairPrice.getText();
				data.put("2",new Object[] {name,price});
				driver.close();
				driver.switchTo().window(mainpage);
			}
			
			else 
			{
				driver.switchTo().window(thirdChairPage);
				name =thirdChairName.getText();
				price =thirdChairPrice.getText();
				data.put("3",new Object[] {name,price});
				driver.close();
				driver.switchTo().window(mainpage);
			
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
			FileOutputStream writeFile = new FileOutputStream(System.getProperty("user.dir") +"/ChairsOutputFilesCucumber/"+fileName);
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
