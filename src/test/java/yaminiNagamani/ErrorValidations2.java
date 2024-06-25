package yaminiNagamani;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import yaminiNagamani.TestComponents.BaseTest;
import yaminiNagamani.pageobjects.CartPage;
import yaminiNagamani.pageobjects.CheckoutPage;
import yaminiNagamani.pageobjects.ConfirmationMessage;
import yaminiNagamani.pageobjects.LandingPage;
import yaminiNagamani.pageobjects.OrderPage;
import yaminiNagamani.pageobjects.ProductCatlogue;

public class ErrorValidations2 extends BaseTest{

	String value="ADIDAS ORIGINAL";
	
	@Test(dataProvider="getData", groups= {"ErrorHandling"})     //groups is used for particular testcase want to execute then we can use groups in testng2.xml file
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, InterruptedException {
		// TODO Auto-generated method stub

		
		ProductCatlogue productCatlogue=landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products=productCatlogue.getProductsList();
	    productCatlogue.addProductToCart(input.get("productName"));
		productCatlogue.cartIcon();
		
		CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		cartpage.gotoCheckout();
	    
		/*CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.placingOrder("India");
		
		ConfirmationMessage confirmationMessage= new ConfirmationMessage(driver);
		String message= confirmationMessage.confirmationScreen();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER.")); */
		
	}

	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatlogue productCatlogue=landingPage.loginApplication("yamininagamani@gmail.com", "Test@123");
		OrderPage orderPage=productCatlogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(value));
	}
	
	//using for different data provided executes one after other(2 logins)
	//Hashmap is used for map all data at one place
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String, String>> data=getJsonDataMap(System.getProperty("user.dir")+"\\src\\test\\java\\yaminiNagamani\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	/*@DataProvider
	public Object[][] getData() throws IOException
	{
		HashMap<String,String> map= new HashMap<String, String>();
		map.put("email", "yamininagamani@gmail.com");
		map.put("password","Test@123" );
		map.put("productName", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map2= new HashMap<String, String>();
		map2.put("email", "shetty@gmail.com");
		map2.put("password","Iamking@000" );
		map2.put("productName", "ADIDAS ORIGINAL");
		return new Object[][] {{map},{map2}};*/
		
	
	/*@DataProvider              
	public Object[][] getData()
	{
		return new Object[][] {{"yamininagamani@gmail.com","Test@123","ADIDAS ORIGINAL"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
	}
	 */
	
}
