/*************************************************************************************************************************************************************************
* Description
*------------
*Test Configure Manage Test Configuration Tab Accepted Value Pop up Screen Accepted Value Relevant To Result icon Properties
**************************************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  MTC-MT-211           17/07/2023   M.Mathushan    Original Version
*
*****************************************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;


public class ManagetestAcceptedValuePopupScreenAcceptedValueRelevantToResulticonProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test

	public static void popupScreenAcceptedValueRelevantToResulticonProperties()
			throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests",8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-211");

		//Check the Accepted Value Pop up Screen Accepted Value Relevant To Result icon Properties
		acceptedValueRelevantToResulticonProperties();
		
		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	//Check the Accepted Value Pop up Screen Accepted Value Relevant To Result icon Properties
	public static void acceptedValueRelevantToResulticonProperties() {
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-211-02",
				ManageTestsPage.acceptedValueRelevantToResulticonProperties,
				"Manage Test Configuration Tab Accepted Value Relevant To Result icon Properties");
	}
}
