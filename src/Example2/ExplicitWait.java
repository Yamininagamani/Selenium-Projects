package Example2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		String[] itemsList= {"Beetroot","Beans","Apple"};
		
		System.setProperty("webbrowser.chorme.browser", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    Thread.sleep(2000);
	    addItems(driver,itemsList);
	    driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	    driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.cssSelector("button.promoBtn")).click();
	    //Explicit wait
	    w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
	    System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());         //Get promo info message
	    
	    
	    
	}
	public static void addItems(WebDriver driver, String[] itemsList)  //all the logics put in one method and call it above the code
	{
		int j=0;
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        
        for(int i=0;i<products.size();i++)
        {
        	//Beetroot - 1kg 
        	//Split with hyphen  name[0]-Beetroot name[1]-1 kg
        	
        	String[] name=products.get(i).getText().split("-");
            String formattedName=name[0].trim();
        
        //Convert itemslist array to arrayList
        //Check whether name you extracted is presented in arraylist or not
        List arrayListItems=Arrays.asList(itemsList);
        
        if(arrayListItems.contains(formattedName))
        {
        	driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();   //Locator parent child xpath
        	j++;
        	
        	if(j==itemsList.length)              //If items 2 put number 2 then it break if item equal to 2
        	{
        		break;
        	}
        }
        }
	

	
	}

}
