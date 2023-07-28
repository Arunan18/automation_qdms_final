/*************************************************************************************************************************************************************************
* Description
*------------
* Test Configure Manage Test Configuration Tab Accepted Value Pop up Screen Properties
**************************************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  MTC-MT-191           17/07/2023   M.Mathushan    Original Version
*
*****************************************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;


public class ManageTestConfigurationTabAcceptedValuePopupScreenProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test

	public static void testConfigurationTabAcceptedValuePopupScreenProperties()
			throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests",8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-191");

		//Check the Manage Test Configuration Tab Accepted Value Pop up Screen Properties
		configurationTabAcceptedValuePopupScreenProperties();
		
		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	//Check the Manage Test Configuration Tab Accepted Value Pop up Screen Properties
	public static void configurationTabAcceptedValuePopupScreenProperties() {
		PageFactory.initElements(driver, mtp);
		ProCommonMethods.modal("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-191-02",
				ManageTestsPage.acceptedValuePopupScreenProperties,
				"Manage Test Configuration Tab Accepted Value Pop up Screen Properties");
	}
}