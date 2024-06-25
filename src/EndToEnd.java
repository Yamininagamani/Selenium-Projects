import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
	
		
		int i=1;                        //using while condition to click + icon for 4 times
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();//click 4 times
			i++;
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select currencyDropdown=new Select(staticDropdown);
		currencyDropdown.selectByIndex(2);   
	}

}