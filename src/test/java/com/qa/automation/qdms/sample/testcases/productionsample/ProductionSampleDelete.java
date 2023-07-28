//***********************************************************************************
//* Description
//*------------
//* PRODUCTION SAMPLE DELETE
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0013   19/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleDelete extends DriverIntialization {
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static Logout logout = new Logout();
	
	@Test
	public static void function() throws InterruptedException, IOException
	{
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, methods);
		
	/* LOGIN */
		LoginTest.Login();
		
	/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"01--PRODUCTION SAMPLE CARD DISPLAYED",
				"02--PRODUCTION SAMPLE CARD ENABLED", productionsample.sampletext,"SAMPLES",
				"03--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");
		
	/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
				"01--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"02--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
				productionsample.productionwindowheadding,
				"03--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW"); 
		
	/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES", productionsample.productionsampleLeftNav,
				"01--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", productionsample.productionwindowheadding,"Production Sample",
				"03--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
	/* DELETE SELECTED PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- PRODUCTION SAMPLE DELETE ICON PROPERTIES");
		ActionCommonMethod.actionS(0, 24, ProductionSamplePage.productionSampleTable, "delete", "Samples Module.xlsx",
				"Production Sample", "TC-PRODUCT-SAM-0013-01", 1);
		
		ProductionSamplePage.okbtn.click();
		
		
/*Excel Sheet Value Passing*/	
		
	String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx";
	String excelSheetName = "Production Sample";
	String testCaseId = "TC-PRODUCT-SAM-0013";

	int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
	int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
	
	FileInputStream file = new FileInputStream(excelPath);
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet("Production Sample");
		 
		XSSFRow row = sheet.getRow(firstRow);
		
			String data = (String) row.getCell(1).getStringCellValue();
			String message = (String) row.getCell(2).getStringCellValue();
			int datacount = (int) row.getCell(3).getNumericCellValue();
		
		
	/* DATA DELETED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP_05-- DATA DELETED SUCCESSFULLY",productionsample.deletemsg,message);
	
	/*TABLE DATA COUNT READUSED OR NOT */
		SampleCommonMethods.notequal("STEP_06-- DATA COUNT IN THE DATA TABLE", productionsample.tablecount, String.valueOf(datacount));
		
		 
	/*LOGOUT FROM FINISH PRODUCT SAMPLE*/
	    logout.LogoutFunction();
		
	}

}
