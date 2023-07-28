/**********************************************************************************
* Description
*------------
*Test Parameter Table Pagination Drop down Properties

***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 10/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0114           10/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;



public class TestParameterTablePaginationDropdownProperties extends DriverIntialization {
	static TestParameterPage Paginationndropdown = new TestParameterPage();

	@Test
	public void TestParameterTableAddParameterButtonPopupScreenClosebuttonPropertie()
			throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Test Parameter Table Pagination Drop-Down Properties
		Paginationndropdown();
		// logout test
		Logout.LogoutFunction();
	}
 
	public void Paginationndropdown() {
		PageFactory.initElements(driver, Paginationndropdown);
		try {
			TestParameterPage.testparameterbtn.click();
			Thread.sleep(2000);
			PaginationndropDown();

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
	}



	public static void PaginationndropDown() {
		PageFactory.initElements(driver, Paginationndropdown);
		
    // Test Parameter Table Pagination Drop-Down Properties
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Parameter",
				"TC-PAR-0114-02", TestParameterPage.Paginationdropdown,
				"Test Parameter Table Paginationn Drop-Down Properties", "1");

}
}

