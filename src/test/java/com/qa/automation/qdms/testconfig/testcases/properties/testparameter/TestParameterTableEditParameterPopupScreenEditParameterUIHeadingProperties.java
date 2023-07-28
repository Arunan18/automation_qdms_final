/**********************************************************************************
* Description
*------------
*Test Parameter Table  - Edit Parameter- Pop up Screen "Edit Parameter" UI Heading Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 15/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*TC-PAR-0105			 15/07/2023    Shobika      Original Version
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

public class TestParameterTableEditParameterPopupScreenEditParameterUIHeadingProperties extends DriverIntialization {
	static TestConfigPage editiconpopupscreenheading = new TestConfigPage();

	@Test
	public static void TestParameterTableEditParameterPopupScreenEditParameterUIHeadingPropertie()
			throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Parameter", "TC-PAR-0105-01");
		// edit pop-up screen properties
		tPmediticonpopupheading(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
		// Refresh
		driver.navigate().refresh();
		// Logout
		Logout.LogoutFunction();
	}

	public static void tPmediticonpopupheading(String data) {
		PageFactory.initElements(driver, editiconpopupscreenheading);
		try {
			TestConfigPage.paraMeterbutton.click();
			try {
				driver.findElement(By.xpath("//td[text()='" + data + "']//following-sibling::td/span/a[1]")).click();
				Thread.sleep(2000);
				tpmediticonIconPopupHeading();

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

	public static void tpmediticonIconPopupHeading() {
		PageFactory.initElements(driver, editiconpopupscreenheading);
		// edit pop-up screen heading Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter",
				"TC-PAR-0105-02", TestConfigPage.tpmediticonpopupheading, "Edit icon pop-up screen heading Properties");
	}
}
