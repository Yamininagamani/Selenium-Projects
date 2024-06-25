package Example2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RowsColumnsCount {

	public static void main(String[] args) {
		

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	       List<WebElement>values= driver.findElements(By.cssSelector(".table-display tr"));
	       
	       System.out.println("Count of columns "+values.size());
	       int i=driver.findElements(By.cssSelector(".table-display tr:nth-child(1)")).get(0).findElements(By.tagName("th")).size();
	       System.out.println("Count of rows "+i);
	       System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
	       
	}

}
