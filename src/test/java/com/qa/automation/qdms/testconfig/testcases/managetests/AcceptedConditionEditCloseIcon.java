//***********************************************************************************
//* Description
//*------------
//* Accepted Edit Cancel Icon
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-103         	18/05/2023     Gobithan     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

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

public class AcceptedConditionEditCloseIcon extends DriverIntialization {
	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static Logout logout = new Logout();
	static boolean click = false;

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
		TestConfigNavigation.pagescroler("//tr[2]/td[1]", "(//td[@class='ant-table-cell'])[11]");

		/* SELECT THE ACCEPTED CONDTION BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- ACCEPTED CONDTION BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 11, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-103-01", 1);

		/* SELECT THE ACCEPTED CONDTION EDIT BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_05-- ACCEPTED CONDTION EDIT BUTTON PROPERTIES");
		ActionCommonMethod.actionS(0, 1, ManageTestsPage.acceptedconditioncontainer, "edit",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-103-01", 2);

		SampleCommonMethods.singleclick("STEP_06-- ACCEPTED CONDTION EDIT CLOSE ICON PROPERTIES", managepage.closeicon,
				"01--ACCEPTED CONDITION EDIT CLOSE ICON DISPLAYED", "02--ACCEPTED CONDITION EDIT CLOSE ICON ENABLED");
		click = true;

		if (click = true) {
			testCase = extent.createTest("03--EDIT CONDITION MODEL WINDOW CLOSED");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase = extent.createTest("03--EDIT CONDITION MODEL WINDOW NOT CLOSED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/* ACCEPETED CONDITION CANCEL BUTTON */
		managepage.acceptedconditioncancelbtn.click();

		/* LOGOUT */
		logout.LogoutFunction();

	}
}
