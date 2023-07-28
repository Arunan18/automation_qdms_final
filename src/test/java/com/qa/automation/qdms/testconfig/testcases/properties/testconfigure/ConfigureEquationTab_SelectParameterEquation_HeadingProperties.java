//***********************************************************************************
// Description
//------------
//Test Configure-Configure Test Table-Configure EquationTab-"Equation Type" DropDown Under-"Select Parameter for create equation"UIHeadingProperties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 22/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0582           22/06/2023    NILUXY.K      Original Version
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigureEquationTab_SelectParameterEquation_HeadingProperties extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();
	static String parameterdata = null;

	@Test
	public static void configureEquation() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0582");

		// CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION
		// TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);

		// CLICK THE SEARCH ICON BUTTON
		TestConfigMethods.clickElement(TestConfigPage.resultRadioButton, "CHECKING THE RESULT RADIO ICON");

		// SELECT THE VALUE FOR THE DROPDOWN FROM THE EXCEL
		selectParameterdata();

		// CALLING THE METHOD FOR CHECKING SELECT PARAMETER HEADING PROPERTIES
		selectParameterHeadingProperties();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	
	public static void methodClickRadioButton() {}
	public static void selectParameterdata() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0582-01");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0582-01");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			parameterdata = (String) row.getCell(3).getStringCellValue();
		}

		// GET THE DATA FOR DROPDOWN	
		Actions actions = new Actions(driver);
		TestConfigPage.dropDownTestParameter.sendKeys(parameterdata);
		actions.sendKeys(Keys.ENTER).perform();
	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR HEADING
	public static void selectParameterHeadingProperties() {
		// CHECK 'TEST PARAMETER' HEADING PROPERTIES
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0582-02", TestConfigPage.selectParameterHeading,
				"SELECT PARAMETER CREATE EQUATION-HEADING PROPERTIES");

	}

}
