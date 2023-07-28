/***************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configuration Card Button UI Properties
****************************************************************************************************
*
* @author      : kajan
* 
* ===================================================================================================
*     Test Case Number    ||      Date      ||      Intis     ||   Comments
* ===================================================================================================
*       TC-TC-0001             22/06/2023            kajan         Original Version
*                                       
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class testConfigCardUI extends DriverIntialization{
	@Test
	public void testConfigCardUIpro() throws InterruptedException, IOException {
		
		//login test
		LoginTest.Login();
		
		//testConfigCardUIpro
		configCardUI();
		
		//logout test
		Logout.LogoutFunction();
		
	}
	public void configCardUI() {
		TestConfigPage tcp=new TestConfigPage();
		PageFactory.initElements(driver, tcp);
		
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test Configuration", "TC-TC-0001-01", TestConfigPage.conficgcard, "Test Configuration Card Button UI Properties");
		
		
	}

}
