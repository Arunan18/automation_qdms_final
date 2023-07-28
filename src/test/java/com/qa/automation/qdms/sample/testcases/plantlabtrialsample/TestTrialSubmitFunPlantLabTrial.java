//*************************************************************************************************
//* Description
//*------------
//* Submit button Functionality Plant Lab Trial Sample
//*************************************************************************************************
//*
//* Author           : S.Sayanthan
//* Date Written     : 12/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0233    12/05/2023    Sayanthan    Orginal Version
//*  TC-P-LAB-SAM-0235
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class TestTrialSubmitFunPlantLabTrial extends DriverIntialization{
	
	
	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();

	static String FinishSample = null;
	static String Test = null;
	static String Date = null;
	static String noOfTrial = null;
	static String expectedDate = null;

	@org.testng.annotations.Test

	public static void noOfTrialFieldFunction() throws InterruptedException, IOException {

		LoginTest.Login();

		// **********************************************************************************
		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE
		// BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, "STEP 1 - CHECKING SAMPLE MODULE");

		// **********************************************************************************
		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH
		// PRODUCT MENU IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 20,
				"STEP 2 - CHECKING FINISH PRODUCT MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && STEP-03
		// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath(), 20,
				"STEP 3 - CHECKING PLANT LAB TRIAL SAMPLE BUTTON");

		// **********************************************************************************
		// STEP-04 SEARCH FINISH PRODUCT SAMPLE AND CLICK ON TEST AND RESULTS
		// **********************************************************************************

		selectSampleExcelData();
		
		
		searchFinishProSample();
		
		
		testAndTrialFinishSample();
		
		
		

//		CLICK ON THE TEST
//		-------------------

		Thread.sleep(2000);
		driver.findElement(By
				.xpath("//li[text()='" + Test + "']"))
				.click();
		
//		CHECKIN THE FUNCTIONALITY OF DATE FIELD
//		-------------------------------------------
		Thread.sleep(1000);

		if (driver.findElement(By.id("date")).isDisplayed()) {
			testCase = extent.createTest("DATE FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (driver.findElement(By.id("date")).isEnabled()) {
				testCase = extent.createTest("DATE FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				driver.findElement(By.id("date")).click();
				driver.findElement(By.id("date")).sendKeys(Date);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER).perform();

			} else {
				testCase = extent.createTest("DATE FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("DATE FIELD IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		

//		CHECKIN THE FUNCTIONALITY OF NO-OF TRIAL FIELD
//		----------------------------------------------
		Thread.sleep(1000);

		if (driver.findElement(By.id("noOfTrial")).isDisplayed()) {
			testCase = extent.createTest("NO-OF TRIAL FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (driver.findElement(By.id("noOfTrial")).isEnabled()) {
				testCase = extent.createTest("NO-OF TRIAL FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				driver.findElement(By.id("noOfTrial")).click();
				driver.findElement(By.id("noOfTrial")).sendKeys(noOfTrial);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER).perform();

			} else {
				testCase = extent.createTest("NO-OF TRIAL FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("NO-OF TRIAL FIELD IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}


//		CHECKING THE SUBMIT BUTTON FUNCTIONALITY
//		------------------------------------------
		
		
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")).isDisplayed()) {
			testCase = extent.createTest("SUBMIT BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")).isEnabled()) {
				testCase = extent.createTest("SUBMIT BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")).click();
				

			} else {
				testCase = extent.createTest("SUBMIT BUTTON IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("SUBMIT BUTTON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		
		
//	   VERIFY THE SUCCESSFUL MESSAGE
//	   -------------------------------
		
		verifySuccessMessage();
		

//		VERIFY THE ADDED DATA 
//		-----------------------
		
		String ActualDate = driver.findElement(By.xpath("//div[2]//div[@class='input_wrapper']")).getText();
		String ExpectedDate = expectedDate;
		System.out.println("Trial : " + ActualDate);
		testCase = extent.createTest("VERIFY THE ADDED DATE");
		if (ActualDate.equals(expectedDate)) {
//            Assert.assertEquals(ActualData, ExpectedData);
			testCase.log(Status.INFO, "ActualDate :- " + ActualDate);
			testCase.log(Status.INFO, "ExpectedDate :- " + ExpectedDate);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualDate);
		} else {
			testCase.log(Status.INFO, "ActualDate :- " + ActualDate);
			testCase.log(Status.INFO, "ExpectedDate :- " + ExpectedDate);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualDate);
		}
		
		
//	CHECK TEST PROCEDURE ICON FUNCTIOANLITY
//	------------------------------------------
		
		
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//span[@class='anticon anticon-read']")).isDisplayed()) {
			testCase = extent.createTest("TEST PROCEDURE ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (driver.findElement(By.xpath("//span[@class='anticon anticon-read']")).isEnabled()) {
				testCase = extent.createTest("TEST PROCEDURE ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='anticon anticon-read']")).click();
				

			} else {
				testCase = extent.createTest("TEST PROCEDURE ICON IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("TEST PROCEDURE ICON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		
		
		
//	VERIFY THE TEST PROCEDURE ICON FUNCTIONALITY
//	-----------------------------------------------
		
		
		String ActualData = driver.findElement(By.xpath("//div[@class='ant-popover-title']")).getText();
        String ExpectedData = "Test Procedure";
        System.out.println("text : " + ActualData);
        testCase = extent.createTest("VERIFY THE TEST PROCEDURE ICON FUNCTIONALITY");
        if (ActualData.equals("Test Procedure")) {
//            Assert.assertEquals(ActualData, ExpectedData);
            testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
            testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
            testCase.log(Status.INFO, "Correct value");
            testCase.log(Status.PASS, ActualData);
        } else {
            testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
            testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
            testCase.log(Status.INFO, "wrong value");
            testCase.log(Status.FAIL, ActualData);
        }
		
		
		
	Thread.sleep(1000);
		MultiSearchMethods.Logout();
		
		
}

	
// ____________________________________________________________________________________________

	public static void selectSampleExcelData() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Plant Lab Trial Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0233");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0233");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			FinishSample = (String) row.getCell(1).getStringCellValue();
			Test = (String) row.getCell(2).getStringCellValue();
			Date = (String) row.getCell(3).getStringCellValue();
			noOfTrial = (String) row.getCell(4).getStringCellValue();
            expectedDate = (String) row.getCell(5).getStringCellValue();
		}
	}

	public static void searchFinishProSample() throws InterruptedException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, SourcePg);

		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();

		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[@class='ant-table-cell'][4]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}

		} catch (Exception e) {

		}

		boolean nextBtn = PlantEquipmentPage.next.isEnabled();
		Thread.sleep(3000);
		List<WebElement> sectionList = SourcePage.column_fourth;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);

			}
			boolean isExist = list.contains(FinishSample);
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

	}

	public static void testAndTrialFinishSample() throws InterruptedException {

		try {

			if (driver
					.findElement(By.xpath("//td[text()='" + FinishSample
							+ "']//following-sibling::td[4]//span[@class='anticon anticon-experiment']"))
					.isDisplayed()) {

				testCase = extent.createTest("Test and Trial Icon Display");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (driver
						.findElement(By.xpath("//td[text()='" + FinishSample
								+ "']//following-sibling::td[4]//span[@class='anticon anticon-experiment']"))
						.isEnabled()) {
					testCase = extent.createTest("Test and Trial Icon Enable");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						driver.findElement(By.xpath("//td[text()='" + FinishSample
								+ "']//following-sibling::td[4]//span[@class='anticon anticon-experiment']")).click();

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
	
	
//	VERIFY THE SUCCESSFUL ADDED NOTIFICATION
//	------------------------------------------
	
	
	public static void verifySuccessMessage() throws InterruptedException {
		
		PageFactory.initElements(driver, PlantLabTrailSamplePg);
		Thread.sleep(500);
		System.out.println("+++++++");
		String actual=	PlantLabTrailSamplePage.submitSuccessNotification.getText();
		System.out.println("msg" + actual);
		
		String expected = "Finish Product Test Added SuccessFully";
		
		
		
		boolean firstdata = true;
		testCase = extent.createTest("CHCK THE SUCCESSFULLY ADDED NOTIFICATION");
		try {
			AssertJUnit.assertEquals(actual,  expected);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actual);
			testCase.log(Status.INFO, "Expected Data :- " + expected);
			testCase.log(Status.PASS, "DATA HAS SUCCESSFULLY ADDED");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actual);
			testCase.log(Status.INFO, "Expected Data :- " + expected);
			testCase.log(Status.FAIL, "DATA HAS NOT ADDED");
		}
		}

		
		
		
	}


