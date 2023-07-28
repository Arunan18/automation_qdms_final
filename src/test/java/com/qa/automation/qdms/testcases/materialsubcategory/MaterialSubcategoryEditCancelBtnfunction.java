/***********************************************************************************
* Description
*------------
* TC-MATSC-0059--Check  Material Sub Category edit Cancel Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-MATSC-0059	     26/07/2023     RAHUL.S     ORIGINAL Version

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

public class MaterialSubcategoryEditCancelBtnfunction extends DriverIntialization{

	static MaterialSubCategoryPage MaSubPg = new MaterialSubCategoryPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, MaSubPg);
		testCase = extent.createTest("TC-MATSC-0059--Check  Material Sub Category edit Cancel Button Functionality");
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
			ActionCommonMethod.actionS(2, 5, MaterialSubCategoryPage.materialSubTable, "edit", "Master Module.xlsx",
					"Material Sub Category", "TC-MATSC-0059-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(MaterialSubCategoryPage.cancelbuttonedit,
					MaterialSubCategoryPage.popUpWindow, "CHECKING THE EDIT CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}


	
	
}
