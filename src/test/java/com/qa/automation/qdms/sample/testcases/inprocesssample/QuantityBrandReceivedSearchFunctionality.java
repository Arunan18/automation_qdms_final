
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE QUALITY & BRAND RECEIVED SEARCH TEST FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   28:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0149	 	 28:04:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0151
//* TC-PRO-SAM-0153
//*****************************************************************************************

/*
* Process Sample  "QUALITY & BRAND RECEIVED"  Search Icon UI Functionality - TC-PRO-SAM-0149
* Process Sample  "QUALITY & BRAND RECEIVED" Text Box UI Functionality - TC-PRO-SAM-0151
* Process Sample  "QUALITY & BRAND RECEIVED"  Search Button UI Functionality -TC-PRO-SAM-0153 
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
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class QuantityBrandReceivedSearchFunctionality extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	static int ExpectedData = 0;
	static String QBRSearchconfirmData = "";

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// ***************************Login Method*************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// ***************************Reach In-Process Sample**************

		AddInprocessSampleTest.SampleMainMethod();

	}
// ****************Count Number of elements Before search**************

	@Test(priority = 1)
	public static void SampleSearchCountBeforeMethod() throws InterruptedException {
		PageFactory.initElements(driver, inprocesssample);
		boolean clickNextPage = true;
		int BeforeCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[15]";
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
// ***************In-Process Sample QUALITY & BRAND RECEIVED Search Icon Method*****************************************

	@Test(priority = 2)
	public static void InProcessCodeSearchiconMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		InprocessSamplePage.Inprocesssampletable.click();
		Thread.sleep(2000);
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 100; i++) {
				if (!pass) {
					try {
						InprocessSamplePage.QBRsearchicon.click();
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

		if (InprocessSamplePage.QBRsearchicon.isDisplayed()) {
			testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH ICON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			Thread.sleep(2000);
			if (InprocessSamplePage.QBRsearchicon.isEnabled()) {
				testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				Thread.sleep(1000);

			} else {
				testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH ICON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
	// ***************In-Process Sample QUALITY & BRAND RECEIVED Search Screen
	// Method ****************************************

	@Test(priority = 3)
	public static void InProcessRawMaterialSearchScreenMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(2000);
		if (InprocessSamplePage.QBRsearchpopup.isDisplayed()) {
			testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH SCREEN VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.QBRsearchpopup.isEnabled()) {
				testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH SCREEN ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.QBRsearchpopup.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH TEXTBOX ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS RAW MATERIAL SEARCH TEXTBOX VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************In-Process Sample QUALITY & BRAND RECEIVED Search Data Text Box Method***************************************

	@Test(priority = 4)
	public static void InProcessQUALITYBRANDRECEIVEDSearchdataboxMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		if (InprocessSamplePage.QBRsearchtextbox.isDisplayed()) {
			testCase = extent.createTest("QUALITY & BRAND RECEIVED SEARCH TEXTBOX IS VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.QBRsearchtextbox.isEnabled()) {
				testCase = extent.createTest("QUALITY & BRAND RECEIVED SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.QBRsearchtextbox.click();

					String excelPath = System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
					String excelSheetName = "Process Sample";
					String testCaseId = "TC-PRO-SAM-0149";

					int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
					int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

					FileInputStream file = new FileInputStream(excelPath);
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheet(excelSheetName);

					for (int i = firstRow; i <= lastRow; i++) {

						XSSFRow row = sheet.getRow(i);

						String SampleCodeSearchData = (String) row.getCell(1).getStringCellValue();
						String QBRSearchconfirmData = (String) row.getCell(1).getStringCellValue();
						ExpectedData = (int) row.getCell(2).getNumericCellValue();

						InprocessSamplePage.QBRsearchtextbox.sendKeys(SampleCodeSearchData);
						String Value = InprocessSamplePage.QBRsearchtextbox.getAttribute("value");
						TestCasePrint("CONFIRM QUALITY & BRAND RECEIVED SEARCH", QBRSearchconfirmData,
								String.valueOf(Value));
						Thread.sleep(2000);

					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("QUALITY & BRAND RECEIVED SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("QUALITY & BRAND RECEIVED SEARCH TEXTBOX VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************In-Process Sample QUALITY & BRAND RECEIVED Search button Method****************************************
	@Test(priority = 5)
	public static void InProcessRawMaterialSearchbuttonMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		System.out.println("************************");

		if (InprocessSamplePage.QBRsearchbutton.isDisplayed()) {
			testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.QBRsearchbutton.isEnabled()) {
				testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.QBRsearchbutton.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS QUALITY & BRAND RECEIVED SEARCH BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************In-Process Sample Code Search After Count Method*****************************************

	@Test(priority = 6)
	public static void SourceAftersearchButton() throws InterruptedException, IOException {

		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		boolean clickNextPage = true;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[15]";

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
		TestCasePrint("CONFIRM SEARCH DATA", String.valueOf(ExpectedData), String.valueOf(AfterCount));

	}

// ***********************************LOG OUT BUTTON******************************

	@Test(priority = 7)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		PageFactory.initElements(driver, inprocesssample);
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
