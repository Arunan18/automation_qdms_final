//***********************************************************************************
//* Description
//*------------
//* Testparameter Validation Under Test Parameter
//***********************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     :23/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0108			 23/05/2023    MATHUSAN     Original Version
//* 
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class Testparametervalidationundertestparameter extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();

	static TestConfigPage addPage = new TestConfigPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();

	@Test

	public static void TestParameterdatatypesearchtextboxfunction() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);
		PageFactory.initElements(driver, addPage);

		// Click LOGIN Button
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// Click the Manage Configure Scorall Page
		managetestconfigurationscorallpage();

		// Click the Edit Configure
		EditConfigure();

		// Click the TestParameter
		testparameter();

		// Click Refresh Button
		driver.navigate().refresh();

		// Click Logout Button
		Logout.LogoutFunction();

	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() throws InterruptedException {
		try {
			TestConfigPage.managetestcongigurescrollpage.click();
			testCase = extent.createTest("CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.PASS, "TEST PASS");

		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						ManageTestsPage.editconfigureheading.click();
						testCase = extent.createTest("EDIT CONFIGURE HEADING FOUND");
						testCase.log(Status.PASS, "TEST PASS");
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2000);
				} else {
					break;
				}

			}
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("EDIT CONFIGURE HEADING HEADING NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// Click the Select Edit Configure

	public static void EditConfigure() throws InterruptedException {

		PageFactory.initElements(driver, ACM);
		Thread.sleep(3000);

		// SELECT THE EDIT CONFIGURE TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 14, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0108-01", 1);

	}

	static String searchvalue1 = null;
	static String validationdata = null;
	static String Actualvalue = null;
	static String Expectedvalue = null;
	static String Validationmessage = null;
	static String Searchvalue1 = null;
	static String Abbreviation = null;
	static String Type = null;
	static String Inputmethod = null;
	static String Unit = null;
	static String DecimalValue = null;

	// Click the Test Parameter

	public static void testparameter() throws IOException, InterruptedException {

		// CLICK THE TESTPARAMETER BUTTON
		Boolean isVisible1;
		try {
			isVisible1 = ManageTestsPage.testparametericon.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.testparametericon.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.testparametericon.click();
					testCase = extent.createTest("CLICK THE TESTPARAMETER BUTTON");
					testCase.log(Status.PASS, "TEST PASS");
				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE TESTPARAMETER BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE TESTPARAMETER BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// Send the data for Excel
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0108";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		for (int i = firstRow; i <= lastRow; i++) {
			DataFormatter gh = new DataFormatter();
			XSSFRow row = sheet.getRow(i);

			XSSFCell cell2 = row.getCell(2);
			Searchvalue1 = gh.formatCellValue(cell2);

			XSSFCell cell3 = row.getCell(3);
			Abbreviation = gh.formatCellValue(cell3);

			XSSFCell cell4 = row.getCell(4);
			Type = gh.formatCellValue(cell4);

			XSSFCell cell5 = row.getCell(5);
			Inputmethod = gh.formatCellValue(cell5);

			XSSFCell cell6 = row.getCell(6);
			Unit = gh.formatCellValue(cell6);

			XSSFCell cell7 = row.getCell(7);
			DecimalValue = gh.formatCellValue(cell7);

			Validationmessage = (String) row.getCell(8).getStringCellValue();
			XSSFCell cell9 = row.getCell(9);
			String val = gh.formatCellValue(cell9);

			XSSFCell cell10 = row.getCell(10);
			String cle = gh.formatCellValue(cell10);

			// Data Not Visible
			Boolean cli = false;
			try {
				driver.findElement(By.xpath("//td[text()='" + Searchvalue1 + "']/following-sibling::td[3]//input"))
						.click();
				testCase = extent.createTest(" CLICK THE SEARCH VALUE 1");
				testCase.log(Status.PASS, "TEST PASS");
				cli = true;
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK SAVE PARAMETER BUTTON");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE SEARCH VALUE 1");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			Boolean dis = false;
			try {
				dis = TestConfigPage.testparameternodatadisplay.isDisplayed();
				testCase = extent.createTest("NODATA DISPLAY");
				testCase.log(Status.PASS, "TEST PASS");
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT NODATA DISPLAY");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
			if (dis == true) {

				// CLICK SAVE PARAMETER BUTTON

				try {
					Boolean isVisible2 = TestConfigPage.clickthesaveparameterbutton.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Save Parameter Button Visible", "true", isVisible2,
							"definition");
					if (isVisible2 == true) {

						Boolean isEnabled2 = TestConfigPage.clickthesaveparameterbutton.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Save Parameter Button Enable", "true", isEnabled2,
								"definition");

						if (isEnabled2 == true) {

							TestConfigPage.clickthesaveparameterbutton.click();
							testCase = extent.createTest(" CLICK SAVE PARAMETER BUTTON");
							testCase.log(Status.PASS, "TEST PASS");
						}
					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT CLICK SAVE PARAMETER BUTTON");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK SAVE PARAMETER BUTTON");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			}

			// Click the Abbreviation Text box , send the Data & Clear the Data

			if (cli == true) {
				try {
					Boolean isVisible2 = driver
							.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='" + Searchvalue1
									+ "']/following-sibling::td[2]"))
							.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Abbreviation Text box Visible", "true", isVisible2,
							"definition");
					if (isVisible2 == true) {

						Boolean isEnabled2 = driver
								.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
										+ Searchvalue1 + "']/following-sibling::td[2]"))
								.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Abbreviation Text box Enable", "true", isEnabled2,
								"definition");

						if (isEnabled2 == true) {

							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[2]")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[2]//input")).sendKeys(Abbreviation);

							if (cle.equals("clear")) {
								driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
										+ Searchvalue1 + "']/following-sibling::td[2]//input"))
										.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);

								testCase = extent
										.createTest("CLICK THE ABBREVIATION TEXT BOX ,SEND THE DATA & CLEAR THE DATA");
								testCase.log(Status.PASS, "TEST PASS");
							}

						}
					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOTCLICK THE ABBREVIATION TEXT BOX ,SEND THE DATA & CLEAR THE DATA");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK THE ABBREVIATION TEXT BOX ,SEND THE DATA & CLEAR THE DATA");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				// Click the type Text box & send the Data

				Boolean isVisible3;
				try {
					isVisible3 = driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
							+ Searchvalue1 + "']/following-sibling::td[3]")).isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Type Text box Visible", "true", isVisible3, "definition");
					if (isVisible3 == true) {

						Boolean isEnabled3 = driver
								.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
										+ Searchvalue1 + "']/following-sibling::td[3]"))
								.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Type Text box Enable", "true", isEnabled3,
								"definition");

						if (isEnabled3 == true) {

							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[3]")).click();
							Thread.sleep(1000);

							System.out.println("typr" + Type);

							driver.findElement(By.xpath("//div[text()='" + Type + "']/..")).click();
							testCase = extent.createTest("CLICK TYPE TEXT BOX");
							testCase.log(Status.PASS, "TEST PASS");
						}
					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT CLICK TYPE TEXT BOX");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK TYPE TEXT BOX");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				// Click the Input Method Text Box & send the Data

				try {
					Boolean isVisible4 = driver
							.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='" + Searchvalue1
									+ "']/following-sibling::td[4]"))
							.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Input Method box Visible", "true", isVisible4,
							"definition");
					if (isVisible4 == true) {

						Boolean isEnabled4 = driver
								.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
										+ Searchvalue1 + "']/following-sibling::td[4]"))
								.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Input Method box Enable", "true", isEnabled4,
								"definition");

						if (isEnabled4 == true) {

							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[4]")).click();
							Thread.sleep(1000);

							driver.findElement(By.xpath("//div[text()='" + Inputmethod + "']")).click();
							testCase = extent.createTest("CLICK INPUTMETHOD TEXT BOX");
							testCase.log(Status.PASS, "TEST PASS");
						}
					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT CLICK INPUTMETHOD TEXT BOX");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK INPUTMETHOD TEXT BOX");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				// Click the Unit Text Box & send the Data

				try {
					Boolean isVisible5 = driver
							.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='" + Searchvalue1
									+ "']/following-sibling::td[6]"))
							.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Unit Text box Visible", "true", isVisible5, "definition");
					if (isVisible5 == true) {

						Boolean isEnabled5 = driver
								.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
										+ Searchvalue1 + "']/following-sibling::td[6]"))
								.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Unit Text box Enable", "true", isEnabled5,
								"definition");

						if (isEnabled5 == true) {

							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[6]")).click();
							Thread.sleep(1000);

							driver.findElement(By.xpath("//div[text()='" + Unit + "']")).click();
							testCase = extent.createTest("CLICK UNIT TEXT BOX");
							testCase.log(Status.PASS, "TEST PASS");
						}
					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT CLICK UNIT TEXT BOX");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK UNIT TEXT BOX");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				// Click the Decimal Value & Send the Data

				try {
					Boolean isVisible6 = driver
							.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='" + Searchvalue1
									+ "']/following-sibling::td[7]"))
							.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Decimal Value Text box Visible", "true", isVisible6,
							"definition");
					if (isVisible6 == true) {

						Boolean isEnabled6 = driver
								.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
										+ Searchvalue1 + "']/following-sibling::td[7]"))
								.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Decimal Value Text box Enable", "true", isEnabled6,
								"definition");

						if (isEnabled6 == true) {

							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[7]")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='"
									+ Searchvalue1 + "']/following-sibling::td[7]//input")).sendKeys(DecimalValue);

							testCase = extent.createTest("CLICK DECIMAL VALUE & SEND THE DATA");
							testCase.log(Status.PASS, "TEST PASS");
						}
					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("CLICK DECIMAL VALUE & SEND THE DATA");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("CLICK DECIMAL VALUE & SEND THE DATA");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				// Click the Relevant To Accepted Criteria & Save parameter

				try {
					driver.findElement(By.xpath("//*[text()='Test Parameter']/../../..//td[text()='" + Searchvalue1
							+ "']/following-sibling::td[8]")).click();
					// Click the Save Parameter
					Boolean isVisible7 = TestConfigPage.clickthesaveparameterbutton.isDisplayed();
					PropertiesCommonMethods.TestReportsq("1.Save Parameter Button Visible", "true", isVisible7,
							"definition");
					if (isVisible7 == true) {

						Boolean isEnabled7 = TestConfigPage.clickthesaveparameterbutton.isEnabled();
						PropertiesCommonMethods.TestReportsq("2.Save Parameter Button Enable", "true", isEnabled7,
								"definition");

						if (isEnabled7 == true) {

							TestConfigPage.clickthesaveparameterbutton.click();
							testCase = extent.createTest("CLICK THE SAVE PARAMETER");
							testCase.log(Status.PASS, "TEST PASS");
							Thread.sleep(500);
						}

					}
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT CLICK THE SAVE PARAMETER");
					testCase.log(Status.FAIL, "TEST FAIL");
				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("NOT CLICK THE SAVE PARAMETER");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			}

			// Take the Validation Message

			String vak1 = null;

			if (val.equals("va1")) {
				try {
					vak1 = TestConfigPage.validationmessagetestparameterva1.getText();
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT GET THE CALIDATION MESSAGE VA1");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			}

			else if (val.equals("va2")) {
				try {
					vak1 = TestConfigPage.validationmessagetestparameterva2.getText();
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT GET THE CALIDATION MESSAGE VA2");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			}

			else if (val.equals("va3")) {
				try {
					vak1 = TestConfigPage.validationmessagetestparameterva3.getText();
				} catch (NoSuchElementException E) {
					testCase = extent.createTest("NOT GET THE CALIDATION MESSAGE VA3");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			}
			Actualvalue = vak1;
			Expectedvalue = Validationmessage;

			try {

				Assert.assertEquals(Actualvalue, Expectedvalue);
				testCase = extent.createTest("Validationmessage");
				testCase.log(Status.PASS, "Test Pass");
				testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
				testCase.log(Status.INFO, "Expecteddata:" + Expectedvalue);

			} catch (Exception e) {
				testCase = extent.createTest("Validationmessage");
				testCase.log(Status.FAIL, "Test Fail");
				testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
				testCase.log(Status.INFO, "Expecteddata:" + Expectedvalue);

			}

			driver.navigate().refresh();
			Thread.sleep(2000);

		}

	}
}