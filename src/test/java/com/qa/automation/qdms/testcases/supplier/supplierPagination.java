//***********************************************************************************
//* Description
//*------------
//* Pagination Functionality In Supplier
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SUP-0090            30/03/2023   Sayan       Orginal Version
//*                        12/07/2023   Priyanka    Updated with pagination common method
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.supplier;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class supplierPagination extends DriverIntialization {

	SupplierPage SupplierPg = new SupplierPage();

	@Test(priority = 0)
	public void supplierPaginationFunction() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, SupplierPg);

			Paginationmethods.pagination("Master Module", "Supplier", "TC-SUP-0090", SupplierPage.PreviousPageBtn,
					SupplierPage.NextPageBtn, SupplierPage.PaginationSecoundPage, SupplierPage.DefaultPaginationPage,
					SupplierPage.PageDropdown, SupplierPage.bef, 4, SupplierPage.aft, "SUPPLIER ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();
	}

}
