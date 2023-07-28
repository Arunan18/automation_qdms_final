//***********************************************************************************
//* Description
//*------------
//* Plant Pagination
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        01/03/2023  RAHUL.S     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.plant;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantPagination extends DriverIntialization {

	static PlantPage plant = new PlantPage();

	@Test
	public void PlantPaginationTestcases() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigatePlantMain();

		}
		if (MasterMainNavigationsTest.clickPlantMain) {

			MasterMainNavigationsTest.navigatePlant();

		}

		if (MasterMainNavigationsTest.Plantclick) {

			PageFactory.initElements(driver, plant);

			Paginationmethods.pagination("Master Module", "Plant", "TC-PLANT-0048", PlantPage.PreviousPageBtn,
					PlantPage.NextPageBtn, PlantPage.PaginationSecoundPage, PlantPage.DefaultPaginationPage,
					PlantPage.PageDropdown, PlantPage.bef, 4, PlantPage.aft, "PLANT ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}
}
