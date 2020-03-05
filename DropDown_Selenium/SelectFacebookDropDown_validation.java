package DropDown_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectFacebookDropDown_validation {

	@Test
	public void selectDDvalue() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
		
WebElement month_dropdown = driver.findElement(By.id("month"));
		
		Select month_dd = new Select (month_dropdown);
		
		//It will Select March
		month_dd.selectByIndex(1);
		
		Thread.sleep(3000);
		 
		// It will select October
		month_dd.selectByValue("10");
		
		
		WebElement selected_value=month_dd.getFirstSelectedOption();
		System.out.println("Before Selection Selected Value is"+selected_value.getText());
		
		
		
		WebElement day_dropdown = driver.findElement(By.id("day"));
		
		Select dd = new Select (day_dropdown);
		
		dd.selectByVisibleText("15");
		Thread.sleep(3000);
		
		//It will Select March
		//month_dd.selectByIndex(1);
		
		Thread.sleep(3000);
		
		// It will select October
		//month_dd.selectByValue("10");
		
		Thread.sleep(3000);
		
		// Recomended
		// It will select Aug
		month_dd.selectByVisibleText("Aug");
		
		System.out.println();
		
		Thread.sleep(3000);
		
		WebElement yeardropdown= driver.findElement(By.id("year"));
		
		Select year = new Select (yeardropdown);
		
		year.selectByVisibleText("2014");
		
		// Validation for Month  its Right or not 
		
		WebElement selected_value1=month_dd.getFirstSelectedOption();
		
		System.out.println("After Selection Selected Value is"+selected_value1.getText());
		
		
		List <WebElement>month_list= month_dd.getOptions();
		
		int total_mont=month_list.size();
		
		Assert.assertEquals(total_mont, 13);
		
		
		System.out.println("Total Month Count is "+total_mont);
		
		for (WebElement ele:month_list)
		{
			String month_name=ele.getText();
			System.out.println("Month Are ==="+month_name);
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
