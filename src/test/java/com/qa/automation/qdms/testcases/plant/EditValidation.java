/***********************************************************************************
* Description
*------------
* EDIT VALIDATION CHECKING IN PLANT
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 08/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLANT-0071          08/03/2023   RAHUL.S    Original Version
*                        18/04/2023   RAHUL.S    MODIFIED
*                        20/07/2023   RAHUL.S    UPDATED
************************************************************************************/
package com.qa.automation.qdms.testcases.plant;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import org.testng.Assert;
import org.testng.AssertJUnit;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.PlantPage;

public class EditValidation extends DriverIntialization {
	static String tobepick = null;
	static String intermediate = null;
	static String editPlant = null;
	static String validationMessage = null;
	static String address = null;
	static String description = null;
	static String fax = null;
	static String contactNo = null;
	static String forReportGenerate = null;

	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}
	}

	/****************************************************************************
	 * DATA SEARCH AND CLICK THE EDIT BUTTON
	 ***************************************************************************/

	public static void dataPick() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Plant";
		String testCaseId = "TC-PLANT-0071-TD";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobepick = (String) row.getCell(1).getStringCellValue();
			intermediate = (String) row.getCell(2).getStringCellValue();
			search();
		}

	}

	public static int search() throws InterruptedException, IOException {
		int a = 0;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String EditXpath_lastPart = "]/td[9]/span/a/span";
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

							testCase = extent.createTest("STEP-05-CHECKING EDIT ICON IS DISPLAYED");
							testCase.log(Status.PASS, "TEST PASS ☑");
							String x = driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart))
									.getAttribute("disabled");
							System.out.println("disabled ************" + x);
							if (x == null) {
								testCase = extent.createTest("STEP-06-CHECKING EDIT ICON IS ENABLED");
								testCase.log(Status.PASS, "TEST PASS ☑");
								driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							} else if (x.equals("true")) {
								testCase = extent.createTest("STEP-06-CHECKING EDIT ICON IS ENABLED");
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
		try {
			String Value = PlantPage.plantname.getAttribute("value");

			TestCasePrint("STEP-07--CONFIRM BEFORE THE EDIT", intermediate, String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("STEP-07--CONFIRM BEFORE THE EDIT", intermediate, String.valueOf(e));
		}

	}

	public static void editValidationForPlant() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Plant";
		String testCaseId = "TC-PLANT-0071";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			editPlant = (String) row.getCell(1).getStringCellValue();
			validationMessage = (String) row.getCell(2).getStringCellValue();
			address = (String) row.getCell(3).getStringCellValue();
			contactNo = (String) row.getCell(4).getStringCellValue();
			fax = (String) row.getCell(5).getStringCellValue();
			description = (String) row.getCell(6).getStringCellValue();
			forReportGenerate = (String) row.getCell(7).getStringCellValue();

			Thread.sleep(2000);
			PlantPage.plantname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			
			PlantPage.plantname.sendKeys(editPlant);
		
			PlantPage.Address.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		
			PlantPage.Address.sendKeys(address);
			
			PlantPage.ContactNo.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			
			PlantPage.ContactNo.sendKeys(contactNo);
			
			PlantPage.fax.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			
			PlantPage.fax.sendKeys(fax);
			
			PlantPage.Description.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		
			PlantPage.Description.sendKeys(description);
			
			PlantPage.ClickSubBusinessUnitDropDown.click();
		
			PlantPage.SelectSubBusiness.click();
		
			PlantPage.UpdateButton.click();
			Thread.sleep(2000);
			try {
				if (PlantPage.UpdateButton.isDisplayed()) {
					testCase = extent.createTest(forReportGenerate);
					String ActualValidation = PlantPage.validation.getText();
					String ExpectedValidation = validationMessage;

					try {
						Assert.assertEquals(ActualValidation, ExpectedValidation);
						testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
						testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
						testCase.log(Status.PASS, "ERROR MESSAGE IS CORRECT");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
						testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
						testCase.log(Status.FAIL, "ERROR MESSAGE IS NOT CORRECT");
					}
				}
			} catch (NoSuchElementException e) {

			}
			Thread.sleep(2000);
			try {
				if(PlantPage.cancelButton.isDisplayed()) {
					PlantPage.cancelButton.click();
				}
			}catch (Exception e) {
				
			}
			
			dataPick();
		}

	}


}
