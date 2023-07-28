//***********************************************************************************
//* Description
//*------------
//*Additional Information Delete Ok Button Functionality - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 11/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0228          11/05/2023   Saranka     Original Version
//*
//***********************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

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
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AdditionalInformation_deleteOkButtonFun  extends DriverIntialization{

	static TestConfigPage DeletOkBtn = new TestConfigPage();
	static ManageTestsPage mangeDeleteOk = new ManageTestsPage();
	static String SearchData = null;
	static String verifyData = null;
	static String Sucessmessage = null;

//===================================================== M E T H O D =======================================================
	@Test
	public void methodCalling() throws InterruptedException, IOException {

		LoginTest.Login();

		AdditionalInformation_deleteOkButtonFun.DeleteOkButtonFunction();

		Logout.LogoutFunction();

	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void DeleteOkButtonFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, DeletOkBtn);
		PageFactory.initElements(driver, mangeDeleteOk);
		

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[normalize-space()='Additional Information']")).click();
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

//______________________________________________
// EXCEL
//_______________________________________________

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0228";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			verifyData = (String) row.getCell(2).getStringCellValue();
			Sucessmessage = (String) row.getCell(3).getStringCellValue();
		}
//_______________________________________________
//  SEARCH DATA TO BE CLICK
//_______________________________________________		

		WebElement table = driver.findElement(By.xpath("//div[@class='ant-table-container']"));
		ActionCommonMethod.actionS(0, 10, table, "Description", "Test Configuragtion Module.xlsx", "Test_Configure",
				"TC-TCN-0228-01", 1);
 
		
		WebElement deleteIcon = driver.findElement(
				By.xpath("//div[@class='ant-modal-content']//tbody//tr[2]/td[5]//span[@aria-label='delete']"));
		SampleActionMethods.clicking(deleteIcon, 2, "STEP:1 DELETE BUTTON");

//_______________________________________________
//  CLICK DELETE OK BUTTON
//_______________________________________________		

		WebElement DeleteOkButton = driver.findElement(By.xpath("//div[@role='tooltip']//button[2]"));
		SampleActionMethods.clicking(DeleteOkButton, 2, "STEP:2 DELTE OK BUTTON");

//_______________________________________________
//  AFTER CLICK DELETE OK BUTTON
//_______________________________________________	

		SampleCommonMethods.dataaddedsuccessmsg("STEP 3: DATA IS DELETED VALIDATION MESSAGE",
				ManageTestsPage.DeleteSucessMessage, Sucessmessage);
		
		boolean isDataDeleted = true;
		List<WebElement> tableRows = TestConfigPage.TableOfGrouPTest.findElements(By.tagName("tr"));

		for (WebElement row : tableRows) {
			if (row.getText().contains(verifyData)) {
				isDataDeleted = false;
				break;
			}
		}

		if (isDataDeleted) {
			System.out.println("Incoming sample data has been deleted successfully.");
			testCase.log(Status.PASS, "Incoming sample data has been deleted successfully");
		} else {
			System.out.println("Failed to delete incoming sample data.");
			testCase.log(Status.FAIL, "Failed to delete incoming sample data");
		}
		
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	
		
		
	} 
	



