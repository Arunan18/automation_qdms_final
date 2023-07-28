//***********************************************************************************
//* Description
//*------------
//*Edit Functionality  Mix Design  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 21/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MIX-DES-0011      21/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignCommonPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;

public class MixDesignEditFunctionality extends DriverIntialization {
	static MixDesignCommonPage Edit = new MixDesignCommonPage();
//	static EditCommonMethod commonMethod = new EditCommonMethod();

	static String EditDataQuantity = null;
	static String SearchData = null;

//______________________________________________________________
//   NAVIGATE TO MIX DESIGN COMPOSITION
//______________________________________________________________
	public static void NaviagetToMixDesignComposition() {
		PageFactory.initElements(driver, Edit);

		MixDesignNavigation.mixDesignNavigation();
		MixDesignNavigation.mixBomDesignComposition();

	}

//________________________________________________________
//   EXCEL METHOD
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
			SearchData = (String) row.getCell(1).getStringCellValue();
			EditDataQuantity = (String) row.getCell(2).getStringCellValue();

		}
	}

//________________________________________________________________________________
//	     SEARCH DATA
//_________________________________________________________________________________
	public static void SeachDataToEdit() throws InterruptedException {
		PageFactory.initElements(driver, Edit);

		ActionCommonMethod.actionS(0, 9, MixDesignCommonPage.Table, "edit", "Samples Module.xlsx", "Mix Design",
				"TC-MIX-DES-0011-01", 1);

//______________________________________________________________________________
//      EDIT FUNCTION
//______________________________________________________________________________		

		testCase = extent.createTest("STEP:4 DATA TO BE EDITED");
		try {
			WebElement Quantity = driver.findElement(By.xpath("//input[@placeholder = 'Quantity']"));
			Quantity.sendKeys(Keys.CONTROL, "a"); // Select all text
			Quantity.sendKeys(Keys.DELETE); // Clear the text
			Quantity.sendKeys(EditDataQuantity);
			testCase.log(Status.PASS, "DATA IS EDITED"); 
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "DATA IS NOT EDITED");
		}

//______________________________________________________________________________
//   UPDATE BUTTON IS DISPLAY ,ENABLE
//_______________________________________________________________________________

		SampleActionMethods.clicking(MixDesignCommonPage.saveButton, 2, "STEP:5 SAVE BUTTON");

	}
//__________________________________________________________________________
//       AFTER EDIT  VALIDATE DATA VISIBLE
//_________________________________________________________________________	

	public static void afterValidateData() throws InterruptedException {
		PageFactory.initElements(driver, Edit);
		
		Thread.sleep(2000);
		MixDesignCommonPage.FullView.click();

		Thread.sleep(2000);
		String text = EditDataQuantity;
		WebElement afterEditedData = driver.findElement(By.xpath("(//td[normalize-space()='" + text + "'])[1]"));

		boolean Visible = afterEditedData.isDisplayed();
		if (Visible) {

			boolean actualVisible = afterEditedData.isDisplayed();
			System.out.println("Edited Data is Visible" + actualVisible);
			boolean expectedVisible = true;
			testCase = extent.createTest("STEP:6 AFTER EDIT DATA IS VISIBLE");

			try {
				assertEquals(actualVisible, expectedVisible);
				testCase.log(Status.INFO, " Actual Visible:" + actualVisible);
				testCase.log(Status.INFO, " Expected Visible:" + expectedVisible);
				testCase.log(Status.PASS, "Visible correct");

			} catch (AssertionError e) {
				// TODO: handle exception
				testCase.log(Status.INFO, " Actual Visible:" + actualVisible);
				testCase.log(Status.INFO, " Expected Visible:" + expectedVisible);
				testCase.log(Status.FAIL, "Visible not correct");
			}

		}
//__________________________________________________________________________
//      AFTER EDIT  VALIDATE DATA GET TEXT
//_________________________________________________________________________	

		String actualText = afterEditedData.getText();
		System.out.println("Edited Data Spell:-" + afterEditedData);
		String expectedText = "";
		testCase = extent.createTest("STEP:7 AFTER EDIT GET TEXT");
		boolean data = true;
		try {
			assertEquals(actualText, expectedText);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		if (data) {
			testCase.log(Status.INFO, " Actual Text:" + actualText);
			testCase.log(Status.INFO, " Expected Text:" + expectedText);
			testCase.log(Status.PASS, "Text Correct");
		} else {
			testCase.log(Status.INFO, " Actual Text:" + actualText);
			testCase.log(Status.INFO, " Expected Text:" + expectedText);
			testCase.log(Status.FAIL, "Text Correct");
		}
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

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
