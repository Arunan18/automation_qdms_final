//***********************************************************************************
//* Description
//*------------
//* TEST CONFIGURE-ACCEPTED COMDITION TAB FUNCTION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0014              08/05/2023   WATHI     Original Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.managetests.ManageTestsMainTests;

public class DeleteEquiationFunctionTest extends TestConfiguteMainTests {
	
	@Test
	public static void deleteequiationfunction() throws InterruptedException, IOException
	{
		
		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);
		
		testCase = extent.createTest("TESTCASE-TC-TCN-0014");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);
		
		ManageTestsMainTests.clickonManageTestConfigure();
		
		// STEP 01- CALL EXCEL
		TestConfiguteMainTests.Excel2();

		// STEP 02- SELECT A RECORD
		TestConfiguteMainTests.selecttest2();

		Thread.sleep(2000);

		// STEP 03- CLICK ON EDIT CONFIG ICON
		TestConfiguteMainTests.clickeditconfigicon2();

		Thread.sleep(3000);
		
		//STEP 04- CHECK "CONFIGURE EQUATION TAB"
		TestConfiguteMainTests.configureequiation();
		
		//STEP 05- CLICK ON "CONFIGURE EQUATION TAB"
		TestConfigPage.configureequatab.click();
		
		//STEP 06- SCROLL DOWN THE PAGE
		TestConfiguteMainTests.scrollup();
		
		//STEP 07- READ EXCEL
		TestConfiguteMainTests.Excel4();
		
		//STEP 08- SCROLL SEARCH AND CLICK ON DELETE ICON
		TestConfiguteMainTests.scrolluntil();
		
		Thread.sleep(2000);
		
		//STEP 09- CLICK ON "OK" DELETE CONFIRMATION MESSAGE
		TestConfigPage.deleteconfirmationokbutton.click();
		
		//STEP 10- CHECK WEATHER THE DELETED DATA AVAILABLE
		TestConfiguteMainTests.scrolluntilafterdelete();
		
		Thread.sleep(2000);
		 
		Logout.LogoutFunction();
		
		

}
}