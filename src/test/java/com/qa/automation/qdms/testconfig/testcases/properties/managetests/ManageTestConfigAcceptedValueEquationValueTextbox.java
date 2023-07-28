//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - "Equation" -"Value" Text Box Properties  
//***************************************************************************************
//*
//* Author           : BFH.Rakshana
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis          Comments
//* ================       ====         =====          ========
//* MTC-MT-205             13/07/2023   BFH.Rakshana   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

import net.bytebuddy.asm.Advice.Enter;

public class ManageTestConfigAcceptedValueEquationValueTextbox extends DriverIntialization {

	@Test
	public static void manageTestConfigAcceptedValueTestParameterDropDown() throws InterruptedException, IOException {

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-205");

		// search
		equationDropDownClick();

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void valueTextbox() throws InterruptedException {
		ManageTestsPage mtp = new ManageTestsPage();
		PageFactory.initElements(driver, mtp);
		
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-205-02",
		ManageTestsPage.ValueTextbox, "Value Textbox UI Properties");
	}
	public static void equationDropDownClick() throws InterruptedException, IOException{
		try {
		Thread.sleep(2000);	
		ManageTestsPage.EquationDropDown.click();
		try {
			ManageTestsPage.Equal.click();
			valueTextbox();
			}
		catch (NoSuchElementException e) {
			 testCase = extent.createTest("Checking The Equal");
			 testCase.log(Status.INFO, "Equal is not available ");
			 testCase.log(Status.FAIL, "TEST FAIL ❎");
			        }
		catch (ElementClickInterceptedException e) {
			        	testCase = extent.createTest("Checking The Equal");
			            testCase.log(Status.INFO, "Unable to Click on the element 'Equal'");
			            testCase.log(Status.FAIL, "TEST FAIL ❎");
			        }
			        catch (Exception e) {
			        	testCase = extent.createTest("Checking Equal");
			            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
			        }
		}
		catch (NoSuchElementException e) {
			 testCase = extent.createTest("Checking The Equation DropDown");
			 testCase.log(Status.INFO, "Equation DropDown is not available ");
			 testCase.log(Status.FAIL, "TEST FAIL ❎");
			        }
		catch (ElementClickInterceptedException e) {
			        	testCase = extent.createTest("Checking The Equation DropDown");
			            testCase.log(Status.INFO, "Unable to Click on the element 'Equation DropDown'");
			            testCase.log(Status.FAIL, "TEST FAIL ❎");
			        }
			        catch (Exception e) {
			        	testCase = extent.createTest("Checking Equation DropDown");
			            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
			        }
	}
}
