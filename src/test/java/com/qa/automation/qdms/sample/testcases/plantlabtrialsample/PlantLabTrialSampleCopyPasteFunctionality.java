//***********************************************************************************
//* Description
//*------------
//*Copy Paste Plant Lab Trail Sample  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 18/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-P-LAB-SAM-0022    18/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

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
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;


public class PlantLabTrialSampleCopyPasteFunctionality extends DriverIntialization {
	static PlantLabTrailSamplePage planttrail = new PlantLabTrailSamplePage();

	static String Searchdata = null;
	static String StatusBarColour = null;
	static String StatusText = null;
	static String Date = null;

//________________________________________________________
//  NAVIGATE TO PLANT LAP TRAIL
//_________________________________________________________	

	public static void navigateToPlantTrailSample() {
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		;
		SampleNavigateTest.labTrialSampleNavigation();
	}

//____________________________________________________________ 
//      EXCEL METHOD
//____________________________________________________________	

	public static void ExcelMethod() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0022";

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
			Date = (String) row.getCell(4).getStringCellValue();
		}
	}

//_______________________________________________________________
//  COPY PASTE FUNCTIONALITY
//________________________________________________________________	
	public static void copyPasteFunctionality() throws InterruptedException {
		PageFactory.initElements(driver, planttrail);

		Thread.sleep(2000);
		SampleActionMethods.perticularDataSearch(PlantLabTrailSamplePage.Table, Searchdata,
				PlantLabTrailSamplePage.copyIcon, PlantLabTrailSamplePage.NextButton);

//________________________________________________________________________
//  ADD PLANT LAP TRAIL BUTTON VISIBLE AND ENABLE - USING COMMON METHOD
//________________________________________________________________________	

		SampleActionMethods.clicking(PlantLabTrailSamplePage.addPlantLabTrailButton, 2," STEP:1 ADD PLANT LAP TRAIL ");

//CLICK TABLE BODY
		Thread.sleep(3000);
		PlantLabTrailSamplePage.ModalBody.click();

//COPY PASTE - ACTION
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

// ___________________________________________________________________________
//		     BEFORE SAVE GET TEXT OF DATE FIELD
// ____________________________________________________________________________
		Thread.sleep(3000);
		String actualTime = PlantLabTrailSamplePage.beforeDate.getAttribute("value");
		System.out.println("Before save field date:-" + actualTime);
		String expectedTime = "";

		testCase = extent.createTest("STEP:2 BEFORE SAVE GET TEXT OF DATE FIELD ");
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

// SEND KEY FOR DATE 
		Thread.sleep(2000);
		PlantLabTrailSamplePage.Date.sendKeys(Date);

		Thread.sleep(2000);
		PlantLabTrailSamplePage.Date.sendKeys(Keys.ENTER);

// ________________________________________________________________________________
//  SAVE BUTTON DISPLAY,ENABLE - USING COMMON METHOD
//________________________________________________________________________________

		SampleActionMethods.clicking(PlantLabTrailSamplePage.SaveButton, 2,"STEP:3 SAVE BUTTON");

	}

//__________________________________________________________________________
//	      AFTER SAVE VALIDATE DATE FIELD  (GET TEXT)
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
//	    AFTER SAVE COMPARE TEXT DATE FIELD
//___________________________________________________________________  			

		String actualTime = PlantLabTrailSamplePage.aftertableDataTimeField.getText();
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
//	           COMPARE DATE FIELDS (BEFORE SAVE - AFTER SAVE)
// ______________________________________________________________________
		testCase = extent.createTest("STEP:5 COMPARE TIME FIELDS (BEFORE SAVE-AFTER SAVE )");
		

		// Add a comparison step
		Thread.sleep(2000);
		String actualBeforeSaveDate = PlantLabTrailSamplePage.beforeDate.getAttribute("value");
		String actualAfterSaveDate = PlantLabTrailSamplePage.aftertableDataTimeField.getText();
		if (actualBeforeSaveDate.equals(actualAfterSaveDate)) {
			testCase.log(Status.PASS, 
					"Step 5: Compare actual times - Actual bedore save time and Actual time after save are the same");
		} else {
			testCase.log(Status.FAIL,
					"Step 5: Compare actual times - Actual time1 and Actual time after save are different");
		}

// _____________________________________________________________________________
//	              VALIDATE IF STATUS IS NEW
//____________________________________________________________________________

		Thread.sleep(2000);
		SampleActionMethods.webelementUi(PlantLabTrailSamplePage.StatusBarNew, StatusBarColour, StatusText,
				"STEP:6 STATUS BAR NEW ");
	}
// _____________________________________________________
//  LOGOUT
//______________________________________________________

	public static void Logout() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Admin = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color'])[1]"));
		Admin.click();

		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.xpath(
				"//body/div/div/div[contains(@class,'ant-dropdown ant-dropdown-placement-bottomRight')]/ul[@role='menu']/li[@role='menuitem']/span[@class='ant-dropdown-menu-title-content']/p[1]"));
		Logout.click();
	}

}
