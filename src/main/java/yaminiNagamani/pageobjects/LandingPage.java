package yaminiNagamani.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yaminiNagamani.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
		
	}
	//WebElement usermail=driver.findElement(By.id("userEmail"));
	//Instead of this we can write findelement like this using constructor
	
	@FindBy(id="userEmail")
	WebElement userMail;
	
	@FindBy(id="userPassword")           //Instaed of id we can use css, xpath if we want
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatlogue loginApplication(String mail, String userPassword) 
	{
		userMail.sendKeys(mail);
		password.sendKeys(userPassword);
		submit.click();
		ProductCatlogue productCatlogue= new ProductCatlogue(driver);
		return productCatlogue;
	}
	
	public LandingPage goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client/");
		return null;
	}
	
	public String getErrorMessage() 
	{
		waitToWebElementAppear(errorMessage);
		return errorMessage.getText();
	}
	
}
