/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field- "Status" Check Box Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (20)         MTC-MT-295         26/06/2023       Arunan    Original Version
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MTAditInfoPopUpActiveDataCheckboxIcon extends DriverIntialization {

	@Test
	public static void mTAditInfoPopUpActiveDataCheckboxIcon() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-295");

//		Check Additional Information Pop-up Properties
		if (NavigateManageTestFromLogin.clicked) {
			Thread.sleep(500);
			properties(NavigateManageTestFromLogin.excelDataValue.get(1));
		}

//		Refresh
		driver.navigate().refresh();

//		Logout
		Logout.LogoutFunction();
	}

	public static void properties(String code) {
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-295-02",
				driver.findElement(By.xpath("//td[text()='" + code + "']//following-sibling::td[3]/label/span")),
				"Checking Additional Inormation Active Data CheckBox Properties :");
	}
}
