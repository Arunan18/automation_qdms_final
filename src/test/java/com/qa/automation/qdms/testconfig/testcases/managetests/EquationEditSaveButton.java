//***********************************************************************************
//* Description
//*------------
//* Equation Edit Save Button
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-081			 16/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.Keys;
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

public class EquationEditSaveButton extends DriverIntialization {

	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();

	@Test
	public static void action() throws InterruptedException, IOException {
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

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");

		/* SELECT THE VALUE */
		AddGroupKey.actionS(0, 9, mangetest.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-081-01", 1);

		/* SELECT THE EDIT VALUE */
		ActionCommonMethod.actionS(0, 4, mangetest.configureequationcontainer, "edit",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-081-01", 2);

		/* TEXT AREA PROPERTYS */
		String txtvalue = TestConfigNavigation.excel("Test Configuragtion Module", "Manage_Tests", "MTC-MT-081", 3);
		testnav.Textboxequation.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP_04--EDIT EQUATION TEXTAREA PROPERTYS", testnav.Textboxequation,
				"01--TEXT AREA DISPLAYED", "01--TEXT AREA ENABLED", txtvalue);

		/* SAVE BUTTON PROPERTYS */
		SampleCommonMethods.singleclick("STEP_05--EQUATION EDIT SAVE BUTTON PROPERTYS", testnav.savebtnn,
				"01--EQUATION EDIT SAVE BUTTON DISPLAYED", "02--EQUATION EDIT SAVE BUTTON ENABLED");
		
		
		/* DATA ADDED MESSAGE PROPERTYS */
		String Message = TestConfigNavigation.excel("Test Configuragtion Module", "Manage_Tests", "MTC-MT-081", 4);
		SampleCommonMethods.dataaddedsuccessmsg("03--DATA ADDED SUCCESS MESSAGE", testnav.successMsg, Message);
		driver.navigate().refresh();
		
		/* LOGOUT */
		logout.LogoutFunction();
	}

}
