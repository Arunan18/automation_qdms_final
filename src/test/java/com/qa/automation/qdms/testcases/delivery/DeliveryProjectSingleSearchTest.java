//***********************************************************************************
//* Description
//*------------
//* Project name Single Search Functionality
//* This Script includes TC-DEL-0018 , TC-DEL-0019 , TC-DEL-0020 
//***********************************************************************************
//*
//* Author           : Suntharalingam Arunan
//* Date Written     : 13/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-DEL-0019         13/03/2023     Arunan     Orginal Version
//*  TC-DEL-0020
//*  TC-DEL-0018
//************************************************************************************
package com.qa.automation.qdms.testcases.delivery;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class DeliveryProjectSingleSearchTest extends DriverIntialization{
	DeliveryPage dp = new DeliveryPage();
	boolean DeliveryTableData=true;
	boolean ProjectTableData=true;
	@Test
	public void deliveryMultiearch() throws InterruptedException, IOException {
		PageFactory.initElements(driver, dp);
		int firstrow = CommonMethods.getFirstRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Delivery", "TC-DEL-0019");
		int lastrow=CommonMethods.getLastRowNum(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx",  "Delivery", "TC-DEL-0019");
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Delivery");
		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			int Project = (int) row.getCell(11).getNumericCellValue();
			int Projecttotal = (int) row.getCell(12).getNumericCellValue();
			
			 
			
		LoginTest.Login();

		MasterMainNavigationsTest.navigateMaster();

		MasterMainNavigationsTest.navigateCustomerMain();

		MasterMainNavigationsTest.navigateDelivery();

//		STEP 1 : Delivery - Project Name Search Button Properties
		MultiSearchMethods.checkSearch(DeliveryPage.ProjectSearch, "STEP 1 : Delivery - Project Name");

//		STEP 2 : Delivery - Project Name Search Icon Click
		MultiSearchMethods.ClickSearch(DeliveryPage.ProjectSearch, DeliveryPage.SearchTextBox,"STEP 2 : Delivery - Project Name");

//		STEP 3 : Delivery - Project Name Search Text Box Properties
		MultiSearchMethods.SearchTextBox(DeliveryPage.SearchTextBox, "STEP 3 : Delivery - Project Name");

//		STEP 4 : Delivery - Project Name Search Button Properties
		MultiSearchMethods.SearchButton(DeliveryPage.SearchBtn, "STEP 4 : Delivery - Project Name");
 
//		STEP 5 : Delivery - Project Name Search Data Input
		MultiSearchMethods.inputDataSearch("TC-DEL-0019", DeliveryPage.SearchTextBox, "STEP 5 : Delivery - Project Name","Delivery", 1, DeliveryPage.ProjectColumn);

//		STEP 6 : Delivery - Project Name Search Button Click
		MultiSearchMethods.SearchButtonClick(DeliveryPage.SearchBtn, DeliveryPage.ResetAll,
				"STEP 6 : Delivery - Project Name");

//		STEP 7 : Delivery - Project Name Single Search Function
		MultiSearchMethods.checkAfterSearchData(DeliveryPage.ProjectColumn, DeliveryPage.ProjectColumnBefore,DeliveryPage.ProjectColumnAfter, "STEP 7 : Delivery - Project Name",Project,ProjectTableData);

//		STEP 8 : Delivery - Project Name Single Search Reset Button Properties
		MultiSearchMethods.resetButton(DeliveryPage.resetBtn, "STEP 8 : Delivery - Project Name Single Search Reset Button");
		Thread.sleep(3000);
		
//		STEP 9 : Delivery - Project Name Single Search Reset Button Function
		MultiSearchMethods.ButtonClick(DeliveryPage.resetBtn, "STEP 9 : Delivery - Project Name Single Search Reset", DeliveryPage.ProjectColumn, Projecttotal);
		
		MultiSearchMethods.Logout();
	}
}
}
