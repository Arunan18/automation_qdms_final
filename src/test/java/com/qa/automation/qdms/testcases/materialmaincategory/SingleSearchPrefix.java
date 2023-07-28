//**********************************************************************************
//* Description
//*------------
//* TC-MATMC-0019 - Check Prefix  "Search" TextBox Functionality
//* TC-MATMC-0020 -	Check Prefix "Search" Button Functionality
//* TC-MATMC-0021 -	Check Prefix "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  14.07.2023 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MATMC-0019        14.07.2023    Sasikala     
//* TC-MATMC-0020
//* TC-MATMC-0021
//************************************************************************************

package com.qa.automation.qdms.testcases.materialmaincategory;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;


public class SingleSearchPrefix extends DriverIntialization {
	
	static MaterialMainCategoryPage MMCategorypg = new MaterialMainCategoryPage();

	@Test
	public static void SupplierSearchFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, MMCategorypg);

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateMaterialMain();
		}
		if (MasterMainNavigationsTest.clickMaterialMain) {

			MasterMainNavigationsTest.navigateMaterialMainCategory();
		}

		if (MasterMainNavigationsTest.matmaincat) {

			PageFactory.initElements(driver, MMCategorypg);

			SingleSearch.singleSearchMethod(2, MaterialMainCategoryPage.prefixsearchtextbox, "Master Module",
					"Material Main Category", "TC-MATMC-0020", 1, 2);
		}

		Logout.LogoutFunction();
	}
}