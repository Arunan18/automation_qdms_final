/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0069	Check Sample Code Autogenerate Add Plant Lab Trial Sample Through the Mix Design	


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     :04.05.2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0069      04.05.2023     RAHUL.S       Original Version
      
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantLabTrailSampleEditValidationMethods;

public class SampleCodeAutoGenerateMethods extends DriverIntialization {
	static String plant = null;
	static String finishProduct = null;
	static String mixedDesign = null;
	static String plantEquipment= null;
	static String sampleDate= null;
	static String creationDate= null;
	public static void excelAutoGenerate() throws InterruptedException, IOException {
		/* Excel Sheet Value Passing */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Mix Design";
		String testCaseId = "TC-MIX-DES-0069";

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
		plantEquipment = (String) row.getCell(4).getStringCellValue();
		sampleDate = (String) row.getCell(5).getStringCellValue();
		creationDate = (String) row.getCell(6).getStringCellValue();

		
	}
	public static void clickPlantLabtrailAuto() throws InterruptedException,IOException{
		if(driver.findElement(By.xpath("//td[text()='"+plant+"']")).isDisplayed()) {
			if(driver.findElement(By.xpath("//td[text()='"+finishProduct+"']")).isDisplayed()) {
				if(driver.findElement(By.xpath("//td[text()='"+mixedDesign+"']")).isDisplayed()) {
					if(driver.findElement(By.xpath("//td[text()='"+plant+"']//following-sibling::td[3]")).isDisplayed()) {
						testCase = extent.createTest("STEP-03-CHECKING THE PLANT LAB TRAIL SAMPLE ICON IS DISPLAYED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						if(driver.findElement(By.xpath("//td[text()='"+plant+"']//following-sibling::td[3]")).isEnabled()) {
							testCase = extent.createTest("STEP-04-CHECKING THE PLANT LAB TRAIL SAMPLE ICON IS ENABLED");
							testCase.log(Status.PASS, "TEST PASS ☑");
				driver.findElement(By.xpath("//td[text()='"+plant+"']//following-sibling::td[3]")).click();
						}else {
							testCase = extent.createTest("STEP-04-CHECKING THE PLANT LAB TRAIL SAMPLE ICON IS NOT ENABLED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					}else {
						testCase = extent.createTest("STEP-03-CHECKING THE PLANT LAB TRAIL SAMPLE ICON IS NOT DISPLAYED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}	
				}
			}
		}
	}
	
	public static void plantEquipmentAuto() throws InterruptedException,IOException{
		/*PLANT EQUIPMENT FIELD DISPLAYED & ENABLED & SELECTED */  
				try {
				SampleCommonMethods.fieldmethodselect("STEP_05-- PLANT EQUIPMENT TEXT BOX FIELD PROPERTIES ", MixDesignPage.plantEquipmentTextBox, "I--  PLANT EQUIPMENT FIELD DISPLAYED", "II--  PLANT EQUIPMENT FIELD ENABLED" , plantEquipment, "III--PLANT DATA SUCCESSFULLY SELECTED");
			Thread.sleep(2000);
				}catch (NoSuchElementException e) {
					// TODO: handle exception
				}
			}
	
	//SENDING DATA TO SAMPLE DATE
		public static void sampleDateForAuto() throws InterruptedException,IOException{
			try {
				SelectDate.dateSelect("Samples Module.xlsx","Mix Design","TC-MIX-DES-0069-01",5,MixDesignPage.sampleDate);
				testCase = extent.createTest("STEP-06--SAMPLE DATE TEXTBOX IS DISPLAYED AND SELECTED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				}catch (Exception e) {
					testCase = extent.createTest("STEP-06-- SAMPLE DATE TEXTBOX IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
		}
		//SENDING DATA TO CREATION DATE
		public static void creationDateForAuto() throws InterruptedException,IOException{
			try {
				MixDesignPage.closeButtonCreationDate.click();
				MixDesignPage.creationDate.sendKeys(creationDate+Keys.ENTER);
				testCase = extent.createTest("STEP-07--SAMPLE DATE TEXTBOX IS DISPLAYED AND SELECTED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				}catch (Exception e) {
					testCase = extent.createTest("STEP-07-- SAMPLE DATE TEXTBOX IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
		}
		//SAVE BUTTON
			public static void saveButttonForAuto() throws InterruptedException, IOException {
				try {
					if (MixDesignPage.saveButtonPlantLabTrail.isDisplayed()) {
						testCase = extent.createTest("STEP-08--MIXED DESIGN SAVE BUTTON IS DISPLAYED");
						testCase.log(Status.PASS, "TEST PASS ☑");

						if (MixDesignPage.saveButtonPlantLabTrail.isEnabled()) {
							testCase = extent.createTest("STEP-09--MIXED DESIGN SAVE BUTTON IS ENABLED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							MixDesignPage.saveButtonPlantLabTrail.click();

						} else {
							testCase = extent.createTest("STEP-09--MIXED DESIGN SAVE BUTTON IS NOT ENABLED");
							testCase.log(Status.FAIL, "TEST FAIL ❎");
						}
					} else {
						testCase = extent.createTest("STEP-08--MIXED DESIGN SAVE BUTTON IS NOT DISPLAYED");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			//AUTOGENERATE CONFIRM
			public static void autoGenerateConfirm() throws InterruptedException,IOException{
				testCase = extent.createTest("STEP-14--SAMPLE CODE AUTO GENERATE THROUGH PLANT LAB TRAIL SAMPLE FUNCTION CONFIRMATION");
				//AUTO GENERATE CODE
				try {
					if(driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]")).isDisplayed()) {
					String value = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[5]"))
							.getText();
					testCase.log(Status.INFO,"THE AUTOGENERATE SAMPLE CODE IS"  + value);
					}


				} catch (Exception e) {

				}
			}
			
			
			//AUTOGENERATE CONFIRM
			public static void addGenerateConfirm() throws InterruptedException,IOException{
				
				testCase = extent.createTest("STEP-13--MIXED DESIGN PLANT LAB TRAIL SAMPLE ADD FUNCTION CONFIRMATION");
				//PLANT
				try {
					String value = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]"))
							.getText();

					PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE PLANT FIELD", plant,
							String.valueOf(value));
				} catch (Exception e) {

				}
				//FINISH PRODUCT
				try {
					String value = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]"))
							.getText();

					PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE FINISH PRODUCT FIELD", finishProduct,
							String.valueOf(value));
				} catch (Exception e) {

				}
				//MIXED DESIGN
				try {
					String value = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]"))
							.getText();

					PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE MIXED DESIGN FIELD", mixedDesign,
							String.valueOf(value));
				} catch (Exception e) {

				}
				//SAMPLE DATE
				try {
					String value = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[6]"))
							.getText();

					PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE SAMPLE DATE FIELD", sampleDate,
							String.valueOf(value));
				} catch (Exception e) {

				}
				//CREATION DATE
				try {
					String value = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[7]"))
							.getText();

					PlantLabTrailSampleEditValidationMethods.TestCasePrint("CONFIRM THE CREATION DATE FIELD", creationDate,
							String.valueOf(value));
				} catch (Exception e) {

			
				
			}
			}
}
