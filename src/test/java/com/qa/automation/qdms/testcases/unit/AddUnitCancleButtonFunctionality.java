//*************************************************************************************************
//* Description
//*------------
//* Add Unit Pop up cancle Button Functionality 
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
//* TC-UNIT-0024          26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.unit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.UnitPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddUnitCancleButtonFunctionality extends DriverIntialization {

	static UnitPage unitpage = new UnitPage();
	static boolean addbutton = false;

	@Test
	public static void AddcancleButton() throws InterruptedException {

		PageFactory.initElements(driver, unitpage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateMaterialMain();
		}

		if (MasterMainNavigationsTest.clickMaterialMain) {
			MasterMainNavigationsTest.navigateUnit();

		}

		if (MasterMainNavigationsTest.clickUnit) {

			try {
				UnitPage.AddUnitButton.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Unit' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Unit' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Unit' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Unit' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Unit' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Unit' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(UnitPage.CancelBtn, UnitPage.editpopup,
					"ADD UNIT CLOSE BUTTON", "ADD UNIT POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
