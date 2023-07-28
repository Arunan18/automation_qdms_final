//***********************************************************************************
//* Description
//*------------
//* Test Trial Validation Production Sample
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 19/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0303     19/05/2023    Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class TestTrialValidationProductionSample extends DriverIntialization {

	
	static ProductionSamplePage ProductionSamplePg = new ProductionSamplePage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();

	static String code = null;
	static String date = null;
	static String noOfTrial = null;
	static String test = null;

	static String trialValue1 = null;
	static String trialValue2 = null;
	static String trialValue3 = null;
	static String trailValueValidation = null;
	

	static String check = null;
	static String forReportBoth = null;
	static String forReporttrialValue = null;

	@Test

	public static void productionSampleTrialValidation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, ProductionSamplePg);

		// LOGIN
		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.finishProductSampleMainNavigation();

		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.productionSampleNavigation();

		// SELECT A PARTICULAR DATA FROM EXCEL
		excel();

//		DeleteAfterDependMethods.searchvalue(code, 1);

		// CLICK THE TEST AND RESULT ICON
		codeClick();

		// CLICK THE TEST CARD

		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='" + test + "']")).click();

//		SEND VALUES TO DATE AND NO OF TRIAL AND CLICK THE SUBMIT BUTTON
//		-----------------------------------------------------------------
		
		driver.findElement(By.id("date")).sendKeys(date);

		driver.findElement(By.id("noOfTrial")).sendKeys(noOfTrial);

		Thread.sleep(200);
		IncomingSamplePage.submitButton.click();

		// CHECKING THE VALIDATION
		Thread.sleep(1000);
		validation();

		// LOGOUT
		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

//__________________________________________________________________________________________________

	public static void excel() throws InterruptedException, IOException {
		/* Excel Sheet Value Passing */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0303-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);
         
		code = (String) row.getCell(1).getStringCellValue();
		date = (String) row.getCell(2).getStringCellValue();
		test = (String) row.getCell(3).getStringCellValue();
		noOfTrial = (String) row.getCell(4).getStringCellValue();

	}

	public static void codeClick() throws InterruptedException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_first;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(code);
			Thread.sleep(3000);
			nextBtn = PlantEquipmentPage.next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				PlantEquipmentPage.next.click();
				Thread.sleep(3000);
			} else
				break;

		}

		try {
			Thread.sleep(1000);
			if (driver
					.findElement(By.xpath("//td[text()='"+code+"'][1]//following-sibling::td[17]//span[@class='anticon anticon-experiment']"))
					.isDisplayed()) {

				testCase = extent.createTest("Test and Trial Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='"+code+"'][1]//following-sibling::td[17]//span[@class='anticon anticon-experiment']"))
						.isEnabled()) {
					testCase = extent.createTest("Test and Trial Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='"+code+"'][1]//following-sibling::td[17]//span[@class='anticon anticon-experiment']"))
								.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("Element is not enable");
					testCase.log(Status.PASS, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("Element is not display");
				testCase.log(Status.PASS, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}
	
	public static void validation() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Production Sample";
		String testCaseId = "TC-PRODUCT-SAM-0303";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();
		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			trialValue1 = (String) row.getCell(1).getStringCellValue();
			trialValue2 = (String) row.getCell(2).getStringCellValue();
			trialValue3 = (String) row.getCell(3).getStringCellValue();
			trailValueValidation = (String) row.getCell(4).getStringCellValue();
			forReporttrialValue = (String) row.getCell(5).getStringCellValue();



//			first field
			
			try {
				if (ProductionSamplePage.firstTrialTextBox.isDisplayed()) {
					if (ProductionSamplePage.firstTrialTextBox.isEnabled()) {
						ProductionSamplePage.firstTrialTextBox.click();
						ProductionSamplePage.firstTrialTextBox.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
						Thread.sleep(2000);
						ProductionSamplePage.firstTrialTextBox.sendKeys(String.valueOf(trialValue1), Keys.ENTER);
					}
				}

			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}

//	Second Field

			Thread.sleep(2000);
			try {
				if (ProductionSamplePage.secondTrialTextBox.isDisplayed()) {
					if (ProductionSamplePage.secondTrialTextBox.isEnabled()) {
						ProductionSamplePage.secondTrialTextBox.click();
						ProductionSamplePage.secondTrialTextBox.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
						Thread.sleep(2000);
						ProductionSamplePage.secondTrialTextBox.sendKeys(String.valueOf(trialValue2), Keys.ENTER);
					}
				}

			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}

//			Third Field

			Thread.sleep(2000);
			try {
				if (ProductionSamplePage.thirdTrialTextBox.isDisplayed()) {
					if (ProductionSamplePage.thirdTrialTextBox.isEnabled()) {
						ProductionSamplePage.thirdTrialTextBox.click();
						ProductionSamplePage.thirdTrialTextBox.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
						Thread.sleep(2000);
						ProductionSamplePage.thirdTrialTextBox.sendKeys(String.valueOf(trialValue3), Keys.ENTER);
					}
				}

			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}

			ProductionSamplePage.trialButton.click();

			if (ProductionSamplePage.trialButton.isDisplayed()) {

				
					try {
						testCase = extent.createTest(forReporttrialValue);
						String ActualValidation = ProductionSamplePage.trialValueValidation.getText();

						String ExpectedValidation = trailValueValidation;

						try {
							Assert.assertEquals(ActualValidation, ExpectedValidation);
							testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
							testCase.log(Status.PASS, "VALIDATION IS CORRECT");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
							testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
							testCase.log(Status.FAIL, "VALIDATION IS NOT CORRECT");
						}
					} catch (NoSuchElementException e) {

					}
				

//				Thread.sleep(2000);
//				driver.navigate().refresh();

			} else {
				testCase = extent.createTest("THE VALIDATION TEST HAS FAILED");
				testCase.log(Status.FAIL, "Test case fail");
			}
		}
	}
	
	
	
}
