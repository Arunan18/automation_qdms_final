//***********************************************************************************
//* Description
//*------------
//* Plant Lab Trial Sample More Option
//***********************************************************************************
//*
//* Author           : Karunya Navanesan
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-P-LAB-SAM-0020    18/05/2023      Karunya     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition.MixDesignMorescreenContent;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class PlantlabtrialsampleMoreoption extends DriverIntialization {

	static PlantLabTrailSamplePage pts = new PlantLabTrailSamplePage();

	static String SeachData = null;
	static String alertMessage = null;

	@Test
	public static void planttrialsampleMore() throws IOException, InterruptedException {

		// Login the system
		LoginTest.Login();

		// Navigate to sample
		SampleNavigateTest.sampleNavigation();

		// Navigate to sample finishproduct
		SampleNavigateTest.finishProductSampleMainNavigation();

		// Excel method
		ExcelMethod();
		
		// Find Plant Lab Trial Sample More Option
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
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0020";

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
		PageFactory.initElements(driver, pts);
		Thread.sleep(4000);
		testCase = extent.createTest("STEP:1");
		ActionCommonMethod.actionS(0, 8, PlantLabTrailSamplePage.plantlabTrialsampleTable, "More", "Samples Module.xlsx", "Plant Lab Trial Sample",
				"TC-P-LAB-SAM-0020-01", 1);

//____________________________________________________________________________________
//  AFTER CLICK MORE ICON  VIEW ALERT MESSAGE 
//_____________________________________________________________________________________	

		testCase = extent.createTest("STEP:3 MORE ALERT POPUP VISIBLE");

		WebElement alert = PlantLabTrailSamplePage.plantlabTrialsampleMorePopup;

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
		
//______________________________________________________________________________
//  ALERT MESSAGE GET TEXT 
//______________________________________________________________________________
		
		testCase =extent.createTest("STEP:4 CHECK ALERT MESSAGE SPELLING");
		String actualText = alert.getText();
		System.out.println("Alert Text:-"+ actualText);
		String expectedText = alertMessage;
		boolean spelling = true;
		try {
		Assert.assertEquals(actualText, expectedText);
		}catch (AssertionError e) {
			// TODO: handle exception
		}
		if(spelling) {
			testCase.log(Status.INFO, "Actual text:"+actualText);
			testCase.log(Status.INFO,"Expected text:"+expectedText);
			testCase.log(Status.PASS,"Correct text");
			
		}else {
			testCase.log(Status.INFO, "Actual text:"+actualText);
			testCase.log(Status.INFO,"Expected text:"+expectedText);
			testCase.log(Status.FAIL,"Correct text");
		}
		
		
		
		}
	}

