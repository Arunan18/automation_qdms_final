//***********************************************************************************
//* Description
//*------------
//*Incoming Sample After Depend Delete Functionality  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 24/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-INC-SAM-0016        24/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.incommingsample;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;

public class AfterDependDeleteFunctionality  extends DriverIntialization{
	static IncomingSamplePage afterDeleteFun = new IncomingSamplePage() ;
	static String SeachData = null;
	static String alertMessage = null;
	
	//________________________________________________________
//  NAVIAGATE TO INCOMINGSAMPLE
//________________________________________________________	
	
	public static void  navigateToIncomingSample() throws InterruptedException {
		PageFactory.initElements(driver, afterDeleteFun);
		
		Thread.sleep(5000);
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();

	} 
//_______________________________________________________________
//      EXCEL METHOD
//_______________________________________________________________
		
	public static void ExcelMethod() throws IOException {
		String excelPath = System.getProperty ("user.dir") +"\\src\\test\\resources\\Excel\\Samples Module.xlsx";
		String excelSheetName = "Incoming Sample";
		String testCaseId = "TC-INC-SAM-0016";
		
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);  

		for (int i = firstRow; i <= lastRow; i++) { 
			XSSFRow row = sheet.getRow(i);
			SeachData = (String) row.getCell(1).getStringCellValue();  
			alertMessage = (String)row.getCell(2).getStringCellValue();
			
	}
	}
//________________________________________________________________________________
//     SEARCH DATA
//_________________________________________________________________________________
	public static void SeachDataToDelete() throws InterruptedException {
		PageFactory.initElements(driver, afterDeleteFun);
		extent.createTest("STEP:1");
		ActionCommonMethod.actionS(0, 22, IncomingSamplePage.incomingSampleTable, "delete", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0016-01", 1);
		 
		
		extent.createTest("STEP:2");
		Thread.sleep(2000);
		
		SampleActionMethods.clicking(IncomingSamplePage.DeleteOkayButton,2, "CLCIKED DELTTE");
		
		
	
//____________________________________________________________________________________
//     AFTER CLICK DELETE BUTTON  VIEW ALERT MESSAGE (Can't delete this module)
//_____________________________________________________________________________________	
	
	testCase = extent.createTest("STEP:3 CAN DLETET THIS MODULE ALERT MESSAGE VISIBLE");
	
	WebElement alert = driver.findElement(By.xpath("(//div[@class='ant-notification-notice-message'])[1]"));
	
	boolean Visible = alert.isDisplayed();
	if (Visible) {
		boolean actualVisible = alert.isDisplayed();
		System.out.println("Alert Visible:-"+actualVisible);
		boolean expectedVisible = true;
		try {
			assertEquals(actualVisible, expectedVisible);
			testCase.log(Status.INFO," Actual Visible:-"+actualVisible);
			testCase.log(Status.INFO," Expected Visible:-"+ expectedVisible);
			testCase.log(Status.PASS,"Correct Visible");
		}catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.INFO," Actual Visible:-"+actualVisible);
			testCase.log(Status.INFO," Expected Visible:-"+ expectedVisible);
			testCase.log(Status.PASS,"Correct Visible");
		}
	
	}
	
//______________________________________________________________________________
//  ALERT MESSAGE GET TEXT 
//______________________________________________________________________________
	
	testCase =extent.createTest("STEP:4 CHECK ALERT MESSAGE SPELLING");
	String actualText = alert.getText();
	System.out.println("Alert Text:-"+ actualText);
	String expectedText = alertMessage;
	boolean spelling = true;
	try {
	Assert.assertEquals(actualText, expectedText);
	}catch (AssertionError e) {
		// TODO: handle exception
	}
	if(spelling) {
		testCase.log(Status.INFO, "Actual text:"+actualText);
		testCase.log(Status.INFO,"Expected text:"+expectedText);
		testCase.log(Status.PASS,"Correct text");
		
	}else {
		testCase.log(Status.INFO, "Actual text:"+actualText);
		testCase.log(Status.INFO,"Expected text:"+expectedText);
		testCase.log(Status.FAIL,"Correct text");
	}
	
	
	}
	
	
	
//_____________________________________________________________________________
// AFTER DELETER VERFIY
//_____________________________________________________________________________	

	public static void verifyDataNotDeleted() {
	    PageFactory.initElements(driver, afterDeleteFun);
	    testCase = extent.createTest("STEP:5 AFTER CLICK DELETE BUTTON  VERIFY DATA IS THERE OR NOT");
	    
	    boolean isDataNotDeleted = false;
	    List<WebElement> tableRows = IncomingSamplePage.incomingSampleTable.findElements(By.tagName("tr"));
	    
	    for (WebElement row : tableRows) {
	        if (row.getText().contains(SeachData)) {
	        	isDataNotDeleted = true;
	            break;
	        }
	    }
	    
	    if (isDataNotDeleted) {
	        System.out.println("Incoming sample data has been deleted successfully.");
	        testCase.log(Status.PASS,"Incoming sample data has not deleted");
	    } else {
	        System.out.println("Failed to delete incoming sample data.");
	        testCase.log(Status.FAIL,"Failed to delete incoming sample data");
	    }
	}
// ____________________________________________________________
//  LOGOUT
//______________________________________________________________	
	public static void Logout() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Admin = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color'])[1]"));
		Admin.click();

		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.xpath(
				"//body/div/div/div[contains(@class,'ant-dropdown ant-dropdown-placement-bottomRight')]/ul[@role='menu']/li[@role='menuitem']/span[@class='ant-dropdown-menu-title-content']/p[1]"));
		Logout.click();

	}


	
	
	
	

}
