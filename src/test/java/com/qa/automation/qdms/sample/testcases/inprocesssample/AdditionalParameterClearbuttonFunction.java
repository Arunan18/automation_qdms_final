
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE ADDITIONAL INFORMATION CLEAR ALL FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   18:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0320	 	 18:04:2023     @SASIKALA     Original Version
//*****************************************************************************************

/*
* TC-PRO-SAM-0320	Check Additional Information Clear All button Functionality
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class AdditionalParameterClearbuttonFunction extends DriverIntialization {
	static InprocessSamplePage inpropg = new InprocessSamplePage();

	static String AdditionalInfoField = null;
	static String ConfirmData = null;
	static String SampleCode = null;
	static String TestName = null;
	static String Date = null;
	static int NoOfTrail = 0;
	static String statusText = null;

//****************************NAVIGATION PATH IN PROCESS SAMPLE***********************************

	@Test(priority = 0)
	public static void TrailWayFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);
		// LOGIN FUNCTION
		LoginTest.Login();

		// CHECKNIG SAMPLE MODULE IS DISPLAYED && ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, "STEP 1 - CHECKING SAMPLE MODULE");

		// CHECKNIG RAW MATERIAL MENU IS DISPLAYED && ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 20,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.inprocessSampleXpath(), 20,
				"STEP 3 - CHECKING IN PROCESS SAMPLE BUTTON");
	}

//**************************************EXCEL WORK******************************
	@Test(priority = 1)
	public static void EXCELWORK() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Process Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0320");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0320");
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SampleCode = (String) row.getCell(1).getStringCellValue();
			TestName = (String) row.getCell(2).getStringCellValue();
			Date = (String) row.getCell(3).getStringCellValue();
			NoOfTrail = (int) row.getCell(4).getNumericCellValue();
			statusText = (String) row.getCell(5).getStringCellValue();
			AdditionalInfoField = (String) row.getCell(6).getStringCellValue();
			ConfirmData = (String) row.getCell(7).getStringCellValue();

		}
	}

//************************TEST CODE SELECTION***********************************
	@Test(priority = 2)
	public static void TESTCODESELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		// XPATH SAMPLECODE
		String Code = SampleCode;
		String CodeXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String CodeXpath_lastPart = "]/td[1]";
		String TesticonXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String TesticonXpath_lastPart = "]/td[18]/span/span";

		boolean clickNextPage = true;
		boolean PageExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					String text = driver.findElement(By.xpath(CodeXpath_firstPart + i + CodeXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Code)) {
						PageExist = true;
						driver.findElement(By.xpath(TesticonXpath_firstPart + i + TesticonXpath_lastPart)).click();
						Thread.sleep(2000);
						clickNextPage = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				if (driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).isEnabled()) {
					driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
					Thread.sleep(2000);
				} else {
					System.out.println("Button Not Enabled");
				}
			} else {
				break;
			}

		}
		if (PageExist = false) {
			System.out.println("No such Element" + PageExist);
		}
	}

//********************************** CLICK ON THE TEST****************************
	@Test(priority = 3)
	public static void TESTSELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='ant-ribbon-wrapper']//div[@class='sc-gzVnrw KZmpn']//li[text()='" + TestName + "']"))
				.click();

	}
//************************CHECK THE FUNCTIONALITY OF DATE FIELD****************************

	@Test(priority = 4)
	public static void DATESELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		Thread.sleep(1000);

		if (driver.findElement(By.id("date")).isDisplayed()) {
			testCase = extent.createTest("DATE FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (driver.findElement(By.id("date")).isEnabled()) {
				testCase = extent.createTest("DATE FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				driver.findElement(By.id("date")).click();
				driver.findElement(By.id("date")).sendKeys(Date);
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER).perform();

			} else {
				testCase = extent.createTest("DATE FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");
			}
		} else {
			testCase = extent.createTest("DATE FIELD IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}

	}

//*************************CHECK THE FUNCTIONALITY OF NO OF TRAIL FIELD******************************

	@Test(priority = 5)
	public static void NOOFTRAILSELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		Thread.sleep(1000);

		if (InprocessSamplePage.nooftrailfield.isDisplayed()) {
			testCase = extent.createTest("NO OF TRAIL FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (InprocessSamplePage.nooftrailfield.isEnabled()) {
				testCase = extent.createTest("NO OF TRAIL FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				InprocessSamplePage.nooftrailfield.click();
				InprocessSamplePage.nooftrailfield.sendKeys(String.valueOf(NoOfTrail));
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.ENTER).perform();

			} else {
				testCase = extent.createTest("NO OF TRAIL FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");
			}
		} else {
			testCase = extent.createTest("NO OF TRAIL FIELD IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}
	}

// ****************************CHECK THE FUNCTIONALITY OF STATUS FIELD*************************

	@Test(priority = 6)
	public static void STATUSSELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		Thread.sleep(1000);

		if (InprocessSamplePage.trailstatusfield.isDisplayed()) {
			testCase = extent.createTest("STATUS FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (InprocessSamplePage.trailstatusfield.isEnabled()) {
				testCase = extent.createTest("STATUS FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				WebElement testStatus = InprocessSamplePage.trailstatusfield;

				testStatus.getText();

			} else {
				testCase = extent.createTest("STATUS FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");
			}
		} else {
			testCase = extent.createTest("STATUS FIELD IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}

	}

// ************************************SUBMIT BUTTON**************************
	@Test(priority = 7)
	public static void SUBMITBUTTONSELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		Thread.sleep(1000);

		if (InprocessSamplePage.trailsubmitbtn.isDisplayed()) {
			testCase = extent.createTest("SUBMIT BUTTON FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (InprocessSamplePage.trailsubmitbtn.isEnabled()) {
				testCase = extent.createTest("SUBMIT BUTTON FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				InprocessSamplePage.trailsubmitbtn.click();

			} else {
				testCase = extent.createTest("SUBMIT BUTTON FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");
			}
		} else {
			testCase = extent.createTest("SUBMIT BUTTON FIELD IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}
	}

// *************************VERIFY THE SUCCESSFUL MESSAGE**********************
	@Test(priority = 8)
	public static void SuccessMessage() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);

		Thread.sleep(1500);
		String actual = InprocessSamplePage.Trialaddsuccessmsg.getText();
		System.out.println("Message" + actual);

		String expected = "Material Test Added Successfully";

		boolean firstdata = true;
		testCase = extent.createTest("CHCK THE SUCCESSFULLY ADDED NOTIFICATION");
		try {
			AssertJUnit.assertEquals(actual, expected);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actual);
			testCase.log(Status.INFO, "Expected Data :- " + expected);
			testCase.log(Status.PASS, "DATA HAS SUCCESSFULLY ADDED");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actual);
			testCase.log(Status.INFO, "Expected Data :- " + expected);
			testCase.log(Status.FAIL, "DATA HAS NOT ADDED");
		}
	}

//****************************ADDITIONAL INFORMATION MODEL***********************************

	@Test(priority = 9)
	public static void addtionalinforFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);
		Thread.sleep(1000);
		if (InprocessSamplePage.additionalInfoModel.isDisplayed()) {
			testCase = extent.createTest("INPROCESS ADDITIONAL INFORMATION MODEL VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");

		} else {
			testCase = extent.createTest("INPROCESS ADDITIONAL INFORMATION MODEL VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

//****************************CONFIRM DATA ENTERD METHOD IN PROCESS SAMPLE***********************************

	@Test(priority = 10)
	public static void confirmdataMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		WebElement AdditionalXpath = driver
				.findElement(By.xpath("//input[@placeholder='" + AdditionalInfoField + "']"));

		driver.findElement(By.xpath("//input[@placeholder='" + AdditionalInfoField + "']")).click();

		driver.findElement(By.xpath("//input[@placeholder='" + AdditionalInfoField + "']")).sendKeys(ConfirmData);

		Thread.sleep(3000);
		String actualdata = AdditionalXpath.getAttribute("value");
		System.out.println("ACTUAL DATA : " + actualdata);

		String expecteddata = ConfirmData;

		boolean firstdata = true;
		testCase = extent.createTest("CHECK THE DATA ADDITIONAL INFORMATION OF THE TABLE");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}
//****************************CLEAR ALL BUTTON IN PROCESS SAMPLE***********************************

	@Test(priority = 11)
	public static void ClearalladdtionalinforFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);
		Thread.sleep(1000);
		if (InprocessSamplePage.additionalInfoClearAll.isDisplayed()) {
			testCase = extent.createTest("INPROCESS ADDITIONAL INFORMATION CLEAR ALL DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (InprocessSamplePage.additionalInfoClearAll.isEnabled()) {
				testCase = extent.createTest("INPROCESS ADDITIONAL INFORMATION CLEAR ALL ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				InprocessSamplePage.additionalInfoClearAll.click();

			} else {
				testCase = extent.createTest("INPROCESS ADDITIONAL INFORMATION CLEAR ALL NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");
			}
		} else {
			testCase = extent.createTest("INPROCESS ADDITIONAL INFORMATION CLEAR ALL IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}
	}

//****************************LOGOUT METHOD***********************************
	@Test(priority = 12)
	public static void LOGOUTFUNCTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inpropg);
		// driver.navigate().refresh();
		Thread.sleep(2000);
		MultiSearchMethods.Logout();

	}

}
