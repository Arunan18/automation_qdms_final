/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0076	Check If Plant lab trail sample pass then only add Production Sample


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :  04/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0076    04/05/2023      RAHUL.S       Original Version
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

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantLabTrailSampleEditValidationMethods;

public class PassCheckingMethods extends DriverIntialization {
static String plantT = null;
static String finishProductT = null;
static String mixedDesignT = null;
static String plantEquipmentT= null;
static String sampleDateT= null;
static String SampleCodeT= null;
static String creationDateT= null;
static String statusT= null;
//static String plantDropDown= null;
static ProductionSamplePage productionsample = new ProductionSamplePage();

public static void excel() throws InterruptedException, IOException {
	/* Excel Sheet Value Passing */

	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Mix Design";
	String testCaseId = "TC-MIX-DES-0076";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
	int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);
	DataFormatter data = new DataFormatter();

	XSSFRow row = sheet.getRow(firstRow);

	plantT = (String) row.getCell(1).getStringCellValue();
	finishProductT = (String) row.getCell(2).getStringCellValue();
	mixedDesignT = (String) row.getCell(3).getStringCellValue();
	statusT = (String) row.getCell(4).getStringCellValue();


	
}
	
	public static void getStatus() throws InterruptedException,IOException{
		
		
		
		if(driver.findElement(By.xpath("//td[text()='"+plantT+"']")).isDisplayed()) {
			if(driver.findElement(By.xpath("//td[text()='"+finishProductT+"']")).isDisplayed()) {
				if(driver.findElement(By.xpath("//td[text()='"+mixedDesignT+"']")).isDisplayed()) {
					if(driver.findElement(By.xpath("//td[text()='"+plantT+"']//following-sibling::td[7]")).isDisplayed()) {
						testCase = extent.createTest("STEP-03-CHECKING THE STATUS IS DISPLAYED");
						testCase.log(Status.PASS, "TEST PASS ☑");
			
				String value =driver.findElement(By.xpath("//td[text()='"+plantT+"']//following-sibling::td[7]")).getText();
				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-04-CONFIRM THE STATUS", statusT,
						String.valueOf(value));
						
					}else {
						testCase = extent.createTest("STEP-03-CHECKING THE STATUS IS NOT DISPLAYED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}	
				}
			}
		}
	}
	//CLICK ADD PRODUCTION SAMPLE BUTTON
	public static void clickAddproductionSampleButton() throws InterruptedException,IOException{
		
		PageFactory.initElements(driver, productionsample);
		try {
			if (MixDesignPage.productionSampelButton.isDisplayed()) {
				testCase = extent.createTest("STEP-09--ADD PRODUCTION SAMPLE BUTTON  IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (MixDesignPage.productionSampelButton.isEnabled()) {
					testCase = extent.createTest("STEP-10--ADD PRODUCTION SAMPLE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					MixDesignPage.productionSampelButton.click();

				} else {
					testCase = extent.createTest("STEP-10--ADD PRODUCTION SAMPLE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-09--ADD PRODUCTION SAMPLE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//CLICK ADD PRODUCTION SAMPLE BUTTON
		public static void productionSampleLeftButton() throws InterruptedException,IOException{
			
			PageFactory.initElements(driver, productionsample);
			try {
				if (ProductionSamplePage.productionsampleLeftNav.isDisplayed()) {
					testCase = extent.createTest("STEP-07-- PRODUCTION SAMPLE LEFT BUTTON  IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					if (ProductionSamplePage.productionsampleLeftNav.isEnabled()) {
						testCase = extent.createTest("STEP-08-- PRODUCTION SAMPLE LEFT BUTTON IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						ProductionSamplePage.productionsampleLeftNav.click();

					} else {
						testCase = extent.createTest("STEP-08-- PRODUCTION SAMPLE LEFT BUTTON IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}
				} else {
					testCase = extent.createTest("STEP-07-- PRODUCTION SAMPLE LEFT BUTTON IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//CHECKING MIXED DESIGN
		public static void mixedDesign() throws InterruptedException, IOException {

			try {

				if (ProductionSamplePage.mixdesign.isEnabled()) {
					testCase = extent.createTest("STEP-12--MIXED DESIGN DROPDOWN TEXTBOX IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					ProductionSamplePage.mixdesign.click();
					Thread.sleep(2000);
					// CHECKING THE PLANT
					try {
						String value = 	driver.findElement(By.xpath("//div[contains(@title,'" + mixedDesignT + "')]")).getText();

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-13--CONFIRM THE MIXED DESIGN FIELD", mixedDesignT,
								String.valueOf(value));
					} catch (Exception e) {

					}
				
					driver.findElement(By.xpath("//div[contains(@title,'" + mixedDesignT + "')]")).click();

				} else {
					testCase = extent.createTest("STEP-12--MIXED DESIGN DROPDOWN TEXTBOX IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//CLICK ADD PRODUCTION SAMPLE BUTTON
				public static void clickCancelButton() throws InterruptedException,IOException{
					
					PageFactory.initElements(driver, productionsample);
					try {
						if (driver.findElement(By.xpath("//button[@class='ant-btn']")).isDisplayed()) {
							testCase = extent.createTest("STEP-13-- CANCEL BUTTON  IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");

							if (driver.findElement(By.xpath("//button[@class='ant-btn']")).isEnabled()) {
								testCase = extent.createTest("STEP-14-- CANCEL BUTTON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath("//button[@class='ant-btn']")).click();

							} else {
								testCase = extent.createTest("STEP-14-- CANCEL BUTTON IS NOT ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL ❎");
							}
						} else {
							testCase = extent.createTest("STEP-13-- CANCEL BUTTON IS NOT DISPLAYED");
							testCase.log(Status.FAIL, "TEST FAIL ❎");
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
}
