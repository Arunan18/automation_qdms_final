//***********************************************************************************
//* Description
//*------------
//* Additional Information Close Button Function
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-086		      16/05/2023   Gobithan     Orginal Version
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
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AdditionalInformationCloseButton extends DriverIntialization {

	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, methods);

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
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				managepage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL ADDITIONAL INFORMATION */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//td[@class='ant-table-cell'])[25]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");

		/* SELECT THE VALUE */
		AddGroupKey.actionS(0, 10, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-085-01", 1);
		Thread.sleep(2000);
		/* CLOSE BUTTON PROPERTYS */
		closebutton();

		/* LOGOUT */
		logout.LogoutFunction();
	}

	// METHOD FOR CLOSE BUTTON FUNCTION
	public static void closebutton() {
		if (ManageTestsPage.additionalinformationclosebutton.isDisplayed()) {
			testCase = extent.createTest("STEP_05-- ADDITIONAL INFORMATION CLOSE BUTTON DISPLYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.additionalinformationclosebutton.isEnabled()) {
				testCase = extent.createTest("STEP_06--ADDITIONAL INFORMATION CLOSE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
					boolean addmodelwindow = true;

					ManageTestsPage.additionalinformationclosebutton.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
						addmodelwindow = false;
					}
					boolean clicked = true;
					if (clicked) {
						testCase = extent.createTest("STEP_07--ADDITIONAL INFORMATION CLOSE BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");

						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP_08--ADDITIONAL INFORMATION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP_08--ADDITIONAL INFORMATION MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP_07--ADDITIONAL INFORMATION CLOSE BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} catch (Exception e) {
				}
			} else {
				testCase = extent.createTest("STEP_06--ADDITIONAL INFORMATION CLOSE BUTTON ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP_05-- ADDITIONAL INFORMATION CLOSE BUTTON DISPLYED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

}
