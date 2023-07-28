package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - Accepted Condition -"Done" Button  Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0855           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTestAcceptedCondition_Done_ButtonProperties extends DriverIntialization{




@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0855-01", 2);


//		Check Properties
		propertiesAcceptedConditionDoneButton();

		Logout.LogoutFunction();

	}

	public static void propertiesAcceptedConditionDoneButton() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0855-02", TestConfigPage.AcceptedConditionDoneuttons, "Step-4--Accepted Condition 'Done' button Properties");

	}


	

}
