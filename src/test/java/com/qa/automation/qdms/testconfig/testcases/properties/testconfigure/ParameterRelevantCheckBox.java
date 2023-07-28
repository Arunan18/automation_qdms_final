/************************************************************************************
* Description
*------------
*Test Configure Table - Parameter  Table - "Relevant" Check box Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0455         26/06/2023      RAHUL.S    Original Version
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ParameterRelevantCheckBox extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test = null;
	static String check = null;

	@Test
	public static void relevantCheckBox() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0455");

		// CLICK THE TEST PARAMETER
		TestConfigMethods.clickButton(2);

		if (NavigateManageTestFromLogin.clicked) {
			// GETTING DATA FROM EXCEL
			relevantCheckBoxPick();
			// CHECKING CHECKBOX PROPERTIES
			relevantCheckBox(check);
		}

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void relevantCheckBox(String check) throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"//td[text()='" + check + "']//following-sibling::td[3]//label[@class='ant-checkbox-wrapper']"))));
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0455-02",
				driver.findElement(By.xpath("//td[text()='" + check
						+ "']//following-sibling::td[3]//label[@class='ant-checkbox-wrapper']")),
				"THE PARAMETER RELEVANT CHECK BOX PROPERTIES");
	}

	public static void relevantCheckBoxPick() throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0455";
		DataFormatter data = new DataFormatter();
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		XSSFRow row = sheet.getRow(firstRow);

		check = data.formatCellValue((row.getCell(3)));

		TestConfigMethods.searchvalue(check, 1);

	}
}
