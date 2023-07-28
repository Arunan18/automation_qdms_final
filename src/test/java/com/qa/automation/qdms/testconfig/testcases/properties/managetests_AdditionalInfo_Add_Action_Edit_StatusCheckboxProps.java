//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field- Action -Edit Icon -"Status" Check box UI Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 05/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-306          05/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class managetests_AdditionalInfo_Add_Action_Edit_StatusCheckboxProps extends DriverIntialization {

	@Test
	public static void statusCheckbox() throws InterruptedException, IOException {

//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickandClickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-306",1);

//		Check Additional Information Pop-up-Add Field- Action -Edit Icon -"Status" Check box
		if (NavigateManageTestFromLogin.clicked) {
			Thread.sleep(500);
			statusCheckboxProps(NavigateManageTestFromLogin.excelDataValue.get(1));
		}

//		Refresh
		driver.navigate().refresh();

//		Logout
		Logout.LogoutFunction();

	}

	public static void statusCheckboxProps(String code) throws InterruptedException {

		Thread.sleep(2000);
		
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-306-02",
				driver.findElement(By.xpath("//td[text()='" + code + "']//following-sibling::td[3]//input[@class='ant-checkbox-input']/..")),
				"Manage Test - Accepted Condition - Add Field- Action -Edit Icon -Status - Check box Properties");

	}

}
