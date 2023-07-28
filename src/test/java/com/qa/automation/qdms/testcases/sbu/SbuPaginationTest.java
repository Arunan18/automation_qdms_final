//***********************************************************************************
//* Description
//*------------
//* SBU Pagination Functionality
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 13/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-SBU-0022          13/03/2023   Priyanka     Orginal Version
//*                       12/07/2023   Priyanka     Updated with Pagination Common method
//************************************************************************************
package com.qa.automation.qdms.testcases.sbu;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SbuPaginationTest extends DriverIntialization {

	SbuPage sbupage = new SbuPage();

	@Test
	public void SbuPaginationTestcases() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigatePlantMain();

		}
		if (MasterMainNavigationsTest.clickPlantMain) {

			MasterMainNavigationsTest.navigateSbu();

		}

		if (MasterMainNavigationsTest.clickSbu) {

			PageFactory.initElements(driver, sbupage);

			Paginationmethods.pagination("Master Module", "SBU", "TC-SBU-0022", SbuPage.PreviousPageBtn,
					SbuPage.NextPageBtn, SbuPage.PaginationSecoundPage, SbuPage.DefaultPaginationPage,
					SbuPage.PageDropdown, SbuPage.bef, 4, SbuPage.aft, "SBU ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
