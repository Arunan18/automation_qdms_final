package com.qa.automation.qdms.testcases.project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.ProjectPage;

public class ProjectValidationCommonMethod extends DriverIntialization {

	@Test
	public static void ProjectCheckEditValidation(String colname ) throws IOException, InterruptedException {

		testCase = extent.createTest(colname + "CHECKING PROJECT FEILD VALIDATION");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0077";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String projectname = (String) row.getCell(1).getStringCellValue();
			String validation = (String) row.getCell(2).getStringCellValue();
			String Message = (String) row.getCell(3).getStringCellValue();

			ProjectPage.projectname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			Thread.sleep(2000);
			ProjectPage.projectname.sendKeys(projectname);
			ProjectPage.projectsavebutton.click();
			Thread.sleep(2000);
			String ActualValidation = ProjectPage.editvalidationmsg.getText();
			System.out.println(ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("Check " + Message);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + Message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
			}

			Thread.sleep(3000);

			ProjectPage.projectname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		}
		ProjectPage.CancelBtn.click();
	}

	// ********************************************************************************************************
	// THE METHOD IS FOR GENERATING REPORT
	// ********************************************************************************************************
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

	public static void ContactPersonCheckEditValidation(String colname) throws IOException, InterruptedException {

		// ProjectPage.projectaddbtn.click();
		testCase = extent.createTest(colname + "CHECKING CONTACT PERSON FEILD VALIDATION");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0077";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String contactperson = (String) row.getCell(4).getStringCellValue();
			String validation = (String) row.getCell(5).getStringCellValue();
			String Message = (String) row.getCell(6).getStringCellValue();

			Thread.sleep(1000);
			ProjectPage.contactperson.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.contactperson.sendKeys(contactperson);
			ProjectPage.projectsavebutton.click();
			Thread.sleep(1000);
			String ActualValidation = ProjectPage.contatpersoneditvalidationmsg.getText();
			System.out.println(ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("Check " + Message);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + Message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
			}

			Thread.sleep(3000);

			ProjectPage.contactperson.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		}
		ProjectPage.CancelBtn.click();
	}

	public static void ContactNoCheckEditValidation(String colname) throws IOException, InterruptedException {

		// ProjectPage.projectaddbtn.click();
		testCase = extent.createTest(colname + "CHECKING CONTACT NO FEILD VALIDATION");
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0077";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String contactperson = (String) row.getCell(7).getStringCellValue();
			String validation = (String) row.getCell(8).getStringCellValue();
			String Message = (String) row.getCell(9).getStringCellValue();

			// Thread.sleep(1000);
			ProjectPage.contactnotextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
			ProjectPage.contactnotextbox.sendKeys(contactperson);
			ProjectPage.projectsavebutton.click();
			Thread.sleep(1000);
			String ActualValidation = ProjectPage.contatnoeditvalidationmsg.getText();
			System.out.println(ActualValidation);
			String ExpectedValidation = validation;
			testCase = extent.createTest("Check " + Message);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass " + Message + "Script");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail " + Message + "Script").assignCategory("High Priority");
			}

			Thread.sleep(3000);

			ProjectPage.contactnotextbox.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		}

		ProjectPage.CancelBtn.click();
	}

	public static void ProjectPlantresetButton(String colname, String colname1)
			throws InterruptedException, IOException {

		if (ProjectPage.plantSearchResetBut.isDisplayed()) {
			testCase = extent.createTest(colname + "CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON DISPLAYED ");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.plantSearchResetBut.isEnabled()) {
				testCase = extent.createTest(colname1 + "CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.plantSearchResetBut.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest(colname1 + "CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest(colname + "CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON DISPLAYED ");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void ProjectnameresetButton(String colname, String colname1)
			throws InterruptedException, IOException {

		if (ProjectPage.projectnameSearchResetBut.isDisplayed()) {
			testCase = extent
					.createTest(colname + "CHECKING PROJECT MODULE PROJECT NAME FIELD RESET BUTTON DISPLAYED ");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.projectnameSearchResetBut.isEnabled()) {
				testCase = extent
						.createTest(colname1 + "CHECKING PROJECT MODULE PROJECT NAME FIELD RESET BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.projectnameSearchResetBut.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent
						.createTest(colname1 + "CHECKING PROJECT MODULE PROJECT NAME FIELD RESET BUTTON ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent
					.createTest(colname + "CHECKING PROJECT MODULE PROJECT NAME FIELD RESET BUTTON DISPLAYED ");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void ProjectCustomerresetButton() throws InterruptedException, IOException {

		if (ProjectPage.plantSearchResetBut.isDisplayed()) {
			testCase = extent.createTest("STEP-11--CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON DISPLAYED ");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (ProjectPage.plantSearchResetBut.isEnabled()) {
				testCase = extent.createTest("STEP-12--CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					Thread.sleep(2000);
					ProjectPage.plantSearchResetBut.click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest("STEP-12--CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-11--CHECKING PROJECT MODULE PLANT FIELD RESET BUTTON DISPLAYED ");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

}
