package Example2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       //Find the count of the links
        //Using 'a' tagname i.e anchor it is used for all links in html
        System.out.println(driver.findElements(By.tagName("a")).size());
        
        //Find count of the links footer section
        WebElement w=driver.findElement(By.id("gf-BIG"));
        System.out.println(w.findElements(By.tagName("a")).size());
        
        //count the links of specific column
        WebElement columnDriver= driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());
        
        for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++)
        {
        	String clickonLinks=Keys.chord(Keys.CONTROL,Keys.ENTER);
        	columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinks);
        	Thread.sleep(5000);
        	
        }
        Set<String> a=driver.getWindowHandles();
       Iterator<String> it= a.iterator();
        
       while(it.hasNext())
       {
        driver.switchTo().window(it.next());
        System.out.println(driver.getTitle());
	}
	}
}
