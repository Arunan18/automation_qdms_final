//***********************************************************************************
//* Description
//*------------
//* Add Config Group Test Material Category Both Type
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 19/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-CGT-0023        	19/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.configgrouptest.AddConfigGroupTest;

public class AddconfigGroupTest_MaterialCategoryBothType extends DriverIntialization{

	static TestConfigPage addPage = new TestConfigPage();
    static configGroupTestsPage configPage = new configGroupTestsPage();
    @Test
    public static void addgroupconfigure() throws InterruptedException, IOException {
        PageFactory.initElements(driver, addPage);
        PageFactory.initElements(driver, configPage);
        // LOGIN TO THE SYSTEM
        LoginTest.Login();
        // NAVIGATE TO TEST CONFIGURATION
        SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", addPage.testconfigurationcard,
                "01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED", addPage.testconfigurationtext,
                "TEST CONFIGURATION", "03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
        // NAVIGATE TO TEST CONFIGURATION
        SampleCommonMethods.methodoneclick("STEP:2 CONFIG GROUP TEST  PROPERTIES", configPage.configgrouptestsleftnav,
                "01--CONFIG GROUP TEST CARD DISPLAYED", "02--CONFIG GROUP TEST CARD ENABLED",
                configPage.configgrouptesttableHeading, "Config Group Test",
                "03--ON CLICK THE CONFIG GROUP TEST CARD IT'S REDERECT TO CORRECT WINDOW");
        //ADD MAIN CATEGORY AND
        AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module","Config_Group_Test","TC-CGT-0023");  
        //LOGOUT TO THE SYSTEM
        Logout.LogoutFunction();
    }
}
