//***********************************************************************************
//* Description
//*------------
//*Delete Equation - Configure Test - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 03/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0146       03/05/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

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
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class DeleteEquationFunction extends DriverIntialization {
	static TestConfigPage DeleteEquation = new TestConfigPage();
	static String toBeSearchdata = null;
	static String EditData = null;
	static String Message = null;
	public static String datacount = "";
	static String validateText = null;
	
//======================================================  M E T H O D  ================================================
	
	@Test
	public void Methods () throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		DeleteEquationFunction.naviagateToMangeTest();
		
		DeleteEquationFunction.ExcelMethod();
		
		DeleteEquationFunction.SearchPerticularDataToBeDelete();
		
	}

	
//======================================================  T E S T C A S E S ================================================
	
	
//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void naviagateToMangeTest() throws InterruptedException, IOException {
		PageFactory.initElements(driver, DeleteEquation);
		
		

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
						driver.findElement(By.xpath("(//th[@class='ant-table-cell'][normalize-space()='Equation'])[1]"))
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

	}

//______________________________________
//  EXCEL METHOD
//_______________________________________
	public static void ExcelMethod() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Config_Group_Test";
		String testCaseId = "TC-TCN-0146";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			toBeSearchdata = (String) row.getCell(1).getStringCellValue();
			Message = (String) row.getCell(2).getStringCellValue();
			validateText = (String) row.getCell(3).getStringCellValue();

		}
	}
//________________________________
// SEARCH DATA
//_______________________________

	public static void SearchPerticularDataToBeDelete() throws InterruptedException {
		PageFactory.initElements(driver, DeleteEquation);

		ActionCommonMethod.actionS(0, 9, TestConfigPage.TableManageConfigure, "Description",
				"Test Configuragtion Module.xlsx", "Config_Group_Test", "TC-TCN-0146-01", 1);

//________________________________
// DELETE FUNCTION
//_______________________________
		SampleActionMethods.clicking(TestConfigPage.EquationDeleteBtn, 2, "STEP :1 DELETE BUTTON");
		TestConfigPage.DeletOkButtonEquation.click();

//_______________________________
// AFTER DELETE VERIFY
//_______________________________

		SampleCommonMethods.dataaddedsuccessmsg("STEP 2: DATA IS DELETED", TestConfigPage.successMsg, Message);

		driver.navigate().refresh();
//_____________________________
// CHECK BEFORE AND AFTER  MODAL
//______________________________

		WebElement BeforeDeleteTableContent = driver.findElement(By.xpath("(//td[contains(text(),'parameter')])[2]"));

		String text = validateText;
		WebElement AfterDeletContent = driver.findElement(By.xpath("(//td[contains(text(),'" + text + "')])[2]"));

//Verify that the deleted data is no longer present in the table
		testCase = extent.createTest("STEP:3 AFTER VALIDATE DATA");
		try {
			WebElement deletedContent = driver.findElement(By.xpath("//td[contains(text(),'" + validateText + "')]"));
			if (!deletedContent.isDisplayed()) {
				System.out.println("STEP 3: Data has been successfully deleted");
			} else {
				System.out.println("STEP 3: Data still exists in the table after deletion");
			}
		} catch (NoSuchElementException e) {
			System.out.println("STEP 3: Data has been successfully deleted");
		}

	}

}
