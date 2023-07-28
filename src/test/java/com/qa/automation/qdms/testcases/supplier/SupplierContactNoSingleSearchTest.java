//************************************************************************************************
//* Description
//*------------
//* TC-SUP-0029	- Check Contact No "Search" TextBox Functionality (Input)
//* TC-SUP-0030	- Check Contact No"Search" Button Functionality
//* TC-SUP-0031	- Check Contact No "Reset" Button Functionality
//************************************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  13.07.2023
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SUP-0029          13.07.2023    Sasikala     
//* TC-SUP-0030
//* TC-SUP-0031
//************************************************************************************
package com.qa.automation.qdms.testcases.supplier;


import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;


public class SupplierContactNoSingleSearchTest extends DriverIntialization {
	static SupplierPage supplierpg = new SupplierPage();
	
	@Test
	public static void SupplierSearchFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, supplierpg);

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

			PageFactory.initElements(driver, supplierpg);

			SingleSearch.singleSearchMethod(4, SupplierPage.SearchTextBox, "Master Module", "Supplier", "TC-SUP-0030",
					1, 2);

		}

		Logout.LogoutFunction();
	}
	
}