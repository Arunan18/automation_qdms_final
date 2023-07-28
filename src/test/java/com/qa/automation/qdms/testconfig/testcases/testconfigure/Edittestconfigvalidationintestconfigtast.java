//***********************************************************************************
//* Description
//*------------
//*  Edit Test Configure Validation in test ConfigURE Tast
//***********************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     : 08/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0396			 08/06/2023    MATHUSAN     Original Version
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class Edittestconfigvalidationintestconfigtast extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();

	static String Actualvaluetest = null;
	static String Actualvaluetesttype = null;
	static String Expectedvaluetest = null;
	static String Expectedvaluetesttype = null;
	static String validationmessagetest = null;
	static String validationmessagetesttype = null;
	static String Actualvalueprefix = null;
	static String Actualvaluemaincategory = null;
	static String Actualvaluediscription = null;
	static String Actualvalueprocedure = null;
	static String Actualvaluereportformat = null;
	static String Expectedvalueprefix = null;
	static String validationmessageprefix = null;
	static String Expectedvaluemaincategory = null;
	static String validationmessagemaincategory = null;
	static String Expectedvaluedescription = null;
	static String validationmessagedescription = null;
	static String Expectedvalueprocedure = null;
	static String validationmessageprocedure = null;
	static String Expectedvaluereportformat = null;
	static String validationmessagereportformat = null;
	static String testname = null;
	static String testtype = null;
	static String prefix = null;
	static String maincatagory = null;
	static String subcatagory = null;
	static String material = null;
	static String discription = null;
	static String Procedure = null;
	static String reportformat = null;
	static String duedays = null;
	static String active = null;;
	static String due = null;

	@Test
	public static void AcceptedConditionvalidation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, ACM);

		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);

		// Click LOGIN Button
		LoginTest.Login();

		// TOP NAVIGATION
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);

		// NAVIGATE TO TEST CONFIGURATION
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);



		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0500";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.out.println(firstRow+"ffffffffff");
		System.out.println(lastRow+"llllllllllll");

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		
		for (int i = firstRow; i <= lastRow; i++) {
			System.out.println(i+"loooppppppppp");
			DataFormatter gh = new DataFormatter();
			XSSFRow row = sheet.getRow(i);

			XSSFCell cell1 = row.getCell(1);
			testname = gh.formatCellValue(cell1);

			XSSFCell cell2 = row.getCell(2);
			testtype = gh.formatCellValue(cell2);

			XSSFCell cell3 = row.getCell(3);
			prefix = gh.formatCellValue(cell3);

			XSSFCell cell4 = row.getCell(4);
			maincatagory = gh.formatCellValue(cell4);

			XSSFCell cell5 = row.getCell(5);
			subcatagory = gh.formatCellValue(cell5);

			XSSFCell cell6 = row.getCell(6);
			material = gh.formatCellValue(cell6);

			XSSFCell cell7 = row.getCell(7);
			discription = gh.formatCellValue(cell7);

			XSSFCell cell8 = row.getCell(8);
			Procedure = gh.formatCellValue(cell8);

			XSSFCell cell9 = row.getCell(9);
			reportformat = gh.formatCellValue(cell9);

			XSSFCell cell10 = row.getCell(10);
			active = gh.formatCellValue(cell10);

			XSSFCell cell11 = row.getCell(11);
			due = gh.formatCellValue(cell11);

			XSSFCell cell12 = row.getCell(12);
			duedays = gh.formatCellValue(cell12);

			XSSFCell cell13 = row.getCell(13);
			validationmessagetest = gh.formatCellValue(cell13);

			XSSFCell cell14 = row.getCell(14);
			validationmessagetesttype = gh.formatCellValue(cell14);

			XSSFCell cell15 = row.getCell(15);
			validationmessageprefix = gh.formatCellValue(cell15);

			XSSFCell cell16 = row.getCell(16);
			validationmessagemaincategory = gh.formatCellValue(cell16);

			XSSFCell cell17 = row.getCell(17);
			validationmessagedescription = gh.formatCellValue(cell17);

			XSSFCell cell18 = row.getCell(18);
			validationmessageprocedure = gh.formatCellValue(cell18);

			XSSFCell cell19 = row.getCell(19);
			validationmessagereportformat = gh.formatCellValue(cell19);

//			Actualvaluetest = ManageTestsPage.configuretestvalidationmessage.getText();
//			Actualvaluetesttype = ManageTestsPage.configuretesttypevalidationmessage.getText();
//			Actualvalueprefix = ManageTestsPage.configuretestprefixvalidationmessage.getText();
//			Actualvaluemaincategory = ManageTestsPage.configuretestmaincategoryvalidationmessage.getText();
//			Actualvaluediscription = ManageTestsPage.configuretestdiscriptionvalidationmessage.getText();
//			Actualvalueprocedure = ManageTestsPage.configuretestprocedurevalidationmessage.getText();
//			Actualvaluereportformat = ManageTestsPage.configuretestreportformatvalidationmessage.getText();
//			Expectedvaluetest = validationmessagetest;
//			Expectedvaluetesttype = validationmessagetesttype;
//			Expectedvalueprefix = validationmessageprefix;
//			Expectedvaluemaincategory = validationmessagemaincategory;
//			Expectedvaluedescription = validationmessagedescription;
//			Expectedvalueprocedure = validationmessageprocedure;
//			Expectedvaluereportformat = validationmessagereportformat;

			// CLICK THE TEST & SEND THE DATA

			try {
				Boolean isVisible1 = ManageTestsPage.configuretesttestinput.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.TestName Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Thread.sleep(1000);
					Boolean isEnabled1 = ManageTestsPage.configuretesttestinput.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.TestName Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.configuretesttestinput.click();
						testCase = extent.createTest("CLICK THE TEST NAME");
						testCase.log(Status.PASS, "TEST PASS");

						try {
							boolean pass = false;
							Thread.sleep(1000);

							for (int iP = 0; iP < 1000; iP++) {
								if (!pass) {
									try {
										if (testname.equals("")) {
											break;

										}
										driver.findElement(By.xpath("//span[text()='" + testname + "']")).click();
										testCase = extent.createTest("TEST NAME FOUND");
										testCase.log(Status.PASS, "TEST PASS");
										pass = true;
									} catch (Exception e) {
									}
								}

								if (!pass) {
									Actions actions = new Actions(driver);
									actions.sendKeys(Keys.ARROW_DOWN).perform();
									Thread.sleep(2000);
								} else {
									break;
								}

							}
						} catch (ElementClickInterceptedException e) {
							testCase = extent.createTest("TEST NOT FOUND");
							testCase.log(Status.FAIL, "TEST FAIL");
						}

					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK THE TEST NAME");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE TEST NAME");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// CLICK THE TEST TYPE & SEND THE DATA

			try {
				Boolean isVisible1 = ManageTestsPage.configuretesttesttypeinput.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Testtype Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretesttesttypeinput.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Testtype Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.configuretesttesttypeinput.click();
						testCase = extent.createTest("CLICK THE TEST NAME");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							boolean pass = false;
							Thread.sleep(1000);

							for (int iP = 0; iP < 1000; iP++) {
								if (!pass) {
									try {
										if (testtype.equals("")) {
											break;

										}
										driver.findElement(By.xpath("//div[text()='" + testtype + "']")).click();
										testCase = extent.createTest("TEST TYPE NAME FOUND");
										testCase.log(Status.PASS, "TEST PASS");
										pass = true;
									} catch (Exception e) {
									}
								}

								if (!pass) {
									Actions actions = new Actions(driver);
									actions.sendKeys(Keys.ARROW_DOWN).perform();
									Thread.sleep(2000);
								} else {
									break;
								}

							}
						} catch (ElementClickInterceptedException e) {
							testCase = extent.createTest("TEST TYPE  NOT FOUND");
							testCase.log(Status.FAIL, "TEST FAIL");
						}

					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK THE TEST NAME");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE TEST NAME");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// CLICK THE PREFIX & SEND THE DATA

			try {
				Boolean isVisible1 = ManageTestsPage.configuretesttestprefixinput.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Prefix Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretesttestprefixinput.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Prefix Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.configuretesttestprefixinput.click();
						testCase = extent.createTest("CLICK THE PREFIX");
						testCase.log(Status.PASS, "TEST PASS");
						
						ManageTestsPage.configuretesttestprefixinput.sendKeys(prefix);
					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK THE PREFIX");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE PREFIX");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// CLICK THE MAIN CATEGORY & SEND THE DATA

			try {
				Boolean isVisible1 = ManageTestsPage.configuretesttestmaincategoryinput.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.MainCategory Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretesttestmaincategoryinput.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.MainCategory Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.configuretesttestmaincategoryinput.click();
						testCase = extent.createTest("CLICK THE MAIN CATEGORY");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							boolean pass = false;
							Thread.sleep(1000);

							for (int iP = 0; iP < 1000; iP++) {
								if (!pass) {
									try {
										if (maincatagory.equals("")) {
											break;

										}
										driver.findElement(By.xpath("//div[text()='" + maincatagory + "']")).click();

										testCase = extent.createTest("MAIN CATAGORY NAME FOUND");
										testCase.log(Status.PASS, "TEST PASS");
										pass = true;
									} catch (Exception e) {
									}
								}

								if (!pass) {
									Actions actions = new Actions(driver);
									actions.sendKeys(Keys.ARROW_DOWN).perform();
									Thread.sleep(2000);
								} else {
									break;
								}

							}
						} catch (ElementClickInterceptedException e) {
							testCase = extent.createTest("MAIN CATAGORY NAME FOUND");
							testCase.log(Status.FAIL, "TEST FAIL");
						}

					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK THE MAIN CATEGORY");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE MAIN CATEGORY");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// CLICK THE SUB CATEGORY & SEND THE DATA

			try {
				Boolean isVisible1 = ManageTestsPage.configuretesttestsubcategoryinput.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.subcatagory Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretesttestsubcategoryinput.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.subcatagory Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.configuretesttestsubcategoryinput.click();
						testCase = extent.createTest("CLICK THE SUBCATEGORY");
						testCase.log(Status.PASS, "TEST PASS");
						try {
							boolean pass = false;
							Thread.sleep(1000);

							for (int iP = 0; iP < 1000; iP++) {
								if (!pass) {
									try {
										if (subcatagory.equals("")) {
											break;

										}
										driver.findElement(By.xpath("//div[text()='" + subcatagory + "']")).click();

										testCase = extent.createTest(" SUB CATEGORY NAME FOUND");
										testCase.log(Status.PASS, "TEST PASS");
										pass = true;
									} catch (Exception e) {
									}
								}

								if (!pass) {
									Actions actions = new Actions(driver);
									actions.sendKeys(Keys.ARROW_DOWN).perform();
									Thread.sleep(2000);
								} else {
									break;
								}

							}
						} catch (ElementClickInterceptedException e) {
							testCase = extent.createTest(" SUB CATEGORY NAME FOUND");
							testCase.log(Status.FAIL, "TEST FAIL");
						}

					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK THE SUBCATEGORY");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE SUBCATEGORY");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		

		// CLICK THE MATERIAL CATEGORY & SEND THE DATA

		try {
			Boolean isVisible1 = ManageTestsPage.configuretesttestamterialinput.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.subcatagory Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.configuretesttestamterialinput.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.subcatagory Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.configuretesttestamterialinput.click();
					testCase = extent.createTest("CLICK THE MATERIAL");
					testCase.log(Status.PASS, "TEST PASS");
					try {
						boolean pass = false;
						Thread.sleep(1000);

						for (int iP = 0; iP < 1000; iP++) {
							if (!pass) {
								try {
									if (material.equals("")) {
										break;

									}
									driver.findElement(By.xpath(
											"//div[@id='material_list']//..//div[contains(@class,'ant-select-item-option-content')][normalize-space()='"
													+ material + "']"))
											.click();

									testCase = extent.createTest(" SUB CATEGORY NAME FOUND");
									testCase.log(Status.PASS, "TEST PASS");
									pass = true;
								} catch (Exception e) {
								}
							}

							if (!pass) {
								Actions actions = new Actions(driver);
								actions.sendKeys(Keys.ARROW_DOWN).perform();
								Thread.sleep(2000);
							} else {
								break;
							}

						}
					} catch (ElementClickInterceptedException e) {
						testCase = extent.createTest(" SUB CATEGORY NAME FOUND");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				}
			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE MATERIAL");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE MATERIAL");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// CLICK THE DESCRIPTION & SEND THE DATA

		try {
			Boolean isVisible1 = ManageTestsPage.configuretestdescriptiontextbox.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Description Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.configuretestdescriptiontextbox.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Description Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.configuretestdescriptiontextbox.click();
					testCase = extent.createTest("CLICK THE DESCRIPTION");
					testCase.log(Status.PASS, "TEST PASS");

					ManageTestsPage.configuretestdescriptiontextbox.sendKeys(discription);
				}
			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE DESCRIPTION");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE DESCRIPTION");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// CLICK THE PROCEDURE & SEND THE DATA

		try {
			Boolean isVisible1 = ManageTestsPage.configuretestproceduretextbox.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Procedure Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.configuretestproceduretextbox.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Procedure Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.configuretestproceduretextbox.click();
					testCase = extent.createTest("CLICK THE PROCEDURE");
					testCase.log(Status.PASS, "TEST PASS");
					// driver.findElement(By.xpath("//div[text()='"+testtype+"']")).click();
					ManageTestsPage.configuretestproceduretextbox.sendKeys(Procedure);
				}
			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE PROCEDURE");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE PROCEDURE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// CLICK THE REPORTFORMAT & CLICK THE DATA

		try {
			Boolean isVisible1 = ManageTestsPage.configuretestreportformattextbox.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Reportformat Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.configuretestreportformattextbox.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Report Format Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.configuretestreportformattextbox.click();
					testCase = extent.createTest("CLICK THE REPORTFORMAT");
					testCase.log(Status.PASS, "TEST PASS");
					
					try {
						boolean pass = false;
						Thread.sleep(1000);

						for (int iP = 0; iP < 1000; iP++) {
							if (!pass) {
								try {
									if (reportformat.equals("")) {
										break;

									}
									driver.findElement(By.xpath("//div[text()='" + reportformat + "']")).click();


									testCase = extent.createTest(" SUB CATEGORY NAME FOUND");
									testCase.log(Status.PASS, "TEST PASS");
									pass = true;
								} catch (Exception e) {
								}
							}

							if (!pass) {
								Actions actions = new Actions(driver);
								actions.sendKeys(Keys.ARROW_DOWN).perform();
								Thread.sleep(2000);
							} else {
								break;
							}

						}
					} catch (ElementClickInterceptedException e) {
						testCase = extent.createTest(" SUB CATEGORY NAME FOUND");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

					
				}
			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE REPORTFORMAT");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE REPORTFORMAT");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// ACTIVE//
		if (active.equals("false")) {
			boolean activebox = true;
			try {

				Boolean isVisible1 = ManageTestsPage.configuretestactivebox.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Active Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretestactivebox.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Active Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						activebox = ManageTestsPage.configuretestactivebox.isSelected();

					}
				}

			} catch (NoSuchElementException E) {
				testCase = extent.createTest("CONFIGURE ACTIVE BOX NOT SELECTED");
				testCase.log(Status.FAIL, "TEST FAIL");

			}

			if (activebox == false) {

				try {
					ManageTestsPage.configuretestactivebox.click();

				} catch (ElementClickInterceptedException E) {
					testCase = extent.createTest("CONFIGURE ACTIVE BOX CLICK");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("CONFIGURE ACTIVE BOX CLICK NOT CLICK");
				testCase.log(Status.FAIL, "Test FAIL");

			}

		}

		// DUE DAY//

		if (due.equals("false")) {
			boolean dueday = true;
			try {

				Boolean isVisible1 = ManageTestsPage.configuretestactivebox.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Dueday Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretestactivebox.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.Dueday Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						dueday = ManageTestsPage.configuretestdueday.isSelected();

					}
				}

			}

			catch (NoSuchElementException E) {
				testCase = extent.createTest("CONFIGURE DUE DAY NOT SELECTED");
				testCase.log(Status.FAIL, "TEST FAIL");

			}
			 if (due.equals("false")) {
						
						try {						
							ManageTestsPage.configuretestdueday.click();
						
					} catch (ElementClickInterceptedException E) {
							testCase = extent.createTest("CONFIGURE DUE DAY CLICK");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("CONFIGURE DUE DAY CLICK NOT CLICK");
						testCase.log(Status.FAIL, "Test FAIL");

				}

				}
			// CLICK THE DUEDAYS & SEND THE DATA

			try {
				Boolean isVisible1 = ManageTestsPage.configuretestduedays.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Duedays Visible", "true", isVisible1, "definition");
				if (isVisible1 == true) {

					Boolean isEnabled1 = ManageTestsPage.configuretestduedays.isEnabled();
					PropertiesCommonMethods.TestReportsq("2.duedays Enable", "true", isEnabled1, "definition");

					if (isEnabled1 == true) {

						ManageTestsPage.configuretestduedays.click();
						
						Thread.sleep(1000);
						//ManageTestsPage.configuretestduedays.clear();
						
						ManageTestsPage.configuretestduedays.sendKeys(duedays);
						testCase = extent.createTest("CLICK THE REPORTFORMAT");
						testCase.log(Status.PASS, "TEST PASS");

					}
				}
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("NOT CLICK THE DUEDAYS");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE DUEDAYS");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		

		// CLICK THE SUBMIT BUTTON

		try {
			Boolean isVisible7 = ManageTestsPage.configuretestsubmitbutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Submitt Button Visible", "true", isVisible7, "definition");
			if (isVisible7 == true) {

				Boolean isEnabled7 = ManageTestsPage.configuretestsubmitbutton.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Submitt Button Enable", "true", isEnabled7, "definition");

				if (isEnabled7 == true) {

					ManageTestsPage.configuretestsubmitbutton.click();

					testCase = extent.createTest("CLICK THE SUBMITT BUTTON");
					testCase.log(Status.PASS, "TEST PASS");
				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE SUBMITT BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE SUBMITT BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// COMPARE THE ACTUALVALUE TEST & EXPECTEDVALUETEST

		Actualvaluetest = ManageTestsPage.configuretestvalidationmessage.getText();
		Expectedvaluetest = validationmessagetest;
		try {

			Assert.assertEquals(Actualvaluetest, Expectedvaluetest);
			testCase = extent.createTest("Test can't be empty");
			testCase.log(Status.PASS, "Test Pass");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvaluetest);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvaluetest);

		} catch (Exception e) {
			testCase = extent.createTest("Test can't be empty Not Visible");
			testCase.log(Status.FAIL, "Test Fail");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvaluetest);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvaluetest);

		}

		// COMPARE THE ACTUAL VALUE TESTTYPE & EXPECTEDVALUETESTTYPE

		Actualvaluetesttype = ManageTestsPage.configuretesttypevalidationmessage.getText();
		Expectedvaluetesttype = validationmessagetesttype;

		try {

			Assert.assertEquals(Actualvaluetesttype, Expectedvaluetesttype);
			testCase = extent.createTest("Test type can't be empty");
			testCase.log(Status.PASS, "Test Pass");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvaluetesttype);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvaluetesttype);

		} catch (Exception e) {
			testCase = extent.createTest("Test type can't be empty Not Visible");
			testCase.log(Status.FAIL, "Test Fail");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvaluetest);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvaluetest);

		}

		// COMPARE THE ACTUAL VALUE PREFIX & EXPECTEDVALUEPREFIX
		Actualvalueprefix = ManageTestsPage.configuretestprefixvalidationmessage.getText();
		Expectedvalueprefix = validationmessageprefix;
		try {

			Assert.assertEquals(Actualvalueprefix, Expectedvalueprefix);
			testCase = extent.createTest("Prefix can't be empty");
			testCase.log(Status.PASS, "Test Pass");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalueprefix);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalueprefix);

		} catch (Exception e) {
			testCase = extent.createTest("Prefix can't be empty Not Visible");
			testCase.log(Status.FAIL, "Test Fail");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalueprefix);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalueprefix);

		}

		// COMPARE THE ACTUAL VALUE MAINCATEGORY & EXPECTEDVALUE MAINCATEGORY

		Actualvaluemaincategory = ManageTestsPage.configuretestmaincategoryvalidationmessage.getText();
		Expectedvaluemaincategory = validationmessagemaincategory;
		Thread.sleep(1000);
		//PropertiesCommonMethods.cTestReports("Material Main Category can't be empty", Expectedvaluemaincategory, Actualvaluemaincategory, testCaseId);
		try {

			Assert.assertEquals(Actualvaluemaincategory, Expectedvaluemaincategory);
			testCase = extent.createTest("Material Main Category can't be empty");
			testCase.log(Status.PASS, "Test Pass");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalueprefix);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalueprefix);

		} catch (Exception e) {
			testCase = extent.createTest("Material Main Category can't be empty Not Visible");
			testCase.log(Status.FAIL, "Test Fail");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalueprefix);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalueprefix);

		}

		// COMPARE THE ACTUAL VALUE DESCRIPTION & EXPECTEDVALUE DESCRIPTION
		Actualvaluediscription = ManageTestsPage.configuretestdiscriptionvalidationmessage.getText();
    	Expectedvaluedescription = validationmessagedescription;
		Thread.sleep(1000);
		PropertiesCommonMethods.cTestReports("DESCRIPTION can't be empty NOT Visible", Expectedvaluedescription, Actualvaluediscription, testCaseId);

		// COMPARE THE ACTUAL VALUE PROCEDURE & EXPECTEDVALUE PROCEDURE

		Actualvalueprocedure = ManageTestsPage.configuretestprocedurevalidationmessage.getText();
		Expectedvalueprocedure = validationmessageprocedure;
		Thread.sleep(1000);
		PropertiesCommonMethods.cTestReports("PROCEDURE can't be empty Not Visible", Expectedvalueprocedure,Actualvalueprocedure, testCaseId);
		
		// COMPARE THE ACTUAL VALUE REPORTFORMAT & EXPECTEDVALUE REPORTFORMAT

		Actualvaluereportformat = ManageTestsPage.configuretestreportformatvalidationmessage.getText();
		Expectedvaluereportformat = validationmessagereportformat;
		Thread.sleep(1000);
		//PropertiesCommonMethods.cTestReports("Report Format can't be empty", Expectedvaluereportformat,Actualvaluereportformat, testCaseId);
		try {

			Assert.assertEquals(Actualvaluereportformat, Expectedvaluereportformat);
			testCase = extent.createTest("Report Format can't be empty");
			testCase.log(Status.PASS, "Test Pass");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalueprefix);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalueprefix);

		} catch (Exception e) {
			testCase = extent.createTest("Report Format can't be empty Not Visible");
			testCase.log(Status.FAIL, "Test Fail");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalueprefix);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalueprefix);

		}
		// Click Refresh Button
		driver.navigate().refresh();
		}
	}
}
