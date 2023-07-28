
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE VEHICLE NUMBER RESET TEST FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   21:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0110	 	 21:04:2023     @SASIKALA     Original Version
//* 
//*****************************************************************************************

/*
* Process Sample  "Vehicle No"  Reset Button UI Functionality - TC-PRO-SAM-0110
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
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class VehicleNoResetFunction extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	@Test(priority = 0)
	public static void LoginMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

// ***************************Login Method*************************

		CheckAddMaterialCancelButtonFunctionalityTest.Login();

// ***************************Reach In-Process Sample**************

		AddInprocessSampleTest.SampleMainMethod();

	}

// ****************Count Number of elements Before search**************
	static int BeforeCount = 0;

	@Test(priority = 1)
	public static void SampleSearchCountBeforeMethod() throws InterruptedException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(2000);
		boolean clickNextPage = true;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[10]";
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

	// ***************In-Process Sample Vehicle No Search Icon Method
	// *****************************************

	@Test(priority = 2)
	public static void InProcessVehicleNoSearchiconMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		InprocessSamplePage.Inprocesssampletable.click();
		Thread.sleep(1000);

		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 100; i++) {
				if (!pass) {
					try {
						InprocessSamplePage.VNsearchicon.click();
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
		if (InprocessSamplePage.VNsearchicon.isDisplayed()) {
			testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH ICON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.VNsearchicon.isEnabled()) {
				testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
			} else {
				testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH ICON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH ICON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
	// ***************In-Process Sample Vehicle No Search Screen Method
	// ****************************************

	@Test(priority = 3)
	public static void InProcessVehicleNoSearchScreenMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(2000);
		if (InprocessSamplePage.VNsearchpopup.isDisplayed()) {
			testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH SCREEN VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.VNsearchpopup.isEnabled()) {
				testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH SCREEN ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.VNsearchpopup.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH TEXTBOX ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS VEHICLE NUMBER SEARCH TEXTBOX VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// ***************In-Process Sample Vehicle No Search Data Text Box Method
	// ***************************************

	@Test(priority = 4)
	public static void InProcessVehicleNoSearchdataboxMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		if (InprocessSamplePage.VNsearchtextbox.isDisplayed()) {
			testCase = extent.createTest("VEHICLE NUMBER SEARCH TEXTBOX IS VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.VNsearchtextbox.isEnabled()) {
				testCase = extent.createTest("VEHICLE NUMBER SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.VNsearchtextbox.click();

					String excelPath = System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
					String excelSheetName = "Process Sample";
					String testCaseId = "TC-PRO-SAM-0110";

					int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
					int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

					FileInputStream file = new FileInputStream(excelPath);
					XSSFWorkbook workbook = new XSSFWorkbook(file);
					XSSFSheet sheet = workbook.getSheet(excelSheetName);

					for (int i = firstRow; i <= lastRow; i++) {

						XSSFRow row = sheet.getRow(i);

						String SampleCodeSearchData = (String) row.getCell(1).getStringCellValue();
						String SampleCodeSearchconfirmData = (String) row.getCell(1).getStringCellValue();

						InprocessSamplePage.VNsearchtextbox.sendKeys(SampleCodeSearchData);
						String Value = InprocessSamplePage.VNsearchtextbox.getAttribute("value");
						TestCasePrint("CONFIRM VEHICLE NUMBER SEARCH", SampleCodeSearchconfirmData,
								String.valueOf(Value));
						Thread.sleep(2000);

					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("VEHICLE NUMBER SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("VEHICLE NUMBER SEARCH TEXTBOX VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// ***************In-Process Sample Raw Material Reset button Method ****************************************
	@Test(priority = 5)
	public static void InProcessCodeResetbuttonMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		Thread.sleep(2000);
		if (InprocessSamplePage.VNreseticon.isDisplayed()) {
			testCase = extent.createTest("INPROCESS VEHICLE NUMBER RESET BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.VNreseticon.isEnabled()) {
				testCase = extent.createTest("INPROCESS VEHICLE NUMBER RESET BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.VNreseticon.click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("INPROCESS VEHICLE NUMBER RESET BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("INPROCESS  RESET BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		String Values = InprocessSamplePage.VNreseticon.getAttribute("Value");
		TestCasePrint("CONFIRM RESET", "null", String.valueOf(Values));
		Thread.sleep(2000);
	}

	// ***************In-Process Sample Code Search After Count Method
	// *****************************************
	static int AfterCount = 0;

	@Test(priority = 6)
	public static void SourceAftersearchButton() throws InterruptedException, IOException {

		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		boolean clickNextPage = true;

		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[10]";

		ArrayList<String> AfterstringList = new ArrayList<String>();
		clickNextPage = true;
		// int AfterCount = 0;

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

	}

	/***************************************************************************************
	 * Reset Before After Counting Check
	 ***************************************************************************************/

	@Test(priority = 7)
	public static void CheckBeforeAfterCount() throws InterruptedException {

		try {
			testCase = extent.createTest("BEFORE AFTER DATA COUNTS ");
			try {
				Assert.assertEquals(AfterCount, BeforeCount);
				testCase.log(Status.INFO, "Before Data Counts :- " + BeforeCount);
				testCase.log(Status.INFO, "After Data Counts :- " + AfterCount);
				testCase.log(Status.PASS, "Correct Before & After Data Counts Are Same");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Before Data Counts :- " + BeforeCount);
				testCase.log(Status.INFO, "After Data Counts:- " + AfterCount);
				testCase.log(Status.FAIL, "Wrong Before & After Data Counts Are Not Same");

			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("CHECKING BEFORE AFTER DATA COUNTS FAILED BECAUSE OF NO ELEMENTS");
		}
	}

// ***********************************LOG OUT BUTTON******************************

	@Test(priority = 8)
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
