/**********************************************************************************
* Description
*------------
* Test Parameter Table  Add Parameter Button-Pop up Screen Parameter Data Type Drop down Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 06/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0098          06/07/2023    Shobika      Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testparameter;

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
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;


	public class TestParameterTableAddParameterButtonPopupScreenParameterDataTypeDropdownProperties
	extends DriverIntialization {
static TestParameterPage Parametertdataypetextbox = new TestParameterPage();

@Test
public void TestParameterTableAddParameterButtonPopupScreenParameterDataTypeDropdownPropertie()
		throws InterruptedException, IOException {
	// login test
	LoginTest.Login();
	// Navigation to TestConfiguration
	TestConfigNavigation.TestConfigurationCard();
	// Test Parameter Table  Add Parameter Button-Pop up Screen Parameter Data Type Drop down Properties
	parametertdataypetextbox();
	// Refresh
	driver.navigate().refresh();
	// logout test
	Logout.LogoutFunction();

}

public void parametertdataypetextbox() {
	PageFactory.initElements(driver, Parametertdataypetextbox);
	try {
		TestConfigPage.paraMeterbutton.click();
		Thread.sleep(2000);

		try {
			TestParameterPage.addparameterbtn.click();
			Thread.sleep(2000);
			Parametertdataypetextbox();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Test Parameter Button");
			testCase.log(Status.INFO, "Unable to Locate the element 'Test Parameter Button'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Test Parameter Button");
			testCase.log(Status.INFO, "Unable to Click on the element 'Test Parameter Button'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (Exception e) {
			testCase = extent.createTest("Checking The Test Parameter Button");
			testCase.log(Status.FAIL, "TEST FAIL ");
			System.out.println(e.toString());

		}

	} catch (NoSuchElementException e) {
		testCase = extent.createTest("Checking Parameter Table Add Parameter Button");
		testCase.log(Status.INFO, "Unable to Locate the element 'Parameter Table Add Parameter Button'");
		testCase.log(Status.FAIL, "TEST FAIL ");
	} catch (ElementClickInterceptedException e) {
		testCase = extent.createTest("Checking The Parameter Table Add Parameter Button");
		testCase.log(Status.INFO, "Unable to Click on the element 'Parameter Table Add Parameter Button'");
		testCase.log(Status.FAIL, "TEST FAIL ");
	} catch (Exception e) {
		testCase = extent.createTest("Parameter Table Add Parameter Button");
		testCase.log(Status.FAIL, "TEST FAIL ");

	}

}

public static void Parametertdataypetextbox() {
	PageFactory.initElements(driver, Parametertdataypetextbox);

	//Test Parameter Table  Add Parameter Button-Pop up Screen Parameter Data Type Drop down Properties
	ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0098-02",
			TestParameterPage.Parametertdataypetextbox,
			"Test Parameter Table  Add Parameter Button-Pop up Screen Parameter Data Type Drop down Properties");
}
}



