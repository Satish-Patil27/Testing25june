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


public class LoginPageTest extends TestBase {

	
	LoginPage login;   		//Create Global object
	
	//It is prerequisite to run	the	test case open the browser + enter URL
	//This will execute	multiple times depend on number of test cases
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initilization();
		 login = new LoginPage();
	}
		
	@Test (priority = 6)
	public void varifySwagLabLogoTest()
	{
		boolean Logo1 = login.varifySwagLabLogo();
		Assert.assertEquals(Logo1, true);
		System.out.println("varifySwagLabLogoTest");
	}
	
	@Test (priority = 5)
	public void varifybotlogoTest()
	{
		boolean Logo2 = login.varifybotlogo();
		Assert.assertEquals(Logo2, true);
		System.out.println("varifybotlogoTest");
	}
	
	
	@Test (enabled = true , priority = 4)
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		Assert.assertEquals(label, "PRODUCTS");
		System.out.println("loginToApp1Test");
	}
	
	@Test (enabled = true , priority = 1)
	public void loginToApp2Test() throws Exception
	{
		loginToApp1Test();
		Assert.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
		System.out.println("loginToApp2Test");
	}
	
	@Test  (enabled = true ,priority = 2)
	public void varifyTitleTest() throws Exception
	{
		String title = login.varifyTitle();
//		Assert.assertEquals(url, "Swag Labs");
		Assert.assertEquals(title, ReadData.readExcelFile(4, 1));
		System.out.println("varifyTitleTest");
	}
	
	@Test (enabled = true ,priority = 3)
	public void VarifyUrlTest() throws Exception
	{
		String url = login.VarifyUrl();
	//	Assert.assertEquals(url, "https://www.saucedemo.com/");
     	Assert.assertEquals(url, ReadData.readExcelFile(0, 1));
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

//VarifyUrlTest    3
//loginToApp1Test   4
//loginToApp2Test    1
//varifySwagLabLogoTest   6               done
//varifyTitleTest     2
//varifybotlogoTest  5
