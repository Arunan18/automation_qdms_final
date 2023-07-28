package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

/***********************************************************************************
* Description
*------------
*Test Configure - Configure Test Table-  Top Bar Review Test - Accepted Condition -"Parameters" UI Sub Heading  Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0854           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ReviewTestAcceptedCondition_Parameters_SubHeadingProperties extends DriverIntialization{




@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0854-01", 2);


//		Check Properties
		propertiesAcceptedConditionParameterssubheading();

		Logout.LogoutFunction();

	}

	public static void propertiesAcceptedConditionParameterssubheading() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0854-02", TestConfigPage.AcceptedConditionParametersHeading, "Step-4--Accepted Condition 'Parameters' Sub Heading Properties");

	}


	

}
