package javaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortStream {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		//Capture all webelements into list
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> oldItems=driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture all web elements into new list
		List<String> newItems=oldItems.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sorted original list of step3
		List<String> sortedItems=newItems.stream().sorted().collect(Collectors.toList());
		
		//Compare newItems list vs sortedItems
		Assert.assertTrue(newItems.equals(sortedItems));
		
		//Scan the veggies column with getText-> Bean->Get price of the item
		List<String> price=oldItems.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
	   price.forEach(a->System.out.println("Beans value "+a));
	  

	}
	private static String getPriceVeggie(WebElement s)
	{
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
