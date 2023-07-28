
/*****************************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Manage Test Configuration Tab,Accepted Value Pop up Screen, Header Line-"Close Icon" Button Properties
 ****************************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 17/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * MTC-MT-241		    17/07/2023      Shangeetha    Original Version  
 **************************************************************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigAcceptedValuePopupCloseIconProperties extends DriverIntialization{
	static ManageTestsPage testPage = new ManageTestsPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Accepted Value Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-241");
		Thread.sleep(2000);
		
		// Calling The Method To Check 'Close' Icon Properties
		closeIconProperties();

		// Refresh
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	
	public static void closeIconProperties() {
		PageFactory.initElements(driver, testPage);
		//Get 'Close' Icon Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests","MTC-MT-241-02", ManageTestsPage.acceptedValuePopCloseIcon,"'Close' Icon Properties");
	
	}
}
