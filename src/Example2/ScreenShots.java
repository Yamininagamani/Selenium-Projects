package Example2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenShots {

	private static final String FileUtils = null;

	public static void main(String[] args)  {
		
		System.setProperty("webbrowser.chorme.browser", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	   // driver.manage().deleteCookieNamed("Cookie Name");
	    
	    //Take screeshot
	    
	    driver.get("https://www.youtube.com/");
	    
	    File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //FileUtils.copyFile(src, new File("C:\\Users\\yamini.nagamani\\Screnshot.png"));
	   // FileUtils.copyFile(src, new File("C:\\Users\\yamini.nagamani\\Screenshot.png"));
	}

}
