package javaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationStream {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		List<String> price;
		do
		{
		List<WebElement> oldItems=driver.findElements(By.xpath("//tr/td[1]"));

		 price=oldItems.stream().filter(s->s.getText().contains("Mango")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		   price.forEach(a->System.out.println("Mango value "+a));
		   
		   if(price.size()<1)
		   {
			   driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		   }
		  
		}while(price.size()<1);
	}
	private static String getPriceVeggie(WebElement s)
	{
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
