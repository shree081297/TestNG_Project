package TestCases;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.LoginPage;
import junit.framework.Assert;

import org.openqa.selenium.*;
@Listeners(Listners.class)
public class LoginTest extends BaseClass {

	@Test(priority=0)
	public void LoginFailureTest() {

		LoginPage lp = new LoginPage();
		lp.LoginFunction("abc@gmail.com", "Shree@123");
		lp.validateError("The email or password you have entered is invalid");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		

	}
	@Test(priority=1)
	public void Tc_02LoginSucessTest() {
		LoginPage lp = new LoginPage();
		lp.LoginFunction("srikanthkurella01@gmail.com", "Shree@123");
	}
}
