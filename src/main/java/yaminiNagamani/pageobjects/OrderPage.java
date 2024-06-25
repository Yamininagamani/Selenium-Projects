package yaminiNagamani.pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yaminiNagamani.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
		
	}
	//tr td:nth-child(3)
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutButton;
	
	public Boolean verifyOrderDisplay(String ProductName)
	{
		Boolean match= productNames.stream().anyMatch(p1->p1.getText().equalsIgnoreCase(ProductName));
	    return match;
	}
	
	
	public void gotoCheckout() {
		checkOutButton.click();
	}
	
}
