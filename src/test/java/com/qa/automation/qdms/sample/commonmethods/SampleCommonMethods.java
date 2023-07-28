package com.qa.automation.qdms.sample.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;

public class SampleCommonMethods extends DriverIntialization { 

	static SampleNavigationPage productionsample = new SampleNavigationPage();







//test case print
	public static void TestCasePrint(String TestCaseName) {
		TestCasePrint(TestCaseName, null, null, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		TestCasePrint(TestCaseName, expectedValue, actualValue, null);
	}

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue,
			String Explanation) {
		/**
		 * 
		 * Prints the results of a test case to an extent report.
		 * 
		 * @param TestCaseName  the name of the test case
		 * 
		 * @param expectedValue the expected value of the test case
		 * 
		 * @param actualValue   the actual value of the test case
		 * 
		 * @param Explanation   an optional explanation for the test case
		 */

		if (expectedValue != null && actualValue != null) {
			boolean position = true;

			ExtentTest testCase = extent.createTest(TestCaseName);
			try {
				AssertJUnit.assertEquals(actualValue, expectedValue);
			} catch (AssertionError e) {
				position = false;
			}
			if (position) {
				testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
				testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
				testCase.log(Status.PASS, "TEST PASS ✅");
			} else {
				testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
				testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
				if (Explanation != null) {
					testCase.log(Status.INFO, Explanation);
				}
				testCase.log(Status.FAIL, "TEST FAIL ❌");
			}
		} else {
			ExtentTest testCase = extent.createTest(TestCaseName);
//				testCase.log(Status.INFO, TestCaseName);
		}

	}
	// ******************************************************************************
	// ******************************************************************************

//data count checking
	public static void dataCountChecking() {

	}

//Delete edit action
	public static void actionS(int column, int clickColumn, WebElement table, String action, String wookBook,
			String sheet, int ro, int col) {

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;

		try {
			filelocation = "./src/test/resources/Excel/" + wookBook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheets = wbook.getSheet(sheet);

		row = sheets.getRow(ro);
		cell = row.getCell(col);
		String iV = dataValue.formatCellValue(cell);

		int i = 0;
		String value = null;
		String value2 = null;
		if (action == "delete") {
			value = ".anticon-delete";
			value2 = ".ant-popover-content";
		} else if (action == "edit") {
			value = ".anticon-edit";
			value2 = ".ant-modal-content";

		}

		else if (action == "Description") {
			value = ".anticon-container";
			value2 = ".ant-modal-content";

		} else if (action == "Add Key Test") {
			value = ".anticon-funnel-plot";
			value2 = ".ant-modal-content";

		} else if (action == "copy") {
			value = ".anticon-copy";
			value2 = ".ant-modal-content";

		} else if (action == "More") {
			value = ".anticon-ellipsis";
			value2 = ".ant-modal-content";

		} else if (action == "Test & Result") {
			value = ".anticon-experiment";
			value2 = ".ant-modal-content";

		} else if (action == "Key Test") {
			value = ".anticon-key";
			value2 = ".ant-modal-content";

		}

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

		}

		allrows = table.findElements(By.cssSelector("tbody tr"));
		num = allrows.size();

		for (i = 0; i < num; i++) {

			List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
			String name = rows.get(column).getText();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();

			if (name.equals(iV)) {
				try {
					WebElement input = rows.get(clickColumn).findElement(By.cssSelector(value));
					boolean value1 = input.isDisplayed();
					TestCasePrint(action + " BUTTON IS DISPLAYED", "true", String.valueOf(value1));
					boolean value3 = input.isEnabled();
					TestCasePrint(action + " BUTTON IS ENABLED", "true", String.valueOf(value3));

					input.click();
					Thread.sleep(3000);
					Boolean popup = driver.findElement(By.cssSelector(value2)).isDisplayed();
					TestCasePrint(action + "POPUP IS DISPLAYED", "true", String.valueOf(popup));

				} catch (Exception e) {

				}

				break;

			}

			else if (rept == false) {
				extent.createTest("SEARCHING DATA NOT FIND IN TABLE");
				break;

			}

		}
		if (rept == true) {
			driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

		}

	}

