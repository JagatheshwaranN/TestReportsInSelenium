/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as xsltReport
package xsltReport;

// Importing the predefined class libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// The class is created with name : CustomerLogin
public class CustomerLogin {

	// Declaring global variable
	WebDriver driver;

	// BeforeTest - The annotated method will be run before any Test methods belonging to classes is run
	@BeforeTest
	public void start() {
		
		// Provide the path of driver location
		System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");

		// Driver instance is created
		driver = new FirefoxDriver();

	}

	/**
	 * The method name is : customerLoginPositive 
	 * This method is annotated with Test.It will act as a test method.
	 * This method will launch browser.
	 * Navigate to the URL and login to the application.
	 * 
	 */
	@Test (priority=1)
	public void customerLoginPositive() {

		// Launching the browser with the below url
		driver.get("http://www.gcrit.com/build3/login.php");

		driver.findElement(By.name("email_address")).sendKeys("testjaga007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("jaga@12345");
		driver.findElement(By.id("tdb5")).click();

		String ExpectedUrl = "http://www.gcrit.com/build3/index.php";
		
		// Capturing the Current page url
		String ActualUrl = driver.getCurrentUrl();

		// Verifying the captured url
		if (ActualUrl.contains(ExpectedUrl)) {
			System.out.println("Login Successful - Passed");
			Assert.assertEquals(ActualUrl, ExpectedUrl);
		} else {
			System.out.println("Login Unsuccessful - Failed");
			Assert.assertEquals(ActualUrl, ExpectedUrl);
		}

	}

	/**
	 * The method name is : customerLoginNegative 
	 * This method is annotated with Test.It will act as a test method 
	 * This method will launch browser
	 * Navigate to the URL and login to the application
	 * 
	 */
	@Test (priority=2)
	public void customerLoginNegative() {

		// Launching the browser with the below url
		driver.get("http://www.gcrit.com/build3/login.php");

		driver.findElement(By.name("email_address")).sendKeys("testjaga007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("jaga@1234");
		driver.findElement(By.id("tdb5")).click();

		String ExpectedUrl = "http://www.gcrit.com/build3/index.php";
		
		// Capturing the Current page url
		String ActualUrl = driver.getCurrentUrl();

		// Verifying the captured url
		if (ActualUrl.contains(ExpectedUrl)) {
			System.out.println("Login Successful - Passed");
			Assert.assertEquals(ActualUrl, ExpectedUrl);
		} else {
			System.out.println("Login Unsuccessful - Failed");
			Assert.assertEquals(ActualUrl, ExpectedUrl);
		}

	}

	// AfterTest - The annotated method will be run after all the Test methods belonging to the classes have run
	@AfterTest
	public void end() {
		
		// The below method will close the current browser window
		driver.close();
	}

}
