//*************************************************************************************************
//* Description
//*------------
//* Add Supplier Category Pop up cancle Button Functionality 
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
//* TC-SUPCAT-0029         26/07/2023   Priyanka     Original
//*************************************************************************************************

package com.qa.automation.qdms.testcases.suppliercategory;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddSupplierCategoryCancleButtonProperties extends DriverIntialization {

	static SupplierCategoryPage suppliercatPage = new SupplierCategoryPage();
	static boolean addbutton = false;

	@Test
	public static void AddcloseButton() throws InterruptedException {

		PageFactory.initElements(driver, suppliercatPage);

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateSupplierMain();
		}

		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.navigateSupplierCategory();

		}

		if (MasterMainNavigationsTest.mainSupplierCategory) {

			try {
				SupplierCategoryPage.addSuppilerCategotyButton.click();

				addbutton = true;

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Locate the element 'Add Supplier Category' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Supplier Category' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Locate the element 'Add Supplier Category' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Supplier Category' Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			} catch (Exception e) {
				testCase = extent.createTest("Locate the element 'Add Supplier Category' Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Add Supplier Category' Button");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		}

		if (addbutton) {

			materialMethodes.cancelOrCloseButtonFunction(SupplierCategoryPage.cancelbutton,
					SupplierCategoryPage.editpopup, "ADD SUPPLIER CATEGORY CANCLE BUTTON",
					"ADD SUPPLIER CATEGORY EQUIPMENT POP UP ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
