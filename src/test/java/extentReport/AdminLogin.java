/**
 * @author Jagatheshwaran
 */

// Importing Package extentReport
package extentReport;

// Importing the predefined class libraries
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

// The class is created with name : AdminLogin
public class AdminLogin {

	// Declaring global variables
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeMethod
	public void start() {

		report = new ExtentReports("./extent-report/extentReport.html");
		test = report.startTest("Automation of Admin Login Functionality");

		// Provide the path of driver location
		System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");

		// Driver instance is created
		driver = new FirefoxDriver();
		test.log(LogStatus.INFO, "Browser Started");

	}

	@Test
	public void adminLogin() {

		// Launching the browser with the below url
		driver.get("http://www.gcrit.com/build3/admin/login.php");
		test.log(LogStatus.INFO, "Appliction is Up and Running");

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin@123");
		driver.findElement(By.id("tdb1")).click();

		// Capturing the current page url
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://www.gcrit.com/build3/admin/index.php";

		// Verifying the captured the url
		Assert.assertEquals(ExpectedUrl, ActualUrl);

		test.log(LogStatus.PASS, "Admin Login Succesful");
		System.out.println("Admin Login Succesful");

	}

	@AfterMethod
	public void end(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenpath = Utility.captureScreen(driver, result.getName());
			String image = test.addScreenCapture(screenpath);
			test.log(LogStatus.FAIL, "Admin Login UnSuccesful", image);
			System.out.println("Admin Login UnSuccesful");
		}
		
		// The below method will close the current browser window
		driver.close();
		
		report.endTest(test);
		report.flush();

	}

}
