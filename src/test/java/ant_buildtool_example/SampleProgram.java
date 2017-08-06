/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as ant_buildtool_example
package ant_buildtool_example;

// Importing the predefined class libraries
import java.util.Date;
import org.testng.annotations.Test;

// The class is created with name : SampleProgram
public class SampleProgram {

	/** 
	 * The method name is : antTestNGMethod
	 * This method is annotated with Test.It will act as a test method
	 * This method will print current date and day
	 * 
	 */
	@Test
	public void antTestNGMethod() {
		System.out.println("A simple program with TestNG and Ant");
		System.out.println("Current Day and Date is :" + currentDate());
	}

	/** 
	 * The method name is : currentDate
	 * This method will return the date in string 
	 * 
	 */
	public static String currentDate() {
		return new Date().toString();
	}

}
