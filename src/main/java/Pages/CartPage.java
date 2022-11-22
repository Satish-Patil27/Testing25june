package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {

	//Test Cases
		//TC1 - varify application your cart Lable 
		//TC2 - Varify application current url
		//TC3 - Remove 3 Product from cart
		//TC4 - Varify visibility of continue shopping tab
		//TC5 - Varify to click checkout tab

	
	//Test Repository

	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement yourCartLeble;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTShirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieTShirtProduct;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShopTab;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkOutTab;

	
	// Constructor
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Method
	
	//TC1 - varify application your cart Lable
	public void varifyyourCartLable()
	{
		driver.getTitle();
	}
	
	//TC2 - Varify application current url
	public void varifyCurrentUrl()
	{
		driver.getCurrentUrl();
	}
	
	//TC3 - Remove 3 Product from cart
	public void remove3Product()
	{
		fleeceJacketProduct.click();
		redTShirtProduct.click();
		onesieTShirtProduct.click();
	}
	
	//TC4 - Varify visibility of continue shopping tab
	public boolean continueShopTab()
	{
		return continueShopTab.isDisplayed();
	}
	
	//TC5 - Varify to click checkout tab
	public void checkOutTab()
	{
		checkOutTab.click();
	}
	
}
