//***********************************************************************************
//* Description
//*------------
//*Delete  Function - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-004            27/04/2023       Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.grouptests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class DeleteFuctionGroupTest extends DriverIntialization {
	static TestConfigPage DeleteFunctionPage = new TestConfigPage();
	static String SearchDataToDelete = null;

//==================================== M E T H O D ===============================================
	@Test
	public void methodCalling() throws InterruptedException, IOException {

//__________________________________LOGIN ____________________________________________

		LoginTest.Login();

//____________________________ NAVIGATE TO GROUP TEST _______________________________

		DeleteFuctionGroupTest.navigateToGroupTest();
		
//______________________________  EXCEL METHOD _____________________________________
		
		DeleteFuctionGroupTest.ExcelMethod();

 //__________________________________________________________________________________
    //	  STEP 1 : DELETE ICON VISIBLE ENABLE     
    //    STEP 2 : DELETE POP VISIBLE AND ENABLE   
    //    STEP 3 : AFTER DELETE CHECK DATA IS THERE OR NOT 
//____________________________________________________________________________________		

		DeleteFuctionGroupTest.DataSearchAndDelete();

//_______________________________ LOGOUT ______________________________________________

		MultiSearchMethods.Logout();

	}
	
	
	

// ================================ T E S T C A S E S  ============================================

//_________________________________________________________________________
// NAVIGATE TO MANAGE TEST CONFIGURE
//__________________________________________________________________________	

	public static void navigateToGroupTest() {
		PageFactory.initElements(driver, DeleteFunctionPage);

		// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO MANAGE TEST CONFIGURE
		SampleCommonMethods.methodoneclick("STEP:1 MANGECONFIGURE PROPERTIES", TestConfigPage.MANGECONFIGURE,
				"MANGECONFIGURE SIDE BUTTON IS DISPLAY", "MANGECONFIGURE SIDE BUTTON IS ENABLED",
				TestConfigPage.ParameterText, "MANGECONFIGURE SIDE BUTTON",
				"ON CLICK THE MANGECONFIGURE BUTTON IT'S REDERECT TO CORRECT FORM");

		// NAVIGATE TO MANAGE GROUP TEST
		SampleActionMethods.clicking(TestConfigPage.GroupTest, 2, "GROUP TEST SIDE BUTTON");
	}

//________________________________________________________
//  EXCEL METHOD
//________________________________________________________	
	public static void ExcelMethod() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0011";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			SearchDataToDelete = (String) row.getCell(1).getStringCellValue();

		}
	}

//________________________________________________________
//  SEARCH DATA TO BE  DELETE 
//________________________________________________________	

	public static void DataSearchAndDelete() throws InterruptedException {
		PageFactory.initElements(driver, DeleteFunctionPage);

		ActionCommonMethod.actionS(0, 6, TestConfigPage.TableFullGroupTest, "delete", "Test Configuragtion Module.xlsx",
				"Group_Tests", "MTC-GT-004-01", 1);

		extent.createTest("STEP:2");
		Thread.sleep(2000);

		SampleActionMethods.clicking(TestConfigPage.OkDeleteBtnGroupTest, 2, "DELETE ALERT");

//________________________________________________________
//  AFTER DELETE  CHECK DATA IS DELETED OR NOT 
//________________________________________________________
		boolean isDataDeleted = true;
		List<WebElement> tableRows = TestConfigPage.TableOfGrouPTest.findElements(By.tagName("tr"));

		for (WebElement row : tableRows) {
			if (row.getText().contains(SearchDataToDelete)) {
				isDataDeleted = false;
				break;
			}
		}

		if (isDataDeleted) {
			System.out.println("Incoming sample data has been deleted successfully.");
			testCase.log(Status.PASS, "Incoming sample data has been deleted successfully");
		} else {
			System.out.println("Failed to delete incoming sample data.");
			testCase.log(Status.FAIL, "Failed to delete incoming sample data");
		}
	}

}
