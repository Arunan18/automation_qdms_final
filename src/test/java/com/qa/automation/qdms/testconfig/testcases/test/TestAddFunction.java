//***********************************************************************************
//* Description
//*------------
//*Edit Function TestCase - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-Test-0022      26/04/2023      Saranka     Original Version
//                    07/07/2023      RAHUL.S      modified
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestAddFunction extends DriverIntialization {

	static TestConfigPage addPage = new TestConfigPage();
	static TestAddFunction methods = new TestAddFunction();
	static String AddData = null;
	public static boolean clickTestConfig = false;
	public static boolean clickTest = false;
	public static boolean clickAddButton = false;
	public static boolean BtnVisible = true;
	public static boolean BtnEnable = true;
	static boolean vali = false;
	static String validation = null;
	public static boolean testconfirm = false;
	public static boolean testnavigate = false;
	static DataFormatter dataValue = new DataFormatter();

	@Test
	public void MethodCalling() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);

//============================================================ M E T H O D ==================================================================

//__________________________________________________________
//  LOGIN
//__________________________________________________________		

		LoginTest.Login();

//__________________________________________________________
//   NAVIGATE TO TEST
//__________________________________________________________		
		if (!testnavigate) {
			TestAddFunction.naviagteToTest();
		}
//_________________________________________________________
//  EXCECL METHOD
//__________________________________________________________		
		// TestAddFunction.ExcelMethod();
		if (testnavigate) {
			inputTestValue("TC-Test-0022", "Test", "");

			// LOGOUT
		}
		Logout.LogoutFunction();

	}

//============================================================ T E S T C A S E S ==================================================================

