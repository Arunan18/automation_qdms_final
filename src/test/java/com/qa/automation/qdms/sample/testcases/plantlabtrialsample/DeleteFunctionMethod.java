
//***********************************************************************************
//* Description
//*------------
//* DELETE FUCNTIONALITY  METHOD IN PLANT LAB TRAIL SAMPLE
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 20/04/2023
//* 
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0015   20/04/2023   NILUXY.K    Orginal Version

//************************************************************************************ 
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;

public class DeleteFunctionMethod  extends DriverIntialization{
	 static String tobedelete = "";
	 static String tobedeleteAftedepend ="";
	 static String deletemsg ="";
	 static String deletemsgdepended ="";
	 // delete excel

		public static void Deleteselect() throws InterruptedException, IOException {

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Plant Lab Trial Sample");
			int rowcount = sheet.getLastRowNum();

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Plant Lab Trial Sample",
					"TC-P-LAB-SAM-0015");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Plant Lab Trial Sample",
					"TC-P-LAB-SAM-0015");

			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				tobedelete = (String) row.getCell(1).getStringCellValue();
				deletemsg = (String) row.getCell(2).getStringCellValue();
			}
		
		}
	
	//SELECT THE DATA IN TABLE
		public static void deleteElement() throws InterruptedException {
			Thread.sleep(2000);
			try {

				if (driver.findElement(By.xpath("//td[text()='" + tobedelete
						+ "']//following-sibling::td[14]//span[@class='anticon anticon-delete']")).isDisplayed()) {

					testCase = extent.createTest("DELETE ICON DISPLY");
					testCase.log(Status.PASS, "TEST PASS ☑");

					if (driver.findElement(By.xpath("//td[text()='" + tobedelete
							+ "']//following-sibling::td[14]//span[@class='anticon anticon-delete']")).isEnabled()) {
						testCase = extent.createTest("DELETE ICON ENABLE");
						testCase.log(Status.PASS, "TEST PASS ☑");

						try {
							driver.findElement(By.xpath("//td[text()='" + tobedelete
									+ "']//following-sibling::td[14]//span[@class='anticon anticon-delete']")).click();

						} catch (Exception e) {

						}

					} else {
						testCase = extent.createTest("ELEMENT IS NOT ENABLE");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}
				} else {
					testCase = extent.createTest("ELEMENT IS NOT DISPLY");
					testCase.log(Status.FAIL, "TEST FAIL ❎");

				}
			} catch (Exception e) {
				testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		}	
		
	public static void deletematerialstateConfirm() throws InterruptedException {

				String SearchPlantlabtrail = tobedelete;

				Thread.sleep(3000);
				PlantLabTrailSamplePage.MixedDesignSearchicon.click();
				Thread.sleep(2000);

				PlantLabTrailSamplePage.MixedDesignSearchTextbox.sendKeys(SearchPlantlabtrail);

				PlantLabTrailSamplePage.MixedDesignSearchTextbox.sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				PlantLabTrailSamplePage.MixedDesignSearchButton.click();

				Thread.sleep(3000);
				String ActualData = PlantLabTrailSamplePage.MixedDesignSearchTextbox.getAttribute("value");
				System.out.println("TEXTBOX DELETE DATA : " + ActualData);
				String ExpectedData = "No Data";

				testCase = extent.createTest("VERIFY THE DELETE FUCNTION");
				AssertJUnit.assertNotSame(ActualData, ExpectedData);
				try {
					testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
					testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
					testCase.log(Status.INFO, "the value is not available");
					testCase.log(Status.PASS, ActualData);
				} catch (Exception e) {
					testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
					testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
					testCase.log(Status.INFO, "the value is available");
					testCase.log(Status.FAIL, ActualData);

				}

			}

	
	/* METHOD FOR SELECT DELETE BUTTON IN PASS AND PROCESS STATUS */

	public static void deleteonstadependstatus() {
		PlantLabTrailSamplePage lg=new PlantLabTrailSamplePage();
		PageFactory.initElements(driver, lg);
		
		String status = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		DataFormatter dataValue = new DataFormatter();
		FileInputStream fileIn = null;
		String filelocation = null;
		XSSFWorkbook wbook = null;
		Boolean not = false;
		Boolean re = null;
		try {
			filelocation = ".\\src\\test\\resources\\Excel\\Samples Module.xlsx";

			fileIn = new FileInputStream(filelocation);
			wbook = (XSSFWorkbook) WorkbookFactory.create(fileIn);

		} catch (Exception e) {
			// TODO: handle exception
		}

		XSSFSheet sheet = wbook.getSheet("Plant Lab Trial Sample");
		PropertiesCommonMethods.excalRowCount("Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0016-01");
		int r = PropertiesCommonMethods.countRow - 1;

		row = sheet.getRow(r);
		cell = row.getCell(1);
		String iV = dataValue.formatCellValue(cell);
		// System.out.println(iV);

		int i = 0;
		String value = null;
		String value2 = null;

		boolean rept = true;
		List<WebElement> allrows = null;
		int num;

		while (rept == true) {
			allrows = PlantLabTrailSamplePage.tableContainer.findElements(By.cssSelector("tbody tr"));
			num = allrows.size();
			for (i = 0; i < num; i++) {

				List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
				// In table selected record column
				String name = rows.get(2).getText();
				status = rows.get(9).getText();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
				}
				rept = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled();
				// System.out.println(rept);

				if (name.equals(iV)) {
					rept = false;
					not = true;
					re = true;
					System.out.println(status);

					if (status.equals("PASS") || status.equals("PROCESS")) {

						testCase = extent.createTest("04--STATUS IS PASS / PROCESS");
						testCase.log(Status.PASS, "TEST PASS");

						try {
							WebElement input = rows.get(14).findElement(By.cssSelector(".anticon-delete"));
							Boolean dis = input.isDisplayed();
							PropertiesCommonMethods.cTestReports("05--DELETE BUTTON IS DISPLAYED", "true", dis,
									"Delete Icon");

							if (dis == true) {
								Boolean ena = input.isEnabled();
								PropertiesCommonMethods.cTestReports("06--DELETE BUTTON IS ENABLED", "true", ena,
										"Delete-Icon");
								if (ena == true) {
									input.click();
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e) {

									}
									Boolean popup = driver.findElement(By.cssSelector(".ant-modal-content"))
											.isDisplayed();
									PropertiesCommonMethods.cTestReports("07--DELETE SCREEN IS DISPLAYED", "true",
											popup, "Delete-Icon");
									rept = false;
									not = true;
									re = false;
									break;
								}
							}
						} catch (Exception e) {

							rept = false;
							break;
						}

					} else {
						testCase = extent.createTest("04--STATUS IS NOT IN PROCESS / PASS");
						testCase.log(Status.FAIL, "TEST FAIL");
						break;
					}

				}

			}
			if (rept == true) {
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}

			}

			else if (rept == false & not == false) {
				testCase = extent.createTest("SEARCHING DATA NOT FIND IN TABLE");

			} else if (rept == false & not == true) {

				if (re == true) {
					testCase.log(Status.PASS, "STATUS NOT IN PROCESS / TEST");

				} else {
					testCase.log(Status.PASS, "STATUS IN PROCESS / TEST DELETE SUCCESS");
				}

			}
		}
		PlantLabTrailSamplePage.deleteokbutton.click();
	}
	
		}

	
	


