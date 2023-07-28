//***********************************************************************************
//* Description
//*------------
//* Additional Information Clear Button Function
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-087		      16/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AdditionalInformationClearButtonFunction extends DriverIntialization {

	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, methods);

		// LOGIN
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				testnav.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TEST PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				managepage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// PAGE SCROLL UNTIL ADDITIONAL INFORMATION
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//td[@class='ant-table-cell'])[25]");

		// SELECT THE ADDITIONAL INFORMATION BUTTON DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ADDITIONAL INFORMATION BUTTON PROPERTIES");

		// SELECT THE VALUE
		AddGroupKey.actionS(0, 10, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-087-01", 1);

		// ADD DATA
		adddata();

		// CLEAR FIELD METHOD
		clearfieldmethod();

		Thread.sleep(1000);
		driver.navigate().refresh();
		// Logout
		Logout.LogoutFunction();

	}

	static boolean select;

	/* Add Data Method */
	public static void adddata() throws IOException, InterruptedException {
		PageFactory.initElements(driver, testnav);
		Boolean click = true;

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-087";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		int l = 1;

		for (int j = firstRow; j <= lastRow; j++) {

			XSSFRow row = sheet.getRow(j);
			String check = (String) row.getCell(2).getStringCellValue();
			String caption = (String) row.getCell(3).getStringCellValue();
			if (caption.equals("")) {
				break;

			}
			String recordtype = (String) row.getCell(4).getStringCellValue();
			int maxlength = (int) row.getCell(5).getNumericCellValue();
			boolean selectloop = (boolean) row.getCell(6).getBooleanCellValue();

			System.out.println(firstRow);
			System.out.println(lastRow);
			try {
				if (driver
						.findElement(By.xpath(
								"//form[@id=\"test\"]/div[" + l + "]/div/div/div/div/div/input[@id=\"caption\"]"))
						.isDisplayed()) {
					testCase = extent.createTest("ROW_" + l + "--CAPTION FIELD DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");
					if (driver
							.findElement(By.xpath(
									"//form[@id=\"test\"]/div[" + l + "]/div/div/div/div/div/input[@id=\"caption\"]"))
							.isDisplayed()) {
						testCase = extent.createTest("ROW_" + l + "--CAPTION FIELD ENABLED");
						testCase.log(Status.PASS, "TEST PASS");

						driver.findElement(By.xpath(
								"//form[@id=\"test\"]/div[" + l + "]/div/div/div/div/div/input[@id=\"caption\"]"))
								.sendKeys(caption);
					} else {
						testCase = extent.createTest("ROW_" + l + "--CAPTION FIELD ENABLED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("ROW_" + l + "--CAPTION FIELD DISPLAYED");
					testCase.log(Status.PASS, "TEST FAIL");
				}

				/* Select the drop down for Test Field */
				Actions actions = new Actions(driver);
				if (recordtype != "") {
					boolean findthevalue = false;
					for (int i = 0; i < 20; i++) {
						try {
							if (driver
									.findElement(By.xpath(
											"//form[@id=\"test\"]/div[" + l + "]/div[2]/div/div/div/div/div/div"))
									.isDisplayed()) {
								testCase = extent.createTest("ROW_" + l + "--RECORD TYPE DROP DOWN FIELD DISPLAYED");
								testCase.log(Status.PASS, "TEST PASS");
								if (driver
										.findElement(By.xpath(
												"//form[@id=\"test\"]/div[" + l + "]/div[2]/div/div/div/div/div/div"))
										.isEnabled()) {
									testCase = extent.createTest("ROW_" + l + "--RECORD TYPE DROP DOWN FIELD ENABLED");
									testCase.log(Status.PASS, "TEST PASS");

									Thread.sleep(1000);
									driver.findElement(By.xpath(
											"//form[@id=\"test\"]/div[" + l + "]/div[2]/div/div/div/div/div/div"))
											.click();

									Thread.sleep(2000);
									driver.findElement(
											By.xpath("(//div[contains(text(),'" + recordtype + "')])[" + l + "]"))
											.click();
									findthevalue = true;
									break;
								} else {
									testCase = extent
											.createTest("ROW_" + l + "--RECORD TYPE DROP DOWN FIELD DISPLAYED");
									testCase.log(Status.PASS, "TEST FAIL");
								}
							} else {
								testCase = extent.createTest("ROW_" + l + "--RECORD TYPE DROP DOWN FIELD ENABLED");
								testCase.log(Status.PASS, "TEST FAIL");
							}
						} catch (Exception e) {
							actions.sendKeys(Keys.ARROW_DOWN).perform();
						}
					}
				}

				if (driver
						.findElement(By.xpath(
								"//form[@id=\"test\"]/div[" + l + "]/div[3]/div/div/div/div/input[@id=\"length\"]"))
						.isDisplayed()) {
					testCase = extent.createTest("ROW_" + l + "--MAX LENGTH FIELD DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");

					if (driver
							.findElement(By.xpath(
									"//form[@id=\"test\"]/div[" + l + "]/div[3]/div/div/div/div/input[@id=\"length\"]"))
							.isEnabled()) {
						testCase = extent.createTest("ROW_" + l + "--MAX LENGTH FIELD ENABLED");
						testCase.log(Status.PASS, "TEST PASS");

						driver.findElement(By.xpath(
								"//form[@id=\"test\"]/div[" + l + "]/div[3]/div/div/div/div/input[@id=\"length\"]"))
								.sendKeys(String.valueOf(maxlength));
					} else {
						testCase = extent.createTest("ROW_" + l + "--MAX LENGTH FIELD DISPLAYED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("ROW_" + l + "--MAX LENGTH FIELD ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}

				Thread.sleep(1000);
				if (driver
						.findElement(By.xpath("//form[@id=\"test\"]/div[" + l + "]/div[4]/div/div/div/div/label/span"))
						.isDisplayed()) {
					testCase = extent.createTest("ROW_" + l + "--ACTIVE CHECK BOX FIELD DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS");

					if (driver
							.findElement(
									By.xpath("//form[@id=\"test\"]/div[" + l + "]/div[4]/div/div/div/div/label/span"))
							.isEnabled()) {
						testCase = extent.createTest("ROW_" + l + "--ACTIVE CHECK BOX FIELD ENABLED");
						testCase.log(Status.PASS, "TEST PASS");

						select = driver
								.findElement(By
										.xpath("//form[@id=\"test\"]/div[" + l + "]/div[4]/div/div/div/div/label/span"))
								.isSelected();

					} else {
						testCase = extent.createTest("ROW_" + l + "--ACTIVE CHECK BOX FIELD DISPLAYED");
						testCase.log(Status.PASS, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("ROW_" + l + "--ACTIVE CHECK BOX FIELD DISPLAYED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
				System.out.println("Boolean" + select);

				String selectedvalue = String.valueOf(select);
				System.out.println("string" + selectedvalue);

				if (check.equals(selectedvalue)) {
					// managepage.checkbox.click();

				} else {
					driver.findElement(
							By.xpath("//form[@id=\"test\"]/div[" + l + "]/div[4]/div/div/div/div/label/span")).click();

				}
				Thread.sleep(1000);
				System.out.println("Selected loop" + selectloop);

			} catch (Exception e) {
				// TODO: handle exception
			}

			l = l + 1;
			try {
				driver.findElement(
						By.xpath("//form[@id=\"test\"]/div[" + l + 1 + "]/div[4]/div/div/div/div/label/span"))
						.isDisplayed();
			} catch (Exception e) {
				click = false;
			}
		}
	}

	public static void clearfieldmethod() {
		SampleCommonMethods.singleclick("STEP_05-- CLEAR BUTTON PROPERTIES", ManageTestsPage.clearbutton,
				"01--CLEAR BUTTON DISPLAYED", "02--CLEAR BUTTON ENABLED");
		boolean clearbutton = true;
		if (clearbutton = true) {
			testCase = extent.createTest("03--CLEAR BUTTON CLICKED");
			testCase.log(Status.PASS, "TEST PASS");

			if (driver.findElement(By.xpath("//*[@id='caption']")).getText() == "") {
				testCase = extent.createTest("04--CAPTION FIELD CEARED");
				testCase.log(Status.PASS, "TEST PASS");

				if (driver.findElement(By.xpath("//input[@id='recordType']")).getText() == "") {
					testCase = extent.createTest("05--RECORT TYPE FIELD CLEARED");
					testCase.log(Status.PASS, "TEST PASS");

					if (driver.findElement(By.xpath("//input[@id='length']")).getText() == "") {
						testCase = extent.createTest("06--MAX LENGTH FIELD CLEARED");
						testCase.log(Status.PASS, "TEST PASS");

						if (driver.findElement(By.xpath("//input[@id='dynamic_form_nest_item_users_0_active']"))
								.isSelected() == false) {
							testCase = extent.createTest("07--ACTION CHECK BOX CLEARED ");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("07--ACTION CHECK BOX NOT CLEARED ");
							testCase.log(Status.FAIL, "TEST PASS");
						}
					} else {
						testCase = extent.createTest("06--MAX LENGTH FIELD NOT CLEARED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("05--RECORT TYPE FIELD NOT CLEARED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} else {
				testCase = extent.createTest("04--CAPTION FIELD NOT CEARED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} else {
			testCase = extent.createTest("03--CLEAR BUTTON NOT CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
}
