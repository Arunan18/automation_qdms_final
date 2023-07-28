/**********************************************************************************
* Description
*------------
*Test Configure Table - Parameter  Table - "Data Type" Top Data Heading Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 13/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0447           13/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ConfigureTableParameterTableDataTypeTopDataHeading extends DriverIntialization {
	static TestConfigPage tatatypetopdataheading = new TestConfigPage();

	@Test
	public void ConfigureTableParameterTableDataTypeTopDataheading() throws InterruptedException, IOException {
		// Navigation
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0447-01", 1);
		// Test Configure Table Parameter search Pop-up screen
		topDataHeading();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();
	}

	public void topDataHeading() {
		PageFactory.initElements(driver, tatatypetopdataheading);

		try {
			TestConfigPage.topbartestparametericon.click();
			Thread.sleep(2000);
			topdataHeading();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Parameter search Icon");
			testCase.log(Status.INFO, "Unable to Locate the element 'Checking Parameter search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Parameter search Icon");
			testCase.log(Status.INFO, "Unable to Click on the element 'Checking Parameter search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (Exception e) {
			testCase = extent.createTest("Checking The Parameter search Icon");
			testCase.log(Status.FAIL, "TEST FAIL ");
			System.out.println(e.toString());
		}
	}

	public void topdataHeading() {
		PageFactory.initElements(driver, tatatypetopdataheading);

		// Parameter Table Data Type Top Data Heading Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0447-02", TestConfigPage.tatatypetopdataheading,
				"Parameter  Table Data Type Top Data Heading Properties");
	}
}
