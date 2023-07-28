//*************************************************************************************************
//* Description
//*------------
//* Add SBU Pop up close Button Functionality 
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
//* TC-SBU-0051          26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.sbu;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddSbuCloseButtonFunction extends DriverIntialization {

	static SbuPage sbupage = new SbuPage();
	static boolean addbutton = false;

	@Test
	public static void AddcancleButton() throws InterruptedException {

		PageFactory.initElements(driver, sbupage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigatePlantMain();
		}

		if (MasterMainNavigationsTest.clickPlantMain) {
			MasterMainNavigationsTest.navigateSbu();

		}

		if (MasterMainNavigationsTest.clickSbu) {

			try {
				SbuPage.addSbuBtn.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Sbu' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Sbu' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Sbu' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Sbu' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Sbu' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Sbu' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(SbuPage.closebutton, SbuPage.editpopup, "ADD SBU CLOSE BUTTON",
					"ADD SBU POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
