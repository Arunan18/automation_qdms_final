/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table Last Part- Review Test Parameter- "Relevant To Accepted Criteria" Check box Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 10/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0535          10/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableLastPartReviewTestParameterRelevantToAcceptedCriteriaCheckboxProperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test1 = null;

	@Test
	public static void testParaMeterTableProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0535");
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

		// Scroll down the page using Actions class
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// Excel Method
		DataFormatter data = new DataFormatter();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0535");

		XSSFRow row = sheet.getRow(firstrow);
		test1 = data.formatCellValue(row.getCell(3));
		Searching.searchvalue(test1, 1);

		// Get Properties
		commonMethodCheckBoxProperties();

	}

	public static void commonMethodCheckBoxProperties() throws InterruptedException, IOException {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0535-02",
				driver.findElement(
						By.xpath("//form[3]//*[contains(text(), '" + test1 + "')]//following-sibling::td//input/..")),
				"Test Configure Table - Parameter Table Last Part- Review Test Parameter- Relevant To Accepted Criteria Checkbox Properties");

	}
}
