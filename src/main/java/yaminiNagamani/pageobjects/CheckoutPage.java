package yaminiNagamani.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import yaminiNagamani.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[placeholder='Select Country']")
     private WebElement selectCountry;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	private WebElement country;
	
	@FindBy(css=".action__submit")
	 private WebElement placeOrder;
	
	By results=By.cssSelector(".ta-results");
	
	public void placingOrder(String countryName) throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.sendKeys(selectCountry, countryName).build().perform();
		waitToElementAppear(By.cssSelector(".ta-results"));
		country.click();
		placeOrder.click();
		
	}

}


