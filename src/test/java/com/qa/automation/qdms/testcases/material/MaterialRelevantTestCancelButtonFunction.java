/***********************************************************************************
* Description
*------------
*TC-MAT-0085--Material Relevant Test Cancel Button Functionality

***********************************************************************************
*
* Author           :Arunan
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-MAT-0084	 26/07/2023     Arunan     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.material;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialRelevantTestCancelButtonFunction extends DriverIntialization {
	static MaterialPage materialPg = new MaterialPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, materialPg);
		testCase = extent.createTest("TC-MAT-0085--Material Relevant Test Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigateMaterial();
		}
		if (MasterMainNavigationsTest.clickMaterial) {
			MasterMainNavigationsTest.clickMaterial = false;
			ActionCommonMethod.actionS(3, 11, MaterialPage.Table, "Add Key Test", "Master Module.xlsx", "Material",
					"TC-MAT-0085-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(MaterialPage.CancelButton, MaterialPage.editPopUP,
					"CHECKING THE RELEVANT TEST CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}
}
