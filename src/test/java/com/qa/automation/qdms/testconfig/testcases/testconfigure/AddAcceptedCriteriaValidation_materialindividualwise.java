//***********************************************************************************
//* Description
//*------------
//* Add Accepted Criteria Validation Material Individual Wise
//***********************************************************************************
//*
//* Author           : SRIHARAN GOBITHAN
//* Date Written     : 12/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*	TC-TCN-0395		    12/06/2023     Gobithan    Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AddAcceptedCriteriaValidation_materialindividualwise extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	static TestConfigNavigation TCN = new TestConfigNavigation();
	static AddAcceptedCriteriaValidation_testwise validation = new AddAcceptedCriteriaValidation_testwise();

	@Test
	public static void TestEquationDeleteFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);
		PageFactory.initElements(driver, ACM);
		PageFactory.initElements(driver, TCN);
		PageFactory.initElements(driver, validation);

		// Click LOGIN Button
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// PAGE SCROLL UNTIL ACCEPTED VALUE COLUMN
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "//th[normalize-space()='Accepted Value']");

		// SELECT THE ACCEPTED VALUE BUTTON DISPLAYED & ENABLED
		AddAcceptedvalue();

		// CHECK EMPTY VALIDATION
		extent.createTest("STEP_05--ACCEPTED CRETERIA MATERIAL INDIVIDUAL WISE VALIDATION");
		validationempty();

		// VALUE EMPTY VALIDATION
		valueemptyvalidation();

		// VALUE MUST BE NUMBER VALIDATION
		valuemustbenumber();

		// VALUE EMPTY VALIDATION
		valueempty();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// SELECT THE ACCEPTED VALUE BUTTON DISPLAYED & ENABLED
	public static void AddAcceptedvalue() {
		extent.createTest("STEP_04--ACCEPTED VALUE  BUTTON PROPERTIES");
		ActionCommonMethod.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0394-01", 1);
	}

	// CHECK EMPTY VALIDATION
	public static void validationempty() throws IOException {
		try {
			ManageTestsPage.acceptedvalueSaveButton.click();
			String Actualvalue = ManageTestsPage.emptyvalidation.getText();
			String expecteddata = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
					"Test_Configure", "TC-TCN-0395", 0, 3);
			try {
				Assert.assertEquals(Actualvalue, expecteddata);
				testCase = extent.createTest("1.INDIVIDUAL TEST PARAMETER EMPTY VALIDATION");
				testCase.log(Status.PASS, "TEST PASS");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL EMPTY VALIDATION ARE CORRECT");
			} catch (AssertionError e) {
				testCase = extent.createTest("1.INDIVIDUAL TEST PARAMETER EMPTY VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL EMPTY VALIDATION ARE NOT CORRECT");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("EMPTY VALIDATION SAVE BUTTON NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	// VALUE EMPTY VALIDATION
	public static void valueemptyvalidation() throws IOException, InterruptedException {
		try {
			try {
				int rowcount = ManageTestsPage.tablerowcount.size();
				if (ManageTestsPage.tabledeletebtn.isDisplayed()) {
					if (ManageTestsPage.tabledeletebtn.isEnabled()) {
						// Delete the already added records
						for (int i = 2; i <= rowcount; i++) {
							ManageTestsPage.tabledeletebtn.click();
							Thread.sleep(500);
							if (ManageTestsPage.confirmokbtn.isDisplayed()) {
								if (ManageTestsPage.confirmokbtn.isEnabled()) {
									ManageTestsPage.confirmokbtn.click();
								} else {
									testCase = extent
											.createTest("MATERIAL TABLE DATA DELETE CONFIRM OK BUTTON IS NOT ENABLED");
									testCase.log(Status.FAIL, "TEST FAIL");
								}
							} else {
								testCase = extent
										.createTest("MATERIAL TABLE DATA DELETE CONFIRM OK BUTTON IS NOT DISPLAYED");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						}
					} else {
						testCase = extent.createTest("MATERIAL TABLE DATA DELETE BUTTON IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("MATERIAL TABLE DATA DELETE BUTTON IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} catch (NoSuchElementException e) {

			}
			Thread.sleep(1000);
			try {
				if (ManageTestsPage.materialradiobtn.isDisplayed()) {
					if (ManageTestsPage.materialradiobtn.isEnabled()) {
						if (!ManageTestsPage.materialradiobtn.isSelected()) {
							ManageTestsPage.materialradiobtn.click();
						}
						if (!ManageTestsPage.individualradiobtn.isSelected()) {
							ManageTestsPage.individualradiobtn.click();
						}
					} else {
						testCase = extent.createTest("MATERIAL RADIO BUTTON IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("MATERIAL RADIO BUTTON IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("MATERIAL RADIO BUTTON IS NOT WORKED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
			
			try {

				String selecttypeparameter = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
						"Test_Configure", "TC-TCN-0395", 1, 2);

				try {
					/* SELECT THE DROP DOWN FOR PARAMETER TYPE FEILD */
					Actions actions = new Actions(driver);
					if (ManageTestsPage.selecttextparameter.isDisplayed()) {
						if (ManageTestsPage.selecttextparameter.isEnabled()) {
							if (selecttypeparameter != "") {
								for (int i = 0; i < 20; i++) {
									try {
										Thread.sleep(1000);
										ManageTestsPage.selecttextparameter.click();
										Thread.sleep(1000);
										driver.findElement(By.xpath("//div[text()='" + selecttypeparameter + "']"))
												.click();
										break;

									} catch (Exception e) {
										actions.sendKeys(Keys.ARROW_DOWN).perform();
									}
								}
							} else {
								testCase = extent
										.createTest("SELECT TYPE PARAMETER FIELD IS EMPTY IN ALREADY EXIT VALIDATION");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest(
									"SELECT TYPE PARAMETER FIELD IS NOT ENABLED IN ALREADY EXIT VALIDATION");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent
								.createTest("SELECT TYPE PARAMETER FIELD IS NOT DISPLAYED IN ALREADY EXIT VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} catch (Exception e) {
					testCase = extent.createTest("ERROR IN SELECT TEXT PARAMETER FIELD IN ALREADY EXIT VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				try {
					String conditionvalue = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
							"Test_Configure", "TC-TCN-0395", 1, 1);

					try {
						/* SELECT THE DROP DOWN FOR PARAMETER TYPE FEILD */
						Actions actions = new Actions(driver);
						if (ManageTestsPage.condition.isDisplayed()) {
							if (ManageTestsPage.condition.isEnabled()) {
								if (conditionvalue != "") {
									for (int i = 0; i < 20; i++) {
										try {
											Thread.sleep(1000);
											ManageTestsPage.condition.click();
											Thread.sleep(1000);
											driver.findElement(By
													.xpath("//div[contains(@title,'" + conditionvalue + "')]//div[1]"))
													.click();
											break;

										} catch (Exception e) {
											actions.sendKeys(Keys.ARROW_DOWN).perform();
										}
									}
								}
							} else {
								testCase = extent.createTest("CONDITION FIELD IS EMPTY CAN'T BE EMPTY VALIDATION");
								testCase.log(Status.FAIL, "TEST FAIL");
							}
						} else {
							testCase = extent.createTest(
									"SELECT TYPE PARAMETER FIELD IS NOT DISPLAYED IN ALREADY EXIT VALIDATION");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} catch (Exception e) {
						testCase = extent.createTest("ERROR IN SELECT TEXT PARAMETER FIELD IN ALREADY EXIT VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {
				}
				try {
					if (ManageTestsPage.acceptedvalueSaveButton.isDisplayed()) {
						if (ManageTestsPage.acceptedvalueSaveButton.isEnabled()) {
							ManageTestsPage.acceptedvalueSaveButton.click();
						} else {
							testCase = extent.createTest("SAVE BUTTON IS NOT ENABLED IN ALREADY EXIT VALIDATION");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("SAVE BUTTON IS NOT DISPLAYED IN ALREADY EXIT VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} catch (Exception e) {
					testCase = extent.createTest("SAVE BUTTON IS NOT WORKED IN ALREDY EXIT VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

				// REPORT FOR CANT'T EMPTY VALIDATION
				String Actualvalue = ManageTestsPage.acceptedvaluefootervalidation.getText();
				String expecteddata = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
						"Test_Configure", "TC-TCN-0395", 1, 3);
				try {
					Assert.assertEquals(Actualvalue, expecteddata);
					testCase = extent.createTest("2.INDIVIDUAL ACCEPTED VALUE CAN'T BE EMPTY VALIDATION");
					testCase.log(Status.PASS, "TEST PASS");
					testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.INFO, "EXPECTED & ACTUAL CAN'T BE EMPTY VALIDATION ARE CORRECT");
				} catch (AssertionError e) {
					testCase = extent.createTest("2.INDIVIDUAL ACCEPTED VALUE CAN'T BE EMPTY VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
					testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.INFO, "EXPECTED & ACTUAL CAN'T BE EMPTY VALIDATION ARE NOT CORRECT");
				}

			} catch (Exception e) {
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("VALUE EMPTY VALIDATION NOT WORKED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	// VALUE MUST BE NUMBER VALIDATION
	public static void valuemustbenumber() throws IOException, InterruptedException {

		try {

			try {
				String sendvalue = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
						"Test_Configure", "TC-TCN-0395", 2, 2);
				if (ManageTestsPage.valuefield.isDisplayed()) {
					if (ManageTestsPage.valuefield.isEnabled()) {
						ManageTestsPage.valuefield.click();
						ManageTestsPage.valuefield.sendKeys(sendvalue);
					} else {
						testCase = extent.createTest("VALUE FIELD IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("VALUE FIELD IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("VALUE FIELD IS NOT WORKED IN VALUE MUST NUMBER VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
			try {
				if (ManageTestsPage.acceptedvalueSaveButton.isDisplayed()) {
					if (ManageTestsPage.acceptedvalueSaveButton.isEnabled()) {
						ManageTestsPage.acceptedvalueSaveButton.click();
					} else {
						testCase = extent.createTest("SAVE BUTTON IS NOT ENABLED IN VALUE MUST BE NUMBER VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("SAVE BUTTON IS NOT DISPLAYED IN  VALUE MUST BE NUMBER VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("ACCEPTED VALUE SAVE BUTTON IS NOT WORK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// REPORT FOR NUMBER MUST VALIDATION
			String Actualvalue = ManageTestsPage.acceptedvaluefootervalidation.getText();
			String expecteddata = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
					"Test_Configure", "TC-TCN-0394", 2, 3);
			try {
				Assert.assertEquals(Actualvalue, expecteddata);
				testCase = extent.createTest("3.INDIVIDUAL ACCEPTED VALUE NUMBER VALIDATION");
				testCase.log(Status.PASS, "TEST PASS");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL ACCEPTED VALUE MUSTBE NUMBER VALIDATION IS CORRECT");
			} catch (AssertionError e) {
				testCase = extent.createTest("3.INDIVIDUAL ACCEPTED VALUE NUMBER VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO, "EXPECTED & ACTUAL ACCEPTED VALUE MUSTBE NUMBER VALIDATION IS NOT CORRECT");
			}

		} catch (Exception e) {
		}

	}

	// VALUE EMPTY VALIDATION
	public static void valueempty() throws IOException, InterruptedException {

		try {

			String conditionvalue = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
					"Test_Configure", "TC-TCN-0395", 3, 1);

			try {
				/* SELECT THE DROP DOWN FOR PARAMETER TYPE FEILD */
				Actions actions = new Actions(driver);
				if (ManageTestsPage.condition.isDisplayed()) {
					if (ManageTestsPage.condition.isEnabled()) {
						if (conditionvalue != "") {
							for (int i = 0; i < 20; i++) {
								try {
									Thread.sleep(1000);
									ManageTestsPage.condition.click();
									Thread.sleep(1000);
									driver.findElement(
											By.xpath("//div[contains(@title,'" + conditionvalue + "')]//div[1]"))
											.click();
									break;

								} catch (Exception e) {
									actions.sendKeys(Keys.ARROW_DOWN).perform();
								}
							}
						}
					} else {
						testCase = extent.createTest("CONDITION FIELD IS EMPTY CAN'T BE EMPTY VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent
							.createTest("SELECT TYPE PARAMETER FIELD IS NOT DISPLAYED IN VALUE EMPTY VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("ERROR IN SELECT TEXT PARAMETER FIELD IN VALUE EMPTY VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			try {
				String sendvalue = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
						"Test_Configure", "TC-TCN-0395", 3, 2);
				if (ManageTestsPage.valuefield.isDisplayed()) {
					if (ManageTestsPage.valuefield.isEnabled()) {
						ManageTestsPage.valuefield.click(); 
						ManageTestsPage.valuefield.sendKeys(sendvalue);
					} else {
						testCase = extent.createTest("VALUE FIELD IS NOT ENABLED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("VALUE FIELD IS NOT DISPLAYED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("VALUE FIELD IS NOT WORKED IN VALUE MUST NUMBER VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
			try {
				if (ManageTestsPage.acceptedvalueSaveButton.isDisplayed()) {
					if (ManageTestsPage.acceptedvalueSaveButton.isEnabled()) {
						ManageTestsPage.acceptedvalueSaveButton.click();
					} else {
						testCase = extent.createTest("SAVE BUTTON IS NOT ENABLED IN VALUE EMPTY VALIDATION");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("SAVE BUTTON IS NOT DISPLAYED IN VALUE EMPTY VALIDATION");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("ACCEPTED VALUE SAVE BUTTON IS NOT WORK");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			// REPORT FOR NUMBER MUST VALIDATION
			String Actualvalue = ManageTestsPage.acceptedvaluefootervalidation.getText();
			String expecteddata = AddAcceptedCriteriaValidation_testwise.excel("Test Configuragtion Module",
					"Test_Configure", "TC-TCN-0395", 3, 3);
			try {
				Assert.assertEquals(Actualvalue, expecteddata);
				testCase = extent.createTest("4.INDIVIDUAL ACCEPTED VALUE FIELD CAN'T BE EMPTY VALIDATION");
				testCase.log(Status.PASS, "TEST PASS");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO,
						"EXPECTED & ACTUAL ACCEPTED VALUE FIELD CAN'T BE EMPTY VALIDATION ARE CORRECT");
			} catch (AssertionError e) {
				testCase = extent.createTest("4.INDIVIDUAL ACCEPTED VALUE FIELD CAN'T BE EMPTY VALIDATION");
				testCase.log(Status.FAIL, "TEST FAIL");
				testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.INFO,
						"EXPECTED & ACTUAL ACCEPTED VALUE FIELD CAN'T BE EMPTY VALIDATION ARE NOT CORRECT");
			}

		} catch (Exception e) {
		}
		
		try {
			// CLICK ON CANCEL BUTTON
			ManageTestsPage.acceptedvalueclosebutton.click();
		} catch (Exception e) {
			testCase = extent.createTest("CANCEL BUTTON IS NOT WORK IN INDIVIDUAL VALIDATION");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

}
