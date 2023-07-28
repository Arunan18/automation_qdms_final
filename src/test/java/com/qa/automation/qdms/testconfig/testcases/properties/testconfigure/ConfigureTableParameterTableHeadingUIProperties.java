/**********************************************************************************
* Description
* Test Configure Table "Parameter " Table Heading UI Properties
*------------
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 13/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0440          13/07/2023    Shobika      Original Version
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

public class ConfigureTableParameterTableHeadingUIProperties extends DriverIntialization {
	static TestConfigPage topbartestparameterhading = new TestConfigPage();

	@Test
	public void ConfigureTableParameterTableHeadingUIPropertie() throws InterruptedException, IOException {
		// Navigation
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0440-01", 1);
		// Test Configure Table Parameter Table Heading UI Properties
		tBParameterHading();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();
	}

	public void tBParameterHading() {
		PageFactory.initElements(driver, topbartestparameterhading);

		try {
			TestConfigPage.topbartestparametericon.click();
			Thread.sleep(2000);
			tbParameterHading();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking top bar test parameter");
			testCase.log(Status.INFO, "Unable to Locate the element 'Checking top bar test parameter'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Checking top bar test parameter");
			testCase.log(Status.INFO, "Unable to Click on the element 'Checking top bar test parameter'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (Exception e) {
			testCase = extent.createTest("Checking The Checking top bar test parameter");
			testCase.log(Status.FAIL, "TEST FAIL ");
			System.out.println(e.toString());
		}
		  
	}

	public void tbParameterHading() {
		PageFactory.initElements(driver, topbartestparameterhading);

		// Test Configure Table Parameter Table Heading UI Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0440-02", TestConfigPage.tbheading,
				"Test Configure Table Parameter Table Heading UI Properties");
	}
}
