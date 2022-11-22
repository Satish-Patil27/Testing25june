package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase {

	LoginPage login;
	InventoryPage Invent;
	CartPage cart;
	
	@BeforeMethod
	public void status() throws Exception
	{
		initilization();
		cart = new CartPage();
		Invent = new InventoryPage();
		login = new LoginPage();
		
	}
	
	
	
	@Test
	
	public void varifyyourCartLebleTest()
	{
		 cart.varifyyourCartLable();
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
