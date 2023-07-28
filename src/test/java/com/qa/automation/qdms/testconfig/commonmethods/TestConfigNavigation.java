package com.qa.automation.qdms.testconfig.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.pages.master.MasterPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.configgrouptest.ConfigGroupTestMainTests;

public class TestConfigNavigation extends ConfigGroupTestMainTests {

	static TestConfigNavigation tc = new TestConfigNavigation();
	static TestConfigPage tcp=new TestConfigPage();

	/*
	 * 
	 * Test Configuration METHOD-1
	 * 
	 * METHOD FOR CHECKING WITH LEFT 4 NAVIGATION ANY 1 NAVIGATION WINDOW VISIBLE OR
	 * NOT
	 * 
	 * 1-->Main Heading 2-->Display Field Xpath 3-->Display TestCase 4-->Enabled
	 * TestCase 5-->Expected Out Put Window1 Xpath 6-->Expected Out Put Window2
	 * 7-->Expected Out Put Window3 8-->Expected Out Put Window4 Xpath 9-->Expected
	 * Out Put Window TestCase
	 * 
	 */

	static boolean sample1;
	static boolean sample2;
	static boolean sample3;
	static boolean sample4;

	public static void mainmethod(String step_heading, WebElement display_xpath, String display_testcase,
			String enabled_testcase, WebElement Expected_Window1_xpath, WebElement Expected_Window2_xpath,
			WebElement Expected_Window3_xpath, WebElement Expected_Window4_xpath, String Window_testcase) {
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
					 * Check After click the Top Navigation Expected Window Shows or Not Expected
					 * Window 1
					 */
					try {
						sample1 = Expected_Window1_xpath.isDisplayed();

					} catch (Exception e) {
						System.out.println("Error in Sample1");
					}

					/*
					 * Check After click the Top Navigation Expected Window Shows or Not Expected
					 * Window 2
					 */
					try {

						sample2 = Expected_Window2_xpath.isDisplayed();

					} catch (Exception e) {
						System.out.println("Error in Sample2");
					}

					/*
					 * Check After click the Top Navigation Expected Window Shows or Not Expected
					 * Window 3
					 */
					try {

						sample3 = Expected_Window3_xpath.isDisplayed();

					} catch (Exception e) {
						System.out.println("Error in Sample3");
					}

					/*
					 * Check After click the Top Navigation Expected Window Shows or Not Expected
					 * Window 4
					 */
					try {

						sample4 = Expected_Window4_xpath.isDisplayed();

					} catch (Exception e) {
						System.out.println("Error in Sample4");
					}
					/*
					 * Check After click the Top Navigation Expected Windows Window1 || Window2||
					 * Window3 || Window4 Shows or Not
					 */

					if (sample1 || sample2 || sample3 || sample4) {
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
	// click on test configuration

	public static void TestConfigurationCard() throws InterruptedException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, tcp);

		Thread.sleep(2000);

		TestConfigPage.testconfiguration.click();
	}

	/* Page Right Scroll Method */
	public static void pagescroler(String outsiteclick_xpath, String untilscroll_xpath) {
		driver.findElement(By.xpath(outsiteclick_xpath)).click();
		try {
			boolean pass = false;
			Thread.sleep(1000); 

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath(untilscroll_xpath)).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}
	
	/* Test Configuration Button */

	/*
	 * test_case -- Test case headding test_xpath -- display textcase xpath
	 * color_value -- icon expected colour value display_status -- display report
	 * detail Enabled_status -- enabled report detail
	 */
	static boolean status = false;

	public static boolean function(String test_case, WebElement test_xpath, String color_value, String display_status,
			String Enabled_status) {
		try {
			testCase = extent.createTest(test_case);
			if (test_xpath.isDisplayed()) {
				testCase = extent.createTest(display_status + "IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");

				if (test_xpath.isEnabled()) {
					testCase = extent.createTest(Enabled_status + "IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");

					String colour = test_xpath.getCssValue("background-color");
					if (colour.equals(color_value)) {
						Assert.assertEquals(colour, color_value);
						testCase.log(Status.INFO, "Actual Data :- " + colour);
						testCase.log(Status.INFO, "Expected Data :- " + color_value);
						testCase.log(Status.PASS, display_status + "BACKGRUND COLOUR IS CORRECT");
						status = true;
					} else {
						testCase.log(Status.INFO, "Actual Data :- " + colour);
						testCase.log(Status.INFO, "Expected Data :- " + color_value);
						testCase.log(Status.FAIL, display_status + "BACKGRUND COLOUR IS NOT CORRECT");
					}

				} else {
					testCase = extent.createTest(Enabled_status + "IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest(display_status + "IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
			System.out.println("ERROR IN" + display_status);
		}
		return status;

	}

	/* Test Configuration Button Expected Window */
	/*
	 * Window_testcase - Headding Test case Expected_Window_xpath - Expected Heading
	 * Xpath testcase_displayed - Display TestCase expecteddata - Expected window
	 * headding
	 */
	public static void expectedwindow(String Window_testcase, WebElement Expected_Window_xpath,
			String testcase_displayed, String expecteddata) {
		try {
			testCase = extent.createTest(Window_testcase);
			if (Expected_Window_xpath.isDisplayed()) {
				String Actualvalue = Expected_Window_xpath.getText();
				System.out.println(Actualvalue);

				if (Actualvalue.equals(expecteddata)) {
					testCase.log(Status.PASS, "TEST PASS");
					testCase.log(Status.INFO, "Actual Data :- " + Expected_Window_xpath.getText());
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.INFO, "THE EXPECTED WINDOW APPEARED");
				} else {

					testCase = extent.createTest(Window_testcase);
					testCase.log(Status.FAIL, "TEST FAIL");
					testCase.log(Status.INFO, "Actual Data :- " + Expected_Window_xpath.getText());
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.INFO, "THE EXPECTED WINDOW DOES NOT APPEARED");
				}
			} else {
				testCase = extent.createTest(Window_testcase);
				testCase.log(Status.PASS, "TEST FAIL");
				testCase.log(Status.INFO, "THE EXPECTED WINDOW HEADING IS NOT DISPLAYED");
			}

		} catch (Exception e) {
			System.out.println("Error in Sample1");
		}
	}

	/* Get the return value from Excel sheet */

	public static String excel(String Sheet_Name, String Page_Name, String TestCase_Id, int i) throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\" + Sheet_Name + ".xlsx";
		String excelSheetName = Page_Name;
		String testCaseId = TestCase_Id;

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(Page_Name);

		XSSFRow row = sheet.getRow(firstRow);
		String value = (String) row.getCell(i).getStringCellValue();
		return value;
	}

}
