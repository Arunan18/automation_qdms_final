//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE SUB CATEGORY MATERIAL TEST FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   20:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0059	 	 20:04:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0061
//* TC-PRO-SAM-0063
//*****************************************************************************************

/*
* Process Sample  "Sub Category"  Search Icon UI Functionality - TC-PRO-SAM-0059
* Process Sample  "Sub Category" Text Box UI Functionality - TC-PRO-SAM-0061
* Process Sample  "Sub Category"  Search Button UI Functionality -TC-PRO-SAM-0063 
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class SubCategorySearchFunctionality extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	static String ExpectedData = "";

//***************************LOGIN & REACH IN-PROCESS SAMPLE*************************

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		// ------Login-----------
		LoginTest.Login();

		// -------Reach In-Process Sample---------
		AddInprocessSampleTest.SampleMainMethod();
	}

// ***************IN-PROCESS SAMPLE COUNT NUMBER OF ELEMENTS BEFORE SEARCH**************

	@Test(priority = 1)
	public static void SampleSearchCountBeforeMethod() throws InterruptedException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(1000);
		boolean clickNextPage = true;
		int BeforeCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String NameXpath_firstPart = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[";
		String NameXpath_lastPart = "]/td[5]";
		while (clickNextPage) {

			for (int i = 2; i < 181; i++) {

				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();

					BeforestringList.add(text);
					BeforeCount = BeforeCount + 1;
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

		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("before count " + BeforeCount);
		System.out.println(BeforestringList);

	}

// ***************IN-PROCESS SAMPLE "SUB CATEGORY" SEARCH ICON METHOD***************************

	@Test(priority = 2)
	public static void InProcessSubCategorySearchiconMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		InprocessSamplePage.Inprocesssampletable.click();
		if (InprocessSamplePage.SCsearchicon.isDisplayed()) {
			testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH ICON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SCsearchicon.isEnabled()) {
				testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					boolean pass = false;
					// Thread.sleep(1000);

					for (int i = 0; i < 100; i++) {
						if (!pass) {
							try {
								InprocessSamplePage.SCsearchicon.click();
								pass = true;
							} catch (Exception e) {
							}
						}

						if (!pass) {
							Actions actions = new Actions(driver);
							actions.sendKeys(Keys.ARROW_RIGHT).perform();
							Thread.sleep(2);
						} else {
							break;
						}

					}
				} catch (Exception e) {
				}

			} else {
				testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH ICON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************IN-PROCESS SAMPLE "SUB CATEGORY" SEARCJ SCREEN METHOD************************

	@Test(priority = 3)
	public static void InProcessSubCategorySearchScreenMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		if (InprocessSamplePage.SCsearchpopup.isDisplayed()) {
			testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH SCREEN VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SCsearchpopup.isEnabled()) {
				testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH SCREEN ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.SCsearchpopup.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH TEXTBOX ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH TEXTBOX VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************IN-PROCESS SAMPLE "SUB CATEGORY" SEARCH DAATA TEXT BOX METHOD*********************

	@Test(priority = 4)
	public static void InProcessSubCategorySearchdataboxMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		if (InprocessSamplePage.Scsearchtextbox.isDisplayed()) {
			testCase = extent.createTest("SUB CATEGORY SEARCH TEXTBOX IS VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.Scsearchtextbox.isEnabled()) {
				testCase = extent.createTest("SUB CATEGORY SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.Scsearchtextbox.click();

					String excelPath = System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
					String excelSheetName = "Process Sample";
					String testCaseId = "TC-PRO-SAM-0059";

					int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
					int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

					FileInputStream file = new FileInputStream(excelPath);
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheet(excelSheetName);

					for (int i = firstRow; i <= lastRow; i++) {

						XSSFRow row = sheet.getRow(i);

						String SampleCodeSearchData = (String) row.getCell(1).getStringCellValue();
						String SampleCodeSearchconfirmData = (String) row.getCell(1).getStringCellValue();
						ExpectedData = (String) row.getCell(2).getStringCellValue();

						InprocessSamplePage.Scsearchtextbox.sendKeys(SampleCodeSearchData);
						String Value = InprocessSamplePage.Scsearchtextbox.getAttribute("value");
						TestCasePrint("CONFIRM SEARCH", SampleCodeSearchconfirmData, String.valueOf(Value));
						Thread.sleep(2000);

					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SUB CATEGORY SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SUB CATEGORY SEARCH TEXTBOX VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************IN-PROCESS SAMPLE "SUB CATEGORY" SEARCH BUTTON METHOD***********************

	@Test(priority = 5)
	public static void InProcessSubCategorySearchbuttonMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		if (InprocessSamplePage.SCsearchbutton.isDisplayed()) {
			testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.SCsearchbutton.isEnabled()) {
				testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.SCsearchbutton.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS SUB CATEGORY SEARCH BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************IN-PROCESS SAMPLE "SUB CATEGORY" SEARCH AFTER COUNT METHOD************************

	@Test(priority = 6)
	public static void SourceAftersearchButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		boolean clickNextPage = true;

		String NameXpath_firstPart = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[";
		String NameXpath_lastPart = "]/td[5]";

		ArrayList<String> AfterstringList = new ArrayList<String>();
		clickNextPage = true;
		int AfterCount = 0;

		while (clickNextPage) {

			for (int i = 2; i < 103; i++) {

				try {
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();

					AfterCount = AfterCount + 1;
					AfterstringList.add(text);
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

		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("After count " + AfterCount);
		System.out.println(AfterstringList);
		TestCasePrint("CONFIRM SUB CATEGORY SEARCH DATA", ExpectedData, String.valueOf(AfterCount));

	}

// ***********************************LOG OUT BUTTON******************************

	@Test(priority = 7)
	public static void LogoutMethod() throws InterruptedException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(1000);
		MultiSearchMethods.Logout();

	}

// *************************THE METHOD IS FOR GENERATING REPORT********************

	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) {
		boolean position = true;

		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.PASS, "TEST PASS â˜‘");
		} else {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.FAIL, "TEST FAIL â�Ž");
		}
	}

}
