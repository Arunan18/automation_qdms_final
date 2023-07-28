
//***********************************************************************************
//* Description
//*------------
//*KEY TEST ICON FUNCTION -MANAGE TEST CONFIGURE
//ICON FUCNTION
//CLOSE FUCNTION
//RETURN FUCNTION
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 15/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-047             15/05/2023    Niluxy      Original Version
//*MTC-MT-048
// MTC-MT-050
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class KeyTestIconFunction extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, groupkey);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000, "STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHOOSE THE KEY TEST DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 1, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-047-01", 1);

		extent.createTest("TESTCASEN0:MTC-MT-047-KEY TEST ICON FUNCTION");

		/* KEY TEST ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4:KEY TEST ICON PROPERTIES", ManageTestsPage.keytesticon,
				"01--KEY TEST ICON DISPLAYED", "02--KEY TEST ICON ENABLED", ManageTestsPage.Editkeytestheading, "Edit Key Test",
				"03--ON CLICK THE KEY TEST ICONIT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("TESTCASEN0:MTC-MT-048-KEY TEST CLOSE BUTTON FUNCTION");

		// CHECK CLOSE BUTTON FUCNTION
		closefunction();

		extent.createTest("TESTCASEN0:MTC-MT-050-KEY TEST RETURN BUTTON FUNCTION");
		/* KEY TEST ICON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP 9: KEY TEST ICON PROPERTIES", ManageTestsPage.keytesticon,
				"01--KEY TEST ICON DISPLAYED", "02--KEY TEST ICON ENABLED", ManageTestsPage.Editkeytestheading,
				"Edit Key Test", "03--ON CLICK THE KEY TEST ICONIT'S REDERECT TO CORRECT WINDOW");
		
		// CHECK THE RETURN BUTTON FUCNTION
		returnFucntion();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

}

	// METHOD FOR CLOSE FUNCTION
	public static void closefunction() {

		if (ManageTestsPage.EditkeytestClose.isDisplayed()) {

			testCase = extent.createTest("STEP 5:KEYTEST EDIT FUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.EditkeytestClose.isEnabled()) {
				testCase = extent.createTest("STEP 6:KEYTESTT EDITFUNCTION- CLOSE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.EditkeytestClose.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:KEYTEST EDITFUNCTION- CLOSE BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:KEYTEST EDITFUNCTION- MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 8:KEYTEST EDITFUNCTION- MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:KEYTEST EDITFUNCTION- CLOSE BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:KEYTEST EDITFUNCTION- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:KEYTEST EDITFUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

//METHOD FOR RETURN FUNCTION
	public static void returnFucntion() {

		if (ManageTestsPage.Editkeytestreturn.isDisplayed()) {

			testCase = extent.createTest("STEP 10:KEYTEST EDIT FUNCTION- RETURN BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.Editkeytestreturn.isEnabled()) {
				testCase = extent.createTest("STEP 11:KEYTESTT EDITFUNCTION- RETURN BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.Editkeytestreturn.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 12:KEYTEST EDITFUNCTION- RETURN BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 13:KEYTEST EDITFUNCTION- MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 13:KEYTEST EDITFUNCTION- MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 12:KEYTEST EDITFUNCTION-RETURN BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 11:KEYTEST EDITFUNCTION- RETURN BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 10:KEYTEST EDITFUNCTION- RETURN BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
}
