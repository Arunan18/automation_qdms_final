
//***********************************************************************************
//* Description
//*------------
//* ADD PLANT LAB TRAIL SAMPLE FUNCTIONALITY  METHOD
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 17/04/2023
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0006   17/04/2023   NILUXY.K    Orginal Version
//*TC-P-LAB-SAM-0008
//TC-P-LAB-SAM-0011
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class AddLabTrailSampleMethods extends DriverIntialization {

	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	public static String pageName = "Plant Lab Trial Sample";

	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();
	static Actions actions = new Actions(driver);
	static SampleActionMethods action = new SampleActionMethods();
	static SelectDate date = new SelectDate();

	static String plant = "";
	static String finishsample = "";
	static String mixdesign = "";
	static String equipment = "";
	static String sampledate = "";
	static String sampleCode = "";
	static String succesnotification ="";

	public static void excelselection() throws InterruptedException, IOException {

		String testCaseId = "TC-P-LAB-SAM-0011";
		int firstrow = CommonMethods.getFirstRowNum(excelpath, pageName, testCaseId);
		int lastrow = CommonMethods.getLastRowNum(excelpath, pageName, testCaseId);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet pageName = workbook.getSheet("Plant Lab Trial Sample");
		Thread.sleep(2000);
		for (int i = firstrow; i <= lastrow; i++) {
			Thread.sleep(2000);
			XSSFRow row = pageName.getRow(i);

			String plant = (String) row.getCell(1).getStringCellValue();
			System.out.println("plant" + plant);
			String finishsample = (String) row.getCell(2).getStringCellValue();
			System.out.println("finishsample" + finishsample);
			String mixdesign = (String) row.getCell(3).getStringCellValue();
			System.out.println("mixdesign" + mixdesign);

			String equipment = (String) row.getCell(4).getStringCellValue();
			System.out.println("equipment" + equipment);

			String sampledate = (String) row.getCell(5).getStringCellValue();
			System.out.println("sampledate " + sampledate);
			String sampleCode = (String) row.getCell(6).getStringCellValue();
			System.out.println("sampleCode" + sampleCode);
//			String creationdate = (String) row.getCell(7).getStringCellValue();
//			System.out.println("creationdate" + creationdate);
			String succesnotification = (String) row.getCell(8).getStringCellValue();
			System.out.println("succesnotification" + succesnotification);

			// PLANT FIELD
			// ________________________________________________________________
			try {
				Thread.sleep(2000);

				action.clicking(labtrailpage.PlantTextbox, 2, "CHECK PLANT TEXBOX");

				Thread.sleep(3000);
				PlantLabTrailSamplePage.PlantTextbox.sendKeys(plant);
				Thread.sleep(3000);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);

			} catch (Exception e) {

			}

			// FINISHED PRODUCT
			// ________________________________________________________________
			try {
				Thread.sleep(2000);
				action.clicking(labtrailpage.FinishproductTextbox, 2, "CHECK FINISH SAMPLE TEXBOX");

				labtrailpage.FinishproductTextbox.sendKeys(finishsample);

				Thread.sleep(3000);
				actions.sendKeys(Keys.ENTER).perform();
				;
				Thread.sleep(2000);

			} catch (Exception e) {

			}

			// MIX DESIGN
			// ________________________________________________________________
			try {
				Thread.sleep(2000);
				action.clicking(labtrailpage.MixdesignTextbox, 2, "CHECK MIXED DESGIN TEXBOX");

				labtrailpage.MixdesignTextbox.sendKeys(mixdesign);
				Thread.sleep(2000);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(3000);

			} catch (Exception e) {

			}

			// EQUIPMENT
			// ________________________________________________________________
			try {
				Thread.sleep(2000);
				action.clicking(labtrailpage.EquipmentTextbox, 2, "CHECK EQUIPMENT TEXBOX");

				labtrailpage.EquipmentTextbox.sendKeys(equipment);
				Thread.sleep(3000);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);

			} catch (Exception e) {

			}

			// SELECTION DATE
			// ________________________________________________________________________
			try {
				action.clicking(labtrailpage.SampledateTextbox, 2, "CHECK SAMPLE CODE TEXBOX");

				SelectDate.dateSelect("Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0011-01", 5,
						PlantLabTrailSamplePage.SampledateTextbox);

//				PlantLabTrailSamplePage.SampledateTextbox.sendKeys(sampledate);
//				Thread.sleep(3000);
//				actions.sendKeys(Keys.ENTER).perform();

			} catch (Exception e) {

			}

			// SAMPLE CODE FIELD
			// ________________________________________________________________________
			try {
				action.clicking(labtrailpage.SampleproductCodeTextbox, 2, "CHECK SAMPLE CODE TEXBOX");
				PlantLabTrailSamplePage.SampleproductCodeTextbox.sendKeys(sampleCode);
				Thread.sleep(1000);
			} catch (Exception e) {

			}

			// click Creation date
			// ________________________________________________________________________
//
//			try {
//				action.clicking(labtrailpage.CreationDateTextbox, 2, "CHECK SAMPLE CODE TEXBOX");
//				PlantLabTrailSamplePage.CreationDateTextbox.sendKeys(creationdate);
//				Thread.sleep(3000);
//			} catch (Exception e) {

		}
	}

// CHECK THE VALUE IS ADDED OR NOT
	public static void checksuccessmessage() throws InterruptedException {

		Thread.sleep(2000);
	
		if (PlantLabTrailSamplePage.SuccessmesageNotification.isDisplayed()) {
			
		String actual=	PlantLabTrailSamplePage.SuccessmesageNotification.getAttribute("value");
		
		String expected =(succesnotification);
		
		
		System.out.println("expecteddata" + expected);
		boolean firstdata = true;
		testCase = extent.createTest("CHCK THE ENTERED DATA HAS SUCCESSFULLY ADDED");
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

	public static void checkLastAddvalue() throws InterruptedException, IOException {

		String actualdata = PlantLabTrailSamplePage.TableFirstRow.getText();
		System.out.println("First row of table : " + actualdata);
        Thread.sleep(3000);
		String expecteddata = mixdesign;
		System.out.println("expecteddata" + mixdesign);
		boolean firstdata = true;
		testCase = extent.createTest("THE ENTERED VALUE HAS SAVE IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata,  mixdesign);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}

}
