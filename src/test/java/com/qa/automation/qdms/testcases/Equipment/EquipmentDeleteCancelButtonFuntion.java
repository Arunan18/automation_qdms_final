/***********************************************************************************
* Description
*------------
* Check Delete Equipment Cancel Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-EQU-0065	       26/07/2023   RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.Equipment;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class EquipmentDeleteCancelButtonFuntion extends DriverIntialization {
	static EquipmentPage eqPg = new EquipmentPage();

	@Test
	public static void deleteCancel() {
		PageFactory.initElements(driver, eqPg);
		testCase = extent.createTest("TC-EQU-0065--Check Delete Equipment Cancel Button Functionality");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateEqupmentMain();

		}
		if (MasterMainNavigationsTest.mainEqupment) {
			MasterMainNavigationsTest.mainEqupment = false;
			MasterMainNavigationsTest.navigateEquipment();
		}
		if (MasterMainNavigationsTest.Equipmentclick) {
			MasterMainNavigationsTest.Equipmentclick = false;
			ActionCommonMethod.actionS(0, 3, EquipmentPage.equipmentTable, "delete", "Master Module.xlsx", "Equipment",
					"TC-EQU-0065-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(EquipmentPage.deleteCancelButton, EquipmentPage.deletePopUP,
					"CHECKING THE DELETE CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}
}
