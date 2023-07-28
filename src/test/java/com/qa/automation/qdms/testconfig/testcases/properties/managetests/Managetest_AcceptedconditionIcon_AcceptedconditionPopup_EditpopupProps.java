//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Accepted Condition -Add Condition- Action - "Edit"- Pop up Screen Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 05/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-334         05/07/2023    N.Karunya   Original Version                
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_AcceptedconditionIcon_AcceptedconditionPopup_EditpopupProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void editiconPopup() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACCEPTED CONDITION ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 11, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-334");

		Thread.sleep(500);
		
		// Checking Action Edit Popup UI Properties
		editicon(NavigateManageTestFromLogin.excelDataValue.get(1));

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void editicon(String Value1) {

		WebElement editicon = driver.findElement(By
				.xpath("//td[text()='" + Value1 + "']//following-sibling::td[1]//span[@class='anticon anticon-edit']"));

		try {
			
			editicon.click();
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Edit Action icon is Clicked");
			testCase.log(Status.PASS, "TEST PASS");
			
			editiconPopupProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Unable to Locate Edit Action icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Edit Action icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Edit Action icon Click");
			testCase.log(Status.INFO, "Edit Action icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void editiconPopupProperties() {

		PageFactory.initElements(driver, mtp);

		ProCommonMethods.modal("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-334-02",
				ManageTestsPage.editpopup, "Manage Test - Accepted Condition- Edit Popup UI Properties");

	}

}
