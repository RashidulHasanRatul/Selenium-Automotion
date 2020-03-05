package Browser;



import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class MultiBrowserTestNG {
	
	
	WebDriver driver;
	@org.testng.annotations.Parameters("BrowserName")
	@BeforeTest
	public void setup(String BrowserName)
	{
		System.out.println("The Browser Name Is:-"+BrowserName);
		
		if(BrowserName.equalsIgnoreCase("chorme")) {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} 
		else if (BrowserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		
	}
	@Test
	public void gooletest() throws InterruptedException
	{
		
		String url="https://www.google.com/";
		driver.get(url);
		
		 Thread.sleep(4000);
			System.out.println(driver.getTitle());
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}

}
