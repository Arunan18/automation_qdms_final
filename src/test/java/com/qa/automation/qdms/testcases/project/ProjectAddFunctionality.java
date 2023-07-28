//*************************************************************************************************
//* Description
//*------------
//* Project Add Functionality  
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRO-0066         22/02/2023   Priyanka     Orginal Version
//*                      07/07/2023   Priyanka     Updated all methods 
//************************************************************************************

package com.qa.automation.qdms.testcases.project;

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
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class ProjectAddFunctionality extends DriverIntialization {

	static boolean per = false;

	ProjectPage projectpage = new ProjectPage();

	@Test

	public void ProjectAddFunction() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateProject();

		}

		testCase = extent.createTest("PROJECT ADD FUNCTIONALITY-TC-PROJECT-0066");

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0066";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String plant = (String) row.getCell(1).getStringCellValue();
			String project = (String) row.getCell(2).getStringCellValue();
			String customer = (String) row.getCell(3).getStringCellValue();
			String contactperson = (String) row.getCell(4).getStringCellValue();
			String contactno = (String) row.getCell(5).getStringCellValue();
			String startdate = (String) row.getCell(6).getStringCellValue();
			String msg = (String) row.getCell(7).getStringCellValue();
			String code = (String) row.getCell(8).getStringCellValue();

			if (MasterMainNavigationsTest.clickProject) {

				ProjectMethods.ProjectAddButton("STEP-01 - CHECKING ADD PROJECT", "STEP-02 - CHECKING ADD PROJECT");

			}

			if (ProjectMethods.clickAddButton) {

				ProjectMethods.plantfield(plant, "STEP-03 ", "STEP-04 ");

				ProjectMethods.sendValues(ProjectPage.projectname, project, "STEP-05 PROJECT FIELD IS DISPLAYED",
						"STEP-06 PROJECT FIELD IS ENABLED");

				ProjectMethods.customerfield(customer, "STEP-07 ", "STEP-08 ");

				ProjectMethods.sendValues(ProjectPage.contactperson, contactperson,
						"STEP-09 CONTACT PERSON FIELD IS DISPLAYED", "STEP-10 CONTACT PERSON FIELD IS ENABLED");

				ProjectMethods.sendValues(ProjectPage.contactno, contactno, "STEP-11 CONTACT NUMBER FIELD IS DISPLAYED",
						"STEP-12 CONTACT NUMBER FIELD IS ENABLED");

				ProjectMethods.startdate(ProjectPage.startdate, ProjectPage.startdateselection, startdate,
						"STEP-13 START DATE FIELD IS DISPLAYED", "STEP-14 START DATE FIELD IS ENABLED");

				ProjectMethods.buttonClick(ProjectPage.projectsavebutton, ProjectPage.successMessages,
						"STEP-15 SAVE BUTTON IS DISPLAYED", "STEP-16 SAVE BUTTON IS ENABLED", "SAVE BUTTON", msg);

			}

			Thread.sleep(2000);
			PageFactory.initElements(driver, projectpage);
			if (ProjectPage.projectsavebutton.isDisplayed()) {
				ProjectMethods.errorMessage();
				per = true;
			}

			if (per == false) {
				ProjectMethods.confirmAdd(code);

			}

			driver.navigate().refresh();

			Logout.LogoutFunction();

		}

	}

}
