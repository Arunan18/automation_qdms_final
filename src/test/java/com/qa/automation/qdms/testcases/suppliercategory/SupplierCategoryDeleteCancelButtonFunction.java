/***********************************************************************************
* Description
*------------
*TC-SUPCAT-0045--Check Delete Supplier Category Cancel Button Functionality

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
package com.qa.automation.qdms.testcases.suppliercategory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class SupplierCategoryDeleteCancelButtonFunction extends DriverIntialization {
	static SupplierCategoryPage supplierCatPg = new SupplierCategoryPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, supplierCatPg);
		testCase = extent.createTest("TC-SUPCAT-0045--Check Delete Supplier Category Cancel Button Functionality");
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
			MasterMainNavigationsTest.navigateSupplierCategory();
		}
		if (MasterMainNavigationsTest.mainSupplierCategory) {
			MasterMainNavigationsTest.mainSupplierCategory = false;
			ActionCommonMethod.actionS(0, 2, SupplierCategoryPage.supplierCatTable, "delete", "Master Module.xlsx", "Supplier Category",
					"TC-SUPCAT-0045-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(SupplierCategoryPage.deleteCancelButton, SupplierCategoryPage.deletePopUP,
					"CHECKING THE DELETE CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}
}
