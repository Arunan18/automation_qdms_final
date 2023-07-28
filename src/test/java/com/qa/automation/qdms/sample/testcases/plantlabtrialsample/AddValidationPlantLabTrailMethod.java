//***********************************************************************************
//* Description
//*------------
//* ADD VALIDATION PLANT LAB TRAIL SAMPLE FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 17/04/2023
//* 
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0012   17/04/2023   NILUXY.K    Orginal Version
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class AddValidationPlantLabTrailMethod extends DriverIntialization {

	public static String excelpath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	public static String pageName = "Plant Lab Trial Sample";

	static PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();
	static Actions actions = new Actions(driver);
	static SampleActionMethods action = new SampleActionMethods();

	
	static String plant = "";
	static String finishsample ="";
	static String mixdesign ="";
	static String equipment ="";
	static String sampledate ="";
	static String sampleCode ="";

//	public static void excelselection() throws InterruptedException, IOException {
//
//		String testCaseId = "TC-P-LAB-SAM-0012";
//		int firstrow = CommonMethods.getFirstRowNum(excelpath, pageName, testCaseId);
//		int lastrow = CommonMethods.getLastRowNum(excelpath, pageName, testCaseId);
//
//		FileInputStream file = new FileInputStream(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet pageName = workbook.getSheet("Plant Lab Trial Sample");
//		Thread.sleep(2000);
//		for (int i = firstrow; i <= lastrow; i++) {
//			Thread.sleep(2000);
//			XSSFRow row = pageName.getRow(i);
//
//			String labTrail = (String) row.getCell(1).getStringCellValue();
//			System.out.println("labTrail" + labTrail);
//			String validation = (String) row.getCell(2).getStringCellValue();
//			System.out.println("validation" + validation);
//
//		}
//
//	}

/////////////////////////////
	
	//EMPTY VALIDATION FOR PLANT FIELD
public static void emptyValueForDropDownPlant() throws InterruptedException, IOException {
	Thread.sleep(2000);
	
	action.clicking(labtrailpage.PlantTextbox, 2, "CHECK PLANT TEXBOX");

	PageFactory.initElements(driver, labtrailpage);

	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Plant Lab Trial Sample";
	String testCaseId = "TC-P-LAB-SAM-0012";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);

	Thread.sleep(2000);
	XSSFRow row = sheet.getRow(firstRow);

	
	Thread.sleep(2000);
	try {
	 String labTrail = (String) row.getCell(1).getStringCellValue();
	String validation = (String) row.getCell(2).getStringCellValue();
	PlantLabTrailSamplePage.PlantTextbox.sendKeys(labTrail);
	
	
	
	Thread.sleep(2000);
	
	String ActualValidation = PlantLabTrailSamplePage.Plantvalidationempty.getText();
	System.out.println("$$$$ " + ActualValidation);
	String ExpectedValidation = validation;
	testCase = extent.createTest("EMPTY VALIDATION FOR PLANT, Check " + " Script");
	try {
		Assert.assertEquals(ActualValidation, ExpectedValidation);
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.PASS, "Pass " + "Script");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
	}
	} catch (Exception e) {
		
	}
}

////EMPTY VALIDATION FOR FINISHED PRODUCT
				
				
public static void emptyValueForDropDownFinishedproduct() throws InterruptedException, IOException {
	PageFactory.initElements(driver, labtrailpage);
	SoftAssert sa = new SoftAssert();
	Thread.sleep(2000);
	action.clicking(labtrailpage.FinishproductTextbox, 2, "CHECK FINISH PRODUCT TEXBOX");
	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Plant Lab Trial Sample";
	String testCaseId = "TC-P-LAB-SAM-0012";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);

	XSSFRow row = sheet.getRow(firstRow+1);
