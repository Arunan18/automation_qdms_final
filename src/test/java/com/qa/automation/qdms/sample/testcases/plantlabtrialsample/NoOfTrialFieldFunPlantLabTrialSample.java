//*************************************************************************************************
//* Description
//*------------
//* No of Trial Field Functionality Plant Lab Trial Sample
//*************************************************************************************************
//*
//* Author           : S.Sayanthan
//* Date Written     : 11/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0230    11/05/2023    Sayanthan    Orginal Version
//
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

public class NoOfTrialFieldFunPlantLabTrialSample extends DriverIntialization {
	
	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();
	static PlantEquipmentPage page = new PlantEquipmentPage();
	static SourcePage SourcePg = new SourcePage();

	static String FinishSample = null;
	static String Test = null;
	static String noOfTrial = null;

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
				.xpath("//div[@class='ant-ribbon-wrapper']//div[@class='sc-gzVnrw KZmpn']//li[text()='" + Test + "']"))
				.click();

//		CHECKIN THE FUNCTIONALITY OF NO-OF TRIAL FIELD
//		-------------------------------------------
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

//	VERIFY THE NO-OF TRIAL FIELD FUNCTIONALITY
//  -------------------------------------------

		String ActualData = driver.findElement(By.id("date")).getText();
		String ExpectedData = noOfTrial;
		System.out.println("Trial : " + ActualData);
		testCase = extent.createTest("VERIFY THE NO-OF TRIAL FUNCTIONALITY");
		if (ActualData.equals(noOfTrial)) {
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
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0230");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Plant Lab Trial Sample", "TC-P-LAB-SAM-0230");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			FinishSample = (String) row.getCell(1).getStringCellValue();
			Test = (String) row.getCell(2).getStringCellValue();
			noOfTrial = (String) row.getCell(3).getStringCellValue();

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

}
