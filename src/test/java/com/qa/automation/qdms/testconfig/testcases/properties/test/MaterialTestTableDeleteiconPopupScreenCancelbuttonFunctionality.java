/**********************************************************************************
* Description
*------------
*Test - Material Test Table Delete icon Pop up Screen "Cancel" button Functionality
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 15/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*TC-Test-0069			 15/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.test;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

	public class MaterialTestTableDeleteiconPopupScreenCancelbuttonFunctionality extends DriverIntialization {
		static TestConfigPage deleteiconcancelbuttonfunct = new TestConfigPage();

		@Test
		public static void MaterialTestTableDeleteiconPopupScreenCancelbuttonFunctionalit()
				throws InterruptedException, IOException {

			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test", "TC-Test-0069-01");
			// pop-up screen cancel button properties
			deleteiconcancelbutton(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
			// Refresh
		    driver.navigate().refresh();
			// Logout
			Logout.LogoutFunction();

		}

		public static void deleteiconcancelbutton(String data) {
			try {
				driver.findElement(By.xpath("//td[text()='" + data + "']//following-sibling::td[1]/span/a[2]")).click();
				Thread.sleep(2000);
				deleteiconCancelbutton();

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
		}

		public static void deleteiconCancelbutton() {
			PageFactory.initElements(driver, deleteiconcancelbuttonfunct);
			// pop-up screen cancel but Functionality
			functionality.ButtonAndIconunctionalityMtd("Material Test Table Delete icon Pop up Screen cancel buton Functionality", 
					TestConfigPage.deleteiconoposcreencancelbtn, "Button");
		}

}
