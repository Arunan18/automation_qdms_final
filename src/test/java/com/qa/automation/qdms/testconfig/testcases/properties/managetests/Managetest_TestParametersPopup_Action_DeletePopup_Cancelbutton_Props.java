//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- Action - Delete Pop up Screen  "Cancel" button Properties 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 17/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-180         17/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_TestParametersPopup_Action_DeletePopup_Cancelbutton_Props extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void actionDeletePopupCancelbutton() throws InterruptedException, IOException {

		// MANAGE TEST - TEST PARAMETERS ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 7, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-180");

		Thread.sleep(1000);

		// Check Test Parameters Popup Screen Action Delete Popup Cancel button
		// Properties
		deleteIcon(NavigateManageTestFromLogin.excelDataValue.get(1));

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void deleteIcon(String Value1) {

		WebElement deleteicon = driver.findElement(By.xpath(
				"//td[text()='" + Value1 + "']//following-sibling::td[9]//span[@class='anticon anticon-delete']"));

		try {

			Thread.sleep(1000);
			deleteicon.click();
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon is Clicked");
			testCase.log(Status.PASS, "TEST PASS");

			actionDeletePopupCancelbuttonProps();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Unable to Locate Delete Action icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void actionDeletePopupCancelbuttonProps() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-180-02", ManageTestsPage.testParametersdeletepopupCancelBtn,
				"Test Parameters - Action -Delete Icon -Popup Cancel button Properties");

	}

}
