/***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab - Equation- Action - "Delete Icon" - Pop up Screen Properties 
//***************************************************************************************
//*
//* Author           : K.Saranga
//* Date Written     : 17/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-263           17/07/2023   K.Saranga   Original Version                
//************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigActionDeletePopup extends DriverIntialization{
	static ManageTestsPage mtp = new ManageTestsPage();
	static String code = null;
	@Test
	public static void manageTestConfigActionDeletePopupProperties() throws InterruptedException, IOException {

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties","Manage_Tests", "MTC-MT-263");

		//Calling the method
		actionDeletePopupPropertiess();

		//REFRESH
		driver.navigate().refresh();

		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();

	}
	public static void actionDeletePopupPropertiess() throws IOException, InterruptedException {
		ManageTestsPage mtp = new ManageTestsPage();
		PageFactory.initElements(driver, mtp);

		// Excel Method
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuration Properties.xlsx",
				"Manage_Tests", "MTC-MT-263");

		XSSFRow row = sheet.getRow(firstrow);
		code= (String) row.getCell(3).getStringCellValue();

		Thread.sleep(2000);
		
		try {
			// Locate the Action Column Delete Icon
			WebElement ActionColumnDeleteIcon = driver.findElement(By.xpath("//td[text()='"+code+"']//following-sibling::td[4]//span[@class='anticon anticon-delete']"));
			ActionColumnDeleteIcon.click();

			testCase = extent.createTest("Checking Action Column Delete Icon");
			testCase.log(Status.INFO, "Action Column Delete Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			Thread.sleep(2000);

			//Calling the method
			deleteIconPopupPropertiess();

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
	public static void  deleteIconPopupPropertiess() {
		PageFactory.initElements(driver, mtp);

		//Check Action Column Edit Icon Properties
		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests","MTC-MT-263-02", ManageTestsPage.deleteiconpopup, "Action Column Delete Icon Pop up Properties");
	}
}







