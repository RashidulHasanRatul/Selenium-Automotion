package Basic;

import java.lang.ProcessHandle.Info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportTest {
	
	public static void main(String[] args) {
		
		// Starting Reporting 
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("testReport.html");
		
		// Create  Extent Report to attach reporter 
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		// creates a toggle for the given test, adds all log events under it 
		ExtentTest test= extent.createTest("RegistrationForm","To Fillup Registration From");
		// Starting TestCase 
		
		
		// Set Property
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		// geturl
			driver.manage().window().maximize();
			test.log(Status.INFO,"Start the test ");
		String url="https://wpforms.com/demo/user-registration-form-demo/";	
		driver.get(url);
		
		test.pass("Navigated Goole.com");
		
		Sleep(2000);
		// fillup page 
	
		WebElement fristname= driver.findElement(By.xpath("//input[@id='wpforms-259288-field_1']"));
		fristname.sendKeys("Ratul");
		test.pass("Fillup the Frist Box");
		Sleep(3000);
		WebElement lastname= driver.findElement(By.xpath("//input[@id='wpforms-259288-field_1-last']"));
		lastname.sendKeys("Hasan");
		test.pass("Fillup lastname");
		
		Sleep(3000);
		WebElement username= driver.findElement(By.xpath("//input[@id='wpforms-259288-field_2']"));
		username.sendKeys("RH RATUL");
		test.pass("Fillup Full Name");
		
		Sleep(1000);
		WebElement Email= driver.findElement(By.xpath("//input[@id='wpforms-259288-field_3']"));
		Email.sendKeys("rhratul121@gmail.com");
		
		
		Sleep(1000);
		WebElement password= driver.findElement(By.xpath("//input[@id='wpforms-259288-field_4']"));
		password.sendKeys("12345");
		test.pass("Create Password");
		Sleep(1000);
		WebElement Bio= driver.findElement(By.xpath("//textarea[@id='wpforms-259288-field_5']"));
		Bio.sendKeys("Hi I am Rashidul Hasan Nick Name Ratul , I want to be a Software Quality Assurance Engineer");
		test.pass("Fillup the Description");
		Sleep(1000);
		WebElement submitButton= driver.findElement(By.xpath("//button[@id='wpforms-submit-259288']"));
	
		submitButton.click();
		test.pass("Close The Test");
		
		test.log(Status.INFO,"End the Test");
		// verifiacation
		
		Sleep(3000);
		// close browser
		driver.quit();
		driver.close();
		
		extent.flush();
		
	
		
		
	}

	private static void Sleep(long i) {
		
		
	}
	
	
	
	
	
	

}
