//***********************************************************************************
//* Description
//*------------
//* Delivery AddButton 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-DEL-0036         01/03/2023   Gobithan     Orginal Version
//*
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
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class DeliveryAdd extends DriverIntialization {

	static DeliveryPage delivery = new DeliveryPage();

	static boolean per = false;

	@Test
	public static void function() throws InterruptedException, IOException {

		PageFactory.initElements(driver, delivery);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateDelivery();

		}

		testCase = extent.createTest("DELIVERY ADD FUNCTIONALITY-TC-DEL-0036");

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Delivery";
		String testCaseId = "TC-DEL-0036";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String delivery = (String) row.getCell(1).getStringCellValue();
			String project = (String) row.getCell(2).getStringCellValue();
			String msg = (String) row.getCell(3).getStringCellValue();

			if (MasterMainNavigationsTest.clickDelivery) {

				DeliveryMethod.deliveryAddButton("STEP-01 - CHECKING ADD DELIVERY", "STEP-02 - CHECKING ADD DELIVERY");

			}

			if (DeliveryMethod.clickAddButton) {
				DeliveryMethod.sendValues(DeliveryPage.DeliveryField, delivery, "STEP-03 DELIVERY FIELD IS DISPLAYED",
						"STEP-04 DELIVERY FIELD IS ENABLED");

				DeliveryMethod.projectfield(project, "STEP-05 ", "STEP-06 ");

				DeliveryMethod.buttonClick(DeliveryPage.Savebtn, DeliveryPage.successmsg,
						"STEP-15 SAVE BUTTON IS DISPLAYED", "STEP-16 SAVE BUTTON IS ENABLED", "SAVE BUTTON", msg);

			}
			try {
				DeliveryPage.Savebtn.isDisplayed();
				materialMethodes.validationconfirm("1", delivery, "Add Delivery Validation");
				per = true;
			} catch (Exception e) {

			}

			if (per == false) {

				DeliveryMethod.confirmAdd(delivery);

			}

			driver.navigate().refresh();

			Logout.LogoutFunction();

		}
	}
}
