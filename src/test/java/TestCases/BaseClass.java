package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void setUpDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.simplilearn.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
