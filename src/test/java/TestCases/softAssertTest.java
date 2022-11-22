package TestCases;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.CaptureScreeshot;

public class softAssertTest extends TestBase {

	
		LoginPage login;
		InventoryPage Invent;
		
		@BeforeMethod
		public void status() throws Exception
		{
			initilization();
			Invent = new InventoryPage();
			login = new LoginPage();
		}
		
		@Test (enabled = true ) 			
		public void smallLogoTest() throws Exception		
		{	
			SoftAssert s =  new SoftAssert();
			System.out.println("Execution started");
			login.loginToApp1();							
			boolean Logo1 = Invent.varifysmallLogo();
			s.assertEquals(Logo1, false);
			System.out.println("Execution ended");
			s.assertAll();
		 
		}
		
		@Test (enabled = false ) 
		public void varifybigLogo() throws Exception			 
		{
			login.loginToApp1();
			boolean Logo2 = Invent.varifybigLogo();
			
		}
		
		@Test (enabled = false)    						
		public void add6ProductTest() throws Exception	 
		{													
			login.loginToApp1();
			String A = Invent.add6Product();
			
		}
		
		@Test (enabled = false)
		public void varifyTwitterLogoTest() throws Exception
		{
			login.loginToApp1();
			boolean Logo3 = Invent.varifyTwitterLogo();
			
		}
		
		@Test (enabled = false)
		public void varifyFacebookLogoTest() throws Exception
		{
			login.loginToApp1();
			boolean Logo4 = Invent.varifyFacebookLogo();
			
		}
		
		@Test (enabled = false)
		public void varifyLinkedinLogoTest() throws Exception
		{
			login.loginToApp1();
			boolean Logo5 = Invent.varifyLinkedinLogo();
			
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

