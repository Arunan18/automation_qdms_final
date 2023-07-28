//***********************************************************************************
//* Description
//*------------
//* Delivery Pagination
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-DEL-0027            01/03/2023   Gobithan     Orginal Version
//*                        12/07/2023   Priyanka     Updated with pagination common method
//************************************************************************************

package com.qa.automation.qdms.testcases.delivery;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.DeliveryPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeliveryPagination extends DriverIntialization {
	static DeliveryPage delivery = new DeliveryPage();

	static Logout logout = new Logout();

	@Test
	public static void pagination() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateCustomerMain();
		}

		if (MasterMainNavigationsTest.clickCustomermain) {

			MasterMainNavigationsTest.navigateDelivery();

		}

		if (MasterMainNavigationsTest.clickDelivery) {

			PageFactory.initElements(driver, delivery);

			Paginationmethods.pagination("Master Module", "Delivery", "TC-DEL-0027", DeliveryPage.PreviousPageBtn,
					DeliveryPage.NextPageBtn, DeliveryPage.PaginationSecoundPage, DeliveryPage.DefaultPaginationPage,
					DeliveryPage.PageDropdown, DeliveryPage.bef, 4, DeliveryPage.aft, "DELIVERY");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}
}
