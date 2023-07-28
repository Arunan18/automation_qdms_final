/***********************************************************************************************************
 * Description
 *------------
 * Test Configure - Manage Test Configuration Tab,Equation Column: Equation Icon Pop up Screen Properties  
 ************************************************************************************************************
 *
 * Author           : Shangeetha
 * Date Written     : 17/07/2023 
 * 
 *
 * 
 * Test Case Number       Date         Intis          Comments
 * ================       ====         =====          ========
 * MTC-MT-245              17/07/2023   M.Shangeetha   Original Version  				                 
 **********************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigTableEquationPopup extends DriverIntialization{
	static ManageTestsPage testPage = new ManageTestsPage();

	@Test
	public static void manageTestConfigTableEquationPopup() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Equation Column,Click on Equation Icon        
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-245");

		// Calling The Method To Check The Equation Icon's Pop Up Properties
		methodEquationIconPopUpProperties();

		// Refresh
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Log Out Of The System.
		Logout.LogoutFunction();

	}       

	public static void methodEquationIconPopUpProperties() {
		//Check The Equation Icon Properties
		PageFactory.initElements(driver, testPage);
		ProCommonMethods.modal("Test Configuration Properties.xlsx", "Manage_Tests","MTC-MT-245-02", ManageTestsPage.equationPop,"Equation Popup UI Properties");
	}

}