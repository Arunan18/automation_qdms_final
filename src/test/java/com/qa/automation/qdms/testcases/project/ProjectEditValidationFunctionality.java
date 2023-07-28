//***********************************************************************************
//* Description
//*------------
//* Project Module Edit Validation Functionality
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 13/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRO-0077         13/03/2023   Priyanka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.pages.master.ProjectPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class ProjectEditValidationFunctionality extends DriverIntialization {

	static boolean update = false;
	static boolean updateBtnVisi = false;
	static boolean checkFirst = false;
	static ProjectPage projectpage = new ProjectPage();

	@Test
	public void ProjectEditinMiddle() throws InterruptedException, IOException {

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

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Project";
		String testCaseId = "TC-PRO-0077";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String searchdata = (String) row.getCell(1).getStringCellValue();
			String beforeplant = (String) row.getCell(2).getStringCellValue();
			String beforeproject = (String) row.getCell(3).getStringCellValue();

			String beforecustomer = (String) row.getCell(4).getStringCellValue();

			String beforecontactperson = (String) row.getCell(5).getStringCellValue();

			String beforecontactno = (String) row.getCell(6).getStringCellValue();
			String beforedate = (String) row.getCell(7).getStringCellValue();
			String plant = (String) row.getCell(8).getStringCellValue();
			String project = (String) row.getCell(9).getStringCellValue();

			String customer = (String) row.getCell(10).getStringCellValue();

			String contactperson = (String) row.getCell(11).getStringCellValue();
			String contactno = (String) row.getCell(12).getStringCellValue();
			String startdate = (String) row.getCell(13).getStringCellValue();

			if (MasterMainNavigationsTest.clickProject) {

				ProjectMethods.Projectsearch("STEP-01 ", "STEP-02 ", searchdata);

			}

			if (ProjectMethods.updateclick) {

				Thread.sleep(1000);
				materialMethodes.popupdatacompare(beforeplant + "," + beforeproject + "," + beforecustomer + ","
						+ beforecontactperson + "," + beforecontactno + "," + beforedate);
			} else {
				testCase = extent.createTest("Dont Have Searched Element to Update");
				testCase.log(Status.INFO, "Dont Have Searched Element");
				testCase.log(Status.FAIL, "So fail");

			}

			if (materialMethodes.edit) {

				PageFactory.initElements(driver, projectpage);

				if (!beforeplant.contentEquals(plant)) {
					MultiSearchMethods.textBoxData(ProjectPage.planttextbox, "Plant ", plant);
				}

				if (!beforeproject.contentEquals(project)) {
					MultiSearchMethods.textBoxData(ProjectPage.projecttextbox, "Project ", project);
				}

				if (!beforecustomer.contentEquals(customer)) {
					MultiSearchMethods.textBoxData(ProjectPage.customertextbox, "Customer ", customer);
				}
				if (!beforecontactperson.contentEquals(contactperson)) {
					MultiSearchMethods.textBoxData(ProjectPage.contactPersontextbox, "Contact Person ", contactperson);
				}

				if (!beforecontactno.contentEquals(contactno)) {
					MultiSearchMethods.textBoxData(ProjectPage.contactnotextbox, "Contact Number ", contactno);
				}
				if (!beforedate.contentEquals(startdate)) {
					MultiSearchMethods.textBoxData(ProjectPage.startdate, "Start Date ", startdate);
				}
			} else {

				testCase = extent.createTest("Dont Have Searched Element to Update");
				testCase.log(Status.INFO, "Dont Have Searched Element");
				testCase.log(Status.FAIL, "So fail");
			}

			if (MultiSearchMethods.checked) {
				MultiSearchMethods.Button(ProjectPage.projectupdatebutton, "Project Update");
				if (MultiSearchMethods.BtnVisible && MultiSearchMethods.BtnEnable) {
					MultiSearchMethods.elementClick(ProjectPage.projectupdatebutton);
					update = true;
				}
			}

			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (update) {
				try {
					wait.until(ExpectedConditions.invisibilityOf(ProjectPage.editModal));
					updateBtnVisi = true;
				} catch (Exception e) {
					updateBtnVisi = false;
				}

				if (updateBtnVisi) {
					testCase = extent.createTest("Update Success Message");
					try {
						Assert.assertEquals(ProjectPage.successMessages.getText(), "Project Updated Successfully");
						testCase.log(Status.INFO, "Actual : " + ProjectPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected : Project Updated Successfully");
						testCase.log(Status.PASS, "Success Message Correct, So Pass");
					} catch (Exception e) {
						testCase.log(Status.INFO, "Actual : " + ProjectPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected : Project Updated Successfully");
						testCase.log(Status.FAIL, "Success Message Wrong, So Fail");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual : " + ProjectPage.successMessages.getText());
						testCase.log(Status.INFO, "Expected : Project Updated Successfully");
						testCase.log(Status.FAIL, "Success Message Wrong, So Fail");
					}

					try {
						driver.findElement(By.xpath("//tr[2][td[1][text()='" + searchdata + "'] and td[2][text() = '"
								+ plant + "'] and td[3][text() = '" + project + "'] and td[4][text() = '" + customer
								+ "'] and td[5][text() = '" + contactperson + "'] and td[6][text() = '" + contactno
								+ "'] and td[7][text() = '" + startdate + "']]")).isDisplayed();
						checkFirst = true;
					} catch (Exception e) {
						// TODO: handle exception
					}

					testCase = extent.createTest("Update Function Conformation");
					if (checkFirst) {
						testCase.log(Status.INFO, "Last Updated Have in First Raw");
						testCase.log(Status.INFO, "All Updated datas are in Table");
						testCase.log(Status.PASS, "So, Updated Function Pass");
					} else {
						testCase.log(Status.INFO, "Last Updated Dont Have in First Raw");
						testCase.log(Status.INFO, "All Updated datas are Not in Table");
						testCase.log(Status.FAIL, "So, Updated Function Fail");
					}
				} else {
					try {
						CustomerPage.loadingUpdate.isDisplayed();
						testCase = extent.createTest("Update Button Loading");
						testCase.log(Status.INFO, "Network Error/Validation Not throwng/System Fail");
						testCase.log(Status.FAIL, "So Fail");
						driver.navigate().refresh();
					} catch (Exception e) {
						materialMethodes.validationconfirm("", "", "project");
					}
				}
			}

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
