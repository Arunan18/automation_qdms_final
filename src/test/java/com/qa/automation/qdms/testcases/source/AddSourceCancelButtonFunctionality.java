//***********************************************************************************
//* Description
//*------------
//*Add Source Cancel Button
//***********************************************************************************
//*
//* Author           : Shadurshi
//* Date Written     : 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SRC-0038          11/04/2023   Gobithan     Excel Data Pass
//*						 05/07/2023   Sasikala	   Modified Fully
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AddSourceCancelButtonFunctionality extends DriverIntialization {

	static SourcePage Sourcepg = new SourcePage();
	static String sourceDescfieldname = "";
	static boolean work = false;

	@Test
	public static void SourceCancelButtonMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Sourcepg);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Call Login Function
		LoginTest.Login();

		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Master));

		// Click Master Card
		SourceTest.CommonMethod(SourcePage.Master, "Master Card");

		if (SourceTest.work) {
			work = false;
			// Click Material Top Bar
			SourceTest.CommonMethod(SourcePage.Materialtopbar, "Material Top Bar");
		}

		if (SourceTest.work) {
			work = false;
			// Source Side Button
			SourceTest.CommonMethod(SourcePage.sourcesitebar, "Source Side Button");
		}

		if (SourceTest.work) {
			work = false;
			// Source Add Button
			SourceTest.CommonMethod(SourcePage.AddSourcebtn, "Source Side Button");
		}

		if (SourceTest.work) {
			work = false;
			// Source Field
			AddSourceMethod();
		}

		if (addsource) {
			addsource = false;
			// Source Description Field
			AddSourceDescMethod();
		}

		if (Desc) {
			Desc = false;
			// Source Cancel Button
			SourceTest.CommonMethod(SourcePage.cancelbutton, "Source Cancel Button");
		}

		// Logout Method
		MultiSearchMethods.Logout();

	}

//*****************************ADD SOURCE FUNCTION***************************
	static boolean addsource = false;

	public static void AddSourceMethod() throws InterruptedException, IOException {

		try {
			addsource = false;
			SourceTest.CommonMethod(SourcePage.sourcefiled, "Source Field");

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Source");

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Source",
					"TC-SRC-0038");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Source",
					"TC-SRC-0038");
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);

				String sourcefieldname = (String) row.getCell(1).getStringCellValue();
				sourceDescfieldname = (String) row.getCell(2).getStringCellValue();

				Thread.sleep(2000);

				SourcePage.sourcefiled.sendKeys(sourcefieldname);
				Thread.sleep(1000);

				testCase = extent.createTest("SOURCE-FIELD-DATA SEND");
				testCase.log(Status.INFO, "Expected Visible :-source Field Data Entered ");
				testCase.log(Status.PASS, " Correct");
				addsource = true;
			}

		} catch (Exception e) {
			testCase.log(Status.INFO, "Expected Visible:-source Field Data not Entered");
			testCase.log(Status.FAIL, "Wrong");
		}
	}

// ******************SOURCE-DESCRIPTION-FIELD-VISIBLE*********************
	static boolean Desc = false;

	public static void AddSourceDescMethod() throws InterruptedException {
		try {
			Desc = false;
			SourceTest.CommonMethod(SourcePage.sourceDescFied, "Source Description Field");

			SourcePage.sourceDescFied.sendKeys(sourceDescfieldname);
			Thread.sleep(2000);
			Desc = true;
			testCase = extent.createTest("SOURCE-DESCRIPTION-FIELD-DATA SEND");
			testCase.log(Status.INFO, "Expected Visible :-source Description Field Data Entered ");
			testCase.log(Status.PASS, " Correct");

		} catch (Exception e) {
			testCase.log(Status.INFO, "Expected Visible:-source Description Field Data not Entered");
			testCase.log(Status.FAIL, "Wrong");
		}
	}
}
