/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
*Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen - Add Field- Action -Edit Icon -"Max length" Text Box UI Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (29)         MTC-MT-304         22/06/2023       Arunan    Original Version
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MTAditInfoPopUpEditMaxLengthTextBox extends DriverIntialization {

	@Test
	public static void mTAditInfoPopUpMaxLengthTextBox() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickandClickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-304",1);

//		Check Additional Information Pop-up Properties
		if (NavigateManageTestFromLogin.clicked) {
			properties(NavigateManageTestFromLogin.excelDataValue.get(2));
		}

//		Refresh
		driver.navigate().refresh();

//		Logout
		Logout.LogoutFunction();
	}

	public static void properties(String code) {
		System.out.println("//input[@id='length'][@value='"+code+"']");
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-304-02",
				driver.findElement(By.xpath("//input[@id='length'][@value='"+code+"']")),
				"Checking Additional Inormation PopUp Edit Max Length Textbox Properties :");
	}
}
