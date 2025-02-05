package javaStream;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
         
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.WINDOW);   //Open another new window
        
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it= handles.iterator();
        String parentWindowId= it.next();
        String childWindowId= it.next();
        driver.switchTo().window(childWindowId);     //Open other website in new window
        driver.get("https://rahulshettyacademy.com/");
        //Get course name into one variable
      String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
    		  .get(1).getText();
      
      //Enter course name into name field of parent window
      driver.switchTo().window(parentWindowId);
     WebElement name= driver.findElement(By.cssSelector("[name='name']"));
     name.sendKeys(courseName);
     
     File file=name.getScreenshotAs(OutputType.FILE);
     
     FileUtils.copyFile(file, new File("picture.png"));
     
     
    System.out.println(name.getRect().getDimension().getHeight());
    System.out.println(name.getRect().getDimension().getWidth());   
	}

}
