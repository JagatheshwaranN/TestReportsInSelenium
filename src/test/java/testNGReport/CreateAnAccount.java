/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as testNGReport
package testNGReport;

// Importing the predefined class libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// The class is created with name : CreateAnAccount
public class CreateAnAccount {

	// Declaring global variable
	public static WebDriver driver;

	// BeforeMethod - The annotated method will be run before each Test methods
	@BeforeMethod
	public void start() {

		// Provide the path of driver location
		System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");

		// Driver instance is created
		driver = new FirefoxDriver();

	}

	/**
	 * This method will enter the required Details to create the Account and
	 * then click Submit button
	 * 
	 * @author Jagatheshwaran
	 */
	@Test
	public void createAccountRegistration() {

		try {

			// Launching the browser with the below url
			driver.get("http://gcrit.com/build3/");

			// Navigating to Create Account page  
			// Entering the required details to create an account in the web site
			driver.findElement(By.linkText("create an account")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")).click();
			driver.findElement(By.name("firstname")).sendKeys("jaga");
			driver.findElement(By.name("lastname")).sendKeys("waran");
			driver.findElement(By.name("dob")).sendKeys("08/30/1994");
			driver.findElement(By.name("email_address")).sendKeys("testjaga001@gmail.com");
			driver.findElement(By.name("street_address")).sendKeys("TamilNadu");
			driver.findElement(By.name("postcode")).sendKeys("600001");
			driver.findElement(By.name("city")).sendKeys("Chennai");
			driver.findElement(By.name("state")).sendKeys("TamilNadu");

			Select dropdown = new Select(driver.findElement(By.name("country")));
			dropdown.selectByVisibleText("India");

			driver.findElement(By.name("telephone")).sendKeys("9944551212");
			driver.findElement(By.name("password")).sendKeys("jaga@1994");
			driver.findElement(By.name("confirmation")).sendKeys("jaga@1994");
			driver.findElement(By.id("tdb4")).click();

			// Capturing the Success message after account creation
			String ConformationMessage = driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).getText();
			
			String ActualMessage = "Your Account Has Been Created!";

			// Verifying the captured success message
			if (ConformationMessage.equals(ActualMessage)) {
				System.out.println("Customer Registration Successful - Passed");
				Assert.assertEquals(ActualMessage, ConformationMessage);
			} else {
				System.out.println("Customer Registration Unsuccessful - Failed");
				Assert.assertEquals(ActualMessage, ConformationMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// AfterMethod - The annotated method will be run after each Test Methods
	@AfterMethod
	public void end() {
		
		// The below method will close the current browser window
		driver.close();
	}

}
