package BaseCucumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BaseTest {

	public static  WebDriver driver;
	public static Properties prop;
	
	public BaseTest()
	{
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/ConfigCucumber/config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void  initBrowser(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else{
			System.out.println("Only one browser is available. Please enter chrome or Chrome.....");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	
	public  void checkPageLoaded()   //To check the whole page is loaded fully before using WebElements
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		for(int i =0;i<25;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(js.executeScript("return document.readyState").toString().equals("complete"))
			{
				break;
			}
			
		}
	}
	
	public void reportFail(String message) {
		Assert.fail(message);
	}
}
