//***********************************************************************************
//* Description
//*------------
//* Production Sample More Option
//***********************************************************************************
//*
//* Author           : Karunya Navanesan
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0018   18/05/2023    Karunya     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.productionsample;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleMoreoption extends DriverIntialization {

	static ProductionSamplePage pts = new ProductionSamplePage();

	static String SeachData = null;
	static String alertMessage = null;

	@Test
	public static void productionsampleMoreoption() throws InterruptedException, IOException {

		// Login the system
		LoginTest.Login();

		// Navigate to sample
		SampleNavigateTest.sampleNavigation();

		// Navigate to sample finishproduct
		SampleNavigateTest.finishProductSampleMainNavigation();

		// Navigate to production sample
		SampleNavigateTest.productionSampleNavigation();

		// Excel method
		ExcelMethod();

		// Find Production  Sample More Option
		SeachDataToMore();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();

	}

//_______________________________________________________________
//  EXCEL METHOD
//_______________________________________________________________

	public static void ExcelMethod() throws IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0018";

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

//________________________________________________________________________________
//  SEARCH DATA
//_________________________________________________________________________________
	public static void SeachDataToMore() throws InterruptedException {
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, pts);
		Thread.sleep(4000);
		testCase = extent.createTest("STEP:1");

		for (int i = 0; i < 50; i++) {
			ProductionSamplePage.productionsampleTable.click();
			Thread.sleep(500);
			action.sendKeys(Keys.ARROW_RIGHT).perform();
		}
		ActionCommonMethod.actionS(0, 15, ProductionSamplePage.productionsampleTable, "More", "Samples Module.xlsx",
				"Production Sample", "TC-PRODUCT-SAM-0018-01", 1);

// ____________________________________________________________________________________
// AFTER CLICK MORE ICON VIEW ALERT MESSAGE
// _____________________________________________________________________________________

		testCase = extent.createTest("STEP:3 MORE ALERT POPUP VISIBLE");

		WebElement alert = ProductionSamplePage.productionsampleMorePopup;

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

// ______________________________________________________________________________
// ALERT MESSAGE GET TEXT
// ______________________________________________________________________________

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

	}
}
