/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table Last Part- Review Test Parameter- Action -Edit icon  Pop up Screen -"Close" Button Functionality
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 11/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0563         11/07/2023     THAKSHILA    Original Version
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class EditiconPopupScreenCloseButtonFunctionality extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test1 = null;

	@Test
	public static void testParaMeterTableProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0563");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING PROPERTIES
			excelMethodCheckBox();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void excelMethodCheckBox() throws InterruptedException, IOException {

		// Excel Method
		DataFormatter data = new DataFormatter();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0563");

		XSSFRow row = sheet.getRow(firstrow);
		test1 = data.formatCellValue(row.getCell(3));

		Searching.searchvalue(test1, 1);
		try {
			// Scroll down the page using Actions class
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1000);

			try {
				// Wait for the edit icon to be clickable

				WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[3]//*[contains(text(), '" + test1
						+ "')]//following-sibling::td//a//span[@aria-label='edit']"))).click();

				// Get Properties
				commonMethodButtonFunctionality();
			} catch (TimeoutException e) {
				testCase = extent.createTest("The Edit Icon");
				testCase.log(Status.INFO, "The element was not clickable within 40 seconds");

			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate The Edit Icon");
			testCase.log(Status.INFO, "Unable to Locate The Edit Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on The Edit Icon");
			testCase.log(Status.INFO, "Unable to Click on The Edit Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check The Edit Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void commonMethodButtonFunctionality() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		WebDriverWait wait = new WebDriverWait(driver, 4);

		// Functionality test code
		testCase = extent.createTest("EDIT ICON POP UP CLOSE BUTTON FUNCTIONALITY");

		wait.until(
				ExpectedConditions.elementToBeClickable(TestConfigPage.reviewTestParaMeterEditIconPopCloseButtonProps));

		try {
			if (TestConfigPage.reviewTestParaMeterEditIconPopCloseButtonProps.isDisplayed()) {

				testCase = extent.createTest("STEP-1-CLOSE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (TestConfigPage.reviewTestParaMeterEditIconPopCloseButtonProps.isEnabled()) {

					testCase = extent.createTest("STEP-2-CLOSE BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {

						TestConfigPage.reviewTestParaMeterEditIconPopCloseButtonProps.click();

						testCase = extent.createTest("STEP-3-CLOSE BUTTON IS CLICKED");
						testCase.log(Status.PASS, "TEST PASS ☑");

					} catch (NoSuchElementException e2) {

						testCase = extent.createTest("LOCATE THE CLOSE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO LOCATE THE CLOSE BUTTON");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (ElementClickInterceptedException e2) {

						testCase = extent.createTest("CLICKED ON THE CLOSE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO CLICK ON CLOSE BUTTON ");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (Exception e2) {

						testCase = extent.createTest("CHECK CLOSE BUTTON FUNCTIONALITY");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} else {
					testCase = extent.createTest("STEP-2-CLOSE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-1-CLOSE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

}
