//*************************************************************************************************
//* Description
//*------------
//* Add Equipment Pop up close Button Functionality 
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 26/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-EQU-0066         26/07/2023   Priyanka     Original
//*************************************************************************************************


package com.qa.automation.qdms.testcases.Equipment;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddEquipmentCloseButtonFunction extends DriverIntialization {

	static EquipmentPage equipmentpage = new EquipmentPage();
	static boolean addbutton = false;

	@Test
	public static void AddcloseButton() throws InterruptedException {

		PageFactory.initElements(driver, equipmentpage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateEqupmentMain();
		}

		if (MasterMainNavigationsTest.mainEqupment) {
			MasterMainNavigationsTest.navigateEquipment();

		}

		if (MasterMainNavigationsTest.Equipmentclick) {

			try {
				EquipmentPage.addequipmentbutton.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Equipment' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Equipment' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Equipment' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Equipment' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Equipment' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Equipment' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(EquipmentPage.closebutton, EquipmentPage.editpopup,
					"ADD EQUIPMENT CLOSE BUTTON", "ADD EQUIPMENT POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
