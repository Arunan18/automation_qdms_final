//*************************************************************************************************
//* Description
//*------------
//* Add Plant Pop up close Button Functionality 
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
//* TC-PLANT-0086          26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.plant;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddPlantCloseButtonFunctionality extends DriverIntialization {

	static PlantPage plantpage = new PlantPage();
	static boolean addbutton = false;

	@Test
	public static void AddcancleButton() throws InterruptedException {

		PageFactory.initElements(driver, plantpage);

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigatePlantMain();
		}

		if (MasterMainNavigationsTest.clickPlantMain) {

			MasterMainNavigationsTest.navigatePlant();

		}

		if (MasterMainNavigationsTest.Plantclick) {
			Thread.sleep(2000);
			try {
				PlantPage.addPlantButton.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Plant' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Plant' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Plant' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Plant' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Plant' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Plant' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(PlantPage.closebutton, PlantPage.editpopup,
					"ADD PLANT CLOSE BUTTON", "ADD PLANT POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();
	}

}
