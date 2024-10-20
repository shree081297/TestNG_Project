package TestCases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Pages.HomePage;
import Pages.LoginPage;
import junit.framework.Assert;

import org.openqa.selenium.*;

@Listeners(Listners.class)
public class LoginTest extends BaseClass {
	Logger log = Logger.getLogger(HomePage.class);

	@Test(groups= {"sanity"},description="Login failure test")
	public void LoginFailureTest() {
		LoginPage lp = new LoginPage(GetDriver());
		lp.LoginFunction("abc@gmail.com", "Shree@123");

		String ActualTitle = lp.validateTitle();
		Assert.assertEquals(ActualTitle, "Login | Learning on Simplilearn");

	}

	@Test(groups= {"sanity","regression"}, description="Login sucess test")
	public void Tc_02LoginSucessTest() {
		LoginPage lp = new LoginPage(GetDriver());
		lp.LoginFunction("srikanthkurella01@gmail.com", "Shree@123");
		String ActualTitle = lp.validateTitle();
		Assert.assertEquals(ActualTitle, "Learning on Simplilearn");
	}

	@Test
	@Parameters({ "param1", "param2" })
	public void Tc_03LoginSucessTest(String uname, String pwd) {
		LoginPage lp = new LoginPage(GetDriver());
		lp.LoginFunction(uname, pwd);
	}

	
	Map<String, String> testdata = new HashMap<String, String>();

	@Test(dataProvider = "dp",groups= {"sanity","regression"}, description="Login sucess dataprovider test")
	public void TC04_LoginSuccessTest(String key) {

		LoginPage lp = new LoginPage(GetDriver());
		lp.LoginFunction(key, testdata.get(key));
	}

	@DataProvider(name = "dp")
	public Iterator<String> method1() {

		testdata.put("aaa@xyz.com", "Abc@1234");
		testdata.put("bbb@xyz.com", "Abc@1234");
		testdata.put("ccc@xyz.com", "Abc@1234");
		testdata.put("Srikanthkurella123@gmail.com", "Shree@123");

		return testdata.keySet().iterator();

	}

	/*@Test
	public void Tc_005() {
		LoginPage lp = new LoginPage();
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		lp.LoginFunction(UserName, Password);
		lp.validateError("The email or password you have entered is invalid.");

	}*/
}
