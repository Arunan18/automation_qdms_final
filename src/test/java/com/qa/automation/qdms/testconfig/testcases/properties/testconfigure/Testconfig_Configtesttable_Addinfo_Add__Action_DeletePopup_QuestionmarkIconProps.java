//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Additional Information -Add Field- Action-"Delete Pop up Screen "?" icon Properties 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-TCN-0797        13/07/2023    N.Karunya   Original Version                
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
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Testconfig_Configtesttable_Addinfo_Add__Action_DeletePopup_QuestionmarkIconProps
		extends DriverIntialization {

	static TestConfigPage tcp = new TestConfigPage();
	
	@Test
	public static void questionmarkIcon() throws InterruptedException, IOException {

		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0797");

		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE ACCEPTED CRITERIA
			TestConfigMethods.clickButton(5);
		}

		Thread.sleep(500);

		// Checking Additional Information Pop-up-Add Field- Action -Delete Icon -Popup
		// "?" icon Properties
		deleteIconExcel(NavigateManageTestFromLogin.excelDataValue.get(1));

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void deleteIconExcel(String Value1) {

		try {

			WebElement deleteicon = driver.findElement(By.xpath("//td[text()='" + Value1
					+ "']//following-sibling::td[4]//span//span[@class='anticon anticon-delete']"));

			Thread.sleep(3000);

			deleteicon.click();
			testCase = extent
					.createTest("Checking The Configure Test Additional Information Add Field Delete Icon Click");
			testCase.log(Status.INFO, "Configure Test Additional Information Add Field Delete Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			questionmarkIconProps();

		} catch (NoSuchElementException e) {
			testCase = extent
					.createTest("Checking The Configure Test Additional Information Add Field Delete Icon Click");
			testCase.log(Status.INFO, "Unable to Locate Configure Test Additional Information Add Field Delete Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent
					.createTest("Checking The Configure Test Additional Information Add Field Delete Icon Click");
			testCase.log(Status.INFO, "Configure Test Additional Information Add Field Delete Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent
					.createTest("Checking The Configure Test Additional Information Add Field Delete Icon Click");
			testCase.log(Status.INFO,
					"Configure Test Additional Information Add Field Delete Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	public static void questionmarkIconProps() throws InterruptedException {

		PageFactory.initElements(driver, tcp);
		Thread.sleep(1000);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0797-02", TestConfigPage.additionalinfoaddActionPopupDeleteQuestionmarkIon,
				"Configure Test Table-Additional Information Pop-up-Add Field- Action -Delete Icon - ? icon UI Properties");

	}

}
