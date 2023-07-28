
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS SAMPLE DELETE TEST FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   17:04:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0013	   17:04:2023     @SASIKALA     Original Version
//*
//*****************************************************************************************

/*
* Process Sample Delete Functionality - TC-PRO-SAM-0013
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class InProcessDeleteFunctionTest extends DriverIntialization {
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	static String SampleDeleteTobeSelect = "";
	static String DeleteSuccessmsg = "";

//**************************REACH IN PROCESS SAMPLE PATH************************ 
	@Test(priority = 0)
	public static void DeleteBasicPathMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		// ------Login-----------
		AddInprocessSampleTest.LoginMethod();

		// --------Sample Navigation----------
		AddInprocessSampleTest.SampleMainMethod();

	}

//**************************DELETE IN PROCESS SAMPLE METHOD************************ 
	@Test(priority = 1)
	public static void DeleteInprocessSampleExcelMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);
		Thread.sleep(1000);
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Process Sample");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0013");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx", "Process Sample",
				"TC-PRO-SAM-0013");
		for (int j = firstrow; j <= lastrow; j++) {
			XSSFRow row = sheet.getRow(j);

			SampleDeleteTobeSelect = (String) row.getCell(1).getStringCellValue();
			DeleteSuccessmsg = (String) row.getCell(2).getStringCellValue();

		}
	}

//**************************DELETE IN PROCESS SAMPLE SELECT METHOD************************ 

	@Test(priority = 2)
	public static void DeleteFunctionMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		// ------------ XPATH DELETE BUTTON------------------

		String Name = SampleDeleteTobeSelect;
		String NameXpath_firstPart = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[";
		String NameXpath_lastPart = "]/td[1]";
		String EditXpath_firstPart = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[";
		String EditXpath_lastPart = "]/td[21]/span[1]/a[1]/a[1]/span[1]";

		// ----------- DELETE BASIC LOOP FUNCTIONS--------------
		boolean clickNextPage = true;
		boolean CustomerExist = false;
		while (clickNextPage) {
			for (int i = 2; i < 103; i++) {
				try {
					Thread.sleep(3000);
					String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
					System.out.println(text);
					if (text.equals(Name)) {
						CustomerExist = true;
						driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
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
		if (CustomerExist = false) {
			System.out.println("No such Element" + CustomerExist);
		}

	}

//**************************DELETE IN PROCESS SAMPLE OK BUTTON FUNCTION************************

	@Test(priority = 3)
	public static void DeleteSelectokMethod() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocesssample);

		if (InprocessSamplePage.Deleteokbtn.isDisplayed()) {
			testCase = extent.createTest("SAMPLE DELETE BUTTON VISIBLE");
			testCase.log(Status.PASS, "TEST PASS");
			if (InprocessSamplePage.Deleteokbtn.isEnabled()) {
				testCase = extent.createTest("SAMPLE DELETE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					InprocessSamplePage.Deleteokbtn.click();

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("SAMPLE DELETE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("SAMPLE DELETE BUTTON VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

//**************************IN PROCESS SAMPLE SUCCESS MESSAGE FUNCTION************************
		Thread.sleep(1000);
		String AddSuccessMessage = InprocessSamplePage.deleteInProcessSamplesuccessmsg.getText();
		System.out.println(AddSuccessMessage);
		String expectedatamsg = DeleteSuccessmsg;

		testCase = extent.createTest("Process Sample Successfully Deleted Message");
		try {
			Assert.assertEquals(AddSuccessMessage, expectedatamsg);
			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.PASS, "Right Success Message Enable");
		} catch (AssertionError e) {

			testCase.log(Status.INFO, "Actual Data :- " + AddSuccessMessage);
			testCase.log(Status.INFO, "Expected Data :- " + expectedatamsg);
			testCase.log(Status.FAIL, "Wrong Success Message Not Enable");
		}

	}

//**************************IN PROCESS SAMPLE LOGOUT METHOD************************

	@Test(priority = 4)
	public static void LogoutMethod() throws InterruptedException {
		Thread.sleep(1000);
		PageFactory.initElements(driver, inprocesssample);
		MultiSearchMethods.Logout();

	}
}
