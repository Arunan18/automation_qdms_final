/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - "Additional Information" - UI Top Heading  Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 10/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0846           23/06/2023   Quenthan     Orginal Version
*
************************************************************************************/


package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class Review_Test_AdditionalInformationUITopHeadingProperties extends DriverIntialization {


@Test
	public void modalproperties() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0846-01", 2);


//		Check Properties
		propertiesAdditionalInformationheading();

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesAdditionalInformationheading() {

		TestConfigPage lk = new TestConfigPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0846-02", TestConfigPage.additionalInformationHeading, "Step-4--Additional Information Heading Properties");

	}




}
