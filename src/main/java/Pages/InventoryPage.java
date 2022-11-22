package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.ReadData;
import Utility.UtilityMethod;

public class InventoryPage extends TestBase {

	//Test Cases
	//TC1 - verify the visibility of small logo
	//TC2 - verify the visibility of big logo
	//TC3 - Add 6 product in cart
	//TC4 - verify the visibility of twitter logo (Assignment)
	//TC5 - verify the visibility of fb logo (Assignment)
	//TC6 - verify the visibility of linkedin logo (Assignment)
	
	//Object reposatory
	
	@FindBy(xpath = "//div[@class='peek']") private WebElement smallLogo;
	@FindBy(xpath = "//img[@class='footer_robot']") private WebElement bigLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement sortDropDown;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceJacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieTShirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redTShirtProduct;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement productCountIcon;
	
	
	
	//Constructor
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method
	//TC1 - verify the visibility of small logo
	public boolean varifysmallLogo()
	{
		return smallLogo.isDisplayed();
	}
	
	//TC2 - verify the visibility of big logo
	public boolean varifybigLogo()
	{
		return bigLogo.isDisplayed();
	}
	
	//TC3 - Add 6 product in cart
	public String add6Product() throws Exception
	{
		
//		Select s = new Select(sortDropDown);
//		s.selectByVisibleText("Price (low to high)");
		UtilityMethod.selectClass(sortDropDown, ReadData.readPropertyFile("dropdown"));
		backPackProduct.click();
		bikeLightProduct.click();
		boltTShirtProduct.click();
		fleeceJacketProduct.click();
		onesieTShirtProduct.click();
		redTShirtProduct.click();
		productCountIcon.click();
		String count = productCountIcon.getText();
		return count;
	}
	
	
	//TC4 - verify the visibility of twitter logo (Assignment)
	public boolean varifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	//TC5 - verify the visibility of fb logo (Assignment)
	public boolean varifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	//TC6 - verify the visibility of linkedin logo (Assignment)
	public boolean varifyLinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
	}
	
}
