/***********************************************************************************
* Description
*------------
* Description Close Icon Functionality
***********************************************************************************
*
* Author           : Arunan
* Date Written     : 26/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-SBU-0021 	         26/07/2023   Arunan     Original Version
//************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class SbuDescriptionCloseIconFunction extends DriverIntialization {

	@Test
	public static void editCancel() {
		SbuMethods.navigateSbu("TC-SBU-0021 - SBU Description Close Icon Functionality");

		if (MasterMainNavigationsTest.clickSbu) {
			ActionCommonMethod.actionS(0, 1, SbuPage.sbuTable, "Description", "Master Module.xlsx", "SBU",
					"TC-SBU-0021-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(SbuPage.descCloseIcon, SbuPage.editpopup,
					"CHECKING THE DESCRIPTION CLOSE BUTTON", "CHECKING THE POPUP");
		}
		SbuMethods.logout();
	}
}
