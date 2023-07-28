/***********************************************************************************
* Description
*------------
* TC-P-LAB-SAM-0013	Plant Lab Trial Sample Edit Functionality (Able to edit Process sample only for NEW Status)

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 05/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0013   05/05/2023     RAHUL.S      Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class EDitLabTrailSampleMethods extends DriverIntialization{
	static String tobepick = null;
	static String intermediateForPlant = null;
	static String intermediateForMixedDesign = null;
	static String intermediateForFinishProduct = null;
	static String sampleCode = null;
	static String intermediateForEquipment= null;
	static String intermediateForSampleDate= null;
	static String intermediateForSampleCode= null;
	static String intermediateForCreationDate= null;
	static String equipment= null;
	static String sampleDate= null;
	static String creationDate= null;
	/****************************************************************************
	 * DATA SEARCH AND CLICK THE EDIT BUTTON
	 ***************************************************************************/

	public static void dataPick() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0013-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			intermediateForPlant = (String) row.getCell(2).getStringCellValue();
			intermediateForFinishProduct = (String) row.getCell(3).getStringCellValue();
			intermediateForMixedDesign = (String) row.getCell(4).getStringCellValue();
			intermediateForEquipment = (String) row.getCell(5).getStringCellValue();
			intermediateForSampleDate = (String) row.getCell(6).getStringCellValue();
			intermediateForSampleCode = (String) row.getCell(7).getStringCellValue();
			intermediateForCreationDate = (String) row.getCell(8).getStringCellValue();
			search();
		}

	}

	public static int search() throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[15]/span/a[2]/span";
		boolean clickNextPage = true;
		boolean sbuExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 102; i++) {
				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println("Plant name  " + text);
					if (text.equals(tobepick)) {
						sbuExist = true;
						if (driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).isDisplayed()) {

							testCase = extent.createTest("STEP-04-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							System.out.println("disabled ************" + x);
							if (x == null) {
								testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL ❎");
								clickNextPage = false;
								a = 1;
								break;

							}
						}

						else {
							testCase.log(Status.FAIL, "TEST FAIL ❎");
							System.out.println("Button NOT Displayed");
						}

					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}
		if (sbuExist = false) {
			System.out.println("No such Element" + sbuExist);
		}
		return a;
	}
	// **********************************************************************************************************************
		// STEP-07-- CONFIRM BEFORE EDIT INTERMIATE
		// **********************************************************************************************************************
		public static void beforeEdit() throws InterruptedException, IOException {
			//INTERMEDIATE FOR PLANT
			try {
				String Value = PlantLabTrailSamplePage.plantTextBox.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-06--CONFIRM THE INTERMEDIATE POINT FOR PLANT", intermediateForPlant,
						String.valueOf(Value));
			} catch (Exception e) {

			}
			//INTERMEDIATE FOR FINISH PRODUCT
			try {
				String Value = PlantLabTrailSamplePage.finishProductTextBox.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-07--CONFIRM THE INTERMEDIATE POINT FOR FINISH PRODUCT", intermediateForFinishProduct,
						String.valueOf(Value));
			} catch (Exception e) {

			}
			
			//INTERMEDIATE FOR MIXED DESIGN
			try {
				String Value = PlantLabTrailSamplePage.mixedDesignTextBox.getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-08--CONFIRM THE INTERMEDIATE POINT FOR MIXED DESIGN", intermediateForMixedDesign,
						String.valueOf(Value));
			} catch (Exception e) {

			}
			//INTERMEDIATE FOR EQUIPMENT
			try {
				String Value = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]/div/span[2]")).getText();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-09--CONFIRM THE INTERMEDIATE POINT FOR EQUIPMENT", intermediateForEquipment,
						String.valueOf(Value));
			} catch (Exception e) {

			}
			//INTERMEDIATE FOR SAMPLE DATE
			try {
				String Value = PlantLabTrailSamplePage.SampledateTextbox.getAttribute("value");

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-10--CONFIRM THE INTERMEDIATE POINT FOR SAMPLE DATE", intermediateForSampleDate,
						String.valueOf(Value));
			} catch (Exception e) {

			}
			//INTERMEDIATE FOR SAMPLE CODE
			try {
				String Value = PlantLabTrailSamplePage.SampleproductCodeTextbox.getAttribute("value");

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-11--CONFIRM THE INTERMEDIATE POINT FOR SAMPLE CODE", intermediateForSampleCode,
						String.valueOf(Value));
			} catch (Exception e) {

			}
			//INTERMEDIATE FOR CREATION DATE
			try {
				String Value = PlantLabTrailSamplePage.CreationDateTextbox.getAttribute("value");

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-12--CONFIRM THE INTERMEDIATE POINT FOR CREATION DATE", intermediateForCreationDate,
						String.valueOf(Value));
			} catch (Exception e) {

			}

		}
		// *****************************************************************************************************************************
		// STEP-03 -- CHECK THE PLANT,FINISH PRODUCT AND MIXED DESIGN FILEDS ARE
		// DISABLED
		// ***************************************************************************************************************************
		public static void checkDisabledField() throws InterruptedException, IOException {
			// test Enabled
			try {
				boolean value = PlantLabTrailSamplePage.plantForCheckDisabled.isEnabled();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-13 -- CHECK THE PLANT FILED IS DISABLED  ", "false", String.valueOf(value));
			} catch (Exception e) {

			}
			try {
				boolean value = PlantLabTrailSamplePage.finishProductForCheckDisabled.isEnabled();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-14 -- CHECK THE FINISH PRODUCT FILED IS DISABLED  ", "false", String.valueOf(value));
			} catch (Exception e) {

			}
			try {
				boolean value = PlantLabTrailSamplePage.mixedDesignForCheckDisabled.isEnabled();

				PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-15 -- CHECK THE MIXED DESIGN FILED IS DISABLED  ", "false", String.valueOf(value));
			} catch (Exception e) {

			}
		}
		// *******************************************************************************************************
		public static void edit() throws InterruptedException, IOException {

			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
			String excelSheetName = "Plant Lab Trial Sample";
			String testCaseId = "TC-P-LAB-SAM-0013";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);

			for (int i = firstRow; i <= lastRow; i++) {
				XSSFRow row = sheet.getRow(i);
				
				equipment = (String) row.getCell(1).getStringCellValue();
				sampleDate = (String) row.getCell(2).getStringCellValue();
				sampleCode = (String) row.getCell(3).getStringCellValue();
				creationDate = (String) row.getCell(4).getStringCellValue();
				Thread.sleep(2000);
				
				
				try {
				/*EQUIPMENT FIELD DISPLAYED & ENABLED & SELECTED */
			
			
			//	SampleCommonMethods.fieldmethodselect("STEP_16--EQUIPMENT FIELD PROPERTIES ", PlantLabTrailSamplePage.EquipmentTextbox, "I--  EQUIPMENT FIELD DISPLAYED", "II--  EQUIPMENT FIELD ENABLED" , equipment, "III--EQUIPMENT DATA SUCCESSFULLY SELECTED");
				Thread.sleep(2000);
					

				//SENDING DATE TO SAMPLE DATE
				PlantLabTrailSamplePage.sampleDateRemove.click();
				Thread.sleep(2000);
				PlantLabTrailSamplePage.SampledateTextbox.sendKeys(sampleDate);
				Thread.sleep(2000);
				//SENDING DATA TO SAMPLE CODE
				PlantLabTrailSamplePage.sampleCode.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
				PlantLabTrailSamplePage.sampleCode.sendKeys(sampleCode);
				Thread.sleep(2000);
				//SENDING DATA TO CREATION DATE
				PlantLabTrailSamplePage.creationDateRemove.click();
				Thread.sleep(2000);
				PlantLabTrailSamplePage.CreationDateTextbox.sendKeys(creationDate+Keys.ENTER);
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				
				
				}catch (Exception e) {
					// TODO: handle exception
				}

				
			}

		}
		public static void clickEditButton() throws InterruptedException, IOException {
			try {
				if (PlantLabTrailSamplePage.UpdateButton.isDisplayed()) {
					testCase = extent.createTest("STEP-16-EDIT BUTTON DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS ☑");
					if (PlantLabTrailSamplePage.UpdateButton.isEnabled()) {
						testCase = extent.createTest("STEP-17-EDIT BUTTON ENABLED");
						testCase.log(Status.PASS, "TEST PASS ☑");
						PlantLabTrailSamplePage.UpdateButton.click();

					} else {
						testCase = extent.createTest("STEP-17-EDIT BUTTON ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("STEP-16-EDIT BUTTON DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// **********************************************************************************************************************
				// STEP-07-- CONFIRM AFTER EDIT 
				// **********************************************************************************************************************
				public static void afterEdit() throws InterruptedException, IOException {
					//INTERMEDIATE FOR PLANT
					try {
						String Value = PlantLabTrailSamplePage.plantTextBox.getText();

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-18--CONFIRM THE INTERMEDIATE POINT FOR PLANT", intermediateForPlant,
								String.valueOf(Value));
					} catch (Exception e) {

					}
					//INTERMEDIATE FOR FINISH PRODUCT
					try {
						String Value = PlantLabTrailSamplePage.finishProductTextBox.getText();

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-19--CONFIRM THE INTERMEDIATE POINT FOR FINISH PRODUCT", intermediateForFinishProduct,
								String.valueOf(Value));
					} catch (Exception e) {

					}
					
					//INTERMEDIATE FOR MIXED DESIGN
					try {
						String Value = PlantLabTrailSamplePage.mixedDesignTextBox.getText();

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-20--CONFIRM THE INTERMEDIATE POINT FOR MIXED DESIGN", intermediateForMixedDesign,
								String.valueOf(Value));
					} catch (Exception e) {

					}
					//INTERMEDIATE FOR EQUIPMENT
					try {
						String Value = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[2]/div[2]/div/div[1]/div/span[2]")).getText();

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-21--CONFIRM THE INTERMEDIATE POINT FOR EQUIPMENT", intermediateForEquipment,
								String.valueOf(Value));
					} catch (Exception e) {

					}
					//INTERMEDIATE FOR SAMPLE DATE
					try {
						String Value = PlantLabTrailSamplePage.SampledateTextbox.getAttribute("value");

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-22--CONFIRM THE INTERMEDIATE POINT FOR SAMPLE DATE", sampleDate,
								String.valueOf(Value));
					} catch (Exception e) {

					}
					//INTERMEDIATE FOR SAMPLE CODE
					try {
						String Value = PlantLabTrailSamplePage.SampleproductCodeTextbox.getAttribute("value");

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-23--CONFIRM THE INTERMEDIATE POINT FOR SAMPLE CODE", sampleCode,
								String.valueOf(Value));
					} catch (Exception e) {

					}
					//INTERMEDIATE FOR CREATION DATE
					try {
						String Value = PlantLabTrailSamplePage.CreationDateTextbox.getAttribute("value");

						PlantLabTrailSampleEditValidationMethods.TestCasePrint("STEP-24--CONFIRM THE INTERMEDIATE POINT FOR CREATION DATE", creationDate,
								String.valueOf(Value));
					} catch (Exception e) {

					}

				}
				
				public static void clickCancelButton() throws InterruptedException, IOException {
					try {
						if (PlantLabTrailSamplePage.Cancelbutton.isDisplayed()) {
							testCase = extent.createTest("STEP-25-CANCEL BUTTON DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							if (PlantLabTrailSamplePage.Cancelbutton.isEnabled()) {
								testCase = extent.createTest("STEP-26-CANCEL BUTTON ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								PlantLabTrailSamplePage.Cancelbutton.click();

							} else {
								testCase = extent.createTest("STEP-26-CANCEL BUTTON ENABLED");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest("STEP-25-CANCEL BUTTON DISPLAYED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
}