//____________________________________________________________
//  NAVIGATE TO TEST
//____________________________________________________________

	public static void naviagteToTest() throws InterruptedException {
		PageFactory.initElements(driver, addPage);

		// NAVIGATE TO TEST CONFIGURATION
		if (!testnavigate) {
//			SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES",
//					TestConfigPage.testconfigurationcard, "TEST CONFIGURATION CARD DISPLAYED",
//					"TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
//					"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			TestConfigNavigation.TestConfigurationCard();
			// NAVIGATE TO TEST SIDE BUTTON

//			SampleCommonMethods.methodoneclick("STEP:1 TEST PROPERTIES", TestConfigPage.TestNavigation,
//					"TEST SIDE BUTTON IS DISPLAY", "TEST SIDE BUTTON IS ENABLED", TestConfigPage.ParameterText,
//					"TEST SIDE BUTTON", "ON CLICK THE TEST BUTTON IT'S REDERECT TO CORRECT FORM");
			Thread.sleep(2000);
			TestConfigPage.TestBtn.click();
			Thread.sleep(2000);
			testnavigate = true;
		}

	}

	static String testName = "";
	static String SuccessMsg = "";
	static boolean inputValue = false;
	public static boolean clickSaveBtn = false;

	public static void inputTestValue(String testcaseId, String tabName, String TestCaseBefore) {
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		inputValue = false;
		clickSaveBtn = false;
		PageFactory.initElements(driver, addPage);
		try {
			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
					tabName, testcaseId);
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
					tabName, testcaseId);
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(tabName);
			for (int i = firstrow; i <= lastrow; i++) {
				XSSFRow row = sheet.getRow(i);
				SuccessMsg = "";
				testName = "";
				testName = dataValue.formatCellValue(row.getCell(1));

				SuccessMsg = dataValue.formatCellValue(row.getCell(2));

				clickAddTestBtn("ADD TEST BUTTON");

				if (clickAddButton) {
					textBox(TestConfigPage.PlaceHolderTestName, TestCaseBefore + "TEST TEXTBOX");
					if (BtnVisible && BtnEnable) {
						TestConfigPage.PlaceHolderTestName.sendKeys(testName);
					}

					inputValue = true;
				}
				clickSaveBtn = false;
				if (inputValue) {
					Button(TestConfigPage.savebtn, TestCaseBefore + "TEST SAVE");
					if (BtnVisible && BtnEnable) {

						TestConfigPage.savebtn.click();
						clickSaveBtn = true;
					}
				}
				if (clickSaveBtn) {
					addedValueCheck();
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
			testCase = extent.createTest("Excel File Not Found");
			testCase.log(Status.INFO, "Excel File Not Found");
			testCase.log(Status.FAIL, "Excel File Not Found, So fail");
		}
	}

	public static void clickAddTestBtn(String TestCase) throws InterruptedException {
		clickAddButton = false;
		PageFactory.initElements(driver, addPage);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.addButton));
		Button(TestConfigPage.addButton, "Add TEST");
		if (BtnVisible && BtnEnable) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.addButton));
				TestConfigPage.addButton.click();
				clickAddButton = true;
			} catch (Exception e) {
				testCase = extent.createTest("ADD TEST BUTTON CLICK");
				testCase.log(Status.INFO, "Add Test Button Clicked Fail");
				testCase.log(Status.FAIL, "Test Save Button not Visible, Button Clicked Fail");
			}
		}

		if (clickAddButton) {
			testCase = extent.createTest("ADD TEST BUTTON FUNCTIONALITY");
			try {
				wait.until(ExpectedConditions.visibilityOf(TestConfigPage.addTestPopUP));
				Assert.assertEquals(TestConfigPage.addTestPopUP.isDisplayed(), true);
				testCase.log(Status.INFO, "Add Test Pop Up Visible");
				testCase.log(Status.PASS, "So, Test TEST Button Functionality Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Add Test Pop Up Not Visible");
				testCase.log(Status.FAIL, "Add Test Button Functionality Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Add Test Pop Up Not Visible");
				testCase.log(Status.FAIL, "Add Test Button Functionality Fail");
			}
		}
	}

	public static void addedValueCheck() throws InterruptedException {
		PageFactory.initElements(driver, addPage);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		testconfirm = false;
		boolean testSaveBtnVisible = false;

		try {
//		wait.until(ExpectedConditions.invisibilityOf(TESTPage.addTESTBtn));
			Thread.sleep(1000);
			Assert.assertEquals(TestConfigPage.savebtn.isDisplayed(), true);
			testSaveBtnVisible = true;
		} catch (AssertionError e) {
			testSaveBtnVisible = false;
		} catch (Exception e) {
			testSaveBtnVisible = false;
		}
		if (testSaveBtnVisible) {
			try {
				wait.until(ExpectedConditions.visibilityOf(TestConfigPage.testValidation));
				validation = TestConfigPage.testValidation.getText();

				vali = true;
			} catch (Exception e) {
				vali = false;
			}

			if (vali) {
				validation();
				testCase = extent.createTest("Add Test Function");
				if (exit) {
//					testCase.log(Status.INFO, "Already Exits Validation Throwing");
//					testCase.log(Status.INFO, "But, Already Exits Validation is Confirmed");
//					testCase.log(Status.PASS, "Add TEST Function is Pass");
					testCase.log(Status.INFO, validation + " message hrowing");
					testCase.log(Status.FAIL, "Add Test Function is Fail");
				}
//				else {
//					testCase.log(Status.INFO, "Already Exits Validation Throwing");
//					testCase.log(Status.INFO, "But, Already Exits Validation Not Confirmed");
//					testCase.log(Status.FAIL, "Add Test Function is Fail");
//				}
				testconfirm = true;
			}
		} else {
			boolean success = false;
			testCase = extent.createTest("TEST :- " + testName + " - Adding Success Message");
			try {
				Assert.assertEquals(TestConfigPage.successMessages.getText(), SuccessMsg);
				testCase.log(Status.INFO, "Actual Success Message :- " + TestConfigPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.PASS, "Success Message  Matching, So Throwing Success Message Pass");
				success = true;
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + TestConfigPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			} catch (Exception e) {
				testCase.log(Status.INFO, "Actual Success Message :- " + TestConfigPage.successMessages.getText());
				testCase.log(Status.INFO, "Expected Success Message :- " + SuccessMsg);
				testCase.log(Status.FAIL, "Success Message Not Matching, So Throwing Success Message Fail");
			}

			boolean firstRow = false;
			testCase = extent.createTest("TEST :- " + testName + " - Added Value Check In First Row");

			try {
				Thread.sleep(2000);
				Assert.assertEquals(TestConfigPage.firstRowData.getText(), testName);
				testCase.log(Status.INFO, "TEST :- " + testName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Founded In First Row");
				testCase.log(Status.PASS, "So, Add TEST Script Pass");
				firstRow = true;
				testconfirm = true;
			} catch (Exception e) {
				testCase.log(Status.INFO, "TEST :- " + testName + " Added Check in First Row");
				testCase.log(Status.INFO, "Added Value Not Founded In First Row");
				testCase.log(Status.FAIL, "So, Add TEST Script Fail");
			}

			if (success) {

				try {
					TestConfigPage.successMessageCloseBtn.click();
				} catch (Exception e) {

				}
			}
			if (firstRow) {
			} else {
				int counts = 0;

				boolean enable = true;
				while (enable) {
					WebDriverWait wai = new WebDriverWait(driver, 2);

					int x = 0;
					try {

						wai.until(ExpectedConditions.visibilityOfAllElements(
								driver.findElements(By.xpath("//td[1][text()='" + testName + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + testName + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}
					counts = counts + x;
					try {
						enable = TestConfigPage.NextPageBtn.isEnabled();
//		Click Next page Button
						if (enable) {

							TestConfigPage.NextPageBtn.click();
							wai.until(
									ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
						}
					} catch (Exception e) {

					}

				}

				testCase = extent.createTest("TEST :- " + testName + " - Added Value Check In TEST Table");
				if (counts == 1) {
					testCase.log(Status.INFO, "TEST :- " + testName + " Added Check in TEST Table");
					testCase.log(Status.INFO, "Added Value Founded In TEST Table");
					testCase.log(Status.PASS, "So, Add TEST Script Pass");
					testconfirm = true;
				} else {
					testCase.log(Status.INFO, "TEST :- " + testName + " Added Check in TEST Table");
					testCase.log(Status.INFO, "Added Value Duplicate In TEST Table");
					testCase.log(Status.FAIL, "So, Add TEST Script Fail");
				}
			}
			driver.navigate().refresh();
		}

	}

	/*********************************************************************************************************************************************************
	 * textBox Properties - (Visible, Enable)
	 **********************************************************************************************************************************************************/
	public static void textBox(WebElement searchbtn, String colName) {
		PageFactory.initElements(driver, addPage);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		testCase = extent.createTest(colName + " textBox - Visible");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase.log(Status.INFO, colName + " textBox Visible");
			testCase.log(Status.PASS, colName + " textBox Visible Script Pass");
		} catch (AssertionError e) {
			BtnVisible = false;
			testCase.log(Status.INFO, colName + " textBox Not Visible");
			testCase.log(Status.FAIL, colName + " textBox Not Visible");
		} catch (NoSuchElementException e) {
			BtnEnable = false;
			testCase.log(Status.INFO, "Dont have " + colName + " textBox Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " textBox Locator");
		}
//		Search Icon Enable
		if (BtnVisible) {
			testCase = extent.createTest(colName + " textBox - Enable");
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase.log(Status.INFO, colName + " textBox Enable");
				testCase.log(Status.PASS, colName + " textBox Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase.log(Status.INFO, colName + " textBox Not Enable");
				testCase.log(Status.FAIL, colName + " textBox Not Enable");
			}
			if (BtnVisible && BtnEnable) {

			}
		}

	}

	public static void Button(WebElement searchbtn, String colName) {
		PageFactory.initElements(driver, addPage);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		testCase = extent.createTest(colName + " Button - Visible");
		try {

			wait.until(ExpectedConditions.visibilityOf(searchbtn));
			Assert.assertEquals(searchbtn.isDisplayed(), true);
			testCase.log(Status.INFO, colName + " Button Visible");
			testCase.log(Status.PASS, colName + " Button Visible Script Pass");
		} catch (AssertionError e) {
			BtnVisible = false;
			testCase.log(Status.INFO, colName + " Button Not Visible");
			testCase.log(Status.FAIL, colName + " Button Not Visible");
		} catch (NoSuchElementException e) {
			BtnEnable = false;
			testCase.log(Status.INFO, "Dont have " + colName + " Button Locator");
			testCase.log(Status.FAIL, "Dont have " + colName + " Button Locator");
		}
//		Search Icon Enable
		if (BtnVisible) {
			testCase = extent.createTest(colName + " Button - Enable");
			try {
				wait.until(ExpectedConditions.visibilityOf(searchbtn));
				Assert.assertEquals(searchbtn.isEnabled(), true);
				testCase.log(Status.INFO, colName + " Button Enable");
				testCase.log(Status.PASS, colName + " Button Enable Script Pass");
			} catch (AssertionError e) {
				BtnEnable = false;
				testCase.log(Status.INFO, colName + " Button Not Enable");
				testCase.log(Status.FAIL, colName + " Button Not Enable");
			}
			if (BtnVisible && BtnEnable) {

			}
		}

	}

	static boolean exit = false;

	public static void validation() {

		if (validation.contains("Name can't be empty")) {
			testCase = extent.createTest("Empty Validation Throwing");
			try {
				String val = TestConfigPage.testValidation.getText();
				testCase = extent.createTest("Empty Validation Confirmation For TEST :- " + testName);
				if (val == "") {
					exit = false;
					testCase.log(Status.INFO, "TEST Data is :- " + val);
					testCase.log(Status.INFO, "TEST Data is Empty");
					testCase.log(Status.PASS, "So, Empty Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "TEST Data is :- " + val);
					testCase.log(Status.INFO, "TEST Data is not Empty");
					testCase.log(Status.PASS, "So, Empty Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
		} else if (validation.contains("Test Name is Already Exist")) {
			testCase = extent.createTest("Already Exists Validation Throwing For TEST :- " + testName);
			try {
				String val = TestConfigPage.testValidation.getText();
				testCase = extent.createTest("Already Validation Confirmation For TEST :- " + testName);
				if (val == "") {
					exit = false;
					testCase.log(Status.INFO, "TEST Data is :- " + val);
					testCase.log(Status.INFO, "TEST Data is already exist ");
					testCase.log(Status.PASS, "So, Already data exist Validation Correct");
					exit = true;
				} else {
					testCase.log(Status.INFO, "TEST Data is :- " + val);
					testCase.log(Status.INFO, "TEST Data is not already exist");
					testCase.log(Status.PASS, "So, Already data exist Validation Wrong");

				}
			} catch (Exception e) {

			}
			driver.navigate().refresh();
			boolean checkValue = false;

			boolean enable = true;
			while (enable) {

				int x = 0;
				try {
					WebDriverWait wai = new WebDriverWait(driver, 5);
					wai.until(ExpectedConditions.visibilityOfAllElements(
							driver.findElements(By.xpath("//td[1][text()='" + testName + "']"))));
					System.out.println("//td[1][text()='" + testName + "']");
					x = driver.findElements(By.xpath("//td[1][text()='" + testName + "']")).size();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (x == 1) {
					checkValue = true;
					break;
				}
				try {
					enable = TestConfigPage.NextPageBtn.isEnabled();
//			Click Next page Button
					if (enable) {

						TestConfigPage.NextPageBtn.click();
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					}
				} catch (Exception e) {

				}

			}
			testCase = extent.createTest("Already Exists Validation Confirmation For TEST :- " + testName);
			if (checkValue) {
				exit = false;
				testCase.log(Status.INFO, "TEST :- " + testName + " Already Exits in TEST Table");
				testCase.log(Status.INFO, "TEST :- " + testName + " Founded In TEST Table");
				testCase.log(Status.PASS, "So, Already Exists Validation Correct");
				exit = true;
			} else {
				testCase.log(Status.INFO, "TEST :- " + testName + " Not in TEST Table");
				testCase.log(Status.INFO, "Added Value Not Founded In TEST Table");
				testCase.log(Status.FAIL, "So, System  Fail");
			}

		} else {
			testCase = extent.createTest("Any Validation Not Throwing");
			testCase.log(Status.INFO, "TEST Added Fail");
			testCase.log(Status.FAIL, "Validation Not Throwing, So TEST Added Fail");
			driver.navigate().refresh();
		}
	}

	public static boolean areAllLetters(String word) {
		return word.matches("[a-zA-Z]+");
	}

}