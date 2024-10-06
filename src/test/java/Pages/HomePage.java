package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import TestCases.BaseClass;

public class HomePage {
	Logger log=Logger.getLogger(HomePage.class);

	WebDriver driver = BaseClass.driver;
	

	public HomePage() {

		PageFactory.initElements(driver, this);
		
		
	}
}
