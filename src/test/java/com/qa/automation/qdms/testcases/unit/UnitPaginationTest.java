//***********************************************************************************
//* Description
//*------------
//* Unit Pagination Functionality 
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-UNIT-0014           22/02/2023   Priyanka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.unit;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.UnitPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class UnitPaginationTest extends com.qa.automation.qdms.base.DriverIntialization {

	UnitPage unitpage = new UnitPage();

	@Test
	public void UnitPaginationTestcases() throws InterruptedException, IOException {

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

			Paginationmethods.pagination("Master Module", "Unit", "TC-UNIT-0014", UnitPage.PreviousPageBtn,
					UnitPage.NextPageBtn, UnitPage.PaginationSecoundPage, UnitPage.DefaultPaginationPage,
					UnitPage.PageDropdown, UnitPage.bef, 4, UnitPage.aft, "UNIT");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
