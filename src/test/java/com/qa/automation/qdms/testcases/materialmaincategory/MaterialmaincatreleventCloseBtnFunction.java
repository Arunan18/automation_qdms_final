/***********************************************************************************
* Description
*------------
* TC-MATMC-0053--Check  Material Main Category relevent \"Close\" Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-MATMC-0053	     26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/

package com.qa.automation.qdms.testcases.materialmaincategory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialmaincatreleventCloseBtnFunction extends DriverIntialization{

	static MaterialMainCategoryPage plntMaMaqPg = new MaterialMainCategoryPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, plntMaMaqPg);
		testCase = extent
				.createTest("TC-MATMC-0053--Check  Material Main Category relevent Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigateMaterialMainCategory();
		}
		if (MasterMainNavigationsTest.matmaincat) {
			MasterMainNavigationsTest.matmaincat = false;
			ActionCommonMethod.actionS(0, 4, MaterialMainCategoryPage.materialMainTable, "funnel-plot", "Master Module.xlsx",
					"Material Main Category", "TC-MATMC-0053-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(MaterialMainCategoryPage.popclose,
					MaterialMainCategoryPage.addmatpopup, "CHECKING THE relevent Close BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}


	
	

}
