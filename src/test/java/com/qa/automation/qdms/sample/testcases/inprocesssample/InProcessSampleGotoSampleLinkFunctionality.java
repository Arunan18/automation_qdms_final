
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS TRAIL GO TO SAMPLE LINK CHECK FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   16:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0310  	   16:05:2023     @SASIKALA     Original Version
//* 
//****************************************************************************************************************

/*
* TC-PRO-SAM-0310	Check when do the Test trial Check the Go to Sample Link Functionality
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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class InProcessSampleGotoSampleLinkFunctionality extends DriverIntialization {
	static InprocessSamplePage InProPg = new InprocessSamplePage();

	static String SampleCode = null;
	static String TestName = null;
	static String Date = null;
	static int NoOfTrail = 0;
	static String statusText = null;

	@Test(priority = 0)
	public static void gotosamplelinkFunction() throws InterruptedException, IOException {

// LOGIN FUNCTION
		LoginTest.Login();

// CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, "STEP 1 - CHECKING SAMPLE MODULE");

// CHECKNIG RAW MATERIAL MENU IS DISPLAYED && STEP-02 CHECKNIG RAW MATERIAL MENU IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 20,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG IN PROCESS SAMPLE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.inprocessSampleXpath(), 20,
				"STEP 3 - CHECKING IN PROCESS SAMPLE BUTTON");
	}

//**************************************EXCEL WORK************************************

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
				"TC-PRO-SAM-0310");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0310");

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

		if (InprocessSamplePage.trailDatefield.isDisplayed()) {
			testCase = extent.createTest("DATE FIELD IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS â˜‘");

			if (driver.findElement(By.id("date")).isEnabled()) {
				testCase = extent.createTest("DATE FIELD IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS â˜‘");

				InprocessSamplePage.trailDatefield.click();
				InprocessSamplePage.trailDatefield.sendKeys(Date);
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

//************************** CLICK ON THE GO TO SAMPLE LINK
	@Test(priority = 8)
	public static void GOTOSampleLinks() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);

		Thread.sleep(2000);
		InprocessSamplePage.gotosamplelink.click();

//**********************VERIFY THE LINK FUNCTIONALITY**********************************

		String ActualText = driver.findElement(By.xpath("//div[2]//div[@class='ant-typography']")).getText();
		String ExpectedText = "In Process Sample";
		System.out.println("Trial : " + ActualText);
		testCase = extent.createTest("VERIFY THE LINK FUNCTIONALITY");
		if (ActualText.equals(ExpectedText)) {
			testCase.log(Status.INFO, "ActualText :- " + ActualText);
			testCase.log(Status.INFO, "ExpectedText :- " + ExpectedText);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, ActualText);
		} else {
			testCase.log(Status.INFO, "ActualText :- " + ActualText);
			testCase.log(Status.INFO, "ExpectedText :- " + ExpectedText);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, ActualText);
		}

	}

// ***************************************LOGOUT FUNCTION************************************ 
	@Test(priority = 9)
	public static void LOGOUTFUNCTION() throws InterruptedException, IOException {
		PageFactory.initElements(driver, InProPg);
		driver.navigate().refresh();
		Thread.sleep(2000);
		MultiSearchMethods.Logout();

	}
}
