package Cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import yaminiNagamani.TestComponents.BaseTest;
import yaminiNagamani.pageobjects.LandingPage;
import yaminiNagamani.pageobjects.ProductCatlogue;

public class StepDefinitionsImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatlogue productCatlogue;
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
}
