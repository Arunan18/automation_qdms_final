//************************************************************************************************
//* Description
//*------------
//* TC-PLANT-0017 - Check Code "Search" TextBox Functionality (Input)
//* TC-PLANT-0019 - Check Code "Search" Button Functionality 
//* TC-PLANT-0021 - Check "Reset" Button Functionality
//************************************************************************************************
//*
//* Author           :  Priyanka Sundaramoorthy 
//* Date Written     : 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PLANT-0017          13/07/2023   Priyanka     
//* TC-PLANT-0019
//* TC-PLANT-0021
//************************************************************************************

package com.qa.automation.qdms.testcases.plant;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SearchPlantCode extends DriverIntialization {

	PlantPage plant = new PlantPage();

	@Test

	public void searchbuttonexistance() throws InterruptedException, IOException {

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

			SingleSearch.singleSearchMethod(1, PlantPage.SearchTextBox, "Master Module", "Plant", "TC-PLANT-0017", 1,
					2);

		}

		Logout.LogoutFunction();
	}
}
