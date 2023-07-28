//***********************************************************************************
//* Description
//*------------
//* Should not be able to delete SBU after depended ( Plant, Material)
//***********************************************************************************
//*
//* Author           : Karunya Navanesan
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SBU-0048         18/05/2023      Karunya     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ShouldnotbeabletodeleteSBUafterdepended extends DriverIntialization {

	static SbuPage mps = new SbuPage();
	static String SeachData = null;
	static String alertMessage = null;

	@Test
	public static void shouldnotbedeletedinSbu() throws InterruptedException, IOException {

		// Login the system
		LoginTest.Login();

		// Navigate to master
		MasterMainNavigationsTest.navigateMaster();

		// Navigate to plant
		MasterMainNavigationsTest.navigatePlantMain();

		// Navigate to sbu
		MasterMainNavigationsTest.navigateSbu("Sub should not be able to Delete function");

		// Find Should not be able to delete SBU after depended ( Plant, Material)
		shouldnotbedeletedinSbuFunctionality();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void shouldnotbedeletedinSbuFunctionality() throws InterruptedException, IOException {

		// --------------------------------------------------------------------------------------
		// Count Before Delete
		// --------------------------------------------------------------------------------------
		PageFactory.initElements(driver, mps);

		boolean clickNextPage = true;
		int BeforeCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String PlantXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String PlantXpath_lastPart = "]/td[1]";
		while (clickNextPage) {

			for (int i = 2; i < 250; i++) {

				try {
					String text = driver.findElement(By.xpath(PlantXpath_firstPart + i + PlantXpath_lastPart))
							.getText();

					BeforestringList.add(text);
					BeforeCount = BeforeCount + 1;
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		Thread.sleep(500);

		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("before count " + BeforeCount);
		System.out.println(BeforestringList);

		// ________________________________________________________________________________
		// Excel Method for get search data for delete
		// _________________________________________________________________________________

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "SBU";
		String testCaseId = "TC-SBU-0048";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		System.out.println("last count:-"+lastRow);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		
			DataFormatter data = new DataFormatter();
			XSSFRow row = sheet.getRow(firstRow);
			XSSFCell cell = row.getCell(1);
			SeachData = data.formatCellValue(cell);
			cell = row.getCell(2);
			alertMessage = data.formatCellValue(cell);
			System.out.println(alertMessage);

		

		// ________________________________________________________________________________
		// SEARCH DATA FOR DELETE
		// _________________________________________________________________________________

		testCase = extent.createTest("STEP:1");
		ActionCommonMethod.actionS(0, 2, SbuPage.sbutable, "delete", "Master Module.xlsx", "SBU", "TC-SBU-0048-01", 1);

		WebElement okButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']"));
		okButton.click();
		
		/* DATA NOT DELETED MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP_04-- DATA NOT DELETED IT'S DEPENDEND",SbuPage.sbunotdeletenotification, alertMessage);

		// --------------------------------------------------------------------------------------
		// Count after delete
		// --------------------------------------------------------------------------------------

		ArrayList<String> AfterstringList = new ArrayList<String>();
		clickNextPage = true;
		int AfterCount = 0;

		while (clickNextPage) {

			for (int i = 2; i < 250; i++) {

				try {
					String text = driver.findElement(By.xpath(PlantXpath_firstPart + i + PlantXpath_lastPart))
							.getText();

					AfterCount = AfterCount + 1;
					AfterstringList.add(text);
				} catch (Exception e) {
				}
			}

			if (clickNextPage == true) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("after count " + AfterCount);
		System.out.println(AfterstringList);
		

		// *****************************************************************************************************
		// STEP-08--CONFIRM THE COUNT BEFORE AND AFTER DELETE
		// *****************************************************************************************************
		
		try {
			testCase = extent.createTest("STEP-08--CONFIRM THE COUNT BEFORE AND AFTER DELETE");

			try {
				Assert.assertEquals(BeforeCount, AfterCount);
				testCase.log(Status.INFO, "BeforeCount :- " + BeforeCount);
				testCase.log(Status.INFO, "AfterCount :- " + AfterCount);

				testCase.log(Status.PASS, "RESET WORKED");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "BeforeCount :- " + BeforeCount);
				testCase.log(Status.INFO, "AfterCount :- " + AfterCount);

				testCase.log(Status.FAIL, "RESET WORKED");
			}
		} catch (Exception e) {

		}
		
		
	}

	
}
