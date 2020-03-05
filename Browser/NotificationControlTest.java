package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationControlTest {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	ChromeOptions options ;

	@BeforeSuite
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		//options.addArguments("--enable-notifications");
		driver.manage().deleteAllCookies();

	

	}

	@Test
	public void NotificationTest() throws InterruptedException {

		

		htmlReporter = new ExtentHtmlReporter("Notification Control.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		test = extent.createTest("Off the Notification to Chrome Browser");

		test.log(Status.INFO, "Start ing The Testing ");

		
		driver.manage().window().maximize();
		test.pass("Navigated To Prothom Alo Home Page ");
		String url = "https://www.prothomalo.com/";
		driver.get(url);
       test.info("End the Test");
		Thread.sleep(3000);

	}

	@AfterSuite
	public void TearDown() {
		driver.close();
		driver.quit();
		extent.flush();

	}

}
