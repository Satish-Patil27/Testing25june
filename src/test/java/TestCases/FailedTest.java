package TestCases;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreeshot;
import Utility.ReadData;


public class FailedTest extends TestBase {

	
	LoginPage login;   		//Create Global object
	
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initilization();
		login = new LoginPage();
	}
		
	@Test 
	public void varifySwagLabLogoTest()
	{
		boolean Logo1 = login.varifySwagLabLogo();
		Assert.assertEquals(Logo1, true);
		System.out.println("varifySwagLabLogoTest");
	}
	
	@Test 
	public void varifybotlogoTest()
	{
		boolean Logo2 = login.varifybotlogo();
		Assert.assertEquals(Logo2, true);
		System.out.println("varifybotlogoTest");
	}
	
	
	@Test 
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		Assert.assertEquals(label, "PRODUCTS");
		System.out.println("loginToApp1Test");
	}
	
	@Test
	public void loginToApp2Test() throws Exception
	{
		loginToApp1Test();
		Assert.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
		System.out.println("loginToApp2Test");
	}
	
	@Test  
	public void varifyTitleTest() throws Exception
	{
		String title = login.varifyTitle();
		Assert.assertEquals(title, "1Swag Labs");
		System.out.println("varifyTitleTest");
	}
	
	@Test 
	public void VarifyUrlTest() throws Exception
	{
		String url = login.VarifyUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/");
//     	Assert.assertEquals(url, ReadData.readExcelFile(0, 1));
		System.out.println("VarifyUrlTest");
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws	Exception
	{
	if(ITestResult.FAILURE == it.getStatus());
	{
	CaptureScreeshot.screenshot(it.getName());
	}
	driver.close();
}
}

