/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - Additional Information -"Max length" UI Sub Heading  Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 10/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0848           23/06/2023   Quenthan     Orginal Version
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

public class ReviewTest_AdditionalInformation_Maxlength_SubHeadingProperties extends DriverIntialization{




@Test
	public void modalproperties() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0848-01", 2);


//		Check Properties
		propertiesAdditionalInformationMaxLenthSubheading();

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesAdditionalInformationMaxLenthSubheading() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0848-02", TestConfigPage.additionalInformationMaxLenthHeading, "Step-4--Additional Information Max length Sub Heading Properties");

	}








}
