//***********************************************************************************
//* Description
//*------------
//* Raw Material Search Functionality in Incoming Samples
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number                      Date         Intis        Comments
//* ================                      ====         =====        ========
//* TC-INC-SAM-0051, TC-INC-SAM-0053      19/04/2023   Sayan     Orginal Version
//* TC-INC-SAM-0055
//************************************************************************************


package com.qa.automation.qdms.sample.testcases.incommingsample;

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
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;

import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class RawMaterialSearchInComingSample extends DriverIntialization {
	
	static String SearchRawMaterial = null;
	static int expectedValue = 0;

	// ********************************************************************************************************
//		 THE METHOD IS FOR GENERATING REPORT 
	// ********************************************************************************************************

	public static void TestCasePrint(String TestCaseName, int expectedValue, String actualValue) {
		boolean test = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			test = false;
		}
		if (test) {
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

	@Test
	public static void singleSearch() throws InterruptedException, IOException {

		SampleNavigationPage SamNavPg = new SampleNavigationPage();
		IncomingSamplePage singleSearch = new IncomingSamplePage();
		PageFactory.initElements(driver, SamNavPg);
		PageFactory.initElements(driver, singleSearch);

		Actions actions = new Actions(driver);
		Thread.sleep(2000);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Incoming Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Incoming Sample", "TC-INC-SAM-0055");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Incoming Sample", "TC-INC-SAM-0055");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SearchRawMaterial = (String) row.getCell(1).getStringCellValue();
             expectedValue = (int) row.getCell(2).getNumericCellValue();
		}

		LoginTest.Login();

		Thread.sleep(500);
		SampleNavigationPage.sampleXpath();

		// ****************************************************************************************
//		    	STEP-01--RAW MATERIAL SAMPLE TAB IS DISPLAYED   &	STEP-02--RAW MATERIAL SAMPLE TAB IS ENABLED
		// ****************************************************************************************

		if (SampleNavigationPage.rawMaterialMainXpath().isDisplayed()) {
			testCase = extent.createTest("STEP-01--RAW MATERIAL SAMPLE TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SampleNavigationPage.rawMaterialMainXpath().isEnabled()) {
				testCase = extent.createTest("STEP-02--RAW MATERIAL SAMPLE TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SampleNavigationPage.rawMaterialMainXpath().click();

			} else {
				testCase = extent.createTest("STEP-02--RAW MATERIAL SAMPLE TAB IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--RAW MATERIAL SAMPLE TAB IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

		// ****************************************************************************************
//		        	STEP-03--INCOMING SAMPLE BUTTON IS DISPLAYED &	STEP-04--INCOMING SAMPLE BUTTON IS ENABLED
		// ****************************************************************************************

		if (SampleNavigationPage.incommingSampleXpath().isDisplayed()) {
			testCase = extent.createTest("STEP-03--INCOMING SAMPLE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");

			if (SampleNavigationPage.incommingSampleXpath().isEnabled()) {
				testCase = extent.createTest("STEP-04--INCOMING SAMPLE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				SampleNavigationPage.incommingSampleXpath().click();

			} else {
				testCase = extent.createTest("STEP-04--INCOMING SAMPLE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-03--INCOMING SAMPLE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

		// ****************************************************************************************
//	       	STEP-05--RAW MATERIAL SEARCH ICON IS DISPLAYED &	STEP-06--RAW MATERIAL SEARCH ICON IS ENABLED
		// ****************************************************************************************
		
		
        driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
        


		if (driver.findElement(By.xpath("//th[4]//div[1]//span[2]")).isDisplayed()) {
			testCase = extent.createTest("STEP-05--RAW MATERIAL SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//th[4]//div[1]//span[2]")).isEnabled()) {
				testCase = extent.createTest("STEP-06--RAW MATERIAL SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				 
				try {
					boolean pass = false;
					Thread.sleep(1000);
				
				  for (int i = 0; i < 1000; i++) {
					 if (!pass) {
			             try {
			                 driver.findElement(
			                         By.xpath("//th[4]//div[1]//span[2]"))
			                         .click();
			                 pass = true;
			             } catch (Exception e) {
			             }
			         }
					 
					 if (!pass) {
			             actions.sendKeys(Keys.ARROW_RIGHT).perform();
			             Thread.sleep(2);
			         } else {
			             break;
			         }
					 
				 }		

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-06--RAW MATERIAL SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-05--RAW MATERIAL SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

		// ************************************************************************************************************
//	       	STEP-07--CHECKING RAW MATERIAL SEARCH TEXTBOX DISPLAYED &	STEP-08--CHECKING RAW MATERIAL SEARCH TEXTBOX ENABLED
		// ************************************************************************************************************

		if (driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Raw Material']"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-07--RAW MATERIAL SEARCH BOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Raw Material']"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-08--RAW MATERIAL SEARCH BOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(
							By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Raw Material']"))
							.click();
					driver.findElement(
							By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Raw Material']"))
							.sendKeys(SearchRawMaterial);

					driver.findElement(
							By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Raw Material']"))
							.sendKeys(Keys.ENTER);

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-08--RAW MATERIAL SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-07--RAW MATERIAL SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

		Thread.sleep(2000);

		// ************************************************************************************************************
//	       	STEP-08--CHECKING RAW MATERIAL SEARCH BUTTON DISPLAYED &	STEP-09--CHECKING RAW MATERIAL SEARCH BUTTON ENABLED
		// ************************************************************************************************************

		if (driver.findElement(By.xpath(
				"//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-primary ant-btn-sm']"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-08--SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath(
					"//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-primary ant-btn-sm']"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-09--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath(
							"//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-primary ant-btn-sm']"))
							.click();
					String Code = driver.findElement(By.xpath(
							"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[4]"))
							.getText();
					System.out.println("PPPPP " + Code);
					String TextBox1 = driver
							.findElement(
									By.xpath("//div[@class='ant-table-filter-dropdown']//input[@placeholder=' Raw Material']"))
							.getAttribute("value");
					System.out.println("text box  " + TextBox1);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP-09--SEARCH BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-08--SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}
		// *************************************************************************************************************************

		boolean clickNextPage = true;
		int actualElementCount = 0;
		boolean passorfail = true;

		ArrayList<String> ActualList = new ArrayList<String>();
		ArrayList<String> ExpectedList = new ArrayList<String>();
		String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String NameXpath_lastPart = "]/td[4]";
		while (clickNextPage) {
			for (int i = 2; i < 750; i++) {
				try {
					String textFull = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
							.getText();
					String text = textFull.toLowerCase();
					
					if (!text.contains(SearchRawMaterial)) {
						passorfail = false;
					}
					if (text.contains(SearchRawMaterial)) {
						ExpectedList.add(text);
					}
					ActualList.add(text);
					actualElementCount = actualElementCount + 1;
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {

				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
//				Thread.sleep(2000);
			} else {
				break;
			}
		}
		driver.navigate().refresh();
		Thread.sleep(3000);

		// ******************************************************************************************************************
//											STEP-10--SINGLE SEARCH CONFIRM
		// ******************************************************************************************************************
		try {
			int Value = actualElementCount;
			TestCasePrint("STEP-10--SINGLE SEARCH CONFIRM", expectedValue, String.valueOf(Value));
		} catch (Exception e) {

		}

		MultiSearchMethods.Logout();

	}
	

}
