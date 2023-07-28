//***********************************************************************************
//* Description
//*------------
//* Delete Supplier Functionality
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        30/03/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.supplier;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteSupplier extends DriverIntialization {

	static SupplierPage SupplierPg = new SupplierPage();

	@Test
	public static void deleteEmployeeFunction() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateSupplierMain();
		}

		if (MasterMainNavigationsTest.clickSuppliermain) {
			MasterMainNavigationsTest.navigateSupplier();
		}

		if (MasterMainNavigationsTest.supplierClick) {

			deleteFunction.clickDelete("Master Module", "Supplier", "TC-SUP-0080", "SUPPLIER");

		}

		Logout.LogoutFunction();
	}

}
