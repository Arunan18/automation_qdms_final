import java.io.IOException;

import org.testng.TestNG;

public class TestRunner{
	 public static void main(String[] args) throws ClassNotFoundException, IOException {
	        // Create an instance of TestNG
	        TestNG testNG = new TestNG();
	        ClassSelector.select("master"); 
	        
	        // Set the test classes to the TestNG instance
	        testNG.setTestClasses(ClassSelector.testClasses.toArray(new Class[0]));

	        // Run the tests
	        testNG.run();   
	    }
	

}
