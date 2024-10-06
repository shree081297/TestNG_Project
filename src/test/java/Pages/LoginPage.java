package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;
import junit.framework.Assert;

public class LoginPage {
	
	@FindBy(className="login")
	WebElement loginlink;
	
	@FindBy(name="user_login")
	WebElement username ;
	
	@FindBy(id="password")
	WebElement password ;
	
	@FindBy(id="remember-me")
	WebElement rememberMe;
	
	@FindBy(name="btn_login")
	WebElement loginBtn;
	
	@FindBy(id="msg_box")
	WebElement error ;
	
	@FindBy(xpath="//img[@alt='Simplilearn Logo']")
	WebElement logo;
	

	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}

	WebDriver driver = BaseClass.driver;

	public void LoginFunction(String UserName, String Password) {

		loginlink.click();
		username.sendKeys(UserName);
		password.sendKeys(Password);
		rememberMe.click();
		loginBtn.click();

	}
	public void validateError(String ExpectedMess) {
		String actualMess=error.getText();
		Assert.assertEquals(actualMess, ExpectedMess);
	}
	public String validateTitle() {
		//String ActualTitle=driver.getTitle();
		//Assert.assertEquals(ActualTitle, ExpTitle);
		return driver.getTitle();
		
	}
	public boolean validatelogo() {
	
		return logo.isDisplayed();
		
	}
}
