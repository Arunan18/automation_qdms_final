//***********************************************************************************
//* Description
//*------------
//* Test Parameter Delete Function After Depend
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-056			 16/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import javax.swing.AbstractAction;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ParameterDeleteFunctionAfterDepend extends DriverIntialization {

	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();

	@Test
	public static void beforedepend() throws InterruptedException, IOException {
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, mangetest);
		PageFactory.initElements(driver, testconfig);

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

		/* PAGE SCROLL UNTIL ACCEPTED VALUE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//td[@class='ant-table-cell'])[7]");

		/* SELECT THE SEARCH VALUE */
		AddGroupKey.actionS(0, 7, mangetest.managetexttablecontainer, "Description", "Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-056-01", 1);

		/* SELECT THE DELETE VALUE */
		ActionCommonMethod.actionS(0, 9, mangetest.testparametertablecontainer, "delete",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-056-01", 2);

		/* CLICK ON DELETE CONFIRMATION BUTTON */
		SampleCommonMethods.singleclick("STEP_04--DELETE CONFIRM BUTTON PROPERTYS", mangetest.confirmokbtn,
				"01--DELETE CONFIRM BUTTON DISPLAYED", "02--DELETE CONFIRM BUTTON ENABLED");

		/* GET THE DELETE MESSAGE FROM EXCEL SHEET */
		String successmessage = TestConfigNavigation.excel("Test Configuragtion Module", "Manage_Tests", "MTC-MT-056",
				3);
		Thread.sleep(1000);
		/* DELETE MESSAGE */
//		SampleCommonMethods.dataaddedsuccessmsg("03--DELETE CONFERMATION MESSAGE AFTER DEPEND",
//				mangetest.notificationmsg, successmessage);

		/* PAGE REFRESH */
		driver.navigate().refresh();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
}
