/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Relavant" Filed Check  box Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 03/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*TC-TCN-0484     03/07/2023     THAKSHILA    Original Version
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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableAddParameterPopupScreenRelavantFiledCheckboxProperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test1 = null;

	@Test
	public static void addParaMeterAddGroupPopupScreenProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0484");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING BUTTON PROPERTIES
			excelMethod();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void excelMethod() throws InterruptedException, IOException {

		// Excel Method
		DataFormatter data = new DataFormatter();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0484");

		XSSFRow row = sheet.getRow(firstrow);
		test1 = data.formatCellValue(row.getCell(3));

		// Properties
		addParaMeterAddGroupButton();
	}

	public static void addParaMeterAddGroupButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		try {
			TestConfigPage.paraMeterAddParaMeterAddGroupButton.click();
			// If clicks
			addParaMeterAddGroupPopUpParameterHeading();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the 'Add Group' Button");
			testCase.log(Status.INFO, "Unable to Locate the 'Add Group'' Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the 'Add Group' Button");
			testCase.log(Status.INFO, "Unable to Click on 'Add Group' Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check 'Add Group' Button Pop-Up");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void addParaMeterAddGroupPopUpParameterHeading() throws InterruptedException, IOException {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0484-02",
				driver.findElement(By.xpath("//div[@class='ant-modal-content']//*[text()='" + test1
						+ "']//following-sibling::td//input[@id='check_relevant']/..")),
				"Test Configure Table - Parameter Table-Add Parameter Pop up Screen-Relavant Filed Check  box Properties");

	}
}