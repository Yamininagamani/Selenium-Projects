package Example2;

import org.openqa.selenium.By;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

    public static void main(String[] args) {

        String year="2024";
        String month="11";
        String date="10";
        String[] selectedDate= {month,date,year};

        System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button__icon")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        
        //Check select is correct or not
        List<WebElement> actualList= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        
        for(int i=0;i<actualList.size(); i++)
        {
        	System.out.println(actualList.get(i).getAttribute("value"));
        	
        	Assert.assertEquals(actualList.get(i).getAttribute("value"),selectedDate[i]);
        }
    }

}
