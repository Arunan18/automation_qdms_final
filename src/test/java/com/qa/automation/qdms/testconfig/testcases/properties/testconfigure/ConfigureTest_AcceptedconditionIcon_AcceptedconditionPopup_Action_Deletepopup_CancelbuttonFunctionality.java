//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Add Key Test -Accepted Condition -Add Condition - Action- Delete Pop up Screen  "Cancel" button Functionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 14/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0761        14/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

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
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigureTest_AcceptedconditionIcon_AcceptedconditionPopup_Action_Deletepopup_CancelbuttonFunctionality
		extends DriverIntialization {
	
	static TestConfigPage tcp = new TestConfigPage();

	@Test
	public static void cancelButton() throws InterruptedException, IOException {

		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0761");

		Thread.sleep(500);
		
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE ACCEPTED CRITERIA
			TestConfigMethods.clickButton(6);
		}

		// Checking Action Delete Popup Cancel Button Functionality
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

		PageFactory.initElements(driver, tcp);
		Thread.sleep(1000);

		try {
			if (TestConfigPage.deletepopupcancelbutton.isDisplayed()) {
				testCase = extent.createTest("Delete Popup Screen Cancel Button is Displayed");
				testCase.log(Status.INFO, "Delete Popup Screen Cancel Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (TestConfigPage.deletepopupcancelbutton.isEnabled()) {
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
