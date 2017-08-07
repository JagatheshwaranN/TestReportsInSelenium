/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as ant_buildtool_example
package ant_buildtool_example;

// Importing the predefined class libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// The class is created with name : Selenium_TestNG_Ant
public class Selenium_TestNG_Ant {
	
	// Declaring global variable
	WebDriver driver;
	
	@BeforeTest
	public void start()
	{
		// Provide the path of driver location
		System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");

		// Driver instance is created
		driver = new FirefoxDriver();

	}

	/** 
	 * The method name is : seleniumTestNGAntMethod
	 * This method is annotated with Test.It will act as a test method
	 * This method will launch browser and navigate to the URL and login to the application
	 * 
	 */
	@Test
	public void seleniumTestNGAntMethod() {
		
		
		// Launching the browser with the below url	
		driver.get("http://www.gcrit.com/build3/login.php");
	
		driver.findElement(By.name("email_address")).sendKeys("testjaga007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("jaga@1234");
		driver.findElement(By.id("tdb5")).click();

		String ExpectedUrl = "http://www.gcrit.com/build3/index.php";
		// Capturing the Current page url
		String ActualUrl = driver.getCurrentUrl();

		// Verifying the captured url
		if (ActualUrl.contains(ExpectedUrl))
		{
			System.out.println("Login Successful - Passed");
			Assert.assertEquals(ActualUrl, ExpectedUrl);
		} 
		else 
		{
			System.out.println("Login Unsuccessful - Failed");
			Assert.assertEquals(ActualUrl, ExpectedUrl);
		}

		
	}
	@AfterTest
	public void end()
	{
		// The below method will close the current browser window
		driver.close();
	}
}