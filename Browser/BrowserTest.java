package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {

		// SetProperty

		WebDriverManager.chromedriver().setup();

		/*
		 * For Fire Fox Browser
		 * 
		 * WebDriverManager.firefoxdriver().setup(); WebDriver driver = new
		 * FirefoxDriver();
		 * 
		 */

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Get URL

		String url = " https://www.google.com/";
		driver.get(url);

		WebElement Searchbox = driver.findElement(By.xpath("//input[@name='q']"));
		Searchbox.sendKeys("Bangladesh");
		// Thread.sleep(3000);

		WebElement searchbutton = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']"));
		searchbutton.click();
		// Enter From Keyboard
		// searchbutton.sendKeys(Keys.RETURN);

		// Close browser
		driver.quit();

	}

}
