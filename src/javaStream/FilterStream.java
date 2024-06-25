package javaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterStream {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Mango");
		List<WebElement> values=driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> value2=values.stream().filter(s->s.getText().contains("Mango")).collect(Collectors.toList());
        
		Assert.assertEquals(values.size(), value2.size());
	}

}
