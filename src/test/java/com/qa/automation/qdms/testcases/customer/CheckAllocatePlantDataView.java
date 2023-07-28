//***********************************************************************************
//* Description
//*------------
//* Allocate Plant Data View Functionality In Customer
//***********************************************************************************
//*
//* Author           : Sasikala Amabalavanar
//* Date Written     : 17/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-CUS-0040         17/07/2023    Sasi     	Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.source.SourceTest;

public class CheckAllocatePlantDataView extends DriverIntialization {
	static CustomerPage Customerpg = new CustomerPage();
	static boolean work = false;
	static String ExpectedData = "";

	@Test
	public static void allocatePlant() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Customerpg);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Login Functional
		LoginTest.Login();

		// Click Master Card
		wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.Master));
		if (LoginTest.login) {
			SourceTest.CommonMethod(CustomerPage.Master, "Master Card");
		}

		// Click Customer Top Menu
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customertopmenu, "Customer Top Menu Card");
		}

		// Customer Site Button
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customersitebutton, "Customer Site Bar Button");
		}
		if (SourceTest.work) {
			work = false;
			AddAllocateautoclickplant();
		}

		if (clickplant) {
			confirmModel();
		}

		// Driver Refresh
		driver.navigate().refresh();

		// Logout Functional
		if (LoginTest.login) {
			Logout.LogoutFunction();
		}
	}

// ******************** Add Allocate Plant Functional **********************************************							
	static boolean clickplant = false;

	public static void AddAllocateautoclickplant() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Customerpg);
		clickplant = false;
		try {
			Thread.sleep(3000);

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Customer");

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Customer",
					"TC-CUS-0040");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "Customer",
					"TC-CUS-0040");

			for (int j = firstrow; j <= lastrow; j++) {
				XSSFRow row = sheet.getRow(j);

				String Customername = (String) row.getCell(1).getStringCellValue();
				ExpectedData = (String) row.getCell(2).getStringCellValue();
				Thread.sleep(2000);

				String Name = Customername;

// ************************ EDIT BASIC LOOP FUNCTIONS ****************************

				boolean clickNextPage = true;
				boolean CustomerExist = false;
				while (clickNextPage) {
					for (int i = 2; i < 103; i++) {
						Thread.sleep(1000);
						try {
							String text = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();

							System.out.println(text);
							if (text.equals(Name)) {
								CustomerExist = true;
								try {
									driver.findElement(By
											.xpath("//td[1][text()='" + Name + "']/following-sibling::td[5]/span/span"))
											.click();
								} catch (Exception e) {

								}
								Thread.sleep(2000);
								clickNextPage = false;
								break;
							}
						} catch (Exception e) {
						}
					}
					if (clickNextPage == true) {

						clickNextPage = CustomerPage.NextPageBtn.isEnabled();

						if (CustomerPage.NextPageBtn.isEnabled()) {
							CustomerPage.NextPageBtn.click();
							Thread.sleep(2000);
						} else {
							System.out.println("Button Not Enabled");
						}
					} else {
						break;
					}

				}
				if (CustomerExist = false) {
					System.out.println("No such Element" + CustomerExist);
				}
			}
			clickplant = true;

		} catch (Exception e) {
			testCase = extent.createTest("Excel Not Working ");
			testCase.log(Status.INFO, "check Excel data");
			testCase.log(Status.FAIL, "wrong");

		}
	}

//	**************************	CHECK THE ALLOCATE PLANT VIEW TO CONFIM **************************

	static boolean data = false;

	public static void confirmModel() {

		boolean data = true;
		String ActualData = CustomerPage.allocatePlantmodalcontent.getText();
		data = true;

		testCase = extent.createTest("CONFIRM THE ALLOCATE PLANT DETAILS");
		try {
			AssertJUnit.assertEquals(ActualData, ExpectedData);

		} catch (AssertionError e) {
			data = false;
		}
		if (data) {
			testCase.log(Status.INFO, "ActualData :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedData :- " + ExpectedData);
			testCase.log(Status.PASS, "Correct Data");
		} else {
			testCase.log(Status.INFO, "ActualData :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedData :- " + ExpectedData);
			testCase.log(Status.FAIL, "Wrong Data");
		}

	}
}
