package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {

	public static WebDriver driver;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	@BeforeMethod(alwaysRun=true)
	public void setUpDriver() {
		String browser=System.getProperty("Browser");
		if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
	
		}
		driver.manage().window().maximize();
		driver.get("https://www.simplilearn.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeTest
	public void SetUpData() throws IOException {
		FileInputStream ip=new FileInputStream("ExcelData.xlsx");
		workbook=new XSSFWorkbook(ip);
		sheet=workbook.getSheet("Sheet1");
		
	}
	@AfterTest
	public void CloseExcel() throws IOException {
		workbook.close();
	}
}
