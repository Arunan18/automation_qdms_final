
//**********************************************************************************
//* Description
//*------------
//* TC-SUPCAT-0011	Check Supplier Category "Search" TextBox Functionality
//* TC-SUPCAT-0013	Check Supplier Category "Search" Button Functionality
//* TC-SUPCAT-0015	Check "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  13.07.2023 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SUPCAT-0011        13.07.2023    Sasikala     
//* TC-SUPCAT-0013
//* TC-SUPCAT-0015
//************************************************************************************


package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SupplierCategorySearchFunctionality extends DriverIntialization {
static SupplierCategoryPage suppliercategorypg = new SupplierCategoryPage();
	
	@Test
	public static void SupplierSearchFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, suppliercategorypg);

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

			PageFactory.initElements(driver, suppliercategorypg);

			SingleSearch.singleSearchMethod(1, SupplierCategoryPage.searchbox, "Master Module", "Supplier Category", "TC-SUPCAT-0013",
					1, 2);

		}

		Logout.LogoutFunction();
	}

}
	
