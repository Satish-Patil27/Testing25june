package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase{

	// Test Cases
	//TC1	- Verify application title
	//TC2	- Verify application URL
	//TC3	- Verify visibility	of SwagLab logo
	//TC4	- Verify visibility	bot	logo
	//TC5	- Login	to	application
	//TC6	- Verify the	URL	of second page (inventory	page)
	
	//Object reposatory
	
	@FindBy(xpath = "//div[@class='login_logo']") private WebElement swaglabLogo;
	@FindBy(xpath = "//div[@class='bot_column']") private WebElement botlogo;
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	@FindBy(xpath = "//span[text()='Products']") private WebElement productLabel;
	
		//Constructor
		public LoginPage() 				
		{
			PageFactory.initElements(driver, this);				// to initilization element in current class with driver
		}
	
		//Methods
		//TC3	- Verify visibility	of SwagLab logo
		public boolean varifySwagLabLogo()
		{
			return swaglabLogo.isDisplayed();
		}
		
		//TC4	- Verify visibility	bot	logo
		public boolean varifybotlogo()
		{
			return botlogo.isDisplayed();
		}
		
		//TC5	- Login	to	application
		public String loginToApp1() throws Exception
		{
			userNameTextBox.sendKeys(ReadData.readPropertyFile("username"));
			passwordTextBox.sendKeys(ReadData.readPropertyFile("password"));
			loginBtn.click();
			return productLabel.getText();
		}
	
		//TC6	- Verify the URL of second page (inventory page)
		public String loginToApp2()
		{
			
			return driver.getCurrentUrl();
			
		}
		
		//TC1	- Verify application title
		public String varifyTitle()
		{
			return driver.getTitle();
		}

		//TC2	- Verify application URL
		public String VarifyUrl() 
		{
			return driver.getCurrentUrl();
		}
	
	
	
	
	
	
}
