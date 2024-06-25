import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();             //Maximize the screen
	     driver.get("https://www.google.com/");           //Using get locator means it loads all the icons & data
	     driver.navigate().to("https://www.youtube.com/");  //using navigate to locator-it is not waiting for loading all data& move to next step
	     driver.navigate().back();
	     Thread.sleep(4000);
	     driver.navigate().forward();
	}

}
