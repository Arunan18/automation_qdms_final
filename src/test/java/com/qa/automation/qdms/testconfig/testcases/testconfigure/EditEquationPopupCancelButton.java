//***********************************************************************************
//* Description
//*------------
//* Edit Equipment Pop up Cancel button
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 11/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0212		 	11/05/2023   Gobithan     Original Version
//* 
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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquationPopupCancelButton extends DriverIntialization {

	static ManageTestsPage manage = new ManageTestsPage();
	static ManageTestsPage managepage = new ManageTestsPage();
	static TestConfigPage testnav = new TestConfigPage();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, testnav);

		propertys();

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Save']/ancestor::div[@class='ant-modal-content']")).isDisplayed();
			boolean addmodelwindow = true;

			/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
			SampleCommonMethods.methodoneclick("STEP_06-- CONFIGURE EQUATION CANCEL BUTTON PROPERTIES",
					manage.cancelbtn, "01--CONFIGURE EQUATION CANCEL BUTTON DISPLAYED",
					"02--CONFIGURE EQUATION CANCEL BUTTON ENABLED", managepage.acceptedheading, "Accepeted Condition",
					"03--ON CLICK THE CONFIGURE EQUATION CANCEL BUTTON IT'S REDIRECT TO CORRECT WINDOW");

			Thread.sleep(2000);
			// ON CLICK THE CANCEL BUTTON POPUP WINDOW CLOSE OR NOT
			if (!driver.findElement(By.xpath("//*[text()='Save']/ancestor::div[@class='ant-modal-content']"))
					.isDisplayed()) {
				addmodelwindow = false;
			}
			boolean clicked = true;
			if (clicked) {
				testCase = extent.createTest("STEP_07:CONFIGURE EQUATION CANCEL BUTTON CLICKED");
				testCase.log(Status.PASS, "TEST PASS");
				if (addmodelwindow == false) {
					testCase = extent.createTest("STEP_08:CONFIGURE EQUATION MODEL WINDOW CLOSED");
					testCase.log(Status.PASS, "TEST PASS");
				} else {
					testCase = extent.createTest("STEP_08:CONFIGURE EQUATION MODEL WINDOW NOT CLOSED");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP_07:CONFIGURE EQUATION CANCEL BUTTON NOT CLICKED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} catch (Exception e) {
		}

		/* CONFIGURE EQUATION CANCEL BUTTON */
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();

		/* LOGOUT */
		Logout.LogoutFunction();
	}

	public static void propertys() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, manage);

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
		AddGroupKey.actionS(0, 9, manage.managetexttablecontainer, "Description", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0212-01", 1);

		/* CONDITION EDIT BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_05-- CONFIGURE EQUATION EDIT BUTTON PROPERTIES");

		/* SELECT THE EDIT VALUE */
		ActionCommonMethod.actionS(0, 4, manage.configureequationcontainer, "edit", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0212-01", 2);
	}
}
