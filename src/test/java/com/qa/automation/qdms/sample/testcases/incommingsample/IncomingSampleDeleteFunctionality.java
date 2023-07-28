//***********************************************************************************
//* Description
//*------------
//*Incoming Sample Delete Functionality  - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-INC-SAM-0015           19/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;

public class IncomingSampleDeleteFunctionality extends DriverIntialization {
	static IncomingSamplePage DeletFun = new IncomingSamplePage();
	static String SearChData = null;

	
//________________________________________________________
//  NAVIAGATE TO INCOMINGSAMPLE
//________________________________________________________	
	
	public static void  navigateToIncomingSample() throws InterruptedException {
		PageFactory.initElements(driver, DeletFun);
		
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
		String testCaseId = "TC-INC-SAM-0015";
		
		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);  

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			SearChData = (String) row.getCell(1).getStringCellValue();   
			
	}
	}
//________________________________________________________________________________
//     SEARCH DATA
//_________________________________________________________________________________
	public static void SeachDataToDelete() throws InterruptedException {
		PageFactory.initElements(driver, DeletFun);
		extent.createTest("STEP:1");
		ActionCommonMethod.actionS(0, 22, IncomingSamplePage.incomingSampleTable, "delete", "Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0015-01", 1);
		 
		
		extent.createTest("STEP:2");
		Thread.sleep(2000);
		
		SampleActionMethods.clicking(IncomingSamplePage.DeleteOkayButton,2, "DELETE ALERT");
		
	}
	
	
//_____________________________________________________________________________
// AFTER DELETER VERFIY
//_____________________________________________________________________________	

	public static void verifyDeletedData() {
	    PageFactory.initElements(driver, DeletFun);
	    testCase = extent.createTest("AFTER DELETE VERIFY DATA");
	    
	    boolean isDataDeleted = true;
	    List<WebElement> tableRows = IncomingSamplePage.incomingSampleTable.findElements(By.tagName("tr"));
	    
	    for (WebElement row : tableRows) {
	        if (row.getText().contains(SearChData)) {
	            isDataDeleted = false;
	            break;
	        }
	    }
	    
	    if (isDataDeleted) {
	        System.out.println("Incoming sample data has been deleted successfully.");
	        testCase.log(Status.PASS,"Incoming sample data has been deleted successfully");
	    } else {
	        System.out.println("Failed to delete incoming sample data.");
	        testCase.log(Status.FAIL,"Failed to delete incoming sample data");
	    }
	}


}
