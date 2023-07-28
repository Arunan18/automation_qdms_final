
//***********************************************************************************
//* Description
//*------------
//* CANCEL BUTTON FUNCTIONALITY TEST AND TRAIL IN PROCESS SAMPLE
//***********************************************************************************
//*
//* Author           : @SASIKALA AMBALAVANAR
//* Date Written     : 11/05/2023
//* 
//*
//* 
//* Test Case Number      Date     	 Intis      Comments
//* ================      ====       =====      ========
//* TC-PRO-SAM-0224   	11/05/2023   @SASI     	Original Version
//*  
//************************************************************************************

/*
 * TC-PRO-SAM-0224	InProcess sample Test & Result Cancel button Functionality
 */

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class TestAndResultCancelBtnFunctionality extends DriverIntialization{
	static InprocessSamplePage inprocessPg = new InprocessSamplePage();
	static String Processsample = "";

//  ******************* IN PROCESS NAVIGATION ****************************

	@Test(priority = 0)
	public static void BtnFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocessPg);

		// LOGIN
		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.rawMaterialSampleMainNavigation();

		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.inprocessSampleNavigation();

	}

//  ******************* EXCEL SHEET DATA ****************************
	@Test(priority = 1)
	public static void selectSampleExcelData() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocessPg);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Process Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Process Sample", "TC-PRO-SAM-0224");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Process Sample", "TC-PRO-SAM-0224");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			Processsample = (String) row.getCell(1).getStringCellValue();

		}

		String Code = Processsample;
		String CodeXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String CodeXpath_lastPart = "]/td[1]";
		String TesticonXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String TesticonXpath_lastPart = "]/td[18]/span/span";

		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
					String text = driver.findElement(By.xpath(CodeXpath_firstPart + i + CodeXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Code)) {
						CustomerExist = true;
						driver.findElement(By.xpath(TesticonXpath_firstPart + i + TesticonXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				} else {
					System.out.println("Button Not Enabled");
				}
			} else {
				break;
			}

		}
		if (CustomerExist = false) {
			System.out.println("No such Element" + CustomerExist);
		}

	}

// ***************************** CANCEL BUTTON FUNCTIONALITY **********************************	

	@Test(priority = 2)
	public static void okbuttonfunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocessPg);
		if (InprocessSamplePage.cancelbtn.isDisplayed()) {
			testCase = extent.createTest("CANCEL BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.cancelbtn.isEnabled()) {
				testCase = extent.createTest("CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.cancelbtn.click();
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("CANCEL BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

// ************************** MODEL CLOSE SCREEN FUNCTIONALITY *********************************

	@Test(priority = 3)
	public static void modalClose() throws InterruptedException {
		PageFactory.initElements(driver, inprocessPg);

		boolean AcctualAfterClick = InprocessSamplePage.testAndTrialModal.isDisplayed();
		boolean ExpectedAfterClick = false;
		testCase = extent.createTest("TEST AND TRIAL MODAL CLOSING");
		try {
			AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);
		} catch (AssertionError e) {
			ExpectedAfterClick = true;
		}
		if (ExpectedAfterClick) {
			testCase.log(Status.INFO, "ActualResult :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedResult :- " + ExpectedAfterClick);
			testCase.log(Status.PASS, "Modal is closed");
		} else {
			testCase.log(Status.INFO, "Actualresult :- " + AcctualAfterClick);
			testCase.log(Status.INFO, "ExpectedResult :- " + ExpectedAfterClick);
			testCase.log(Status.FAIL, "Modal is not closed");
		}
		Thread.sleep(1000);

		// LOGOUT METHOD CALLING
		MultiSearchMethods.Logout();

	}


}
