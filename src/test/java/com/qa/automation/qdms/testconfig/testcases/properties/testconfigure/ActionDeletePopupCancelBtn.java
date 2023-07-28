/***********************************************************************************
//* Description
//*------------
//* Test Configure - "Accepted Condition" - Action Column Delete Icon Pop up Screen - Cancel Button Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 17/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0760        17/07/2023      K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ActionDeletePopupCancelBtn extends DriverIntialization {
	static TestConfigPage testconfigurebutton = new TestConfigPage();
	static String code = null;
	@Test
	public static void actionDeletePopupCancelButton() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties","Test_Configure", "TC-TCN-0760");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(6);

		//Calling the method
		deletePopupCancelBtnProperties();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void deletePopupCancelBtnProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testconfigurebutton);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Test_Configure", "TC-TCN-0760");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(3).getStringCellValue();

		try {
			// Locate the Action Column Edit Icon
			WebElement ActionColumnDeleteIcon = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[1]//span[@class='anticon anticon-delete']"));
			ActionColumnDeleteIcon.click();

			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			Thread.sleep(2000);

			//Calling the method
			deletePopupCancelBtnPropertiess();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Unable to Locate Action Column Delete Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void  deletePopupCancelBtnPropertiess() {
		PageFactory.initElements(driver, testconfigurebutton);

		//Check Action Column Edit Icon Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure","TC-TCN-0760-02", TestConfigPage.deleteiconpopupcancelbutton, "Action Column Delete Icon Pop up Screen Cancel Button Properties");
	}	
}

