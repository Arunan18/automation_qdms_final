//***********************************************************************************
//* Description
//*------------
//* Employee Role Validation 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 10/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0022           10/03/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.role;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class RoleValidation extends DriverIntialization {

	static RolePage rolepage = new RolePage();
	static Logout logout = new Logout();

	@Test
	public static void EmployeeRoleValidation() throws InterruptedException, IOException {
		PageFactory.initElements(driver, rolepage);

		// Login
		LoginTest.Login();

		MasterMainNavigationsTest.navigateMaster();

		// Main Navigation Click
		Thread.sleep(2000);
		RolePage.EmployeemneuBar.click();

		// Sub Navigation Click
		RolePage.RoleButton.click();

		// Checking Validation
		RoleValidationChecking();

		// Logout
		Logout.LogoutFunction();
	}

	// **********************************************************************************************************************
	// STEP-01 CHECKING VALIDATION
	// **********************************************************************************************************************

	public static void RoleValidationChecking() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Role";
		String testCaseId = "TC-ROL-0022";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Role");

		testCase = extent.createTest("STEP-01--ROLE FIELD VALIDATION");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(1).getBooleanCellValue();
			String Role = (String) row.getCell(2).getStringCellValue();
			row.getCell(3).getStringCellValue();
			row.getCell(4).getStringCellValue();

			if (check) {
				RolePage.RoleNameTextField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
				RolePage.RoleNameTextField.sendKeys(Role);

			} else {
				Thread.sleep(1000);
				RolePage.cancelButton.click();
			}
		}
	}
}