try {
	String labTrail = (String) row.getCell(1).getStringCellValue();
	String validation = (String) row.getCell(2).getStringCellValue();

	PlantLabTrailSamplePage.FinishproductTextbox.sendKeys(labTrail);
	
	PlantLabTrailSamplePage.PlantTextbox.sendKeys(plant);
	PlantLabTrailSamplePage.EquipmentTextbox.sendKeys(plant);
	Thread.sleep(1000);
	labtrailpage.FinishproductTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	PlantLabTrailSamplePage.Savebutton.click();

	Thread.sleep(2000);
	String ActualValidation = PlantLabTrailSamplePage.finishproductvalidationempty.getText();
	System.out.println("$$$$ " + ActualValidation);
	String ExpectedValidation = validation;
	testCase = extent.createTest("EMPTY VALIDATION FOR FINISH PRODUCT, Check " + " Script");
	try {
		Assert.assertEquals(ActualValidation, ExpectedValidation);
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.PASS, "Pass " + "Script");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
	}
	} catch (Exception e) {
		
	}
}



//EMPTY VALIDATION FOR MIX DESIGN
public static void emptyValueForDropDownMixdesign() throws InterruptedException, IOException {
	PageFactory.initElements(driver, labtrailpage);
	SoftAssert sa = new SoftAssert();
	Thread.sleep(2000);

	action.clicking(labtrailpage.MixdesignTextbox, 2, "CHECK MIX DESIGN TEXBOX");
	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Plant Lab Trial Sample";
	String testCaseId = "TC-P-LAB-SAM-0012";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);

	XSSFRow row = sheet.getRow(firstRow+2);
try {
	String labTrail = (String) row.getCell(1).getStringCellValue();
	String validation = (String) row.getCell(2).getStringCellValue();

	PlantLabTrailSamplePage.MixdesignTextbox.sendKeys(labTrail);
	Thread.sleep(1000);
	labtrailpage.MixdesignTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	PlantLabTrailSamplePage.Savebutton.click();

	Thread.sleep(2000);
	String ActualValidation = PlantLabTrailSamplePage.Mixdesignvalidationempty.getText();
	System.out.println("$$$$ " + ActualValidation);
	String ExpectedValidation = validation;
	testCase = extent.createTest("EMPTY VALIDATION FOR MIX DESIGN, Check " + " Script");
	try {
		Assert.assertEquals(ActualValidation, ExpectedValidation);
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.PASS, "Pass " + "Script");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
	}
} catch (Exception e) {
	
}
}
//
//
////EMPTY VALIDATION FOR EUIPMENT FIELD
	public static void emptyValueForDropDownEuipment() throws InterruptedException, IOException {
		PageFactory.initElements(driver, labtrailpage);
		SoftAssert sa = new SoftAssert();
		Thread.sleep(2000);
		action.clicking(labtrailpage.EquipmentTextbox, 2, "CHECK EQUIPMENT TEXBOX");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Plant Lab Trial Sample";
		String testCaseId = "TC-P-LAB-SAM-0012";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		XSSFRow row = sheet.getRow(firstRow+3);
try {
		String labTrail = (String) row.getCell(1).getStringCellValue();
		String validation = (String) row.getCell(2).getStringCellValue();

		PlantLabTrailSamplePage.PlantTextbox.sendKeys(labTrail);
		Thread.sleep(1000);
		labtrailpage.MixdesignTextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		PlantLabTrailSamplePage.Savebutton.click();

		Thread.sleep(2000);
		String ActualValidation = PlantLabTrailSamplePage.Equipementvalidationempty.getText();
		System.out.println("$$$$ " + ActualValidation);
		String ExpectedValidation = validation;
		testCase = extent.createTest("EMPTY VALIDATION FOR EUIPMENT FIELD, Check " + " Script");
		try {
			Assert.assertEquals(ActualValidation, ExpectedValidation);
			testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
			testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
			testCase.log(Status.PASS, "Pass " + "Script");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
			testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
			testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
			testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
		}
} catch (Exception e) {
	}	
	}
		//EMPTY VALIDATION FOR DATE FIELD
		public static void emptyValueForDropDownDate() throws InterruptedException, IOException {
			PageFactory.initElements(driver, labtrailpage);
			SoftAssert sa = new SoftAssert();
			Thread.sleep(2000);
			action.clicking(labtrailpage.EquipmentTextbox, 2, "CHECK EQUIPMENT TEXBOX");
			String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
			String excelSheetName = "Plant Lab Trial Sample";
			String testCaseId = "TC-P-LAB-SAM-0012";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(excelSheetName);

			XSSFRow row = sheet.getRow(firstRow+4);
try {
			String labTrail = (String) row.getCell(1).getStringCellValue();
			String validation = (String) row.getCell(2).getStringCellValue();

			PlantLabTrailSamplePage.SampledateTextbox.sendKeys(labTrail);
			Thread.sleep(1000);
			PlantLabTrailSamplePage.Savebutton.click();

			Thread.sleep(2000);
			String ActualValidation = PlantLabTrailSamplePage.Startdatevalidationempty.getText();
			System.out.println("$$$$ " + ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("EMPTY VALIDATION FOR SAMPLE DATE FIELD, Check " + " Script");
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
			}		
		} catch (Exception e) {
			
		}
	
		}

