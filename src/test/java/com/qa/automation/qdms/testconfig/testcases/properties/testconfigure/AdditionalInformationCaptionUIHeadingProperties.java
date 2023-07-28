//**************************************************************************************************************************
//* Description
//*------------
//*Test Configure Configure Test Table Top Bar Additional Information Caption UI Heading  Properties
//**************************************************************************************************************************
//*
//* Author           :M.Mathushan
//* Date Written     :13/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0765			13/07/2023    M.Mathushan   Original Version  
//*                    
//**************************************************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AdditionalInformationCaptionUIHeadingProperties extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();

	@Test
	public static void informationCaptionUIHeadingProperties () throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0765");

		// Calling The Method For Navigate To Test Configure Module-Additional
		// Information
		TestConfigMethods.navigate_TestConfigureTabs(7);
		Thread.sleep(2000);

		// Check Test Configure Module  Additional Information Caption UI Heading Properties
		captionUIHeadingProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	// Check Test Configure Module Additional Information Caption UI  Heading Properties
	public static void captionUIHeadingProperties() {
		PageFactory.initElements(driver, testconfigpg);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0765-02",
				TestConfigPage.additionalInformationcaptionUIheadingprop, "Additional Information Caption UI Heading Properties");

	}
}

