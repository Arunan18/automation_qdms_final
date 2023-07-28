//*************************************************************************************************
//* Description
//*------------
//* Add Plant Equipment Pop up cancle Button Functionality 
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
//* TC-PLA-EQU-0082         26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.plantequipment;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddPlantEquipmentCancleButtonFunction extends DriverIntialization {

	static PlantEquipmentPage plantequpage = new PlantEquipmentPage();
	static boolean addbutton = false;

	@Test
	public static void AddcloseButton() throws InterruptedException {

		PageFactory.initElements(driver, plantequpage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateEqupmentMain();
		}

		if (MasterMainNavigationsTest.mainEqupment) {
			MasterMainNavigationsTest.navigatePlantEquipment();

		}

		if (MasterMainNavigationsTest.plntEquipmentclick) {

			try {
				PlantEquipmentPage.AddPlantEquipment.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Plant Equipment' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Plant Equipment' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Plant Equipment' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Plant Equipment' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Plant Equipment' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Plant Equipment' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(PlantEquipmentPage.cancelbtn, PlantEquipmentPage.editpopup,
					"ADD PLANT EQUIPMENT CANCLE BUTTON", "ADD PLANT EQUIPMENT POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