//SPECIAL CHARACTER VALIDATION FOR CODE FIELD
public static void SpecialcharacterCodeValidation() throws InterruptedException, IOException {
	PageFactory.initElements(driver, labtrailpage);
	SoftAssert sa = new SoftAssert();
	Thread.sleep(2000);
	action.clicking(labtrailpage.EquipmentTextbox, 2, "CHECK EQUIPMENT TEXBOX");
	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Plant Lab Trial Sample";
	String testCaseId = "TC-P-LAB-SAM-0012";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);

	XSSFRow row = sheet.getRow(firstRow+5);
try {
	String labTrail = (String) row.getCell(1).getStringCellValue();
	String validation = (String) row.getCell(2).getStringCellValue();

	PlantLabTrailSamplePage.SampleproductCodeTextbox.sendKeys(labTrail);
	Thread.sleep(1000);
	PlantLabTrailSamplePage.Savebutton.click();

	Thread.sleep(2000);
	String ActualValidation = PlantLabTrailSamplePage.Spciealcharacterforsamplecodevalidationempty.getText();
	System.out.println("$$$$ " + ActualValidation);
	String ExpectedValidation = validation;
	testCase = extent.createTest("SPCIEAL VALIDATION FOR SAMPLE CODE FIELD, Check " + " Script");
	try {
		Assert.assertEquals(ActualValidation, ExpectedValidation);
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.PASS, "Pass " + "Script");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
	}		
} catch (Exception e) {
	
}
}
 // SPACE  VALIDATION VALUE FOR CODE FIED

public static void SpaceValueForCode() throws InterruptedException, IOException {
	PageFactory.initElements(driver, labtrailpage);
	SoftAssert sa = new SoftAssert();
	Thread.sleep(2000);
	
	action.clicking(labtrailpage.EquipmentTextbox, 2, "CHECK EQUIPMENT TEXBOX");
	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Plant Lab Trial Sample";
	String testCaseId = "TC-P-LAB-SAM-0012";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(excelSheetName);

	XSSFRow row = sheet.getRow(firstRow+6);
try {
	String labTrail = (String) row.getCell(1).getStringCellValue();
	String validation = (String) row.getCell(2).getStringCellValue();

	PlantLabTrailSamplePage.SampleproductCodeTextbox.sendKeys(labTrail);
	Thread.sleep(1000);
	PlantLabTrailSamplePage.Savebutton.click();

	Thread.sleep(2000);
	String ActualValidation = PlantLabTrailSamplePage.Spciealcharacterforsamplecodevalidationempty.getText();
	System.out.println("$$$$ " + ActualValidation);
	String ExpectedValidation = validation;
	testCase = extent.createTest("SPACE VALIDATION FOR SAMPLE CODE FIELD, Check " + " Script");
	try {
		Assert.assertEquals(ActualValidation, ExpectedValidation);
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.PASS, "Pass " + "Script");
	} catch (AssertionError e) {
		testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
		testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("Low Priority");
		testCase.log(Status.FAIL, "Fail " + "Script").assignCategory("High Priority");
	}		
} catch (Exception e) {
	
}
			
	

		}
}


	
	