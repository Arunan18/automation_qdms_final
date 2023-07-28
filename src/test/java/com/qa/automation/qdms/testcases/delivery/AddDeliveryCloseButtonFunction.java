//*************************************************************************************************
//* Description
//*------------
//* Add Delivery Pop up close Button Functionality 
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
//* TC-DEL-0041          26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.delivery;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddDeliveryCloseButtonFunction extends DriverIntialization {

	static DeliveryPage deliverypage = new DeliveryPage();
	static boolean addbutton = false;

	@Test
	public static void AddcloseButton() throws InterruptedException {

		PageFactory.initElements(driver, deliverypage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {
			MasterMainNavigationsTest.navigateDelivery();

		}

		if (MasterMainNavigationsTest.clickDelivery) {

			try {
				DeliveryPage.deliveryaddbtn.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Delivery' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Delivery' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Delivery' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Delivery' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Delivery' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Delivery' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(DeliveryPage.closebutton, DeliveryPage.editpopup,
					"ADD DELIVERY CLOSE BUTTON", "ADD DELIVERY POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
