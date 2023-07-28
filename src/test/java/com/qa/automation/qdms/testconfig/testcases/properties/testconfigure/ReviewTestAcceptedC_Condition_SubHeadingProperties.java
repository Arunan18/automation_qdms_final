
/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - Accepted Condition -"Condition" UI Sub Heading  Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0853           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTestAcceptedC_Condition_SubHeadingProperties extends DriverIntialization{
	@Test
	public void propertiesChecking() throws InterruptedException, IOException {
		
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0853-01", 2);


//		Check Properties
		propertiesAcceptedCondition_Condition_subheading();

		Logout.LogoutFunction();

	}

	public static void propertiesAcceptedCondition_Condition_subheading() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0853-02", TestConfigPage.AcceptedCondition_ConditionHeading, "Step-4--Accepted Condition 'Condition' Sub Heading Properties");

	}
}
