//***********************************************************************************
//* Description
//*------------
//* CANCEL PLANT LAB TRAIL SAMPLE FUNCTIONALITY  METHOD
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 17/04/2023
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0010   17/04/2023   NILUXY.K    Orginal Version

//************************************************************************************


package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

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

public class CancelLabTrailSamplemethod extends DriverIntialization {

	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	public static String pageName = "Plant Lab Trial Sample";

	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();
	static Actions actions = new Actions(driver);
	static SampleActionMethods action = new SampleActionMethods();

	static String plant = "";

	public static void excelselection() throws InterruptedException, IOException {

		String testCaseId = "TC-P-LAB-SAM-0010";
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

			// Clickplant
			// :________________________________________________________________
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

			// Click finish sample Category
//					// :________________________________________________________________
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

//					// Click mix design
//					// :________________________________________________________________
			try {
				Thread.sleep(2000);
				action.clicking(labtrailpage.MixdesignTextbox, 2, "CHECK MIXED DESGIN TEXBOX");

				labtrailpage.MixdesignTextbox.sendKeys(mixdesign);
				Thread.sleep(3000);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);

			} catch (Exception e) {

			}

//					// Click Equipment
//					// :________________________________________________________________
			try {
				Thread.sleep(2000);
				action.clicking(labtrailpage.EquipmentTextbox, 2, "CHECK EQUIPMENT TEXBOX");

				labtrailpage.EquipmentTextbox.sendKeys(equipment);
				Thread.sleep(3000);
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);

			} catch (Exception e) {

			}

//				// SELECTION DATE
			try {
				action.clicking(labtrailpage.SampledateTextbox, 2, "CHECK SAMPLE DATE TEXBOX");
				
				SelectDate.dateSelect("Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0010-01", 5,
						PlantLabTrailSamplePage.SampledateTextbox);
				//PlantLabTrailSamplePage.SampledateTextbox.sendKeys(sampledate);
				Thread.sleep(3000);
				actions.sendKeys(Keys.ENTER).perform();

			} catch (Exception e) {

			}

			// click sample Code

			try {
				action.clicking(labtrailpage.SampleproductCodeTextbox, 2, "CHECK SAMPLE CODE TEXBOX");
				PlantLabTrailSamplePage.SampleproductCodeTextbox.sendKeys(sampleCode);
				Thread.sleep(1000);
			} catch (Exception e) {

			}

			// click Creation date
//
//			try {
//				action.clicking(labtrailpage.CreationDateTextbox, 2, "CHECK SAMPLE CODE TEXBOX");
//				PlantLabTrailSamplePage.CreationDateTextbox.sendKeys(creationdate);
//				Thread.sleep(3000);
//			} catch (Exception e) {

		}
	}

		public static void CancelMaterialbutton() throws InterruptedException {

			Thread.sleep(3000);
			if (PlantLabTrailSamplePage.Cancelbutton.isDisplayed()) {

				testCase = extent.createTest(" ADD PLANT LAB TRAIL CANCEL BUTTON DISPLY");
				testCase.log(Status.PASS, "TEST PASS");
				if (PlantLabTrailSamplePage.Cancelbutton.isEnabled()) {
					testCase = extent.createTest("ADD PLANT LAB TRAIL CANCEL BUTTON ENABLED");
					testCase.log(Status.PASS, "TEST PASS");

					try {
						driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
						boolean addmodelwindow = true;
						System.out.println(addmodelwindow);
						PlantLabTrailSamplePage.Cancelbutton.click();
						if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
							addmodelwindow = false;
						}
						
						// Add Button Clicked or not
						boolean clicked = true;

						if (clicked) {
							testCase = extent.createTest("ADD PLANT LAB TRAIL CANCEL BUTTON CLICKED");
							testCase.log(Status.PASS, "TEST PASS");
							System.out.println("MATERIAL" + addmodelwindow);
							if (addmodelwindow == false) {
								System.out.println(addmodelwindow);
								testCase = extent.createTest("ADD PLANT LAB TRAIL MODEL WINDOW CLOSED");
								testCase.log(Status.PASS, "TEST PASS");
							} else {
								testCase = extent.createTest("ADD PLANT LAB TRAIL MODEL WINDOW NOT CLOSED");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("ADD PLANT LAB TRAIL CANCEL BUTTON NOT CLICKED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("ADD PLANT LAB TRAIL CANCEL BUTTON IS ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("ADD PLANT LAB TRAIL CANCEL BUTTON DISPLY");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		}
	
	
	public static void checkLastAddvalue() throws InterruptedException, IOException {

		String actualdata = PlantLabTrailSamplePage.TableFirstRow.getText();
		System.out.println("First row of table : " + actualdata);

		Thread.sleep(2000);
		String expecteddata = plant;
		System.out.println("expecteddata"+expecteddata);
		boolean firstdata = true;
		testCase = extent.createTest("THE ENTERED VALUE HAS SAVE IN FIRST OF THE TABLE");
		try {
			AssertJUnit.assertNotSame(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "THE DATA HAS NOT ADDED");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "THE DATA HAS ADDED");
		}

	}
}
