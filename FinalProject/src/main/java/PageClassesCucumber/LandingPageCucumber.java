package PageClassesCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseCucumber.BaseTest;

public class LandingPageCucumber extends BaseTest {
	
	
	//********************************** WebElements of landing page ***************************
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
	
	
	//**************************** Functions of landing page *****************************
	
	public LandingPageCucumber(){
		PageFactory.initElements(driver,this);
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public HomePageCucumber doLogin(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver,30); 
		wait.until(ExpectedConditions.visibilityOf(loginLink));
		loginLink.click();
		wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		return new HomePageCucumber();
	}

}
