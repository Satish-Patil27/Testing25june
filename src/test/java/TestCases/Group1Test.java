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


public class Group1Test extends TestBase {

	
	LoginPage login;   		
	
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
	{
		initilization();				// <include name = "Regression"><include  = Run test case "Regression" only
		 login = new LoginPage();		// <exclude name = "Regression"><exclude   = avoid those test cases which containing "Smoke"  
	}
		
	@Test (groups = {"Sanity","Smoke","Regression"})
	public void varifySwagLabLogoTest()
	{
		boolean Logo1 = login.varifySwagLabLogo();
		Assert.assertEquals(Logo1, true);
		System.out.println("varifySwagLabLogoTest");
	}
	
	@Test (groups = "Sanity")
	public void varifybotlogoTest()
	{
		boolean Logo2 = login.varifybotlogo();
		Assert.assertEquals(Logo2, true);
		System.out.println("varifybotlogoTest");
	}
	
	
	@Test (groups = "Regression")
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		Assert.assertEquals(label, "PRODUCTS");
		System.out.println("loginToApp1Test");
	}
	
	@Test (groups = "Sanity")
	public void loginToApp2Test() throws Exception
	{
		loginToApp1Test();
		Assert.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
		System.out.println("loginToApp2Test");
	}
	
	@Test (groups = "Smoke")
	public void varifyTitleTest() throws Exception
	{
		String title = login.varifyTitle();
//		Assert.assertEquals(url, "Swag Labs");
		Assert.assertEquals(title, ReadData.readExcelFile(4, 1));
		System.out.println("varifyTitleTest");
	}
	
	@Test (groups = "Sanity")
	public void VarifyUrlTest() throws Exception
	{
		String url = login.VarifyUrl();
	//	Assert.assertEquals(url, "https://www.saucedemo.com/");
     	Assert.assertEquals(url, ReadData.readExcelFile(0, 1));
		System.out.println("VarifyUrlTest");
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws	Exception
	{
	if(ITestResult.FAILURE == it.getStatus());
	{
	CaptureScreeshot.screenshot(it.getName());
	}
	driver.close();
}
}







