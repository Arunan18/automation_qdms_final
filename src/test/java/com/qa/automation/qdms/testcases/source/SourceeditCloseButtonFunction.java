/***********************************************************************************
* Description
*------------
* TC-SRC-0054--Check Delete Source "Cancel" Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-SRC-0054	 26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.source;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class SourceeditCloseButtonFunction extends DriverIntialization{


	static SourcePage sourcePg = new SourcePage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, sourcePg);
		testCase = extent.createTest("TC-SRC-0054--Check Source Cancel Button Functionality");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateMaterialMain();

		}
		if (MasterMainNavigationsTest.clickMaterialMain) {
			MasterMainNavigationsTest.clickMaterialMain = false;
			MasterMainNavigationsTest.navigateSource();
		}
		if (MasterMainNavigationsTest.clickSource) {
			MasterMainNavigationsTest.clickSource = false;
			ActionCommonMethod.actionS(0, 2, SourcePage.sourceTable, "edit", "Master Module.xlsx", "Source",
					"TC-SRC-0054-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(SourcePage.closebutton, SourcePage.editpoup,
					"CHECKING THE DELETE CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

	
	



}
