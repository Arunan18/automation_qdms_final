//***********************************************************************************
//* Description
//*------------
//* Add Employee Functionality
//***********************************************************************************
//*
//* Author           : kajenthiran
//* Date Written     : 19/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        19/07/2023   kajan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddEmployee extends EmployeeTest {

	static EmployeePage EmployeePg = new EmployeePage();

	@Test
	public static void addemployee() throws InterruptedException, IOException {
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateEmployeeMain();

		}
		if (MasterMainNavigationsTest.clickEmployeeMain) {
			MasterMainNavigationsTest.clickEmployeeMain = false;
			MasterMainNavigationsTest.navigateEmployee();
		}
		if (MasterMainNavigationsTest.clickEmployee) {
			MasterMainNavigationsTest.clickEmployee = false;
			addEmployee("Master Module", "Employee", "TC-EMP-0084");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

	public static void addEmployee(String excelbook, String exceltab, String testid)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, EmployeePg);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get data from excel

		XSSFRow row = null;

		DataFormatter dataValue = new DataFormatter();
		String filelocation;
		String firstName = null;
		String lasttname = null;
		String plantt = null;
		String desigination = null;
		String employeeAddress = null;
		String employeeContactNo = null;
		String employeeEmail = null;
		try {
			filelocation = "./src/test/resources/Excel/" + excelbook + ".xlsx";
			System.out.println(testid + "ttttttttttttttttttttt");
			int firstrow = CommonMethods.getFirstRowNum(filelocation, exceltab, testid);
			int lastrow = CommonMethods.getLastRowNum(filelocation, exceltab, testid);
			System.out.println(firstrow + "ffffffff");
			System.out.println(lastrow + "llllllllllllll");

			FileInputStream file = new FileInputStream(filelocation);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(exceltab);

			for (int j = firstrow; j <= lastrow; j++) {
				row = sheet.getRow(j);

				firstName = dataValue.formatCellValue(row.getCell(1));
				lasttname = dataValue.formatCellValue(row.getCell(2));
				plantt = dataValue.formatCellValue(row.getCell(3));
				desigination = dataValue.formatCellValue(row.getCell(4));
				employeeAddress = dataValue.formatCellValue(row.getCell(5));
				employeeContactNo = dataValue.formatCellValue(row.getCell(6));
				employeeEmail = dataValue.formatCellValue(row.getCell(7));
				boolean exdata = true;
				/*********************************************************************************************/
				Thread.sleep(2000);
				if (exdata) {
					exdata = false;
					materialMethodes.click(EmployeePage.addEmployeeButton, "ADD employee BUTTON");
				}
				if (materialMethodes.click) {
					materialMethodes.click = false;
					materialMethodes.sendkey(EmployeePage.firstNameField, firstName, "first name");

				}
				if (materialMethodes.sent) {
					materialMethodes.sent = false;
					materialMethodes.sendkey(EmployeePage.lastNameField, lasttname, "last name");
				}
				if (materialMethodes.sent) {
					materialMethodes.sent = false;
					materialMethodes.dropdown(EmployeePage.plantDropdown, plantt,
							"//div[@id='plant_list']//..//div[contains(@class,'ant-select-item')]/div[text()='", "']",
							"plant");

				}
				if (materialMethodes.select) {
					materialMethodes.select = false;
					materialMethodes.dropdown(EmployeePage.designationDropdown, desigination,
							"//div[@id='desigination_list']//..//div[contains(@class,'ant-select-item')]/div[text()='",
							"']", "desigination");

				}
				if (materialMethodes.select) {
					materialMethodes.select = false;
					materialMethodes.sendkey(EmployeePage.employeeAddressField, employeeAddress, "employee");
				}
				if (materialMethodes.sent) {
					materialMethodes.sent = false;
					materialMethodes.sendkey(EmployeePage.employeeContactNoField, employeeContactNo, "contact no");

				}
				if (materialMethodes.sent) {
					materialMethodes.sent = false;
					materialMethodes.sendkey(EmployeePage.employeeEmailField, employeeEmail, "employee email");
				}
				if (materialMethodes.sent) {
					materialMethodes.sent = false;
					materialMethodes.click(EmployeePage.saveBtn, "employ save");
				}
				if (materialMethodes.click) {
					materialMethodes.click = false;
					materialMethodes.popupcheck(driver.findElement(By.xpath("//div[@class='ant-modal-content']")),
							"ADD employee");

				}

				if (materialMethodes.pop) {

					materialMethodes.datacheckinfirstrow("1,2,4,5", 2,
							firstName + "," + lasttname + "," + desigination + "," + employeeEmail,
							"ADD MATERIAL PLANT WISE");

				} else if (!materialMethodes.pop) {

					materialMethodes.validationconfirm("", "", "add employee");
//		          REFRESH
					driver.navigate().refresh();
					Thread.sleep(1000);
				}

			}

		} catch (Exception e) {
			testCase = extent.createTest("EXCEL DATA NOT THERE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
//	          REFRESH
			driver.navigate().refresh();
			Thread.sleep(1000);

		}
	}

}
