import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) {
		//System.setProperty is optional for selenium
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.youtube.com/");
	        System.out.println(driver.getTitle());
	        System.out.println(driver.getCurrentUrl());
	
	}

}
