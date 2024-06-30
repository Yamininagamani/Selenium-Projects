package yaminiNagamani.pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import yaminiNagamani.AbstractComponents.AbstractComponent;

public class ConfirmationMessage extends AbstractComponent{

	WebDriver driver;
	public ConfirmationMessage(WebDriver driver)
	{
		super(driver);
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".hero-primary")
     WebElement confirmationMessage;
	

	public String confirmationScreen()
	{
		return confirmationMessage.getText();
	}
	
}


