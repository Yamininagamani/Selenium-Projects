package javaStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement editableName=driver.findElement(By.cssSelector("[name='name']"));
        
        //using above relative locator to print field name
       System.out.println(driver.findElement(with(By.tagName("label")).above(editableName)).getText());;

       
      //Using Below locator click on submit button
       WebElement dateOfBirth= driver.findElement(By.cssSelector("[for='dateofBirth']"));
       driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
       
       //Using toLeftOf locator click  check box
       WebElement checkBox= driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
       driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
       
       //Using toRightOf locator to print name of radio button
       WebElement radioBtn= driver.findElement(By.id("inlineRadio1"));
       System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText());
	}

}
