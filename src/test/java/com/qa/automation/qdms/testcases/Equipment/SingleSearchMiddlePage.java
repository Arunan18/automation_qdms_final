//***********************************************************************************
//* Description
//*------------
//*SINGLE SEARCH MIDDLE PAGE EQUIPMENT TYPE AND MULTI SEARCH IN MIDDLE PAGE
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 06/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-EQU-0063        06/03/2023    RAHUL.S      Original Version
//* TC-EQU-0064          10/04/2023    RAHUL.S      MULTI SEARCH ATTACHED
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;

public class SingleSearchMiddlePage extends DriverIntialization {
	static String searchEquipmentType = null;
	static int expectedcount = 0;
	static int actualElementCount = 0;
	static int actualElementCountMulti = 0;
	static String searchEquipment ="Batching Plant Admixture Scale";
	static int expectedcountforMulti = 0;

// ********************************************************************************************************
//	 THE METHOD IS FOR GENERATING REPORT 
//********************************************************************************************************		
	public static void testCasePrint(String TestCaseName, int expectedcount2, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedcount2);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedcount2);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedcount2);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}

	}

	public static void equipment() throws InterruptedException, IOException {
//****************************************************************************************
//    	STEP-01--MATERIAL TAB IS DISPLAYED   &	STEP-02--MATERIAL TAB IS ENABLED
//****************************************************************************************	
		if (EquipmentPage.equipmenttab.isDisplayed()) {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (EquipmentPage.equipmenttab.isEnabled()) {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				EquipmentPage.equipmenttab.click();

			} else {
				testCase = extent.createTest("STEP-02--MATERIAL TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--MATERIAL TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void equipmentNavigation() throws InterruptedException, IOException {
//****************************************************************************************
//        	STEP-03--MATERIAL BUTTON IS DISPLAYED &	STEP-04--MATERIAL BUTTON IS ENABLED
//****************************************************************************************		

		if (EquipmentPage.equipmentnavigation.isDisplayed()) {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (EquipmentPage.equipmentnavigation.isEnabled()) {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				EquipmentPage.equipmentnavigation.click();

			} else {
				testCase = extent.createTest("STEP-04--MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void searchequpmentType() throws InterruptedException, IOException {
//****************************************************************************************
//STEP-05-- CHECKING GO TO MIDDLE PAGE 
//****************************************************************************************	

		if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isDisplayed()) {
			Thread.sleep(2000);
			String nextButton = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
					.getAttribute("disabled");
			System.out.println("@@" + nextButton);
			if (nextButton == null) {
				for (int i = 0; i < 2; i++) {
					try {

						driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
						testCase = extent.createTest("STEP-05--CHECKING GO TO MIDDLE PAGE");
						testCase.log(Status.PASS, "TEST PASS ☑");
						Thread.sleep(2000);
					} catch (Exception e) {
					}
				}
			} else {
				testCase = extent.createTest("STEP-05-- CHECKING GO TO MIDDLE PAGE ");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}

		}

//****************************************************************************************
//    	STEP-06--MATERIAL TYPE SEARCH ICON IS DISPLAYED &	STEP-07--MATERIAL TYPE SEARCH ICON IS ENABLED
//****************************************************************************************	
		if (driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-06---MATERIAL TYPE SEARCH ICON IS DISPLAYED ");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-07--MATERIAL TYPE SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[3]/div/span[2]"))
							.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-07--PLANT SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-06--PLANT SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

//************************************************************************************************************
//    	STEP-08--CHECKING EQUIPMENT TYPE SEARCH DROP DOWN DISPLAYED &	STEP-09--CHECKING EQUIPMENT TYPE SEARCH DROP DOWN ENABLED
////************************************************************************************************************			
		if (EquipmentPage.equipmentType.isDisplayed()) {
			testCase = extent.createTest("STEP-08--CHECKING EQUIPMENT TYPE SEARCH DROP DOWN DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (EquipmentPage.equipmentType.isEnabled()) {
				testCase = extent.createTest("STEP-09--CHECKING EQUIPMENT TYPE SEARCH DROP DOWN ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					boolean isSelect = false;
					while (!isSelect) {
						driver.findElement(By.xpath("//*[@id=\"equipmentType\"]")).sendKeys(Keys.ENTER);
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@id=\"equipmentType\"]")).sendKeys(Keys.ARROW_DOWN);
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[@id=\"equipmentType\"]")).sendKeys(Keys.ENTER);
						Thread.sleep(1000);
						String text = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]"))
								.getText();
						isSelect = text.equals(searchEquipmentType);
					}
					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-09--CHECKING EQUIPMENT TYPE SEARCH TEXTBOX ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-08--CHECKING EQUIPMENT TYPE SEARCH TEXTBOX DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		boolean clickNextPage = true;

		boolean passorfail = true;
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		String nameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String nameXpath_lastPart = "]/td[3]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					if (!text.contains(searchEquipmentType)) {
						passorfail = false;
					}
					if (text.contains(searchEquipmentType)) {
						expectedList.add(text);
					}
					actualList.add(text);
					actualElementCount = actualElementCount + 1;
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
		
	}

	public static void count() throws InterruptedException, IOException {
//******************************************************************************************************************	
//									STEP-10--SINGLE SEARCH CONFIRM
//******************************************************************************************************************	
		try {
			int Value = actualElementCount;
			testCasePrint("STEP-10--SINGLE SEARCH CONFIRM", expectedcount, String.valueOf(Value));
		} catch (Exception e) {

		}

	}

	/****************************************************************************
	 * DATA SEARCH FOR EQUIPMENT TYPE
	 ***************************************************************************/

	public static void searchEquipmentType() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Equipment";
		String testCaseId = "TC-EQU-0063";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			searchEquipmentType = (String) row.getCell(1).getStringCellValue();
			expectedcount = (int) row.getCell(2).getNumericCellValue();
			searchequpmentType();
		}

	}

	public static void multisaerchEquipment() throws InterruptedException, IOException {
		// ************************************************************************************************************
//	STEP-10--CHECKING EQUIPMENT  SEARCH DISPLAYED &	STEP-11--CHECKING EQUIPMENT SEARCH ENABLED
//************************************************************************************************************	
		if (driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-10--CHECKING EQUIPMENT SEARCH ICON DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-11--CHECKING EQUIPMENT SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[1]/table/thead/tr/th[1]/div/span[2]"))
							.click();
					Thread.sleep(3000);
				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-11--CHECKING EQUIPMENT SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-10--CHECKING EQUIPMENT SEARCH ICON DISABLED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	public static void multisaerchEquipmentTextBox() throws InterruptedException, IOException {
		// ************************************************************************************************************
//	STEP-12--CHECKING EQUIPMENT TEXTBOX DISPLAYED &	STEP-13--CHECKING EQUIPMENT TEXTBOX ENABLED
//************************************************************************************************************
		if (driver.findElement(By.xpath("//input[@placeholder=' Equipment']")).isDisplayed()) {
			testCase = extent.createTest("STEP-12--CHECKING EQUIPMENT SEARCH TEXTBOX DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//input[@placeholder=' Equipment']")).isEnabled()) {
				testCase = extent.createTest("STEP-13--CHECKING EQUIPMENT SEARCH TEXTBOX ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder=' Equipment']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder=' Equipment']")).sendKeys(searchEquipment);
				Thread.sleep(2000);
			} else {
				testCase = extent.createTest("STEP-13--CHECKING EQUIPMENT SEARCH TEXTBOX ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-12--CHECKING EQUIPMENT SEARCH TEXTBOX DISABLED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
	}

	// ************************************************************************************************************
	// SEARCH FOR EQUIPMENT
	// ************************************************************************************************************
	public static void searchEquipmentForMulti() throws InterruptedException, IOException {
		boolean clickNextPage = true;
		
		boolean passorfail = true;
		ArrayList<String> actualList1 = new ArrayList<String>();
		ArrayList<String> expectedList1 = new ArrayList<String>();

		String nameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String nameXpath_lastPart = "]/td[1]";
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String textFull = driver.findElement(By.xpath(nameXpath_firstPart + i + nameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();

					if (!text.contains(searchEquipment)) {
						passorfail = false;
					}
					if (text.contains(searchEquipment)) {
						expectedList1.add(text);

					}
					actualList1.add(text);
					actualElementCountMulti = actualElementCountMulti + 1;
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
		
	}

	/****************************************************************************
	 * DATA SEARCH FOR EQUIPMENT 
	 ***************************************************************************/

	public static void searchEquipment() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Equipment";
		String testCaseId = "TC-EQU-0064";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			//searchEquipmentType = (String) row.getCell(1).getStringCellValue();
			searchEquipment = (String) row.getCell(1).getStringCellValue();
			expectedcountforMulti = (int) row.getCell(2).getNumericCellValue();
			searchEquipmentForMulti();
		}

	}
	public static void countForMultiSearch() throws InterruptedException, IOException {
	//******************************************************************************************************************	
//	STEP-10--MULTI SEARCH CONFIRM
//******************************************************************************************************************	
try {
int Value = actualElementCountMulti;
testCasePrint("STEP-10--MULTI SEARCH CONFIRM", expectedcountforMulti, String.valueOf(Value));
} catch (Exception e) {

}

}

}
