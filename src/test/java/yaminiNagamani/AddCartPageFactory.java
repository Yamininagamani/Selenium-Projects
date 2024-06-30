package yaminiNagamani;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import yaminiNagamani.pageobjects.CartPage;
import yaminiNagamani.pageobjects.CheckoutPage;
import yaminiNagamani.pageobjects.ConfirmationMessage;
import yaminiNagamani.pageobjects.LandingPage;
import yaminiNagamani.pageobjects.ProductCatlogue;

public class AddCartPageFactory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String value="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goToUrl();
		ProductCatlogue productCatlogue=landingPage.loginApplication("yamininagamani@gmail.com", "Test@123");
		List<WebElement> products=productCatlogue.getProductsList();
	    productCatlogue.addProductToCart(value);
		productCatlogue.cartIcon();
		
		CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.verifyProductDisplay(value);
		Assert.assertTrue(match);
		cartpage.gotoCheckout();
	    
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.placingOrder("India");
		
		
		ConfirmationMessage confirmationMessage= new ConfirmationMessage(driver);
		String message= confirmationMessage.confirmationScreen();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
}
