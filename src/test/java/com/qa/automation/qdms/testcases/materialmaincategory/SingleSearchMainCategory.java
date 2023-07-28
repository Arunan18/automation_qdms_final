//**********************************************************************************
//* Description
//*------------
//* TC-MATMC-0013	Check Main Category "Search" TextBox Functionality
//* TC-MATMC-0015	Check Main Category "Search" Button Functionality
//* TC-MATMC-0017	Check Main Category "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  13.07.2023 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MATMC-0013        13.07.2023    Sasikala     
//* TC-MATMC-0015
//* TC-MATMC-0017
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

public class SingleSearchMainCategory extends DriverIntialization {
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

			SingleSearch.singleSearchMethod(1, MaterialMainCategoryPage.searchTextbox, "Master Module",
					"Material Main Category", "TC-MATMC-0015", 1, 2);
		}

		Logout.LogoutFunction();
	}

}
