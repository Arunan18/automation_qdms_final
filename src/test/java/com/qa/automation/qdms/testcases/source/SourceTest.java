
//****************************************************************************************
//		DESCRIPTION
//------------------
//					ADD SOURCE BUTTON & ADD SOURCE TEST FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   09:03:2023	
//****************************************************************************************
//* Test Case Number 	Date          Intis        Comments
//* =================	======      ========       ========
//* TC-SRC-0025 	  09.03.2023     @SASIKALA     Original Version("Add Source" Button Functionality)
//* TC-SRC-0031       09.03.2023     @SASIKALA     Original Version (Add Source  Functionality)
//************************************************************************************

/*
 * Common Method Calling
 * 			
 *  Step:-01 -- Login
 *  Step:-02 -- Click Master
 *  Step:-03 -- Click Material Top Bar
 *  Step:-04 -- Click Source Site Bar
 *  Step:-05 -- Add Source Button
 *  Step:-06 -- Check Model Source
 *  Step:-07 -- Check 2 Field Source & Description
 *  Step:-08 -- Save Button Function
 *  Step:-09 -- Check Model Source Close
 *  Step:-10 -- If Any Validation Happened Check (Already Exist , etc..)
 *  step:-11 -- After Save Check PopUp Success Message
 *  step:-12 -- Save After Check Table
 *  step:-13 -- Last Added First Row Check
 *  
 */
package com.qa.automation.qdms.testcases.source;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class SourceTest extends DriverIntialization {
	static SourcePage sourcepg = new SourcePage();
	static String sourcesuccessmsg = "";
	static String sourcefieldname = "";
	public static boolean work = false;

	// Common Method Calling
	@Test
	public static void addSoureCommonFunctionCalling() throws InterruptedException, IOException {
		PageFactory.initElements(driver, sourcepg);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		testCase = extent.createTest("TC-SRC-0031 - Source Add Function".toUpperCase());
		// Call Login Function
		LoginTest.Login();

		// Master Card Click
		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Master));
		CommonMethod(SourcePage.Master, "Master Card");

		// Click Material Top Bar
		if (work) {
			CommonMethod(SourcePage.Materialtopbar, "Material Top Bar");
		}

		// Click Source Site Bar
		if (work) {
			CommonMethod(SourcePage.sourcesitebar, "Source Side Button");
		}

		// Excel Added Details
		if (work) {
			ExcelMethodForSource();
		}

		// Logout Function
		MultiSearchMethods.Logout();

	}

	static boolean popup = false;

//******************Check the PopUp Screen Add Source Button************************	
	public static void AddSourcePopUpVisible() {
		popup = false;
		try {
			SourcePage.Sourceheader.isDisplayed();
			testCase = extent.createTest("Add Source PopUp Displayed");
			testCase.log(Status.INFO, "Expected Displayed:- Add Source PopUp Displayed");
			testCase.log(Status.PASS, " Correct");
			popup = true;
		} catch (Exception e) {
			testCase = extent.createTest("Add Source PopUp Not Displayed");
			testCase.log(Status.INFO, "Expected Displayed:- Add Source PopUp Not Displayed");
			testCase.log(Status.FAIL, "Wrong");
		}

	}

//*************************Excel Method***********************
	static boolean input = false;
	static boolean save = false;

	public static void ExcelMethodForSource() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Source");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Source",
				"TC-SRC-0031");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Source",
				"TC-SRC-0031");
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			sourcefieldname = (String) row.getCell(1).getStringCellValue();
			String sourceDescfieldname = (String) row.getCell(2).getStringCellValue();
			sourcesuccessmsg = (String) row.getCell(3).getStringCellValue();
			CommonMethod(SourcePage.AddSourcebtn, "Add Source Button");
			if (work) {
				// Check The PopUp Screen
				AddSourcePopUpVisible();
			}
			if (popup) {
				// Wait until SourceField
				wait.until(ExpectedConditions.elementToBeClickable(SourcePage.sourcefiled));

				// Check The Source Field
				CommonMethod(SourcePage.sourcefiled, "Source Field");
			}
			if (work) {
				input = false;
				SourcePage.sourcefiled.sendKeys(sourcefieldname);
				SourcePage.sourceDescFied.sendKeys(sourceDescfieldname);
				input = true;
			}

			if (input) {
				// Click Save Button
				CommonMethod(SourcePage.sourceSavebtn, "Source Save Button");
				
			}
			
			if (work) {
				check();
			}

		}
	}
