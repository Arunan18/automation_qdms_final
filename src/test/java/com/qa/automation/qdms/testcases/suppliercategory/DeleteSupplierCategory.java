/***********************************************************************************
* Description
*------------
* DELETE IN SUPPLIER CATEGORY 
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 09/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-SUPCAT-0041      09/03/2023   RAHUL.S    Original Version
*                     12/04/2023   RAHUL.S    MODIFIED
************************************************************************************/
package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteSupplierCategory extends DriverIntialization {

	@Test

	public static void supplierCategory() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}
		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateSupplierMain();

		}

		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.navigateSupplierCategory();
		}

		if (MasterMainNavigationsTest.mainSupplierCategory) {

			deleteFunction.clickDelete("Master Module", "Supplier Category", "TC-SUPCAT-0041", "SUPPLIER CATEGORY");

		}

		Logout.LogoutFunction();
	}
}
