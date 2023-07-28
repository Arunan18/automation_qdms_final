/**********************************************************************************
* Description
*------------
*Test Configure Table - Parameter  Table - "Parameter"  Search text Box  Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 13/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0444           13/07/2023    Shobika      Original Version
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

public class ConfigureTableParameterTableParameterSearchTextBox extends DriverIntialization {
	static TestConfigPage pmsearchtextbox = new TestConfigPage();

	@Test
	public void ConfigureTableParameterTableParameterSearchTextbox() throws InterruptedException, IOException {
		// Navigation
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0444-01", 1);
		// Test Configure Table Parameter search Text Box
		pmsearchtextBox();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();
	}

	public void pmsearchtextBox() {
		PageFactory.initElements(driver, pmsearchtextbox);

		try {
			TestConfigPage.topbartestparametericon.click();
			Thread.sleep(2000);

			try {
				TestConfigPage.pmsearchicon.click();
				Thread.sleep(2000);
				pmSearchTextBox();

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

	public void pmSearchTextBox() {
		PageFactory.initElements(driver, pmsearchtextbox);

		// Test Configure Table Parameter search Text Box
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0444-02", TestConfigPage.pmsearchtextbox, "Test Configure Table Parameter search Text Box");
	}
}