//**********************************************************************
	// Click Save Button Function

	public static void PopUpCloseFunction() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean ExpectedPopUpVisible = false;
		boolean ActualPopUpVisible = true;
		testCase = extent.createTest("ADD-SOURCE-POPUP-SCREEN-CLOSE-SUCESSFULLY");
		try {
			ExpectedPopUpVisible = false;
			wait.until(ExpectedConditions.invisibilityOf(SourcePage.sourceSavebtn));
			ActualPopUpVisible = SourcePage.sourceSavebtn.isDisplayed();
			System.out.println(ActualPopUpVisible);

			Assert.assertEquals(ActualPopUpVisible, ExpectedPopUpVisible);
			testCase.log(Status.INFO, "Actual Visible :- " + ActualPopUpVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedPopUpVisible);
			testCase.log(Status.PASS, " Correct");

		} catch (AssertionError e) {
			System.out.println("Not Visible PopUp Screen");
			testCase.log(Status.INFO, "ActualVisible :- " + ActualPopUpVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedPopUpVisible);
			testCase.log(Status.FAIL, "Wrong");

		} catch (Exception e) {
			System.out.println("Not Visible PopUp Screen");
			testCase.log(Status.INFO, "ActualVisible :- " + ActualPopUpVisible);
			testCase.log(Status.INFO, "Expected Visible :- " + ExpectedPopUpVisible);
			testCase.log(Status.FAIL, "Wrong");
		}

	}

	// *************************************************
	// If Any Validation Happened Check (Already Exist , etc..)

	public static void SourceValidation() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean val = false;
		String validation = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(SourcePage.SourceFieldValidation));
			validation = SourcePage.SourceFieldValidation.getText();
			val = true;
		} catch (Exception e) {
			val = false;
		}
		if (val) {
			if (validation.contains("Source can't be empty")) {
				testCase = extent.createTest("Empty Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "Source Added Fail");
				testCase.log(Status.FAIL, "Empty Validation Throwing, So Source Added Fail");
				driver.navigate().refresh();
			} else if (validation.contains("Source already exists")) {
				testCase = extent.createTest("Already Exists Validation Throwing For Source :- " + sourcefieldname);
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "Source Added Fail");
				testCase.log(Status.FAIL, "Already Exists Validation Throwing, So Source Added Fail");
				driver.navigate().refresh();
				boolean checkValue = false;

				boolean enable = true;
				while (enable) {

					int x = 0;
					try {
						WebDriverWait wai = new WebDriverWait(driver, 5);
						wai.until(ExpectedConditions.visibilityOfAllElements(
								driver.findElements(By.xpath("//td[1][text()='" + sourcefieldname + "']"))));
						x = driver.findElements(By.xpath("//td[1][text()='" + sourcefieldname + "']")).size();
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (x == 1) {
						checkValue = true;
						break;
					}
					try {
						SbuPage.NextPageBtn.click();
						WebDriverWait wai = new WebDriverWait(driver, 2);
						wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
					} catch (Exception e) {

					}
				}
				testCase = extent.createTest("Already Exists Validation Conformation For Source :- " + sourcefieldname);
				if (checkValue) {
					testCase.log(Status.INFO, "Source :- " + sourcefieldname + " Already Exits in Source Table");
					testCase.log(Status.INFO, "Source :- " + sourcefieldname + " Founded In Source Table");
					testCase.log(Status.FAIL, "So, Add Source Script Fail");
				} else {
					testCase.log(Status.INFO, "Source :- " + sourcefieldname + " Not in Source Table");
					testCase.log(Status.INFO, "Added Value Not Founded In Source Table");
					testCase.log(Status.FAIL, "So, System  Fail");
				}

			} else if (validation.contains("Only 3 characters long!")) {
				testCase = extent.createTest("Added Data Lenth Not Match Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "Source Added Fail");
				testCase.log(Status.FAIL, "Added Data Lenth Not Match Validation Throwing, So Source Added Fail");
				driver.navigate().refresh();

			} else if (validation.contains("Source allow only letters")) {
				testCase = extent.createTest("Wrong Characters Validation Throwing");
				testCase.log(Status.INFO, "Validation :- " + validation);
				testCase.log(Status.INFO, "Source Added Fail");
				testCase.log(Status.FAIL, "Wrong Characters Validation Throwing, So Source Added Fail");
				driver.navigate().refresh();
			} else {
				testCase = extent.createTest("Any Validation Not Throwing");
				testCase.log(Status.INFO, "SBU Added Fail");
				testCase.log(Status.FAIL, "Validation Not Throwing, So SBU Added Fail");
				driver.navigate().refresh();
			}
		}
	}

	// *************************************************
	// After Save Check PopUp Success Message

	public static void SavePopUpSuccessMsg() throws InterruptedException {

		String expectedatamsg = "";
		String AddSuccessMessage = null;

		try {
			Thread.sleep(1000);
			AddSuccessMessage = SourcePage.AddSourcesuccessmsg.getText();
			expectedatamsg = sourcesuccessmsg;

			testCase = extent.createTest("Data Added Success Message");

			Assert.assertEquals(AddSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Success Message Enable");

		} catch (AssertionError e) {

			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}
	}

//*************************************************************************
	// CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
static boolean firstRow=false;
	public static void checkLastAddvalue() throws InterruptedException, IOException {
		firstRow=false;
		SourcePage Sourcepg = new SourcePage();
		PageFactory.initElements(driver, Sourcepg);

		boolean firstdata = true;
		String actualdata = "";
		String expecteddata = "";

		try {
			expecteddata = sourcefieldname;
			Thread.sleep(2000);
			actualdata = SourcePage.lastaddedfirstdata.getText();
			System.out.println("First row of table : " + actualdata);
			System.out.println("First row of table : " + expecteddata);

			testCase = extent.createTest("CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");

			AssertJUnit.assertEquals(actualdata, expecteddata);

			if (firstdata) {
				testCase.log(Status.INFO, "Actual Data :- " + actualdata);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.PASS, "Correct last added data");
				firstRow=true;
			}
		} catch (AssertionError e) {
			firstdata = false;

		} catch (Exception e) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}

//************************************************************************************
//	Check The Data Added Or Not In Full Table

	public static void CheckFullTable() {

		int counts = 0;

		boolean enable = true;
		while (enable) {
			WebDriverWait wai = new WebDriverWait(driver, 2);

			int x = 0;
			try {

				wai.until(ExpectedConditions.visibilityOfAllElements(
						driver.findElements(By.xpath("//td[1][text()='" + sourcefieldname + "']"))));
				x = driver.findElements(By.xpath("//td[1][text()='" + sourcefieldname + "']")).size();
			} catch (Exception e) {
				e.printStackTrace();
			}
			counts = counts + x;
			enable = SourcePage.NextPageBtn.isEnabled();
//    Click Next page Button
			if (enable) {
				try {
					SourcePage.NextPageBtn.click();
					wai.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tr"))));
				} catch (Exception e) {

				}
			}
		}

		testCase = extent.createTest("Source :- " + sourcefieldname + " - Added Value Check In Source Table");
		if (counts == 1) {
			testCase.log(Status.INFO, "Source :- " + sourcefieldname + " Added Check in Source Table");
			testCase.log(Status.INFO, "Added Value Founded In Source Table");
			testCase.log(Status.PASS, "So, Add Source Script Pass");
		} else {
			testCase.log(Status.INFO, "Source :- " + sourcefieldname + " Added Check in Source Table");
			testCase.log(Status.INFO, "Added Value Duplicate In Source Table");
			testCase.log(Status.FAIL, "So, Add Source Script Fail");
		}

	}

//****************************************************************************************
	/*
	 * Any Button Click Use This Method Here I have Checked Enable & Disable
	 * Individual -- At the same time i have checked Both enable & displayed only
	 * Able to click Button
	 */

	public static void CommonMethod(WebElement Button, String ReportName) throws InterruptedException {
		work = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			if (Button.isDisplayed()) {
				testCase = extent.createTest(ReportName + " Displayed");
				testCase.log(Status.INFO, "Expected Displayed:- " + ReportName + " Displayed");
				testCase.log(Status.PASS, " Correct");

			} else {
				testCase = extent.createTest(ReportName + " Not Displayed");
				testCase.log(Status.INFO, "Expected Displayed:- " + ReportName + " Not Displayed");
				testCase.log(Status.FAIL, " Wrong");
			}

			if (Button.isEnabled()) {
				testCase = extent.createTest(ReportName + " Enabled");
				testCase.log(Status.INFO, "Expected Enabled:- " + ReportName + " Enabled");
				testCase.log(Status.PASS, " Correct");

			} else {
				testCase = extent.createTest(ReportName + " Not Enabled");
				testCase.log(Status.INFO, "Expected Enabled:-" + ReportName + " Not Enabled");
				testCase.log(Status.FAIL, " Correct");
			}

			if (Button.isDisplayed() && Button.isEnabled()) {
				Button.click();
				testCase = extent.createTest(ReportName + " CLICKED");
				testCase.log(Status.INFO, "Expected :- " + ReportName + " Clicked");
				testCase.log(Status.PASS, " Correct");
				work = true;
			} else {
				testCase = extent.createTest(ReportName + " NOT CLICKED");
				testCase.log(Status.INFO, "Expected :- " + ReportName + " Not Clicked");
				testCase.log(Status.FAIL, " Wrong");
			}
		} catch (NoSuchElementException e) {
			ExtentTest testCase = extent.createTest(ReportName + " NO ELEMENT EXCEPTION");
			testCase.log(Status.INFO, ReportName + "Button not clickable!");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		catch (ElementClickInterceptedException e) {
			ExtentTest testCase = extent.createTest(ReportName + "ELEMENT CLICK EXCEPTION ");
			testCase.log(Status.INFO, ReportName + "button not clickable!");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTest testCase = extent.createTest("WebElement Exception ");
			testCase.log(Status.INFO, ReportName + " button not clickable!");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		
	}

	public static void check() throws InterruptedException, IOException {
		boolean check = false;
		if (work) {

			try {
				Thread.sleep(1000);
				Assert.assertEquals(SourcePage.sourceSavebtn.isDisplayed(), true);
				check = true;
			} catch (AssertionError e) {
				check = false;
			} catch (Exception e) {
				check = false;
			}
		}

		if (check) {
			// Source Filed Validation
			SourceValidation();

			driver.navigate().refresh();
		} else {

			// Check PopUp Message 
			SavePopUpSuccessMsg();

			// Check the Last Added Data Come in First Row
			checkLastAddvalue();

			if(!firstRow) {
			// Check the Data in full table
			CheckFullTable();
			}
		}
	}

}
