/***********************************************************************************
* Description
*------------
* Edit Close Icon Functionality
***********************************************************************************
*
* Author           : Arunan
* Date Written     : 26/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-PLANT-0087       	 26/07/2023   Arunan     Original Version
//************************************************************************************/

package com.qa.automation.qdms.testcases.plant;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class PlantEditCloseIconFunctionality extends DriverIntialization {

	static PlantPage plantpage = new PlantPage();
	static boolean addbutton = false;

	@Test
	public static void AddcancleButton() throws InterruptedException {

		PageFactory.initElements(driver, plantpage);

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigatePlantMain();
		}

		if (MasterMainNavigationsTest.clickPlantMain) {

			MasterMainNavigationsTest.navigatePlant();

		}

		if (MasterMainNavigationsTest.Plantclick) {

			ActionCommonMethod.actionS(0, 8, PlantPage.table,
					"edit", "Master Module.xlsx", "Plant", "TC-PLANT-0087-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(PlantPage.editCloseIcon, PlantPage.editPopUP,
					"CHECKING THE EDIT CLOSE ICON", "CHECKING THE POPUP");
		}


		MultiSearchMethods.Logout();

	}

}
