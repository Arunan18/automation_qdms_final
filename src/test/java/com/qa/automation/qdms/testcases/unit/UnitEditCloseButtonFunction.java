/***********************************************************************************
* Description
*------------
*TC-UNIT-0038--Check edit Unit "Close" Button Functionality

***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-UNIT-0038	     26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.unit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.UnitPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class UnitEditCloseButtonFunction extends DriverIntialization{


	static UnitPage unitPg = new UnitPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, unitPg);
		testCase = extent.createTest("TC-UNIT-0038--Check Delete Unit Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigateUnit();
		}
		if (MasterMainNavigationsTest.clickUnit) {
			MasterMainNavigationsTest.clickUnit = false;
			ActionCommonMethod.actionS(0, 1, UnitPage.unitTable, "edit", "Master Module.xlsx", "Unit",
					"TC-UNIT-0038-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(UnitPage.UnitCloseButton, UnitPage.deletePopUP,
					"CHECKING THE edit CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}


	
	



}
