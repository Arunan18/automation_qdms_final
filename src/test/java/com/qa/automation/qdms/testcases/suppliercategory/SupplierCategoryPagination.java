//***********************************************************************************
//* Description
//*------------
//* Pagination Functionality In Supplier Category
//***********************************************************************************
//*
//* Author           : Rahul Sivapalan 
//* Date Written     : 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-SUP-0090                         Rahul       Orginal Version
//*                        12/07/2023   Priyanka    Updated with pagination common method
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.suppliercategory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SupplierCategoryPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SupplierCategoryPagination extends DriverIntialization {

	static SupplierCategoryPage Supplier = new SupplierCategoryPage();

	@Test
	public static void supplierCategory() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, Supplier);

			Paginationmethods.pagination("Master Module", "Supplier Category", "TC-SUPCAT-0016",
					SupplierCategoryPage.PreviousPageBtn, SupplierCategoryPage.NextPageBtn,
					SupplierCategoryPage.PaginationSecoundPage, SupplierCategoryPage.DefaultPaginationPage,
					SupplierCategoryPage.PageDropdown, SupplierCategoryPage.bef, 4, SupplierCategoryPage.aft,
					"SUPPLIER CATEGORY ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
