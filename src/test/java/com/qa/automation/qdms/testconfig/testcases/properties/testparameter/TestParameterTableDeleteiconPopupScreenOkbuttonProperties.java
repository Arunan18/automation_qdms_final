/**********************************************************************************
* Description
*------------
*Test Parameter Table  Delete icon Pop up Screen "Ok " button Properties 
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 15/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*TC-PAR-0109			 15/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testparameter;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestParameterTableDeleteiconPopupScreenOkbuttonProperties extends DriverIntialization {
	static TestConfigPage deleteiconpopupscreenokbtn = new TestConfigPage();

	@Test
	public static void TestParameterTableDeleteiconPopupScreenOkbuttonPropertie()
			throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Parameter", "TC-PAR-0109-01");
		// edit pop-up screen ok button properties
		deleteiconppupscreenokbutton(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
		// Refresh
		driver.navigate().refresh();
		// Logout
		Logout.LogoutFunction();

	}

	public static void deleteiconppupscreenokbutton(String data) {
		PageFactory.initElements(driver, deleteiconpopupscreenokbtn);
		try {
			TestConfigPage.paraMeterbutton.click();
			try {
				driver.findElement(By.xpath("//td[text()='" + data + "']//following-sibling::td/span/a[2]")).click();
				Thread.sleep(2000);
				deleteiconppupscreenokButton();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking Edit Icon");
				testCase.log(Status.INFO, "Unable to Locate the element 'Checking Edit Icon'");
				testCase.log(Status.FAIL, "TEST FAIL ");

			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking Edit Icon Icon");
				testCase.log(Status.INFO, "Unable to Click on the element 'Checking Edit Icon Icon'");
				testCase.log(Status.FAIL, "TEST FAIL ");

			} catch (Exception e) {
				testCase = extent.createTest("Checking The Edit Icon");
				testCase.log(Status.FAIL, "TEST FAIL ");
				System.out.println(e.toString());
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking test parameter button");
			testCase.log(Status.INFO, "Unable to Locate the element 'Checking test parameter button'");
			testCase.log(Status.FAIL, "TEST FAIL ");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Edit Icon Icon");
			testCase.log(Status.INFO, "Unable to Click on the element 'Checkin test parameter button'");
			testCase.log(Status.FAIL, "TEST FAIL ");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The test parameter button");
			testCase.log(Status.FAIL, "TEST FAIL ");
			System.out.println(e.toString());
		}

	}


	public static void deleteiconppupscreenokButton() {
		PageFactory.initElements(driver, deleteiconpopupscreenokbtn);
		// delete pop-up screen ok button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0109-02",
				TestConfigPage.deleteiconpopupscreenokbutton, "delete icon pop-up screen ok button Properties");
	}
}
