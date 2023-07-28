/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table Middle Page- Test Parameter Table- "Input Method" Drop Down Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 06/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0511        06/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableMiddlePageTestParameterTableValueDatePickerFiledProperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test1 = null;
	static String test2 = null;

	@Test
	public static void testParaMeterTableProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0511");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING PROPERTIES
			excelMethodCheckBoxCLick();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void excelMethodCheckBoxCLick() throws InterruptedException, IOException {
		// Excel Method
		DataFormatter data = new DataFormatter();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0511");

		XSSFRow row = sheet.getRow(firstrow);
		test1 = data.formatCellValue(row.getCell(3));
		test2 = data.formatCellValue(row.getCell(4));
		Searching.searchvalue(test1, 1);

		try {
			driver.findElement(
					By.xpath("//*[text()='" + test1 + "']//following-sibling::td//input[@id='check_relevant']/.."))
					.click();
			PageFactory.initElements(driver, testConfig);

			// Find the target element you want to scroll to
			WebElement targetElement = TestConfigPage.scrollDown;

			// Create an Actions instance
			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			// Perform a series of actions to scroll to the target element
			actions.moveToElement(targetElement).perform();
			// common method for select an item from a drop down
			ActionCommonMethod.dropdDown(TestConfigPage.paraMeterTestParaMeterTypeDropdown, test2);

			// If clicks
			commonMethodCalendarProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Parameter Relevant Checkbox");
			testCase.log(Status.INFO, "Unable to Locate the Parameter Relevant Checkbox");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Parameter Relevant Checkbox");
			testCase.log(Status.INFO, "Unable to Click on Parameter Relevant Checkbox");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Check Parameter Relevant Checkbox");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void commonMethodCalendarProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0511-02", TestConfigPage.paraMeterAddParaMeterCalendarFeild,
				"Test Configure Table - Parameter Table Middle Page- Test Parameter Table- Value Date Picker Filed Properties");

	}
}
