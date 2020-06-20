package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import junit.framework.Assert;

public class LandingPage extends PageBaseClass 
{
	

	public LandingPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
	}
	
	@FindBy(linkText=("Log-in"))
	WebElement loginLink;
	
	@FindBy(xpath ="//div[@id='password-credentials']//input[@id='spree_user_email']")
	WebElement usernameTextBox;
	
	@FindBy(xpath ="//div[@id='password-credentials']/div/div/input[@id='spree_user_password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@id='login_form']/input[3]")
	WebElement loginButton;
	
	@FindBy(xpath ="//*[@id=\"topnav_wrapper\"]/ul/li[5]/span")
	WebElement storageButton;
	
	@FindBy(xpath="//*[@id=\"authentication_popup\"]/div[1]/div/div[2]/a[1]")
	WebElement cancelLoginButton;
	
	public HomePage cancelLogin(){
		cancelLoginButton.click();
		HomePage homepage = new HomePage(driver,logger);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}
	
	public HomePage doLogin(String username, String password)
	{
		logger.log(Status.INFO,"Using the sign in option");
		isAvailable(loginLink,30);
		loginLink.click();
		logger.log(Status.PASS,"User ready to enter username and password");
		logger.log(Status.INFO, "User entering username " + username);
		isAvailable(usernameTextBox,10);
		usernameTextBox.sendKeys(username);
		logger.log(Status.PASS,"username entered successfully " + username);
		logger.log(Status.INFO,"User entering the password " + password);
		passwordTextBox.sendKeys(password);
		logger.log(Status.PASS,"Password entered succesfully ");
		logger.log(Status.INFO,"Clicking the login button");
		loginButton.click(); 
		
		//From here I am deleting the solid wait 5 seconds thread.sleep();
		checkPageLoaded();
		String title = driver.getTitle();
		if(title.equals("Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder"))
		{
			logger.log(Status.PASS,"User signed in successfully");
		}
		else
		{
			reportFail("User email or password incorrect ");
		}
		
		HomePage homepage = new HomePage(driver,logger);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}
	
}

