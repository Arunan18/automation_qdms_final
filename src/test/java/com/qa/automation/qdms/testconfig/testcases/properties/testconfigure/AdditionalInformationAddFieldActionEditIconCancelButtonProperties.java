//**************************************************************************************************************************
//* Description
//*------------
//*Test Configure Configure Test Table Top Bar Additional Information Add Field Action Edit Icon Cancel Button Properties
//**************************************************************************************************************************
//*
//* Author           :M.Mathushan
//* Date Written     :13/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0787			13/07/2023    M.Mathushan   Original Version  
//*                    
//**************************************************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AdditionalInformationAddFieldActionEditIconCancelButtonProperties extends DriverIntialization {

	@Test
	public static void addFieldActionEditIconCancelButtonProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0787");
		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0787-01");

		// Calling The Method For Navigate To Test Configure Module-Additional
		// Information

		TestConfigMethods.navigate_TestConfigureTabs(7);
		Thread.sleep(2000);

		// Click the Edit Icon
		editiconclick();

		// Click Test Configure Module Additional Information Additional Information Add
		// Field Action Edit Icon Save Button Properties
		actionEditIconCancelButtonProperties(TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	// Check Test Configure Module Additional Information Add Field Additional
	// Information Add Field Action Edit Icon Properties
	public static void actionEditIconCancelButtonProperties(String Value) {

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0787-02",
				driver.findElement(
						By.xpath("//input[@value='" + Value + "']/ancestor::td/following-sibling::td[4]/span/a[2]")),
				"Additional Information  Add Field Status Add Field Action Edit Cancel Button Properties");

	}
	// Click the Edit Icon
	public static void editiconclick() {

		try {
			driver.findElement(By.xpath("//*[text()='" + TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)
					+ "']/following-sibling::td[4]/span/a[1]")).click();
			testCase = extent.createTest("Click The  Additional Information Add Field Action Edit Icon");
			testCase.log(Status.PASS, "Test Pass");
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Not Visible Additional Information Add Field Action Edit Icon");
			testCase.log(Status.FAIL, "Test Fail");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Not Click Additional Information Add Field Action Edit Icon");
			testCase.log(Status.FAIL, "Test Fail");
		} catch (Exception e) {
			testCase = extent.createTest("Not Click Additional Information Add Field Action Edit Icon");
			testCase.log(Status.FAIL, "Test Fail");
		}
	}
}
