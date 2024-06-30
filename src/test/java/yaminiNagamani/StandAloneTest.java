package yaminiNagamani;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String value="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("yamininagamani@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		//when select the product wait method is applied for visibilty & invisibilty icons
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
	WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(value))
		.findFirst().orElse(null);
	
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	//All cart products list saved in cartProduct
	//selected product matches the product in cart 
	List<WebElement> cartProduct=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match= cartProduct.stream().anyMatch(p1->p1.getText().equalsIgnoreCase(value));
	Assert.assertTrue(match);
	
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a=new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
	//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".actions a")).click();
	String message= driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
