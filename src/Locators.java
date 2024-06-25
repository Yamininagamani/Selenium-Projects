import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get(" https://yexledemo.appiancloud.com/suite/sites/automation-cases");
	        driver.findElement(By.id("un")).sendKeys("YexleQA");
	        driver.findElement(By.name("pw")).sendKeys("Test@12");
	        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
	        System.out.println(driver.findElement(By.cssSelector("div.message")).getText());      //print message in ecllipse;
	        driver.findElement(By.id("forgotPasswordLink")).click();                         //find the link and also Linktext(Locator) to find the link
	       Thread.sleep(1000);
	        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("yamini");     //using xpath to enter username
	       driver.findElement(By.cssSelector("input[id='username']")).clear();      //Clear the data in username
	       driver.findElement(By.name("forgotPasswordBack")).click();
	       driver.findElement(By.xpath("//div/form/div[2]/div/input")).sendKeys("YexleQA");
	       driver.findElement(By.xpath("//div/form/div[3]/div/input")).sendKeys("Test@123");
	       driver.findElement(By.xpath("//input[@value='Sign In']")).click();
	}

}
