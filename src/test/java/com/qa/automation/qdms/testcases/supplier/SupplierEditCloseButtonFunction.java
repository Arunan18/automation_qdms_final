/***********************************************************************************
* Description
*------------
*TC-SUPCAT-0045--Check edit Supplier  Close Button Functionality

***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-SUPCAT-0045	     26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.supplier;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class SupplierEditCloseButtonFunction extends DriverIntialization{


	static SupplierPage supplierPg = new SupplierPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, supplierPg);
		testCase = extent.createTest("TC-SUP-0082--Check Delete Supplier Cancel Button Functionality");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateSupplierMain();

		}
		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.clickSuppliermain = false;
			MasterMainNavigationsTest.navigateSupplier();
		}
		if (MasterMainNavigationsTest.supplierClick) {
			MasterMainNavigationsTest.supplierClick = false;
			ActionCommonMethod.actionS(2, 7, SupplierPage.supplierTable, "delete", "Master Module.xlsx", "Supplier",
					"TC-SUP-0082-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(SupplierPage.supplierCancelButton, SupplierPage.popUpModel,
					"CHECKING THE edit Close BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}


	
	
	



}
