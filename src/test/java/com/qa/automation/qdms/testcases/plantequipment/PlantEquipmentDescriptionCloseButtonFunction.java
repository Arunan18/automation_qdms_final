/***********************************************************************************
* Description
*------------
* Check Description Pnt Equipment Close Button Functionality
***********************************************************************************
*
* Author           :Arunan
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
*TC-PLA-EQU-0061	     26/07/2023     Arunan     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.plantequipment;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class PlantEquipmentDescriptionCloseButtonFunction extends DriverIntialization {
	static PlantEquipmentPage plntEqPg = new PlantEquipmentPage();

	@Test
	public static void deleteCancel() {
		PageFactory.initElements(driver, plntEqPg);
		testCase = extent.createTest("TC-PLA-EQU-0061--Check Description Plant Equipment Close Button Functionality");
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
			ActionCommonMethod.actionS(3, 9, PlantEquipmentPage.Table, "Description", "Master Module.xlsx",
					"Plant Equipment", "TC-PLA-EQU-0061-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(PlantEquipmentPage.descCloseBtn,
					PlantEquipmentPage.editPopUP, "CHECKING THE Description Close BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			MultiSearchMethods.Logout();

		}

	}
}
