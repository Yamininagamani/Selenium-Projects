package Example2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
       
 
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        
        System.out.println(driver.findElement(By.id("content")).getText());

	
	}

}
