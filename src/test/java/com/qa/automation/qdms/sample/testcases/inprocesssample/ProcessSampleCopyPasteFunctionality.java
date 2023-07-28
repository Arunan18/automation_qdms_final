//***********************************************************************************
//* Description
//*------------
//*Copy Paste Inprocess Sample  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 18/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-INC-SAM-0020        18/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;

public class ProcessSampleCopyPasteFunctionality extends DriverIntialization {
	static InprocessSamplePage sampleProcess = new InprocessSamplePage();
	static String Searchdata = null;
	static String StatusBarColour = null;
	static String StatusText = null;

//____________________________________________________________
//  NAVIAGATE TO INPROCESS SAMPLE NAVIGATION
//_____________________________________________________________	

	public static void NavigateToInProcessSamplePage() {

		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.inprocessSampleNavigation();
	}

//__________________________________________________________________
//           EXCEL METHOD
//__________________________________________________________________
	public static void ExcelMethod() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Process Sample";
		String testCaseId = "TC-INC-SAM-0020";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			Searchdata = (String) row.getCell(1).getStringCellValue();
			StatusBarColour = (String) row.getCell(2).getStringCellValue();
			StatusText = (String) row.getCell(3).getStringCellValue();

		}
	}

//________________________________________________________________________
//  COPY PASTE FUNCTION - USING METHOD FROM COMMON METHOD 	
//________________________________________________________________________
	public static void copyPasteFunctionality() throws InterruptedException {
		PageFactory.initElements(driver,sampleProcess);
		
		Thread.sleep(2000);
		SampleActionMethods.perticularDataSearch(InprocessSamplePage.Table, Searchdata, InprocessSamplePage.copyIcon, InprocessSamplePage.NextButton);
		

//________________________________________________________________________
//  ADD PROCESS SAMPLE  BUTTON VISIBLE AND ENABLE - USING COMMON METHOD
//________________________________________________________________________	

		SampleActionMethods.clicking(InprocessSamplePage.addProcessSampleButton,2, " STEP:1 ADD PROCESS SAMPLE BUTTON ");

//CLICK TABLE BODY
		Thread.sleep(3000);
		InprocessSamplePage.ModalBody.click();

//COPY PASTE - ACTION
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

// ___________________________________________________________________________
//     BEFORE SAVE GET TEXT OF TIME FIELD
// ____________________________________________________________________________
		Thread.sleep(2000);
		String actualTime = InprocessSamplePage.beforeTimeField.getAttribute("value");
		System.out.println("Before save field time:-" + actualTime);
		String expectedTime = "";

		testCase = extent.createTest("STEP:2 BEFORE SAVE GET TEXT OF TIME FIELD ");
		try {
			Assert.assertEquals(actualTime, expectedTime);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		boolean timeText = true;
		if (timeText) {
			testCase.log(Status.INFO, "Actual text:-" + actualTime);
			testCase.log(Status.INFO, "Expecedt text:-" + expectedTime);
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "Actual text:-" + actualTime);
			testCase.log(Status.INFO, "Expecedt text:-" + expectedTime);
			testCase.log(Status.FAIL, "In-Correct ");
		}

// ________________________________________________________________________________
//   SAVE BUTTON DISPLAY,ENABLE - USING COMMON METHOD
// ________________________________________________________________________________

		SampleActionMethods.clicking(InprocessSamplePage.SaveButton,2, "STEP:3 SAVE BUTTON");

	}

//__________________________________________________________________________
//      AFTER SAVE VALIDATE TIME FIELD  (GET TEXT)
//__________________________________________________________________________	

	public static void afterValidateSaveData() throws InterruptedException {
		PageFactory.initElements(driver, Searchdata);
		
// SCROLL RIGHT			

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1000, 0);");

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(
				"//div[@class='ant-table ant-table-small ant-table-ping-right ant-table-fixed-header ant-table-fixed-column ant-table-scroll-horizontal ant-table-has-fix-left ant-table-has-fix-right']"));
		element.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().sendKeys(Keys.ARROW_RIGHT).build().perform();

//__________________________________________________________________
//    AFTER SAVE COMPARE TEXT TIME FIELD
//___________________________________________________________________  			

		String actualTime = InprocessSamplePage.aftertableDataTimeField.getText();
		System.out.println("After save field time:-" + actualTime);
		String expectedTime = "";

		testCase = extent.createTest("STEP:4 GET TEXT FROM TABLE DATA TIME FIELD");
		try {
			Assert.assertEquals(actualTime, expectedTime);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		boolean timeText = true;
		if (timeText) {
			testCase.log(Status.INFO, "Actual text:-" + actualTime);
			testCase.log(Status.INFO, "Expecedt text:-" + expectedTime);
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "Actual text:-" + actualTime);
			testCase.log(Status.INFO, "Expecedt text:-" + expectedTime);
			testCase.log(Status.FAIL, "In-Correct ");
		}

// ______________________________________________________________________
//           COMPARE TIME FIELDS (BEFORE SAVE - AFTER SAVE)
// ______________________________________________________________________
		testCase = extent
				.createTest("STEP:5 COMPARE TIME FIELDS (BEFORE SAVE-AFTER SAVE )");

		// Add a comparison step
		String actualBeforeSaveTime = InprocessSamplePage.beforeTimeField.getAttribute("value");
		String actualAfterSaveTime = InprocessSamplePage.aftertableDataTimeField.getText();
		if (actualBeforeSaveTime.equals(actualAfterSaveTime)) {
			testCase.log(Status.PASS,
					"Step 5: Compare actual times - Actual bedore save time and Actual time after save are the same");
		} else {
			testCase.log(Status.FAIL,
					"Step 5: Compare actual times - Actual time1 and Actual time after save are different");
		}

// _____________________________________________________________________________
//              VALIDATE IF STATUS IS NEW
// ____________________________________________________________________________

		SampleActionMethods.webelementUi(InprocessSamplePage.StatusBarNew, StatusBarColour, StatusText,
				"STEP:6 STATUS BAR NEW ");
	}

}
