/***********************************************************************************
* Description
*------------
* Check Delete SBU "Cancel" Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
*  TC-SBU-0046	       26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class SbuDeleteCancelButtonFunction extends DriverIntialization {
	static SbuPage sbu = new SbuPage();

	@Test
	public static void deleteCancel() {
		PageFactory.initElements(driver, sbu);
		testCase = extent.createTest("TC-SBU-0046--Check Delete SBU Cancel Button Functionality");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigatePlantMain();

		}
		if (MasterMainNavigationsTest.clickPlantMain) {
			MasterMainNavigationsTest.clickPlantMain = false;
			MasterMainNavigationsTest.navigateSbu();
		}
		if (MasterMainNavigationsTest.clickSbu) {
			MasterMainNavigationsTest.clickSbu = false;
			ActionCommonMethod.actionS(0, 2, SbuPage.sbuTable,
					"delete", "Master Module.xlsx", "SBU", "TC-SBU-0046-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(SbuPage.CancelButton, SbuPage.deletePopUP,
					"CHECKING THE DELETE CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

}
