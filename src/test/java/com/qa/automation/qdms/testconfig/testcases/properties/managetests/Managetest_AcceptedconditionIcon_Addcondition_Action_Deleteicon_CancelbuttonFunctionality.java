//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Accepted Condition -Add Condition - Action- Delete Pop up Screen  "Cancel" button Functionality 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 06/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-350         06/07/2023    N.Karunya   Original Version                
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
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_AcceptedconditionIcon_Addcondition_Action_Deleteicon_CancelbuttonFunctionality
		extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void deleteCancelButton() throws InterruptedException, IOException {

		// TEST PAGE ACCEPTED CONDITION ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 11, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-349");

		Thread.sleep(500);

		// Check Accepted Condition Popup Screen Action Delete Icon Popup Cancel Button
		// Properties
		deleteIconClick(NavigateManageTestFromLogin.excelDataValue.get(1));

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void deleteIconClick(String Value1) {

		WebElement editicon = driver.findElement(By.xpath(
				"//td[text()='" + Value1 + "']//following-sibling::td[1]//span[@class='anticon anticon-delete']"));

		try {

			editicon.click();
			testCase = extent.createTest("Checking The Delete Action icon Click");
			testCase.log(Status.INFO, "Delete Action icon is Clicked");
			testCase.log(Status.PASS, "TEST PASS");

			deleteCancelButtonFunctionality();

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

	public static void deleteCancelButtonFunctionality() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);

		try {
			if (ManageTestsPage.deletepopupcancelbutton.isDisplayed()) {
				testCase = extent.createTest("Delete Popup Screen Cancel Button is Displayed");
				testCase.log(Status.INFO, "Delete Popup Screen Cancel Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.deletepopupcancelbutton.isEnabled()) {
					testCase = extent.createTest("Delete Popup Screen Cancel Button is Enabled");
					testCase.log(Status.INFO, "Delete Popup Screen Cancel Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Delete Popup Screen Cancel Button is not Enabled");
					testCase.log(Status.INFO, "Delete Popup Screen Cancel Button is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Delete Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.INFO, "Delete Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Delete Popup Screen Cancel Button");
			testCase.log(Status.INFO, "Delete Popup Screen Cancel Button is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Delete Popup Screen Cancel Button");
			testCase.log(Status.INFO,"Unable to check the functionality of Delete Popup Screen Cancel Button");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
