//***********************************************************************************
//* Description
//*------------
//* TEST CONFIG TEST PARAMETER TABLE PAGINATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 03/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0107  		 03/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestConfigTestParameterPagination extends DriverIntialization {
	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();
@Test
public static void action() throws InterruptedException, IOException
{
	
	PageFactory.initElements(driver, logout);
	PageFactory.initElements(driver, testnav);
	PageFactory.initElements(driver, testconfig);
	PageFactory.initElements(driver, mangetest);
	
	/* LOGIN */
	LoginTest.Login();
	
	/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
	SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
		
	/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
	SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES", testnav.ManageCofigureMenuBar,
			"01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
			"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED",testnav.GroupTest,
			testnav.managetest,"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW"); 

	/* CONFIFGURE TEST PROPERTIES DISPLAYED & ENABLED */
	SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
			"01--CONFIGURE TEST LEFT NAVIGATION BUTTON DISPLAYED",
			"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", mangetest.managetestconfigure,"Manage Tests Configure",
			"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");
	
	
	/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
	TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]","(//span[@aria-label='check'])[1]");
	
	/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
	extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");
	
	/* SELECT THE VALUE */
	AddGroupKey.actionS(0, 14,  mangetest.managetexttablecontainer, "Description",
			"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0107-01", 5);
	Thread.sleep(2000);
	/* CLICK THE SECOND FORM */
	driver.findElement(By.xpath("(//div[contains(@class,'ant-steps-item-icon')])[2]/..")).click();
	
	// CHECK THE PAGINATION FUCNTIONALITY
	Paginationmethods.pagination("Test Configuragtion Module", "Test_Configure", "TC-TCN-0107", TestConfigPage.previousbt,
			TestConfigPage.nextbt, TestConfigPage.pag2nd, TestConfigPage.pag1st, TestConfigPage.dropdown,
			TestConfigPage.configbefore, 4, TestConfigPage.configafter, "MANGE TEST PAGINATION");
	
	/* Log Out */
	Logout.LogoutFunction();
}
}
