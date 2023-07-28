//***************************************************************************************
//* Description
//*------------
//*Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen-Add Field- Action-"Delete Pop up Screen "?" icon Properties 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-309         12/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class managetests_AdditionalInfo_Add_Action_Deletepopup_Questionmark_iconProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void QuestionmarkIcon() throws InterruptedException, IOException {

//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickandClickIcon("Manage Tests", 10, "Description",
				"Test Configuration Properties", "Manage_Tests", "MTC-MT-309", 2);

//		Check Additional Information Pop-up-Add Field- Action -Delete Icon -Popup "?" icon Properties
		if (NavigateManageTestFromLogin.clicked) {
			Thread.sleep(500);
			QuestionmarkIconProps();
		}

//		Refresh
		driver.navigate().refresh();

//		Logout
		Logout.LogoutFunction();

	}

	public static void QuestionmarkIconProps() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-309-02", ManageTestsPage.additionalinfoPopupDeletePopupQuestionmarkIcon,
				"Additional Information Pop-up-Add Field- Action -Delete Icon -Popup ? icon Properties");

	}
	

}
