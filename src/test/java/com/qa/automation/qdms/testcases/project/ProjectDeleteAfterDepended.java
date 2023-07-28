////***********************************************************************************
////* Description
////*------------
////* Project Delete Functionality after depended
////***********************************************************************************
////*
////* Author           : Priyanka Sundaramoorthy
////* Date Written     : 22/02/2023
////* 
////*
////* 
////* Test Case Number       Date         Intis        Comments
////* ================       ====         =====        ========
////* TC-PRO-0088           22/02/2023   Priyanka     Orginal Version
////*
////************************************************************************************
//
//
//package com.qa.automation.qdms.testcases.project;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;
//import com.qa.automation.qdms.base.DriverIntialization;
//import com.qa.automation.qdms.commonmethods.CommonMethods;
//import com.qa.automation.qdms.pages.master.ProjectPage;
//import com.qa.automation.qdms.testcases.login.LoginTest;
//import com.qa.automation.qdms.testcases.master.MasterTest;
//
//public class ProjectDeleteAfterDepended extends DriverIntialization {
//
//	@Test
//	public void ProjectDelFirstPage() throws InterruptedException, IOException {
//
//		LoginTest.Login();
//
//		MasterTest.MasterCard();
//
//		ProjectMethods.ProjectPagination();
//
//		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
//		String excelSheetName = "Project";
//		String testCaseId = "TC-PRO-0088";
//
//		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
//		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
//
//		FileInputStream file = new FileInputStream(excelPath);
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheet(excelSheetName);
//
//		for (int i = firstRow; i <= lastRow; i++) {
//
//			XSSFRow row = sheet.getRow(i);
//
//			String searchdata = (String) row.getCell(1).getStringCellValue();
//			Boolean afterdeletion = (Boolean) row.getCell(2).getBooleanCellValue();
//			Thread.sleep(3000);
//
//			// **********************************************************************************
//			// STEP-01 Searching Data to Delete
//			// **********************************************************************************
//			Thread.sleep(2000);
//			ProjectDeleteCommonMethod.ProjectDeletedependconfirm();
//			Thread.sleep(2000);
//			ProjectDeleteCommonMethod.ProjectDeletedependsearch(searchdata, "STEP-01 ", "STEP-02 ");
//			Thread.sleep(2000);
//			// **********************************************************************************
//			// STEP-02 Clicking Delete Button
//			// **********************************************************************************
//
//			ProjectPage.projectdeleteok.click();
//			Thread.sleep(4000);
//
//			// **********************************************************************************
//			// STEP-03 Checking count after deletion
//			// **********************************************************************************
//
//			ProjectDeleteCommonMethod.ProjectAfterDeletedependconfirm();
//
//			ProjectDeleteCommonMethod.ProjectDeleteDependEqu("STEP-03 ",afterdeletion);
//
//		}
//	}
//
//}
