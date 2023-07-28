//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Accepted Condition-Add Condition-"Edit" icon UI Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 05/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-332          05/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_AcceptedconditionIcon_AcceptedconditionPopup_EditiconProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	

	@Test
	public static void editIcon() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE TEST PAGE ACCEPTED CONDITION ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 11,"Description","Test Configuration Properties","Manage_Tests","MTC-MT-332");
		
		Thread.sleep(500);
	
		// Check Accepted Condition Popup Screen Edit Icon Properties
		editIconProperties(NavigateManageTestFromLogin.excelDataValue.get(1));
		

    	// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}

	
	public static void editIconProperties(String Value1) {
		
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-332-02",
				driver.findElement(By.xpath("//td[text()='" + Value1 + "']//following-sibling::td[1]//span[@class='anticon anticon-edit']")),
				"Manage Test - Accepted Condition - Edit Icon UI Properties");
		
	}

}
