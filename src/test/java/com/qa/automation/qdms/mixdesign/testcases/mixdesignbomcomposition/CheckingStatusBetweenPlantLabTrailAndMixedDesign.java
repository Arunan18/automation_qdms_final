/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0075	Check If Plant Lab trail sample Pass check the Mix Design status also Pass	


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :03.05.2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*TC-MIX-DES-0075      03.05.2023     RAHUL.S       Original Version
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class CheckingStatusBetweenPlantLabTrailAndMixedDesign extends DriverIntialization {
	static MixDesignPage mx = new MixDesignPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static String plant = null;
	static String finishProduct = null;
	static String mixedDesign = null;
	static String plantEquipment = null;
	static String sampleDate = null;
	static String SampleCode = null;
	static String creationDate = null;
	static String statusWE = null;
	static String statusMixed = null;

	@Test
	public static void checking() throws InterruptedException, IOException {
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, mx);
		try {
			/* LOGIN */
			LoginTest.Login();

			Thread.sleep(3000);
			/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
			methods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
					"I--PRODUCTION SAMPLE CARD DISPLAYED", "II--PRODUCTION SAMPLE CARD ENABLED",
					productionsample.sampletext, "SAMPLES",
					"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

			/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
			methods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
					"I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
					"II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
					productionsample.productionwindowheadding,
					"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

			/* PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
			methods.methodoneclick("STEP_03-- PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES",
					productionsample.plantLabTrailSampleLeftButton, "I-- PLANT LAB TRAIL SAMPLE BUTTON DISPLAYED",
					"II-- PLANT LAB TRAIL SAMPLE BUTTON ENABLED", productionsample.plantlabwindowheadding,
					"Plant-Lab Trial Sample", "III--ON CLICK  PLANT LAB TRAIL SAMPLE BUTTON SHOWES CORRECT WINDOW");
		} catch (Exception e) {
			// TODO: handle exception
		}
		excel();
		Thread.sleep(2000);
		clickPlantLabtrail();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='homebtn']")).click();
		Thread.sleep(2000);
		MixDesignPage.mixedDesignCard.click();
	
		clickMixedDesignStatus();
		//confirm status
		statusConfirm();
		//logout
		Logout.LogoutFunction();
	}

	public static void excel() throws InterruptedException, IOException {
		/* Excel Sheet Value Passing */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0068";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);
		DataFormatter data = new DataFormatter();

		XSSFRow row = sheet.getRow(firstRow);

		plant = (String) row.getCell(1).getStringCellValue();
		finishProduct = (String) row.getCell(2).getStringCellValue();
		mixedDesign = (String) row.getCell(3).getStringCellValue();

	}

	// GET PLANT LAB TRAIL SAMPLE STATUS
	public static void clickPlantLabtrail() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//td[text()='" + plant + "']")).isDisplayed()) {
			if (driver.findElement(By.xpath("//td[text()='" + finishProduct + "']")).isDisplayed()) {
				if (driver.findElement(By.xpath("//td[text()='" + mixedDesign + "']")).isDisplayed()) {

					if (driver.findElement(By.xpath("//td[text()='" + plant + "']//following-sibling::td[9]"))
							.isDisplayed()) {
						testCase = extent.createTest("STEP-04-CHECKING THE PLANT LAB TRAIL SAMPLE STATUS IS DISPLAYED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						statusWE = driver
								.findElement(By.xpath("//td[text()='" + plant + "']//following-sibling::td[9]"))
								.getText();
						System.out.println("&&&&&&&&" + statusWE);
					} else {
						testCase = extent
								.createTest("STEP-04-CHECKING THE PLANT LAB TRAIL SAMPLE STATUS IS NOT DISPLAYED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				}
			}
		}
	}

	// GET MIXED DESIGN STATUS
	public static void clickMixedDesignStatus() throws InterruptedException, IOException {
		if (driver.findElement(By.xpath("//td[text()='" + plant + "']")).isDisplayed()) {
			if (driver.findElement(By.xpath("//td[text()='" + finishProduct + "']")).isDisplayed()) {
				if (driver.findElement(By.xpath("//td[text()='" + mixedDesign + "']")).isDisplayed()) {
					if (driver.findElement(By.xpath("//td[text()='" + plant + "']//following-sibling::td[7]"))
							.isDisplayed()) {
						testCase = extent.createTest("STEP-05-CHECKING THE MIXED DESIGN STATUS IS DISPLAYED");
						testCase.log(Status.PASS, "TEST PASS ☑");

						statusMixed = driver
								.findElement(By.xpath("//td[text()='" + plant + "']//following-sibling::td[7]"))
								.getText();
						System.out.println("&&&&&&&&" + statusMixed);

					} else {
						testCase = extent.createTest("STEP-05-CHECKING THE MIXED DESIGN STATUS  IS NOT DISPLAYED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				}
			}
		}
	}

	// CONFIRM THE STATUS
	public static void statusConfirm() throws InterruptedException, IOException {

		if (statusMixed.equals(statusWE)) {
			testCase = extent.createTest("STEP-06-CHECKING THE STATUS BETWEEN PLANT LAB TRAIL SAMPLE IS EQUAL");
			testCase.log(Status.PASS, "TEST PASS ☑");
		} else {
			testCase = extent.createTest("STEP-06-CHECKING THE STATUS BETWEEN PLANT LAB TRAIL SAMPLE IS NOT EQUAL");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
}
