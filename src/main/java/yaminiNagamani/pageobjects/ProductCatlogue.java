package yaminiNagamani.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yaminiNagamani.AbstractComponents.AbstractComponent;

public class ProductCatlogue extends AbstractComponent {

	WebDriver driver;
	public ProductCatlogue(WebDriver driver)
	{
	 super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
		
	}
	//WebElement usermail=driver.findElement(By.id("userEmail"));
	//Instead of this we can write findelement like this using constructor
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");       //wait until call the by.cssselector then we declare here
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.id("toast-container");
	
	public List<WebElement> getProductsList() {
		waitToElementAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName)
	{
		WebElement prod=getProductsList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod= getProductName(productName);
		prod.findElement(addToCart).click();
		waitToElementAppear(toastMessage);
		waitElementDisappear(spinner);
	}
}
