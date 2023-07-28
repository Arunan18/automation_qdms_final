/****************************************************************************************
* Description
*------------
Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - Accepted Value-Action - "Delete" icon Properties
***************************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Name        Comments
* ================       ====         =====        ========
*  
*MTC-MT-232       17/07/2023    THAKSHILA    Modified Version    */

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class PopupScreenAcceptedValueActionDeleteiconProperties extends DriverIntialization {
	static ManageTestsPage manageTest = new ManageTestsPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The
		// Manage Test Page and Click on Accepted Value Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-232");

		// Get PROPERTIES
		Thread.sleep(500);
		deleteIconProps(NavigateManageTestFromLogin.excelDataValue.get(1));
		// Refresh
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void deleteIconProps(String searchCode) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-231-02",
				driver.findElement(By.xpath("//td[text()='" + searchCode + "']/following-sibling::td[4]/span/a[2]")),
				"Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - Accepted Value-Action - Delete icon Properties");

	}
}
