package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

//This class will be extended to all page classes and test classes
public class TestBase {

	//driver is	defined	globally by	which it can be	used by all	page and test classes
	public static WebDriver driver;
	
	//Static cause single copy of driver will be used all across the classes	
	//This	method	open	the	browser	and	enter	the	application	URL
	public void initilization() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	//	driver.get(ReadData.readPropertyFile("url"));
		driver.get(ReadData.readExcelFile(0,1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
