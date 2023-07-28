/**********************************************************************************
* Description
*------------
*Configure Test Table Procedure Text Box Properties 
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 12/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0429           12/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;



public class ConfigureTestTableProcedureTextBoxProperties extends DriverIntialization {
	static TestConfigPage Proceduretextbox = new TestConfigPage();

	@Test
	public void ConfigureTestTableProcedureTextBoxPropertie() throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Test Configure Configure Procedure TextBox Properties
		ptexTbox();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();
	}

	public void ptexTbox() {
		PageFactory.initElements(driver, Proceduretextbox);
		try {
			TestConfigPage.testconfigureButton.click();
			Thread.sleep(2000);
			pTextbox();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Test Configu re  Button");
			testCase.log(Status.INFO, "Unable to Locate the element 'est Configure Button'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Test  Configure  Button");
			testCase.log(Status.INFO, "Unable to Click on the element 'Test Configure  Button'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (Exception e) {
			testCase = extent.createTest("Checking The Test Configure  Button");
			testCase.log(Status.FAIL, "TEST FAIL ");
			System.out.println(e.toString());
		}
	}

	public static void pTextbox() {
		PageFactory.initElements(driver, Proceduretextbox);

		// Test Configure Configure Procedure TexBox Properties
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0429-02",
				TestConfigPage.proceduretextbox, "Test Configur Procedure TexBox Properties");
	}
}



