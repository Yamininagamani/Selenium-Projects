import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select currencyDropdown=new Select(staticDropdown);
		currencyDropdown.selectByIndex(2);               //Select dropdown by using index starts with o
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByVisibleText("INR");     //Select dropdown by visible text in dropdown 
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByValue("USD");           //Select dropdown by value 
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());    
	}

}
