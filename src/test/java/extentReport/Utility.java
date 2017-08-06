package extentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {

	public static String captureScreen(WebDriver driver,String screenName) {
		
			String userDirectory = System.getProperty("user.dir");
			String customLocation = "//src//test//resources//extentScreenshots//failure//";
			String failureImageFileLoc = userDirectory + customLocation + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + "-" + screenName + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(failureImageFileLoc));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return failureImageFileLoc;

		}


}
