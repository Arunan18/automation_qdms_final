/***********************************************************************************
* Description
*------------
* TC-MATSC-0068--Check Relevant Test Material Sub Category Cancel Button Functionality
***********************************************************************************
*
* Author           :Arunan
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-MATSC-0068	     26/07/2023     Arunan     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.materialsubcategory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialSubCategoryRelavantTestCancelButtonFunction extends DriverIntialization {
	static MaterialSubCategoryPage MaSubPg = new MaterialSubCategoryPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, MaSubPg);
		testCase = extent.createTest("TC-MATSC-0068--Check Relevant Test Material Sub Category Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigateMaterialSubCategory();
		}
		if (MasterMainNavigationsTest.clicksubCategory) {
			MasterMainNavigationsTest.clicksubCategory = false;
			ActionCommonMethod.actionS(2, 4, MaterialSubCategoryPage.Table, "Add Key Test", "Master Module.xlsx",
					"Material Sub Category", "TC-MATSC-0068-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(MaterialSubCategoryPage.CancelButton,
					MaterialSubCategoryPage.editPopUP, "CHECKING THE RELEVANT TEST CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

}
