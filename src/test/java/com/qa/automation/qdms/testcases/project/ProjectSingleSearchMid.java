//***********************************************************************************
//* Description
//*------------
//* Project Single Search in Middle Page 
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 08/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRO-0089           22/02/2023   Priyanka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.pages.master.UnitPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.master.MasterTest;
import com.qa.automation.qdms.testcases.unit.UnitMethods;

public class ProjectSingleSearchMid extends DriverIntialization {

	@Test
	public void ProjectSearchFirst() throws InterruptedException, IOException {

		LoginTest.Login();

		MasterTest.MasterCard();

		ProjectMethods.ProjectPagination();

		// ****************************************************************************************
		// STEP-01--CUSTOMER TAB IS DISPLAYED & STEP-02--CUSTOMER TAB IS ENABLED
		// ****************************************************************************************

		ProjectPage.customerTopTab.click();

	//	ProjectMethods.customertopTab("STEP-01 ", "STEP-02 ");

		// ****************************************************************************************
		// STEP-03--PROJECGT BUTTON IS DISPLAYED & STEP-04--PROJECT BUTTON IS ENABLED
		// ****************************************************************************************

		ProjectMethods.ProjectleftButton("STEP-03 ","STEP-04 ");

		ProjectPage.projectleftbutton.click();
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0089";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String searchdata = (String) row.getCell(1).getStringCellValue();
			int datacount = (int) row.getCell(2).getNumericCellValue();
			int page = (int) row.getCell(3).getNumericCellValue();
			Thread.sleep(3000);



		ProjectMethods.ProjectNavigatetoMiddle(page);
		
		
		// ****************************************************************************************
		// STEP-05--PROEJCT SEARCH ICON IS DISPLAYED & STEP-06--PROJECT SEARCH ICON IS
		// ENABLED
		// ****************************************************************************************

		ProjectMethods.ProjectSearchIcon("STEP-05 ", "STEP-06 ");

		// ************************************************************************************************************
		// STEP-07--CHECKING PROJECT SEARCH TEXTBOX DISPLAYED & STEP-08--CHECKING
		// PROJECT SEARCH TEXTBOX ENABLED
		// ************************************************************************************************************

		ProjectMethods.ProjectSearchTextbox(searchdata ,"STEP-07 ", "STEP-08 ");

		// ************************************************************************************************************
		// STEP-09--CHECKING PROJECT SEARCH BUTTON DISPLAYED & STEP-10--CHECKING PROJECT
		// SEARCH BUTTON ENABLED
		// ************************************************************************************************************

		ProjectMethods.ProjectSearchButton("STEP-09 ", "STEP-10 ");

		// ******************************************************************************************************************
		// STEP-11--SINGLE SEARCH CONFIRM
		// ******************************************************************************************************************
		ProjectMethods.ProjectFSingleSearchConfirm("STEP-11 " , datacount);

	}
	}
}
