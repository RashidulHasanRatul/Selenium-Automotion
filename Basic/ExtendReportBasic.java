package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportBasic {

	public static void main(String[] args) throws InterruptedException {
		// Start Reporting
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		
		// Create ExtentRepot and attach Reporters
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// creates a toggle for the given test, adds all log events under it  
		ExtentTest  test = extent.createTest("Google Search", "IT is test to  validate google search Functionality");
		
		//  Start Test
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test.log(Status.INFO,"Starting Test Case" );
		
		String url = " https://www.google.com/";
		driver.get(url);
		test.pass("Nevigated Google.com");

		WebElement Searchbox = driver.findElement(By.xpath("//input[@name='q']"));
		Searchbox.sendKeys("Bangladesh");
		 Thread.sleep(3000);
		 test.pass("Enter Seraching World");

		WebElement searchbutton = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']"));
		searchbutton.click();
		test.pass("Click to Search Button");
		// Enter From Keyboard
		// searchbutton.sendKeys(Keys.RETURN);

		// Close browser
		driver.close();
		driver.quit();
		test.pass("Close the Test");
		test.info(" Test Completed ");
		
		extent.flush();
		
		
		
		
		
		
		
		
		
		
	}

}
