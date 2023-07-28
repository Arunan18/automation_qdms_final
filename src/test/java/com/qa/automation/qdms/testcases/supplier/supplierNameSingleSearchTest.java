//************************************************************************************************
//* Description
//*------------
//* TC-SUP-0015	- Check Supplier "Search" TextBox Functionality (Input)
//* TC-SUP-0017	- Check Supplier "Search" Button Functionality 
//* TC-SUP-0019	- Check Supplier "Reset" Button Functionality
//************************************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  13.07.2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SUP-0015          13.07.2023   Sasikala     
//* TC-SUP-0017
//* TC-SUP-0019
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

public class supplierNameSingleSearchTest extends DriverIntialization {
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
		if(MasterMainNavigationsTest.clickSuppliermain) {
			
			MasterMainNavigationsTest.navigateSupplier();
		}
			
		if (MasterMainNavigationsTest.supplierClick) {

			PageFactory.initElements(driver, supplierpg);

			SingleSearch.singleSearchMethod(1, SupplierPage.SearchTextBox, "Master Module", "Supplier",
					"TC-SUP-0017", 1, 2);
			
		}

		Logout.LogoutFunction();
	}
}
	
	

	