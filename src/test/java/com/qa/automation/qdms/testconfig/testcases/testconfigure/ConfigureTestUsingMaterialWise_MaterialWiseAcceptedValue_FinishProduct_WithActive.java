//***********************************************************************************
//* Description
//*------------
//* Configure Test Using Material Wise Material Wise Accepted Value (FINISH PRODUCT TEST- WITH ACTIVE)
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 25/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0318        	25/05/2023     Gobithan     Orginal Version
//*						09/06/2023     Gobithan		Rework
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AcceeptedCretiaStep;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigureTestUsingMaterialWise_MaterialWiseAcceptedValue_FinishProduct_WithActive
		extends DriverIntialization {
	public static boolean click1 = false;
	static TestConfigPage addPage = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static TestParameterStep testparameter = new TestParameterStep();
	static configureEquationStep configure = new configureEquationStep();
	static AcceptCondition accepted = new AcceptCondition();
	static Addaditionalinformation additionalinformation = new Addaditionalinformation();
	static SampleActionMethods action = new SampleActionMethods();
	public static boolean scuss = false;
	static String TAB=null;
	

	@Test
	public static void configuretest() throws InterruptedException, IOException {
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, testparameter);
		PageFactory.initElements(driver, accepted);
		PageFactory.initElements(driver, additionalinformation);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);

		try {
			if (LoginTest.login) {
				// TESTCASE REPORT
				extent.createTest(
						"TC-TCN-0318-Configure Test Using Material Wise Material Wise Accepted Value (FINISH PRODUCT TEST- WITH ACTIVE)");
				action.clicking(TestConfigPage.testconfigurationcard, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
			}
			if (action.cilick) {
				action.cilick = false;
				// TOP NAVIGATION
				action.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
			}
			if (action.cilick) {
				action.cilick = false;
				// NAVIGATE TO TEST CONFIGURATION
				Thread.sleep(2000);
				action.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
				click1 = true;
			}
			if (click1) {
				click1 = false;
				// CONFIGURE TEST FIELD
				TAB="Configure Test";
				AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-first");
			}
			System.out.println(AddConfigureTest.submit + "jjjjjjjjhhhhhhhh");
			if (AddConfigureTest.submit) {
				AddConfigureTest.submit = false;
				// TEST PARAMETER FIELD
				Thread.sleep(2000);
				TAB="select parameter step in Test parameter";
				TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-second");

				// ADD PARAMETER FIELD
				Thread.sleep(3000);
				TAB="add parameter detils step in test parameter";
				TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-second");
			}
			System.out.println(TestParameterStep.para + "jjjjjjjjhhhhhhhh");
			if (TestParameterStep.para) {
				TestParameterStep.para = false;
				// CONFIGURE EQUATION FIELD
				TAB="add equation step";
				Thread.sleep(2000);
				configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-third");
			}
			boolean next = false;
			System.out.println(configureEquationStep.eqsav + "jjjjjjjjhhhhhhhh");
			if (configureEquationStep.eqsav) {
				// CLICK ON NEXT BUTTON
				Thread.sleep(3000);
				TestConfigPage.nextBtn.click();
				next = true;
			}
			System.out.println(next + "jjjjjjjjhhhhhhhh");
			if (next) {
				next = false;
				// ACCEPTED CRITERIA FIELD
				TAB="add Accepted criteria step";
				Thread.sleep(3000);
				AcceeptedCretiaStep.accepted("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-fourth");
			}
			Actions actions;
			Thread.sleep(3000);
			actions = new Actions(driver);
			if (AcceeptedCretiaStep.acepc) {
				AcceeptedCretiaStep.acepc = false;

				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				TestConfigPage.nextBtn.click();
				next = true;
			}
			if (next) {
				next = false;
				// ACCEPTED CRITERIA FIELD
				TAB="add key test step";
				Thread.sleep(3000);
				AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-fifth");
			}
			if (AddKeyTestfunction.keysave) {
				AddKeyTestfunction.keysave = false;
				Thread.sleep(3000);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				TestConfigPage.nextBtn.click();
				next = true;
			}
			if (next) {
				next = false;
				// ADDITIONAL INFORMATION
				TAB="add aditional information";
				Thread.sleep(3000);
				Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-seventh");
				TestConfigPage.nextBtn.click();

				// Review test Check in Review Tab
				TAB="configure review step";
				ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0318-first",
						"TC-TCN-0318-second", "TC-TCN-0318-third", "TC-TCN-0318-fourth", "TC-TCN-0318-fifth", "",
						"TC-TCN-0318-seventh");

				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				action.clicking(addPage.donebutton, 2000, "DONE BUTTON ACTION");
				TAB="test configuration confirm in sample module step";
				TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
						"TC-TCN-0318-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "first",
						AddConfigureTest.active);
								scuss = true;
			}
		} catch (InterruptedException e) {
			testCase = extent.createTest("TEST CONFIGRATION BLOCKED IN "+TAB);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (IOException e) {
			testCase = extent.createTest("TEST CONFIGRATION BLOCKED IN "+TAB);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("TEST CONFIGRATION BLOCKED IN "+TAB);
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		if (!scuss) {
			testCase = extent.createTest("TEST CONFIGRATION TEST");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		else if (scuss) {
			testCase = extent.createTest("TEST CONFIGRATION TEST");
			testCase.log(Status.PASS, "TEST PASS ");
		}
		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
