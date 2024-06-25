package Example2;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	        
	        //main page scroll
	        JavascriptExecutor js= (JavascriptExecutor)driver;
	        
	        
	        js.executeScript("window.scrollBy(0,600)");
	        Thread.sleep(2000);
	        //seperate section scroll
	        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	        
	      List<WebElement>data=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));	
	      
	      int sum=0;                     //Add all values
	      for(int i=0;i<data.size();i++)
	      {
	    	int values= Integer.parseInt(data.get(i).getText());           //convert sting data into integer values
	    	sum=sum+values;                                              //adding values
	      }
	      
	      System.out.println(sum);
	      System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText());
	      int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	      Assert.assertEquals(sum,total);
	}

}
