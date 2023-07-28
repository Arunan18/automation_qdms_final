
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS TRAIL SAMPLE STATUS FILED CHECK FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   15:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0304  	   15:05:2023     @SASIKALA     Original Version
//* TC-PRO-SAM-0306
//****************************************************************************************************************

/*
* TC-PRO-SAM-0304	Check when do the Test trial Check the Submit button Functionality  
* TC-PRO-SAM-0306	Check when do the Test trial Check the Test Procedure icon Functionality
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class InProcessSampleTestTrailSubmitbtnFunction extends DriverIntialization {
	static InprocessSamplePage InProPg = new InprocessSamplePage();

	static String SampleCode = null;
	static String TestName = null;
	static String Date = null;
	static int NoOfTrail = 0;
	static String statusText = null;

	@Test(priority = 0)
	public static void dateFieldFunction() throws InterruptedException, IOException {

		// LOGIN FUNCTION
		LoginTest.Login();

		// CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE BUTTON
		// IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, "STEP 1 - CHECKING SAMPLE MODULE");

		// CHECKNIG RAW MATERIAL MENU IS DISPLAYED && STEP-02 CHECKNIG RAW MATERIAL
		// MENU IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 20,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG IN
		// PROCESS SAMPLE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.inprocessSampleXpath(), 20,
				"STEP 3 - CHECKING IN PROCESS SAMPLE BUTTON");

	}

//********************************EXCEL WORK******************************
	@Test(priority = 1)
	public static void EXCELWORK() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Process Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0304");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0304");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SampleCode = (String) row.getCell(1).getStringCellValue();
			TestName = (String) row.getCell(2).getStringCellValue();
			Date = (String) row.getCell(3).getStringCellValue();
			NoOfTrail = (int) row.getCell(4).getNumericCellValue();
			statusText = (String) row.getCell(5).getStringCellValue();

		}
	}

//************************TEST CODE SELECTION***********************************
	@Test(priority = 2)
	public static void TESTCODESELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

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
		PageFactory.initElements(driver, InProPg);

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='ant-ribbon-wrapper']//div[@class='sc-gzVnrw KZmpn']//li[text()='" + TestName + "']"))
				.click();

	}

//************************CHECK THE FUNCTIONALITY OF DATE FIELD****************************

	@Test(priority = 4)
	public static void DATESELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

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
		PageFactory.initElements(driver, InProPg);

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
//****************************CHECK THE FUNCTIONALITY OF STATUS FIELD*************************

	@Test(priority = 6)
	public static void STATUSSELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

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

//************************************SUBMIT BUTTON**************************
	@Test(priority = 7)
	public static void SUBMITBUTTONSELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

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

//*************************VERIFY THE SUCCESSFUL MESSAGE**********************
	@Test(priority = 8)
	public static void SuccessMessage() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

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

	// ************************************TEST PROCEDURE
	// BUTTON**************************
	@Test(priority = 9)
	public static void PROCEDURESELECTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

		driver.navigate().refresh();
		Thread.sleep(3000);
		if (InprocessSamplePage.trailprocedureicon.isDisplayed()) {
			testCase = extent.createTest("TEST PROCEDURE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (InprocessSamplePage.trailprocedureicon.isEnabled()) {
				testCase = extent.createTest("TEST PROCEDURE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				InprocessSamplePage.trailprocedureicon.click();

			} else {
				testCase = extent.createTest("TEST PROCEDURE BUTTON FIELD IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL â�Ž");
			}
		} else {
			testCase = extent.createTest("TEST PROCEDURE BUTTON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL â�Ž");
		}
	}

//	VERIFY THE TEST PROCEDURE ICON FUNCTIONALITY
//	-----------------------------------------------
	@Test(priority = 10)
	public static void PROCEDUREVERIFY() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

		Thread.sleep(1000);
		String ActualData = InprocessSamplePage.procedureverify.getText();
		String ExpectedData = "Test Procedure";
		System.out.println("text : " + ActualData);
		testCase = extent.createTest("VERIFY THE TEST PROCEDURE ICON FUNCTIONALITY");
		if (ActualData.equals("Test Procedure")) {
//            Assert.assertEquals(ActualData, ExpectedData);
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualData);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualData);
		}
	}

	@Test(priority = 11)
	public static void LOGOUTFUNCTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);
		driver.navigate().refresh();
		Thread.sleep(2000);
		MultiSearchMethods.Logout();

	}
}
