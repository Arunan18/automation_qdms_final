/*************************************************************************************************************************************************************************
* Description
*------------
*Test Configure Manage Test Configuration Tab Accepted Value Pop up Screen Accepted Value Action Heading Properties
**************************************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  MTC-MT-212           17/07/2023   M.Mathushan    Original Version
*
*****************************************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;


public class ManagetestAcceptedValuePopupScreenAcceptedValueActionHeadingProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test

	public static void popupScreenAcceptedValueActionHeadingProperties()
			throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests",8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-212");
		
		//Scorall Down
		for (int down = 0; down < 10; down++) {
			 Actions actions = new Actions(driver);
			 actions.sendKeys(Keys.ARROW_DOWN).perform();
			 Thread.sleep(1000);
			 }

		//Check the Accepted Value Pop up Screen Accepted Value Action Heading Properties
		acceptedValueActionHeadingProperties();
		
		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	//Check the Accepted Value Pop up Screen Accepted Value Action Heading Properties
	public static void acceptedValueActionHeadingProperties() {
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-212-02",
				ManageTestsPage. acceptedValueActionHeadingProperties,
				"Manage Test Configuration Tab Accepted Value Action Heading Properties");
	}
}
