package Example2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> childWindow=driver.getWindowHandles();
        Iterator<String>a=childWindow.iterator();
        String parentId= a.next();
        String childId=a.next();
        driver.switchTo().window(childId);
       System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
       //driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
       String emailId=driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
       driver.switchTo().window(parentId);
       driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
