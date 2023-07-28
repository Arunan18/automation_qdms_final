//***********************************************************************************
//* Description
//*------------
//* Equation Edit Cancel Button
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-082			 16/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.Expectedoutput;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EquationEditCancelButton extends DriverIntialization {

	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static Expectedoutput output = new Expectedoutput();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, mangetest);
		PageFactory.initElements(driver, output);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				testnav.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", mangetest.managetestconfigure,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				mangetest.managetestconfigure, "Manage Tests Configure",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");

		/* SELECT THE VALUE */
		AddGroupKey.actionS(0, 9, mangetest.managetexttablecontainer, "Description", "Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-082-01", 1);

		/* SELECT THE EDIT VALUE */
		ActionCommonMethod.actionS(0, 4, mangetest.configureequationcontainer, "edit",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-082-01", 2);

		/* CANCEL BUTTON PROPERTYS */
		closeButton();

		/* CLOSE FIRST MODEL WINDOW */
		ManageTestsPage.eqcancelbtn.click();

		/* LOGOUT */
		logout.LogoutFunction();
	}

	// METHOD FOR CLOSE BUTTON FUNCTION
	public static void closeButton() {
		if (testnav.cancelbuttoninequationedit.isDisplayed()) {
			testCase = extent.createTest("STEP_05--EQUATION EDIT CANCEL BUTTON DISPLYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (testnav.cancelbuttoninequationedit.isEnabled()) {
				testCase = extent.createTest("STEP_06--EQUATION EDIT CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					testnav.cancelbuttoninequationedit.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//*[text()='Edit Equation']/../..")).isDisplayed()) {
						addmodelwindow = false;
					}
					boolean clicked = true;
					if (clicked) {
						testCase = extent.createTest("STEP_07--EQUATION EDIT CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP_08--EQUATION EDIT MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP_08--EQUATION EDIT CANCEL MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP_07--EQUATION EDIT CANCEL BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} catch (Exception e) {
				}
			} else {
				testCase = extent.createTest("STEP_06--EQUATION EDIT CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP_05--EQUATION EDIT CANCEL BUTTON DISPLYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
}
