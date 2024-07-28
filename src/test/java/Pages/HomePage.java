package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class HomePage {

	WebDriver driver = BaseClass.driver;
	

	public HomePage() {

		PageFactory.initElements(driver, this);
		
		
	}
}
