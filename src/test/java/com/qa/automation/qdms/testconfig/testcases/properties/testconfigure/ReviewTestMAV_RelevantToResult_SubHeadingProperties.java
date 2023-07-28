
/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - Material Accepted Value -"Relevant To Result" UI Sub Heading  Properties
*
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0828           26/06/2023   Quenthan     Orginal Version
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

public class ReviewTestMAV_RelevantToResult_SubHeadingProperties extends DriverIntialization{


@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0828-01", 2);


//		Check Properties
		propertiesMaterialAcceptedValueRelevantToResultSubHeading();

		Logout.LogoutFunction();

	}

	public static void propertiesMaterialAcceptedValueRelevantToResultSubHeading() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0828-02", TestConfigPage.MaterialAcceptedalueRelevantToResultSubHeading, "Step-4--Material Accepted Value 'Relevant To Result' Sub Heading Properties");

	}




}
