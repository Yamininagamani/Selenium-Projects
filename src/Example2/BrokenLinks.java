package Example2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webbrowser.chorme.browser", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));     //Call all links in list
	  SoftAssert a= new SoftAssert();               //softassert is used for continue test all link even it has broken link
	  
	  for(WebElement link:links)
	  {
		  String url=link.getAttribute("href");
		  HttpURLConnection conne =(HttpURLConnection)new URL(url).openConnection();
		    conne.setRequestMethod("HEAD");
		    conne.connect();
		   int respCode= conne.getResponseCode();
		    System.out.println(respCode);
		    a.assertTrue(respCode<400, "The link name is "+link.getText()+"is broken with code is "+respCode);
	  }
	  a.assertAll();
	}

}
