package TestCases;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.CaptureScreeshot;


public class InventoryPageTest extends TestBase{

	LoginPage login;
	InventoryPage Invent;
	
	@BeforeMethod
	public void status() throws Exception
	{
		initilization();
		Invent = new InventoryPage();
		login = new LoginPage();
	}
	
	@Test (enabled = true /*, timeOut = 3500*/) 			//test case finish within the time-out or not by using time-out keyword 
	public void smallLogoTest() throws Exception		// if test case did't finish within the time-out Result for test case is "Fail"
	{													// if test case finish within the time-out Result for test case is "Passed"
		login.loginToApp1();							// (timeOut = 3500 milliseconds)
		boolean Logo1 = Invent.varifysmallLogo();
	    Assert.assertEquals(Logo1, true);
//		Assert.assertEquals(Logo1, true , "Test case failed");		//If test case failed then print massage "Test case failed"
//	    Assert.assertTrue(false);						       // if we want to pass test case then true both method & argument [Assert.asserttrue(true);]	
	    Assert.assertFalse(false);						// if we want to pass test case then false both method & argument [Assert.assertFalse(false);]
	    System.out.println("This is Small logo test case");
	}
	
	@Test (enabled = true /*, invocationCount = 3*/) //if we want to run one test case in multiple time by using invocation count Keyword
	public void varifybigLogo() throws Exception			// In this case one test case run in 3 times   (invocationCount = 3) 
	{
		login.loginToApp1();
		boolean Logo2 = Invent.varifybigLogo();
		Assert.assertEquals(Logo2, true);
	}
	
	@Test (enabled = true)    						// if we want to run or not run test cases by using enabled Keyword 
	public void add6ProductTest() throws Exception		// (enabled = false)  = test case not run 
	{													// (enabled = true) = test case run
		login.loginToApp1();
		String A = Invent.add6Product();
		Assert.assertEquals(A, "6");
	}
	
	@Test (enabled = true)
	public void varifyTwitterLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean Logo3 = Invent.varifyTwitterLogo();
		Assert.assertEquals(Logo3, true);
	}
	
	@Test (enabled = true)
	public void varifyFacebookLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean Logo4 = Invent.varifyFacebookLogo();
		Assert.assertEquals(Logo4, true);
	}
	
	@Test (enabled = true)
	public void varifyLinkedinLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean Logo5 = Invent.varifyLinkedinLogo();
		Assert.assertEquals(Logo5, true);
	}
	
	
	@AfterMethod
	public void CloseBrowser(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE == it.getStatus());
		{
			CaptureScreeshot.screenshot(it.getName());
		}
		
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
