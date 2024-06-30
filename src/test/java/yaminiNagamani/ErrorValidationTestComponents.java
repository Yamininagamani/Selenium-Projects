package yaminiNagamani;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import yaminiNagamani.TestComponents.BaseTest;
import yaminiNagamani.TestComponents.Retryanlyz;
import yaminiNagamani.pageobjects.CartPage;
import yaminiNagamani.pageobjects.ProductCatlogue;

public class ErrorValidationTestComponents extends BaseTest {

	@Test(retryAnalyzer=Retryanlyz.class)
	public void ErrorValidations() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub

		String value="ADIDAS ORIGINAL";
		landingPage.loginApplication("yamininagamani@gmail.com", "Test@1234");		
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
		
	}
	
	@Test
	public void ProductErrorValidations() throws IOException, InterruptedException
	{
		String value="ADIDAS ORIGINAL";
		ProductCatlogue productCatlogue=landingPage.loginApplication("yamininagamani@gmail.com", "Test@123");
		List<WebElement> products=productCatlogue.getProductsList();
	    productCatlogue.addProductToCart(value);
		productCatlogue.cartIcon();
		
		CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.verifyProductDisplay(value);
		Assert.assertTrue(match);
		
	}
}
