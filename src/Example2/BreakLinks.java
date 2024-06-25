package Example2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BreakLinks {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webbrowser.chorme.browser", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
	    
	    HttpURLConnection conne =(HttpURLConnection)new URL(url).openConnection();
	    conne.setRequestMethod("HEAD");
	    conne.connect();
	   int respCode= conne.getResponseCode();
	    System.out.println(respCode);

	}

}
