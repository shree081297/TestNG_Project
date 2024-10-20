package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {

	public static WebDriver driver;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public void SetDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	public WebDriver GetDriver() {

		return threadLocalDriver.get();

	}

	@BeforeMethod(alwaysRun = true)
	public void SetUpDriver() throws MalformedURLException {

		String browser = System.getProperty("Browser");
		// String mode = System.getProperty("Mode");

		// String browser = "chrome";

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("remote-chrome")) {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WIN11);
			cap.setBrowserName("chrome");

			URL hub = new URL("http://localhost:4444/");
			driver = new RemoteWebDriver(hub, cap);

		} else {
			driver = new ChromeDriver();
		}

		SetDriver(driver);
		GetDriver().get("https://simplilearn.com/");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void TearDown() {

		GetDriver().quit();
	}

	@BeforeTest
	public void SetUpData() throws IOException {
		FileInputStream ip = new FileInputStream("ExcelData.xlsx");
		workbook = new XSSFWorkbook(ip);
		sheet = workbook.getSheet("Sheet1");

	}

	@AfterTest
	public void CloseExcel() throws IOException {
		workbook.close();
	}
}
