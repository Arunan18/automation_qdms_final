
//*******************************************************************************
//* Description
//*------------
//*Edit Aditional Information   TextBox Button functionality - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0232        16/05/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class EditAditionalInformationPopupTextBoxFunction extends DriverIntialization {
	static TestConfigPage TextBox = new TestConfigPage();
	static ManageTestsPage textBoxPopup = new ManageTestsPage();
	static String SearchData = null;
	static String EditData = null;
	static String Sucessmessage = null;
	static String SearchData2 = null;
	
	
//====================================== M E T H O D =================================================
	@Test
	public void method() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		EditAditionalInformationPopupTextBoxFunction.EditTextBoxFunctionality();
		
		Logout.LogoutFunction();
		
		
	}

//======================================= T E S T C A S E S ============================================		
//_________________________________________________________________
//  NAVIGATE TO TEST CONFIGURATION PARAMETER
//_________________________________________________________________ 
	public static void EditTextBoxFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, TextBox);
		PageFactory.initElements(driver, textBoxPopup);

// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
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
		String testCaseId = "TC-TCN-0232";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			EditData = (String) row.getCell(2).getStringCellValue();
			Sucessmessage = (String) row.getCell(3).getStringCellValue();
			SearchData2 = (String )row.getCell(4).getStringCellValue();
		}

//_______________________________________________
//  SEARCH DATA TO BE CLICK
//_______________________________________________		

		WebElement table = driver.findElement(By.xpath("//div[@class='ant-table-container']"));
		ActionCommonMethod.actionS(0, 14, table, "Description", "Test Configuragtion Module.xlsx", "Test_Configure",
				"TC-TCN-0232-01", 1); 

		WebElement AddionalInformation = driver
				.findElement(By.xpath("(//div[normalize-space()='Additional Information'])[1]"));
		Thread.sleep(2000);
		AddionalInformation.click();
//________________________________________________
// CLICK EDIT BUTTON
//________________________________________________

		WebElement edit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[2]/div/div/div/form/div/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[5]/span/a[1]/span"));
		//ActionCommonMethod.actionS(0, 4, table1, "edit", "Test Configuragtion Module.xlsx", "Test_Configure",
				//"TC-TCN-0232-01", 4);
		edit.click();
//________________________________________________
// TEXT BOX VISIBLE VISIBLE
//________________________________________________	

		WebElement TextBox = driver.findElement(By.xpath("(//input[@id='caption'])[2]"));
		Thread.sleep(2000);

		boolean Viisble = TextBox.isDisplayed();
		if (Viisble) {
			boolean actualVisible = TextBox.isDisplayed();
			System.out.println("actual Visible:-" + actualVisible);
			boolean expectedVisible = true;
			testCase = extent.createTest(" STEP:2 TEXT BOX VISIBLE");
			try {
				Assert.assertEquals(actualVisible, expectedVisible);
				testCase.log(Status.INFO, "actual Visible:-" + actualVisible);
				testCase.log(Status.INFO, "expected Visible:" + expectedVisible);
				testCase.log(Status.PASS, "Visible Correct");
			} catch (AssertionError e) {
				// TODO: handle exception
				Assert.assertEquals(actualVisible, expectedVisible);
				testCase.log(Status.INFO, "actual Visible:-" + actualVisible);
				testCase.log(Status.INFO, "expected Visible:" + expectedVisible);
				testCase.log(Status.FAIL, "Visible In-Correct");
			}

		}

//________________________________________________
// TEXT BOX VISIBLE ENABLE
//________________________________________________
		boolean Enable = TextBox.isEnabled();
		if (Enable) {
			boolean actualEnable = AddionalInformation.isEnabled();
			System.out.println("actual Enable:-" + actualEnable);
			boolean expectedEnable = true;
			testCase = extent.createTest(" STEP:3 TEXT BOX ENABLE");
			try {
				Assert.assertEquals(actualEnable, expectedEnable);
				testCase.log(Status.INFO, "actual Enable:-" + actualEnable);
				testCase.log(Status.INFO, "expected Enable:" + expectedEnable);
				testCase.log(Status.PASS, "Visible Correct");
			} catch (AssertionError e) {
				// TODO: handle exception
				Assert.assertEquals(actualEnable, expectedEnable);
				testCase.log(Status.INFO, "actual enable:-" + actualEnable);
				testCase.log(Status.INFO, "expected Enable:" + expectedEnable);
				testCase.log(Status.FAIL, "Visible In-Correct");
			}

		}

//_________________________________________
// TEXT BOX FUNCTION
//_________________________________________

		TextBox.sendKeys(Keys.CONTROL, "a");
		TextBox.sendKeys(Keys.DELETE);
		TextBox.sendKeys(EditData);

//____________________________________
//  SAVE BUTTON
//____________________________________

		WebElement saveButton = driver.findElement(By.xpath("//a[normalize-space()='Save']"));
		SampleActionMethods.clicking(saveButton, 2, "STEP:4  SAVE BUTTON ");
		
//____________________________________
// AFTER SAVE 
//____________________________________
		
		WebElement validationMessage = driver.findElement(By.xpath("//div[contains(text(),'Test Record Updated Sucessfully')]"));
		SampleCommonMethods.dataaddedsuccessmsg("STEP :5 DATA IS SAVED VALIDATION MESSAGE", validationMessage, Sucessmessage);

	}

}
