//***********************************************************************************
//* Description
//*------------
//* TEST DELETE OK BUTTON-GROUP TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-CGT-0010      18/05/2023   Niluxy       Orginal Version
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.grouptests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestDeleteOkButtonFunction extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static ActionCommonMethod Common = new ActionCommonMethod();
	static TestConfigNavigation navigation = new TestConfigNavigation();
	static SampleCommonMethods sample = new SampleCommonMethods();
	String message = null;
	
	@Test
	public static void paginationcheck() throws InterruptedException, IOException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, grouptest);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, navigation);
		PageFactory.initElements(driver, sample);
		extent.createTest("TESTCASEN0:TC-CGT-0010-TESTS DELETE OK BUTTON FUNCTION");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);
		// CLICK THE TEST CONFIGURATION MODULE
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(page.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST CONFIG");

		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(page.GroupTest, 20, "STEP 3:CHECKING THE GROUP TEST");

		// CHOOSE THE TESTS DATA FROM EXCEL
		Thread.sleep(3000);
		ActionCommonMethod.actionS(0, 5, grouptest.GroupTesttableContainer, "Add Key Test",
				"Test Configuragtion Module.xlsx", "Config_Group_Test", "TC-CGT-0010-01", 1);

		/* TESTS ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(2000);
		SampleCommonMethods.methodoneclick("STEP 4: TEST ICON PROPERTIES", grouptest.testIcon,
				"01--TEST ICON DISPLAYED", "02--TEST ICON ENABLED", grouptest.testheadingpopup, "Tests",
				"03--ON CLICK THE TEST ICON IT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("STEP 5: DELETE BUTTON FUNCTION");

		// CHOOSE THE TESTS DATA FROM EXCEL
		Thread.sleep(3000);
		ActionCommonMethod.actionS(0, 1, grouptest.GroupTestinsideContainer, "delete",
				"Test Configuragtion Module.xlsx", "Config_Group_Test", "TC-CGT-0010-01", 2);
		/* TESTS ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(2000);

		// CHECK THE OK BUTTON FUNCTION
		okbutton();

		// GET THE DELETED THE NOTIFICATION FROM THE EXCEL
		String message = TestConfigNavigation.excel("Test Configuragtion Module", "Config_Group_Test", "TC-CGT-0010",
				3);
		Thread.sleep(2000);
		/* DATA DELETED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP 6: CHECK DATA IS DELETED",TestConfigPage.successMsg, message);
		
		// REFRESH THE PAGE
		Thread.sleep(3000);
		driver.navigate().refresh();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// METHOD FOR CLOSE ICON FUNCTION
	public static void okbutton() {

		if (grouptest.deleteokbuttoninGroupTest.isDisplayed()) {

			testCase = extent.createTest("STEP 5:TESTS FUNCTION- OK BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (grouptest.deleteokbuttoninGroupTest.isEnabled()) {
				testCase = extent.createTest("STEP 6:TESTS FUNCTION- OK BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-popover-content']")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					grouptest.deleteokbuttoninGroupTest.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-popover-content']")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:TEST FUNCTION- OK BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:TEST VALUE  FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 8:TEST  FUNCTION- OK BUTTON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:TEST FUNCTION- OK BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:TEST  FUNCTION- OK BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:TEST  FUNCTION- OK BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}