//**********************************************************************************
//* Description
//*------------
//* TC-UNIT-0009	Check Unit "Search" TextBox Functionality (Input)
//* TC-UNIT-0011	Check Unit "Search" Button Functionality
//* TC-UNIT-0013	Check Unit "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  14.07.2023 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-UNIT-0009         14.07.2023    Sasikala     
//* TC-UNIT-0011
//* TC-UNIT-0013
//************************************************************************************


package com.qa.automation.qdms.testcases.unit;


import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.UnitPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class UnitFirstSingleSearch extends DriverIntialization {
	static UnitPage unitpage = new UnitPage();
	
	@Test
	public static void SupplierSearchFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, unitpage);

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateMaterialMain();
		}
		if (MasterMainNavigationsTest.clickMaterialMain) {

			MasterMainNavigationsTest.navigateUnit();
		}

		if (MasterMainNavigationsTest.clickUnit) {

			PageFactory.initElements(driver, unitpage);

			SingleSearch.singleSearchMethod(1, UnitPage.SearchBox, "Master Module", "Unit", "TC-UNIT-0011",
					1, 2);

		}

		Logout.LogoutFunction();
	}

}
	