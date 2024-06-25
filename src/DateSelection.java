import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelection {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click(); 
       
       //Select current date form calendar using CSS locator with unique classname 
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("div[id='ui-datepicker-div']")).click();
       driver.findElement(By.xpath("//table/tbody/tr[5]/td[3]/a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();
         }

}

