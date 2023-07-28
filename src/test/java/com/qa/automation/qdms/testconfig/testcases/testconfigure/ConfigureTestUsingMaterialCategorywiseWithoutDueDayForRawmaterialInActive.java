/***********************************************************************************
* Description
*------------
* Configure Test Using Material wise (without due day)(RAW MATERIAL TEST-Without Active)
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 24/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-TCN-0278            24/05/2023   Arunan     Orginal Version
*						 06/06/2023   Gobithan   Rework
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigureTestUsingMaterialCategorywiseWithoutDueDayForRawmaterialInActive extends DriverIntialization {
	static TestConfigPage addPage = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static TestParameterStep testparameter = new TestParameterStep();
	static configureEquationStep configure = new configureEquationStep();
	static AcceptCondition accepted = new AcceptCondition();
	static Addaditionalinformation additionalinformation = new Addaditionalinformation();
	static SampleActionMethods action = new SampleActionMethods();

	@Test
	public static void addgroupconfigure() throws InterruptedException, IOException {
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, testparameter);
		PageFactory.initElements(driver, accepted);
		PageFactory.initElements(driver, additionalinformation);
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, action);

//		LOGIN TO THE SYSTEM
		LoginTest.Login();

// 		TESTCASE REPORT
		extent.createTest(
				"TC-TCN-0278-Configure Test  Using Material wise (without due day) (RAW MATERIAL TEST-Without Active)");

// 		TOP NAVIGATION
		action.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");

// 		NAVIGATE TO TEST CONFIGURATION
		Thread.sleep(2000);
		action.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");

//        Configure Test Configure Test Step
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-first");
		Thread.sleep(500);

//        Select Parameter in Parameter Step
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-second");
		Thread.sleep(500);

//        Add parameter in Parameter Step
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-second");
		Thread.sleep(500);

//        Add Equation in Equation Step
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-third");
		Thread.sleep(3000);

//        Next Button Click in Equation
		TestConfigPage.nextBtn.click();
		Thread.sleep(500);

//        Add Accepted Value in Accepted creatia Step
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-fourth");
		Thread.sleep(3000);

//      Next Button Click in  Accepted creatia
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();
		Thread.sleep(1500);

//        Add Key Test in Key Test Step
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-fifth");

//      Next Button Click in Key Test
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();
		Thread.sleep(1500);

//        Add Additional Information in Additional Information Step
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-seventh");

//      Next Button Click in Additional Information
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

//		Review test Check in Review Tab
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0278-first",
				"TC-TCN-0278-second", "TC-TCN-0278-third", "TC-TCN-0278-fourth", "TC-TCN-0278-fifth",
				"TC-TCN-0278-sixth", "TC-TCN-0278-seventh");

//		Done Button Click
		SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", addPage.donebutton, "DONE BUTTON DISPLAYED",
				"DONE BUTTON ENABLED");

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0278-eigth", AddConfigureTest.testname, AddConfigureTest.testtype, "First",
				AddConfigureTest.active);

//		LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
}
