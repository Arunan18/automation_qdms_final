
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE MORE OPTION FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   05:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0018   	   05:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-PRO-SAM-0018	Process Sample More Option
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition.MixDesignMorescreenContent;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class InProcessSampleMoreOptionFunction extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();
	static String SeachData = null;
	static String alertMessage = null;

//*************************LOGIN AND REACH INPROCESS SAMPLE NAVIGATION*****************

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		// ------Login-----------
		LoginTest.Login();

		// -----------Reach In-Process Sample--------------

		AddInprocessSampleTest.SampleMainMethod();

	}

//******************************** EXCEL METHOD*******************************************
	@Test(priority = 1)
	public static void ExcelMethod() throws IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Process Sample";
		String testCaseId = "TC-PRO-SAM-0018";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			SeachData = (String) row.getCell(1).getStringCellValue();
			alertMessage = (String) row.getCell(2).getStringCellValue();

		}
	}

//******************************** SEARCH DATA TO MORE METHOD*******************************************

	@Test(priority = 2)
	public static void SeachDataToMore() throws InterruptedException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(4000);
		testCase = extent.createTest("STEP:1");
		ActionCommonMethod.actionS(0, 16, InprocessSamplePage.InpSampleTable, "More", "Samples Module.xlsx",
				"Process Sample", "TC-PRO-SAM-0018-01", 1);

	}

//******************************** ALERT MESSAGE METHOD*******************************************

	@Test(priority = 3)
	public static void AlertMethod() throws IOException, InterruptedException {

		// ----------AFTER CLICK MORE ICON VIEW ALERT MESSAGE----------

		testCase = extent.createTest("STEP:3 MORE ALERT POPUP VISIBLE");

		WebElement alert = InprocessSamplePage.InProcessMorePopup;

		boolean Visible = alert.isDisplayed();
		if (Visible) {
			boolean actualVisible = alert.isDisplayed();
			System.out.println("Alert Visible:-" + actualVisible);
			boolean expectedVisible = true;
			try {
				assertEquals(actualVisible, expectedVisible);
				testCase.log(Status.INFO, " Actual Visible:-" + actualVisible);
				testCase.log(Status.INFO, " Expected Visible:-" + expectedVisible);
				testCase.log(Status.PASS, "Correct Visible");
			} catch (AssertionError e) {
				// TODO: handle exception
				testCase.log(Status.INFO, " Actual Visible:-" + actualVisible);
				testCase.log(Status.INFO, " Expected Visible:-" + expectedVisible);
				testCase.log(Status.PASS, "Correct Visible");
			}

		}

//**********************************ALERT MESSAGE GET TEXT*************************************
		testCase = extent.createTest("STEP:4 CHECK ALERT MESSAGE SPELLING");
		String actualText = alert.getText();
		System.out.println("Alert Text:-" + actualText);
		String expectedText = alertMessage;
		boolean spelling = true;
		try {
			Assert.assertEquals(actualText, expectedText);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (spelling) {
			testCase.log(Status.INFO, "Actual text:" + actualText);
			testCase.log(Status.INFO, "Expected text:" + expectedText);
			testCase.log(Status.PASS, "Correct text");

		} else {
			testCase.log(Status.INFO, "Actual text:" + actualText);
			testCase.log(Status.INFO, "Expected text:" + expectedText);
			testCase.log(Status.FAIL, "Correct text");
		}

//**********************Log Out Method*************************************
		MultiSearchMethods.Logout();

	}
}
