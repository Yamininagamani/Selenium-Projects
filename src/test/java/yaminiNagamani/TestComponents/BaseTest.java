package yaminiNagamani.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import yaminiNagamani.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop= new Properties();
		//path get from  global.properties file properties path
		FileInputStream fis= new FileInputStream("C:\\Users\\yamini.nagamani\\eclipse-workspace\\SeleniumMavenPractice\\src\\main\\java\\yaminiNagamani\\resources\\GlobalData.properties");
		prop.load(fis);
		
		//For execution in command prompt (When getproperty is true then execute getproperty when it false then execute prop.getprooerty
		String browserName=System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		WebDriverManager.chromedriver().setup();	
		 driver =new ChromeDriver();
		 
		}
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 //Firefox
		 }
		else if(browserName.equalsIgnoreCase("edge"))
	    {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver=new EdgeDriver();
		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png";
	}
	
	
	public List<HashMap<String, String>> getJsonDataMap(String filePath) throws IOException 
	{
		
	String jsonContent= FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);
	//To use Jackson databind
	ObjectMapper mapper= new ObjectMapper();
	List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>()
			{});
	 return data;
	}
	
	
	@BeforeMethod(alwaysRun=true)             //alwaysRun=true is used for grouping in ErrorValidations2 class
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage= new LandingPage(driver);
		landingPage.goToUrl();
		return landingPage;
	}

	
}
	
