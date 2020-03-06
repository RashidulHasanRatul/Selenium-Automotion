package DynamicRadioButtonAndCheckbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radio_Button_Handle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		String url= "https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html";
		driver.get(url);
		
		// RadioButton
	List<WebElement> radio=	driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));

	for (int i =0;i<radio.size();i++) {
		
		WebElement localRadio=radio.get(i);
		
		String value = localRadio.getAttribute("value");
		
		System.out.println("values from Radio Button are>>>>>>>>>"+value);
		
		if(value.equalsIgnoreCase("Ruby")) {
			
			localRadio.click();
		}

		
	}
	
	//Checkbox
	
	List<WebElement>checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
	
	for(int i=0; i <checkbox.size();i++) {
		
		WebElement element= checkbox.get(i);
		
		String id = element.getAttribute("id");
		 
		if(id.equalsIgnoreCase("code")) 
		{
			element.click();
			
			break;
			
		}
		
	}
	

	
	
	}

}