	// DATA COUNT IN TABLE
	public static int count = 0;

	public static int CountOfData(WebElement table) {
		int num = 0;
		int counte = 0;
		List<WebElement> allrows = null;

		for (int i = 0; i < 103; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {

			}
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size() - 1;
			counte = counte + num;
			boolean nextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
					.isEnabled();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}

			if (nextPage == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {

				}
			} else {
				break;

			}
		}
		count = counte;
		return count;

	}
	//*********************************************************************************************
	public static void actionS1(int column, int clickColumn, WebElement table, String action, String wookBook,
			String tab, int r, int c) {

		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		Boolean not = false;
		try {
			filelocation = "./src/test/resources/Excel/" + wookBook;

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheet = wbook.getSheet(tab);

		row = sheet.getRow(r);
		cell = row.getCell(c);
		String iV = dataValue.formatCellValue(cell);
		// System.out.println(iV);

		int i = 0;
		String value = null;
		String value2 = null;
		if (action == "delete") {
			value = ".anticon-delete";
			value2 = ".ant-popover-content";
		} else if (action == "edit") {
			value = ".anticon-edit";
			value2 = ".ant-modal-content";

		}
		else if (action=="copy") {
			value = ".anticon-copy";
			value2 = ".anticon-check-circle";
			
		}

		else if (action == "Description") {
			value = ".anticon-container";
			value2 = ".ant-modal-content";

		} else if (action == "Add Key Test") {
			value = ".anticon-funnel-plot";
			value2 = ".ant-modal-content";

		}

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		while (rept == true) {
			allrows = table.findElements(By.cssSelector("tbody tr"));
			num = allrows.size();
			for (i = 0; i < num; i++) {

				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				String name = rows.get(column).getText();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				// System.out.println(rept);
				if (name.equals(iV)) {
					WebElement input = rows.get(clickColumn).findElement(By.cssSelector(value));
					Boolean dis = input.isDisplayed();
					PropertiesCommonMethods.cTestReports("1." + action.toUpperCase() + "-Icon Displayed", "true", dis,
							action + "-Icon");

					if (dis == true) {
						Boolean ena = input.isEnabled();
						PropertiesCommonMethods.cTestReports("2." + action.toUpperCase() + "-Icon Enable", "true", ena,
								action + "-Icon");
						if (ena == true) {
							input.click();
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {

							}
							Boolean popup = driver.findElement(By.cssSelector(value2)).isDisplayed();
							PropertiesCommonMethods.cTestReports(
									action.toUpperCase() + "-Pop Up Is Displayed, " + action + "-Icon Is Clicked",
									"true", popup, action + "-Icon");
							rept = false;
							not = true;
							break;
						}
					}

				}

			}
			if (rept == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}

			}

			else if (rept == false & not == false) {
				extent.createTest("SEARCHING DATA NOT FIND IN TABLE");

			}
		}
	}
	
	
	/*
	 * 
	 * SAMPLE METHOD-1
	 * 
	 * METHOD FOR CHECKING WITH LEFT 2 NAVIGATION ANY 1 NAVIGATION WINDOW VISIBLE OR NOT
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Expected Out Put Window1 Xpath 6-->Expected Out Put Window2
	 * Xpath 7-->Expected Out Put Window TestCase
	 * 
	 */
	
	static boolean sample1;
	static boolean sample2;

	public static void mainmethod(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase, WebElement Expected_Window1_xpath, WebElement Expected_Window2_xpath,
			String Window_testcase) 
	{
		PageFactory.initElements(driver, productionsample);

		try {
			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");

					display_xpath.click();

					/*
					 * Check After click the Top Navigation Expected Window Shows or Not
					 * Expected Window 1
					 */
					try {
						sample1 = Expected_Window1_xpath.isDisplayed();

					} catch (Exception e) {
						System.out.println("Error in Sample1");
					}

					/*
					 * Check After click the Top Navigation Expected Window Shows or Not
					 * Expected Window 2
					 */
					try {

						sample2 = Expected_Window2_xpath.isDisplayed();

					} catch (Exception e) {
						System.out.println("Error in Sample2");
					}

					/*
					 * Check After click the Top Navigation Expected Windows
					 *  Window1 || Window2 Shows or Not
					 */

					if (sample1 || sample2) {
						testCase = extent.createTest(Window_testcase);
						testCase.log(Status.PASS, "TEST PASS"); 
					} else {
						testCase = extent.createTest(Window_testcase);
						testCase.log(Status.FAIL, "TEST FAIL");
						testCase.log(Status.INFO, "THE EXPECTED WINDOW HEADING DOES NOT APPEAR");
					}

				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
	
	/*
	 * SAMPLE METHOD-2
	 * 
	 * METHOD FOR CHECKING WITH ON CLICK THE BUTTON EXPECTED WINDOW VISIBLE OR NOT
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Expected Out Put Window 6-->Expected Out Put Window TestCase
	 * 
	 */
	
	public static void methodoneclick(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase, WebElement Expected_Window_xpath, String expecteddata,	String Window_testcase) 
	{
		PageFactory.initElements(driver, productionsample);

		try {
			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");
					
					Thread.sleep(2000);
					display_xpath.click();

					/* 
					 * Check After click the Button Expected Window Shows or Not
					 * Expected Window
					 */
					Thread.sleep(2000);
					try {
						
						if (Expected_Window_xpath.isDisplayed() ) {
							String Actualvalue = Expected_Window_xpath.getText();
							System.out.println(Actualvalue);
							
						try {
						    Assert.assertEquals(Actualvalue, expecteddata);
							testCase = extent.createTest(Window_testcase);
							testCase.log(Status.PASS, "TEST PASS");
							testCase.log(Status.INFO, "Actual Data :- " + Expected_Window_xpath.getText());
							testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
						} catch (AssertionError e) {
							
							testCase = extent.createTest(Window_testcase);
							testCase.log(Status.FAIL, "TEST FAIL");
							testCase.log(Status.INFO, "Actual Data :- " + Expected_Window_xpath.getText());
							testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
							testCase.log(Status.INFO, "THE EXPECTED WINDOW HEADING DOES NOT APPEAR");
						}
						}else {
							System.out.println("EXPECTED WINDOW NOT DISPLAYED");
						}
					

					} catch (Exception e) {
						System.out.println("Error in Sample1");
					}


				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
	
	/*
	 * SAMPLE METHOD-3
	 * 
	 * METHOD FOR SELECT DROPDOWN FIELD
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Dropdown Field Xpath 6-->Dropdown Field TestCase
	 * 
	 */
	public static void fieldmethoddropdown(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase, String field_xpath, String selected_testcase ) 
	{
		PageFactory.initElements(driver, productionsample);

		try {
			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");
					
					Thread.sleep(1000); 
					display_xpath.click();

					Actions actions = new Actions(driver);
					Thread.sleep(1000);
			
					
					/* Select the drop down for Sub Category Field Field */
                    
					boolean findthevalue = false;
                      for(int i = 0; i < 20; i++) {
                          try {
                          	Thread.sleep(1000); 
                          	 driver.findElement(By.xpath(field_xpath)).click();
                               
                              findthevalue = true; 
                              testCase = extent.createTest("03--Dropdown Value Selected");
      						  testCase.log(Status.PASS, "TEST PASS");
                              break;
                              
                          } catch (Exception e) {
                              actions.sendKeys(Keys.ARROW_DOWN).perform();
                          }
                      }
					
				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
	
	/*
	 * SAMPLE METHOD-4 
	 * 
	 * METHOD FOR SELECT DROPDOWN FIELD 
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Dropdown Field Xpath 6-->Dropdown Field TestCase
	 * 
	 */
	public static void fieldmethodselect(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase,String sendkey, String selected_testcase ) 
	{
		PageFactory.initElements(driver, productionsample);

		try {
			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");
					
			try {
					Thread.sleep(2000);
					display_xpath.click();
					
					Thread.sleep(3000);
					display_xpath.sendKeys(sendkey);
					Thread.sleep(1000);
					display_xpath.sendKeys(Keys.ENTER);
					
					testCase = extent.createTest(selected_testcase);
					testCase.log(Status.PASS, "TEST PASS");
			}
			catch (Exception e) {
				testCase = extent.createTest(selected_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}

				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
	
	/*
	 * SAMPLE METHOD-5 
	 * 
	 * METHOD FOR SEND KEY FIELD 
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Send key value
	 * 
	 */
	
	public static void sendvalue(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase,String sendkey) 
	{
		PageFactory.initElements(driver, productionsample);

		try {
			testCase = extent.createTest(step_heading);
			Thread.sleep(1500);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");
							
					Thread.sleep(2000);
					display_xpath.click();
					
					Thread.sleep(2000);
					display_xpath.sendKeys(sendkey);

				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
	
	/*
	 * SAMPLE METHOD-6
	 * 
	 * METHOD FOR CHECKING WITH ON CLICK THE BUTTON EXPECTED WINDOW VISIBLE OR NOT
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Expected Out Put Window 6-->Expected Out Put Window TestCase
	 * 
	 */
	
	public static void singleclick(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase) 
	{
		PageFactory.initElements(driver, productionsample);

		try {
			testCase = extent.createTest(step_heading);
			if (display_xpath.isDisplayed()) {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.PASS, "TEST PASS");

				if (display_xpath.isEnabled()) {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.PASS, "TEST PASS");
					
					Thread.sleep(1000);
					display_xpath.click();
  

				} else {
					testCase = extent.createTest(enabled_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_testcase);
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("Error in Method");
		}
	}
	
	/* EQUAL MESSAGE CHECKING DATA ADDED SUCCESS MESSAGE */
	
	public static void dataaddedsuccessmsg(String test_case, WebElement message_xpath, String expectedmsgresult) throws InterruptedException {
		
		Thread.sleep(1000);
		String AddSuccessMessage = message_xpath.getText(); 
		
		String expectedatamsg = expectedmsgresult;

		testCase = extent.createTest(test_case);
		try {
			Assert.assertEquals(AddSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Message Enable");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Message Not Enable");
		}

}
	
/* EQUAL MESSAGE CHECKING */
	
	public static void dataaddedmsg(String test_case, int actualvalue, int expectevalue) throws InterruptedException {
		
		Thread.sleep(1000);
		testCase = extent.createTest(test_case);
		try {
			Assert.assertEquals(actualvalue, expectevalue);
			testCase.log(Status.INFO, "Actual Data :- " + actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectevalue);
			testCase.log(Status.PASS, "BEFORE AND AFTER DATA COUNTS ARE EQUAL");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectevalue);
			testCase.log(Status.FAIL, "BEFORE AND AFTER DATA COUNTS ARE NOT EQUAL");
		}

}

	/* EQUAL FAIL MESSAGE CHECKING FOR DATA TABLE COUNT */
  
	public static void notequal(String test_case, WebElement message_xpath, String expectedmsgresult) throws InterruptedException {
		
		Thread.sleep(2000);
		String Actualdata = message_xpath.getText();
		String[] Actualspliddata = Actualdata.split("of ");
		String Actualvalue = Actualspliddata[1];
		String expectedatamsg = expectedmsgresult;

		testCase = extent.createTest(test_case); 
		try {
			Assert.assertEquals(Actualvalue, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong, Data Count is Equal");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Correct, Data Count is Not Equal");
		}

}
	
	/* EQUAL PASS MESSAGE CHECKING FOR DATA TABLE COUNT */
	public static void equalpass(String test_case, WebElement message_xpath, String expectedmsgresult) throws InterruptedException {
		
		Thread.sleep(2000);
		String Actualdata = message_xpath.getText();
		String[] Actualspliddata = Actualdata.split("of ");
		String Actualvalue = Actualspliddata[1];

		String expectedatamsg = expectedmsgresult;

		testCase = extent.createTest(test_case); 
		try {

			Assert.assertEquals(Actualvalue, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Correct, Data Count is Equal");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong, Data Count is Not Equal");
			
		} 
}
	
/* DATA ADDED FIRST OF THE TABLE */
	
public static void firstrowdata(String test_case, WebElement firstdata_xpath, String expecteddata)
{
	

	boolean firstdata = true;
	String actualdata=null;
	testCase = extent.createTest(test_case);
	try {
		 actualdata = firstdata_xpath.getText();
		AssertJUnit.assertEquals(actualdata, expecteddata);

	} catch (AssertionError e) {
		firstdata = false;
	}catch (NoSuchElementException e) {
		firstdata = false;
	}
	if (firstdata) {
		testCase.log(Status.INFO, "Actual Data :- " + actualdata);
		testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
		testCase.log(Status.PASS, "Correct last data added in first row");
	} else {
		testCase.log(Status.INFO, "Actual Data :- " + actualdata);
		testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
		testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
	}
}

//check the data has added in first row even if click cancel button
public static void firstrowdataCancel(String test_case, WebElement firstdata_xpath, String expecteddata)
{
	String actualdata = null;

	boolean firstdata = false;
	testCase = extent.createTest(test_case);
	try {
		actualdata = firstdata_xpath.getText();
		AssertJUnit.assertEquals(actualdata, expecteddata);

	} catch (AssertionError e) {
		firstdata = true;
	} catch (NoSuchElementException e) {
		firstdata = true;
	}
	if (firstdata) {
		testCase.log(Status.INFO, "Actual Data :- " + actualdata);
		testCase.log(Status.INFO, "Expected Data :- " + expecteddata);	
		testCase.log(Status.PASS, "Data Not Added in First Row");
	} else {
		testCase.log(Status.INFO, "Actual Data :- " + actualdata);
		testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
		testCase.log(Status.FAIL, "Data Added in First row");
	}
}
//*******************************************************************************
public void perticulardataaction(String WorkbookName,String TabName,String TestCaseId,List<WebElement> column, String TestTrialColumnNo, String nameColumnNo ) throws IOException, InterruptedException {
//	@FindBy (xpath ="//tbody[@class='ant-table-tbody']/tr/td[2]")
//	public static List<WebElement> column;
//
String workbooks = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + WorkbookName + ".xlsx";
int firstrow = CommonMethods.getFirstRowNum(workbooks, TabName, TestCaseId);
int lastrow = CommonMethods.getLastRowNum(workbooks, TabName, TestCaseId);
FileInputStream file = new FileInputStream(workbooks);
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheet(TabName);
int rowcount = sheet.getLastRowNum();
for (int i = firstrow; i <= lastrow; i++) { 
	XSSFRow rowk = sheet.getRow(i);

	String searchQuery = rowk.getCell(1).getStringCellValue();
	System.out.println(searchQuery + "******************");
	// ********************************************************************
	boolean clickNextPage = true;
	boolean sbuExist = false; 
	while (clickNextPage) {
		Thread.sleep(2000);
		int size = column.size();
		System.out.println(size);
		for (int j = 2; j <= size; j++) {
			System.out.println(j);
			Thread.sleep(1000);
			String NameXpath_firstPart = "//tbody[@class='ant-table-tbody']/tr[";
			String text=null;
			try {
			 text = driver.findElement(By.xpath(NameXpath_firstPart + j + "]/td[" + nameColumnNo + "]"))
					.getText();
			} catch (NoSuchElementException e) {
				TestCasePrint("Searched Element Not There");
			}
			System.out.println(text);
			Thread.sleep(500);
			if (text.contains(searchQuery)) {  
				Thread.sleep(500); 
				
				 
				try {
				driver.findElement(
						By.xpath(NameXpath_firstPart + j + "]/td[" + TestTrialColumnNo + "]/span"))
						.click();
				} catch (NoSuchElementException e) {
					TestCasePrint("Clicked Element Not There");
				}
				sbuExist = true;
				break;
			}

			if(sbuExist) {
				break;
			}
		}
		if(sbuExist) {
			break;
		}
		try {
		WebElement next=driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"));
		clickNextPage = next.isEnabled();
		if (clickNextPage == true) {
			Thread.sleep(2000);
			next.click();
		}
		}catch (NoSuchElementException e) {
			TestCasePrint("Next Button Element Not There");
		}
		
	}

}
}

}
//test
