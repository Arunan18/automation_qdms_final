//***********************************************************************************
//* Description
//*------------
//* MANAGE TEST PAGINATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-024			 28/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ManageTestPagination extends DriverIntialization {
	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, mangetest);
		
		/* LOGIN */
		LoginTest.Login();
		
		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
					"01--TEST CONFIGURATION CARD DISPLAYED",
					"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			
		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES", testnav.MANGECONFIGURE,
				"01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest,
				testnav.managetest,"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW"); 
		
		/* MANAGE TEST  PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", mangetest.managetestconfigure,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED", mangetest.managetestconfigure,"Manage Tests Configure",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		
		// CHECK THE PAGINATION FUCNTIONALITY
		Paginationmethods.pagination("Test Configuragtion Module", "Manage_Tests", "MTC-MT-024", TestConfigPage.previousbt,
				TestConfigPage.nextbt, TestConfigPage.pag2nd, TestConfigPage.pag1st, TestConfigPage.pagdrp,
				ManageTestsPage.before, 4, ManageTestsPage.after, "MANGE TEST PAGINATION");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
		
		
	}

}
