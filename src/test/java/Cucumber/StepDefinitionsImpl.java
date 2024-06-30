package Cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import yaminiNagamani.TestComponents.BaseTest;
import yaminiNagamani.pageobjects.CartPage;
import yaminiNagamani.pageobjects.CheckoutPage;
import yaminiNagamani.pageobjects.ConfirmationMessage;
import yaminiNagamani.pageobjects.LandingPage;
import yaminiNagamani.pageobjects.ProductCatlogue;

public class StepDefinitionsImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatlogue productCatlogue;
    public ConfirmationMessage confirmationMessage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException 
    {
        landingPage=launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username, String password)
    {
        productCatlogue=landingPage.loginApplication(username,password);
    }


    @When("^I add prodcut (.+) to cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException
    {
        List<WebElement> products=productCatlogue.getProductsList();
        productCatlogue.addProductToCart(productName);
    }
    
    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName) throws InterruptedException
    {
    	CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		cartpage.gotoCheckout();
	    
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.placingOrder("India");

    }
    
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
    	//ConfirmationMessage confirmationMessage= new ConfirmationMessage(driver);
    	String message= confirmationMessage.confirmationScreen();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}
