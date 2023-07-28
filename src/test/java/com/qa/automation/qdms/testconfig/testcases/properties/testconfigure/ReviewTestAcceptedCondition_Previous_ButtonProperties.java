/***********************************************************************************
* Description
*------------
*Test Configure - Configure Test Table-  Top Bar Review Test - Accepted Condition -"Previous" Button  Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0856           26/06/2023   Quenthan     Orginal Version
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

public class ReviewTestAcceptedCondition_Previous_ButtonProperties extends DriverIntialization{




@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0856-01", 2);


//		Check Properties
		propertiesAcceptedConditionPreviousButton();

		Logout.LogoutFunction();

	}

	public static void propertiesAcceptedConditionPreviousButton() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0856-02", TestConfigPage.AcceptedConditionPreviousuttons, "Step-4--Accepted Condition 'Previous' button Properties");

	}


	

}
