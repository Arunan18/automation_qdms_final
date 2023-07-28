/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field- Action -"Edit Icon " Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (21)         MTC-MT-297         26/06/2023       Arunan    Original Version
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MTAdititonalInformationEditIcon extends DriverIntialization {

	@Test
	public static void mTAditInfoPopUpActiveCheckbox() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-297");

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
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-297-02",
				driver.findElement(By.xpath("//td[text()='" + code + "']//following-sibling::td[4]/span/a[1]/span")),
				"Checking Additional Inormation Edit Icon Properties :");
	}
}
