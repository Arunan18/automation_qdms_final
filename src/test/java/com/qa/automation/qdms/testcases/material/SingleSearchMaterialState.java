//**********************************************************************************
//* Description
//*------------
//* TC-MAT-0042 - Check Material State  "Search" TextBox Functionality
//* TC-MAT-0043	- Check Material State  "Search" Button Functionality
//* TC-MAT-0044	- Check Material State "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  14.07.2023 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MAT-0042           14.07.2023    Sasikala     
//* TC-MAT-0043
//* TC-MAT-0044
//************************************************************************************

package com.qa.automation.qdms.testcases.material;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SingleSearchMaterialState extends DriverIntialization {

	static MaterialPage MaterialPg = new MaterialPage();

	@Test
	public static void MaterialStateSearch() throws InterruptedException {
		PageFactory.initElements(driver, MaterialPg);

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateMaterialMain();
		}
		if (MasterMainNavigationsTest.clickMaterialMain) {

			MasterMainNavigationsTest.navigateMaterial();
		}

		if (MasterMainNavigationsTest.clickMaterial) {

			PageFactory.initElements(driver, MaterialPg);

			SingleSearch.singleSearchMethod(6, MaterialPage.MaterialStateTextbox, "Master Module", "Material",
					"TC-MAT-0043", 1, 2);
		}

		Logout.LogoutFunction();
	}
}