package yaminiNagamani.pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yaminiNagamani.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutButton;
	
	public Boolean verifyProductDisplay(String ProductName)
	{
		Boolean match= cartProduct.stream().anyMatch(p1->p1.getText().equalsIgnoreCase(ProductName));
	    return match;
	}
	
	
	public void gotoCheckout() {
		checkOutButton.click();
	}
	
}
