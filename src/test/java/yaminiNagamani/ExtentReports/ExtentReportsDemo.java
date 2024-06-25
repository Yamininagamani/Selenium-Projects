package yaminiNagamani.ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExtentReportsDemo {

	ExtentReports extent;
	@Test
	public void config()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation results");
		reporter.config().setDocumentTitle("Test results");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "yamini");
	}
	
	@Test
	public void initialDemo()
	{
		
		ExtentTest test=extent.createTest("Initial Demo");
		System.setProperty("webbrowser.chrome.browser", "C:\\Users\\yamini.nagamani\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		//driver.close();
		//test.fail("Results do not match its failed");	             //If we want to show the fail test report then we can use this
		extent.flush();
		
	}
}
