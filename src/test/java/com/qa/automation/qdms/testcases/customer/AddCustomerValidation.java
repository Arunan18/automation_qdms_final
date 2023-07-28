
//****************************************************************************************
//		DESCRIPTION
//------------------
//					ADD CUSTOMER VALIDATION FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   21.03.2023	
//****************************************************************************************
//* Test Case Number      		Date          Intis        Comments
//* =================       ======       	========       ========
//* TC-CUS-0072       		21.03.2023    	@SASIKALA      Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddCustomerValidation extends DriverIntialization {

	static boolean per = false;

	static CustomerPage customerfunpg = new CustomerPage();

	@Test(priority = 1)
	public static void fieldvisible() throws InterruptedException, IOException {
		PageFactory.initElements(driver, customerfunpg);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateCustomer();

		}

		testCase = extent.createTest("CUSTOMER ADD FUNCTIONALITY-TC-CUS-0071");

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx";
		String excelSheetName = "Customer";
		String testCaseId = "TC-CUS-0071";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			String plant = (String) row.getCell(1).getStringCellValue();
			String customer = (String) row.getCell(2).getStringCellValue();
			String email = (String) row.getCell(3).getStringCellValue();
			String address = (String) row.getCell(4).getStringCellValue();
			String contactno = (String) row.getCell(5).getStringCellValue();
			String msg = (String) row.getCell(6).getStringCellValue();

			String[] aa = plant.split(",");

			if (MasterMainNavigationsTest.clickCustomer) {

				CustomerMethods.CustomerAddButton("STEP-01 - CHECKING ADD CUSTOMER", "STEP-02 - CHECKING ADD CUSTOMER");

			}
			int count = 0;
			if (CustomerMethods.clickAddButton) {

				if (CustomerPage.Customerplantfiled.isDisplayed()) {
					testCase = extent.createTest("STEP- 03 PLANT FIELD VISIBLE");
					testCase.log(Status.PASS, "TEST PASS");
					if (CustomerPage.AddCustomerbtn.isEnabled()) {
						testCase = extent.createTest("STEP-04 PLANT FIELD IS ENABLED");
						testCase.log(Status.PASS, "TEST PASS");

						WebElement plants = driver.findElement(By.id("customer_plant"));
						for (int n = 0; n < aa.length; n++) {
							plants.click();
							plants.clear();
							plants.sendKeys(aa[n]);
							try {
								Thread.sleep(500);
								plants.click();
								Thread.sleep(500);
								count = driver.findElements(By.xpath(
										"//div[@class='rc-virtual-list']//div[@class='ant-select-item ant-select-item-option']"))
										.size();
							} catch (Exception e1) {

							}
							if (count == 0) {
								count = 9;
							}
							System.out.println("::::::::::::" + count);
							for (int m = 0; m < count; m++) {
								System.out.println("//div[@class='rc-virtual-list-holder-inner']/div[" + m + "]/div");
								WebElement mm = null;
								boolean check = false;
								try {
									mm = driver.findElement(By
											.xpath("//div[@class='rc-virtual-list-holder-inner']/div[" + m + "]/div"));
									check = true;
								} catch (Exception e) {
									check = false;
								}
								if (check) {
									String nn = mm.getText();
									if (nn.contentEquals(aa[n])) {
										plants.sendKeys(Keys.ENTER);
										break;
									}
								}
							}

						}
					}

					CustomerMethods.sendValues(CustomerPage.CustomerFiled, customer,
							"STEP-05 CUSTOMER FIELD IS DISPLAYED", "STEP-06 CUSTOMER FIELD IS ENABLED");
					CustomerMethods.sendValues(CustomerPage.CustomerEmailFiled, email,
							"STEP-07 EMAIL FIELD IS DISPLAYED", "STEP-08 EMAIL FIELD IS ENABLED");
					CustomerMethods.sendValues(CustomerPage.CustomerAddressFiled, address,
							"STEP-09 ADDRESS FIELD IS DISPLAYED", "STEP-10 ADDRESS FIELD IS ENABLED");
					CustomerMethods.sendValues(CustomerPage.CustomerContactNoFiled, contactno,
							"STEP-11 CONTACT NO FIELD IS DISPLAYED", "STEP-12 CONTACT NO FIELD IS ENABLED");

					CustomerMethods.buttonClick(CustomerPage.Customersavebtn, CustomerPage.AddCustomersuccessmsg,
							"STEP-13 SAVE BUTTON IS DISPLAYED", "STEP-14 SAVE BUTTON IS ENABLED", "SAVE BUTTON", msg);

				}

				Thread.sleep(2000);
				PageFactory.initElements(driver, customerfunpg);
				if (CustomerPage.Customersavebtn.isDisplayed()) {
					materialMethodes.validationconfirm("", "", "Add Customer Validation");
					per = true;
				}

				if (per == false) {
					CustomerMethods.confirmAdd(customer);

				}

				driver.navigate().refresh();

				Logout.LogoutFunction();

			}

		}

	}
}
