//***********************************************************************************
//* Description
//*------------
//* USER MORE DETAILS POPUP DETAILS
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 18/07/2023
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-USER-0043           18/07/2023    Sasi      Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.user;

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
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.source.SourceTest;

public class UserMoreDetailsPopUpTest extends UserMainTests {
	static UserPage userpg = new UserPage();
	static String ExpectedData = "";

	@Test
	public static void userMoreDetails() throws InterruptedException, IOException {
		PageFactory.initElements(driver, userpg);

		// Login Test
		LoginTest.Login();

		// Master Card Click
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		// Navigate Employee Main Screen
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateEmployeeMain();
		}

		// Navigate User Screen
		if (MasterMainNavigationsTest.clickEmployeeMain) {
			MasterMainNavigationsTest.navigateUser();
		}

		// Click More Based on User email Functional
		if (MasterMainNavigationsTest.clickUser) {
			viewMoreClickIcon();
		}

		// Confirm More Option
		if (clickplant) {
			confirmModel();
		}

		// Driver Refresh Page
		driver.navigate().refresh();

		// Logout Page
		if (LoginTest.login) {
			Logout.LogoutFunction();
		}
	}

// ************* Click More Based on User email Functional *****************

	static boolean clickplant = false;

	public static void viewMoreClickIcon() throws InterruptedException, IOException {

		PageFactory.initElements(driver, userpg);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		clickplant = false;
		try {
			Thread.sleep(3000);

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("User");

			int firstrow = CommonMethods.getFirstRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "User",
					"TC-USER-0043");
			int lastrow = CommonMethods.getLastRowNum(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Master Module.xlsx", "User",
					"TC-USER-0043");

			for (int j = firstrow; j <= lastrow; j++) {
				XSSFRow row = sheet.getRow(j);

				String Useremail = (String) row.getCell(1).getStringCellValue();
				ExpectedData = (String) row.getCell(2).getStringCellValue();
				Thread.sleep(2000);

				boolean clickNextPage = true;
				boolean CustomerExist = false;
				while (clickNextPage) {
					for (int i = 2; i <= 11; i++) {
						Thread.sleep(1000);
						try {
							String text = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();

							System.out.println("-" + text + "-" + Useremail + "-");
							Thread.sleep(200);
							if (text.contentEquals(Useremail)) {

								try {
									wait.until(ExpectedConditions.elementToBeClickable(
											driver.findElement(By.xpath("//td[text()='" + Useremail
													+ "']//following-sibling::td[7]//span[@class='anticon anticon-ellipsis']"))));
									SourceTest.CommonMethod(driver.findElement(By.xpath("//td[text()='" + Useremail
											+ "']//following-sibling::td[7]//span[@class='anticon anticon-ellipsis']")),
											"More Option Icon");
									CustomerExist = true;
									break;
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							}
						} catch (Exception e) {
						}
					}
					if (CustomerExist) {
						break;
					}
					clickNextPage = UserPage.NextPageBtn.isEnabled();

					if (clickNextPage) {
						UserPage.NextPageBtn.click();
					} else {
						System.out.println("Button Not Enabled");
					}

				}

			}
			clickplant = true;

		} catch (Exception e) {
			testCase = extent.createTest("Excel Not Working ");
			testCase.log(Status.INFO, "check Excel data");
			testCase.log(Status.FAIL, "wrong");

		}
	}

// ************** CHECK THE MORE DETAILS SUPPLIER VIEW TO CONFIM **********

	static boolean data = false;

	public static void confirmModel() throws InterruptedException {
		PageFactory.initElements(driver, userpg);

		String ActualData = "";
		testCase = extent.createTest("CONFIRM THE MORE DETAILS SUPPLIER VIEW");
		try {
			data = true;
			Thread.sleep(1000);
			ActualData = UserPage.moremodalcontent.getText();
			AssertJUnit.assertEquals(ActualData, ExpectedData);
			testCase.log(Status.INFO, "ActualData :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedData :- " + ExpectedData);
			testCase.log(Status.PASS, "Correct Data");
		} catch (AssertionError e) {
			data = false;
			testCase.log(Status.INFO, "ActualData :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedData :- " + ExpectedData);
			testCase.log(Status.FAIL, "Wrong Data");
		}

	}
}
