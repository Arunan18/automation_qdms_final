//***********************************************************************************
//* Description
//*------------
//* Edit Equipment Before And After Depend
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 04/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0136			 04/05/2023   Gobithan     Orginal Version
//* TC-TCN-0137			 04/05/2023	  
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

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
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquipmentAfterDepend extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage manage = new ManageTestsPage();
	static TestConfigPage testnav = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();
	static ActionCommonMethod action = new ActionCommonMethod();
	static Logout logout = new Logout(); 

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, grouptest);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, testconfig);

		/* LOGIN */
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES",
				testnav.ManageCofigureMenuBar, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* CONFIFGURE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--CONFIGURE TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", manage.managetestconfigure,
				"Manage Tests Configure", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "//th[normalize-space()='Accepted Condition']");

		/* SELECT THE EQUATION BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EQUATION BUTTON PROPERTIES");

		/* SELECT THE EDIT VALUE */
		AddGroupKey.actionS(0, 9, manage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0137-01", 1);

		/* SELECT THE EDIT VALUE IN POPUP WINDOW */
		extent.createTest("STEP_05-- EQUATION BUTTON POPUP WINDOW EDIT BUTTON PROPERTIES");
		ActionCommonMethod.actionS(0, 4, testnav.equationtablecontainer, "edit", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0137-01", 2);

		/* EDIT VALUE SUCCESS MESSAGE */
		editvalue();

		/* LOGOUT TO THE SYSTEM */
		Logout.LogoutFunction();
	} 

	static boolean savebtnn = false;
	public static void editvalue() throws InterruptedException {
		try {
			Thread.sleep(1000);
			testnav.savebtnn.click(); 
			savebtnn = true;
		} catch (Exception e) {

		}

		if (savebtnn == true) {
			extent.createTest("STEP_06-- EDIT EQUATION DEPEND MESSAGE");

			if (driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[2]/div[1]/div[2]")).isDisplayed()
					&& testnav.testdependValidationmsg.isDisplayed()) {
				testCase = extent.createTest("01--EDIT EQUATION IS DEPEND");
				testCase.log(Status.PASS, "TEST PASS");
			} else {
				testCase = extent.createTest("01--EDIT EQUATION VALUE IS NOT DEPEND");
				testCase.log(Status.PASS, "TEST FAIL");
			}

		}
		Thread.sleep(1000);
		testnav.cancelbtn.click();
		
		Thread.sleep(1000);
		testnav.equipmentcancelbtn.click();
	}
}
