package com.qa.automation.qdms.commonmethods;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.CustomerPage;

public class EnableDisableCheckCommonTest extends DriverIntialization{
	static CustomerPage customerfunpg = new CustomerPage();

	//*****************************************************************************************
	//LOGIN FUNCTION
	//*****************************************************************************************
		@Test(priority = 0)
		public static void EnableDisablecheckbasicpath() throws InterruptedException {
			PageFactory.initElements(driver, customerfunpg);
			// Login credintial
			CustomerPage.username.sendKeys("Admin");
			CustomerPage.password.sendKeys("tokyo@admin");
			CustomerPage.login.click();
			// Master click
			Thread.sleep(2000);
			CustomerPage.Master.click();
			// customer page
			Thread.sleep(1000);
			CustomerPage.Customertopmenu.click();
			CustomerPage.Customersitebutton.click();
			CustomerPage.AddCustomerbtn.click();
		}

	//***********************************************************************************
		static boolean Visible = true;
		static boolean Enable = true;
		
		
		
			public static void EnableDisablecheckMethod(WebElement field,String testCasedetail,String displaypass, String displayfail, String enablepass, String enablefail) throws InterruptedException {
			PageFactory.initElements(driver, customerfunpg);	
			testCase = extent.createTest(testCasedetail);
			String expecteddata ="true";
			try {
				Assert.assertEquals(field.isDisplayed(), true);
				testCase.log(Status.INFO, "Actual Data :- " + Visible);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.PASS,displaypass);
			} catch (AssertionError e) {
				Visible=false;
				testCase.log(Status.INFO, "Actual Data :- " + Visible);
				testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
				testCase.log(Status.FAIL,displayfail);
			}
			catch (NoSuchElementException e) {
				Visible=false;
				testCase.log(Status.FAIL, "Wrong last added data");
			}
			if(Visible) {
				try {
					Assert.assertEquals(field.isEnabled(), true);
					testCase.log(Status.INFO, "Actual Data :- " + Enable);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.PASS, enablepass);
				} catch (AssertionError e) {
					Enable=false;
					testCase.log(Status.INFO, "Actual Data :- " + Enable);
					testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
					testCase.log(Status.FAIL, displayfail);
				}
			}
	/*		if (Visible) {
				USE THE OTHER METHODS
			}*/
		}
	//******************************************************************************************
		@Test(priority = 1)
		public static void CustomerEnableDisablecheckMethod() throws InterruptedException {
			PageFactory.initElements(driver, customerfunpg);
			if (CustomerPage.CustomerFiled.isDisplayed()) {
				if (CustomerPage.CustomerFiled.isEnabled()) {
					System.out.println("Enabled Customer Filed");
				} else {
					System.out.println("Customer Filed is not Enabled");
				}

			} else {
				System.out.println("Customer Filed is not Displayed");
			}
		}
}


