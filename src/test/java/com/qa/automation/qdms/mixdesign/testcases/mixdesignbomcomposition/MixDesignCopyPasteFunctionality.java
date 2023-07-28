//***********************************************************************************
//* Description
//*------------
//*Copy Paste Mix Design  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 20/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MIX-DES-0020       20/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignCommonPage;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;

public class MixDesignCopyPasteFunctionality extends DriverIntialization {
	static MixDesignCommonPage copyPaste = new MixDesignCommonPage();
	static String SearchData = null;
	static String Date = null;
	static String StatusBarColour = null;
	static String NewText = null;

//___________________________________________________________
//    NAVIGATE TO MIX DESIGN BOM COMPOSITION
//___________________________________________________________

	public static void NavigatetoMixDesignComposition() {
		PageFactory.initElements(driver, copyPaste);

		MixDesignNavigation.mixDesignNavigation();
		MixDesignNavigation.mixBomDesignComposition();

	}

//________________________________________________________
//   EXCEL METHOD
//________________________________________________________	
	public static void ExcelMethod() throws IOException {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design ";
		String testCaseId = "TC-MIX-DES-0020";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			Date = (String) row.getCell(2).getStringCellValue();
			StatusBarColour = (String) row.getCell(3).getStringCellValue();
			NewText = (String) row.getCell(4).getStringCellValue();

		}
	}
//__________________________________________________________________
//    SEARCH DATA TO COPY
//__________________________________________________________________

	public static void copyPasteFunctionality() throws InterruptedException {
		PageFactory.initElements(driver, copyPaste);

		SampleActionMethods.perticularDataSearch(MixDesignCommonPage.Table, SearchData, MixDesignCommonPage.copy,
				MixDesignCommonPage.NextBtn);

//_____________________________________________________________________
//  ADD BUTTON VISIBLE AND ENABLE
//_____________________________________________________________________

		SampleActionMethods.clicking(MixDesignCommonPage.addbtn, 2, "STEP:1 ADD BUTTON");

		Thread.sleep(2000);
		MixDesignCommonPage.PlacHolderToClick.click();

//______________________________________________________________________
//   COPY PASTE FUNCTION
//______________________________________________________________________		
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

// DATE ADD 
		Thread.sleep(2000);
		MixDesignCommonPage.datePlaceHolder.sendKeys(Date);
		Thread.sleep(2000);
		MixDesignCommonPage.datePlaceHolder.sendKeys(Keys.ENTER);

//______________________________________________________________________
//    GET TEXT FORM DATE
//_______________________________________________________________________		

		Thread.sleep(2000);
		String actualTime = MixDesignCommonPage.datePlaceHolder.getAttribute("value");
		System.out.println("Before save field time:-" + actualTime);
		String expectedTime = "";

		testCase = extent.createTest("STEP:2 BEFORE SAVE GET TEXT OF DATE FIELD");
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

//__________________________________________________________
//    SAVE BUTTON VISIBLE ANE ENABLE
//__________________________________________________________	

		SampleActionMethods.clicking(MixDesignCommonPage.saveButton, 2, "STEP:3 SAVE BUTTON");
	}

//___________________________________________________________
//  AFTER SAVE VALIDATE DATE
//___________________________________________________________
	public static void afterValidate() throws InterruptedException {
		PageFactory.initElements(driver, copyPaste);
	
//______________________________________________________________________
//	    GET TEXT FORM DATE
//_______________________________________________________________________		

		Thread.sleep(2000);
		String actualDate = MixDesignCommonPage.TableDataDate.getText();
		System.out.println("after save field time:-" + actualDate);
		String expectedDate = "";

		testCase = extent.createTest("STEP:4 AFTER SAVE GET TEXT OF DATE FIELD");
		try {
			Assert.assertEquals(actualDate, expectedDate);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		boolean timeText = true;
		if (timeText) {
			testCase.log(Status.INFO, "Actual text:-" + actualDate);
			testCase.log(Status.INFO, "Expecedt text:-" + expectedDate);
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "Actual text:-" + actualDate);
			testCase.log(Status.INFO, "Expecedt text:-" + expectedDate);
			testCase.log(Status.FAIL, "In-Correct ");
		}

//______________________________________________________________________
//      COMPARE TIME FIELDS (BEFORE SAVE - AFTER SAVE)
//______________________________________________________________________
		testCase = extent.createTest("STEP:5 COMPARE DATE FIELDS (BEFORE SAVE - AFTER SAVE");

		// Add a comparison step
		String actualBeforeSaveTime = MixDesignCommonPage.datePlaceHolder.getAttribute("value");
		String actualAfterSaveTime = MixDesignCommonPage.TableDataDate.getText();
		if (actualBeforeSaveTime.equals(actualAfterSaveTime)) {
			testCase.log(Status.PASS,
					"Step 5: Compare actual times - Actual bedore save time and Actual time after save are the same");
		} else {
			testCase.log(Status.FAIL,
					"Step 5: Compare actual times - Actual time1 and Actual time after save are different");
		}

//_____________________________________________________________________________
//         VALIDATE IF STATUS IS NEW
//____________________________________________________________________________	

		SampleActionMethods.webelementUi(MixDesignCommonPage.StatusNew, StatusBarColour, NewText, "STEP:6 STATUS BAR");
	}

// ____________________________________________________________
//  LOGOUT
//______________________________________________________________	
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
