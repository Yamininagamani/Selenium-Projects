import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class LocatorsAdvanced {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text="home";
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();             //chromedriver implements the webdriver interface
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get(" https://yexledemo.appiancloud.com/suite/sites/automation-cases");
	        driver.findElement(By.id("un")).sendKeys("YexleQA");
	        driver.findElement(By.cssSelector("input[id='un']")).clear(); 
	        driver.findElement(By.cssSelector("#un")).sendKeys("YexleQA");
	        driver.findElement(By.name("pw")).sendKeys("Test@12");
	       driver.findElement(By.cssSelector("input[name='pw']")).clear();      //Clear the data in username
	      driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("Test@123");        //another way to send values using cssselector
	      //driver.findElement(By.xpath("//input[@value='Sign In']")).click();        //using xpath one way 
	      driver.findElement(By.xpath("//input[contains(@value,'Sign In')]")).click();   //using xpath with another way
	      System.out.println(driver.findElement(By.cssSelector("p span span")).getText());
	      Assert.assertEquals(driver.findElement(By.cssSelector("p span span")).getText(),"Find your new"+" "+text); //Test the validation using assertion
	      driver.findElement(By.xpath("//*[text()='New Case']")).click();          //Using * character insted of tagname 
	     
	}

}
