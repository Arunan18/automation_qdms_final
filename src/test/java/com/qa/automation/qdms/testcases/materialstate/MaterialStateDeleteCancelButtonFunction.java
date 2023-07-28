/***********************************************************************************
* Description
*------------
* TC-MATSTA-0045--Check Delete Material State"Cancel" Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-MATSTA-0045	 26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.materialstate;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialStateDeleteCancelButtonFunction extends DriverIntialization {
	static MaterialStatePage MaStaPg = new MaterialStatePage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, MaStaPg);
		testCase = extent.createTest("TC-MATSTA-0045--Check Delete Material State Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigateMaterialState();
		}
		if (MasterMainNavigationsTest.clickMaterialState) {
			MasterMainNavigationsTest.clickMaterialState = false;
			ActionCommonMethod.actionS(0, 1, MaterialStatePage.materialStateTable, "delete", "Master Module.xlsx",
					"Material State", "TC-MATSTA-0045-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(MaterialStatePage.deleteCancelButton,
					MaterialStatePage.deletePopUP, "CHECKING THE DELETE CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

}
