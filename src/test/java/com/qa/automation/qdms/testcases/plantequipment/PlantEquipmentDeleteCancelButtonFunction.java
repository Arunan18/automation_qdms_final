/***********************************************************************************
* Description
*------------
* Check Delete Pnt Equipment Cancel Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-PLA-EQU-0095	     05/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.plantequipment;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class PlantEquipmentDeleteCancelButtonFunction extends DriverIntialization {
	static PlantEquipmentPage plntEqPg = new PlantEquipmentPage();

	@Test
	public static void deleteCancel() {
		PageFactory.initElements(driver, plntEqPg);
		testCase = extent.createTest("TC-PLA-EQU-0095--Check Delete Plant Equipment Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigatePlantEquipment();
		}
		if (MasterMainNavigationsTest.plntEquipmentclick) {
			MasterMainNavigationsTest.plntEquipmentclick = false;
			ActionCommonMethod.actionS(3, 10, PlantEquipmentPage.equipmentTable, "delete", "Master Module.xlsx",
					"Plant Equipment", "TC-PLA-EQU-0095-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(PlantEquipmentPage.deleteCancelButton,
					PlantEquipmentPage.deletePopUP, "CHECKING THE DELETE CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}
}
