/***********************************************************************************
* Description
*------------
* Configure Test  Using Main Category wise (With Key Test)
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 31/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0355           31/05/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ConfigureTestUsingMaterialwise_WithAdditionalinformation extends DriverIntialization {
	static Logout logout = new Logout();
	static SampleActionMethods actions = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();
	static TestConfigPage addPage = new TestConfigPage();

	@Test
	public static void configureTestUsingMaterialwise() throws InterruptedException, IOException {

		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, addPage);
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000, "TEST CONFIGURATION CARD");
		Thread.sleep(2000);
		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);
		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);

		// CONFIGURE TEST FIELD
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-first");
		Thread.sleep(2000);

		// TEST PARAMETER FIELD
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-secound");
		Thread.sleep(3000);

		// ADD PARAMETER FIELD
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-secound");
		Thread.sleep(2000);

		// CONFIGURE EQUATION FIELD
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-third");
		Thread.sleep(3000);

		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// ACCEPTED CRITERIA FIELD
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-fourth");
		Thread.sleep(3000);
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// ACCEPTED CRITERIA FIELD
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-fifth");
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

//		//ADD CONDITION IN CONDITION STEP
//				Thread.sleep(3000);
//				AcceptCondition.condition("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-sixth");
//				TestConfigPage.nextBtn.click();
//				Thread.sleep(3000);

		// ADD INFORMATION
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-seventh");

		Thread.sleep(3000);

		TestConfigPage.nextBtn.click();

		// Review test Check in Review Tab
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0355-first",
				"TC-TCN-0355-secound", "TC-TCN-0355-third", "TC-TCN-0355-fourth", "TC-TCN-0355-fifth",
				"TC-TCN-0355-sixth", "TC-TCN-0355-seventh");

		// DONE BUTTON PROPERTYS
		SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", TestConfigPage.donebutton, "DONE BUTTON DISPLAYED",
				"DONE BUTTON ENABLED");

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0355-eight", AddConfigureTest.testname, AddConfigureTest.testtype, "second",
				AddConfigureTest.active);
		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

}
