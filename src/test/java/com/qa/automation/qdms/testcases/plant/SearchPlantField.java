//***********************************************************************************
//* Description
//*------------
//* TC-PLANT-0023 Check Plant "Search" TextBox Functionality (Input)
//* TC-PLANT-0024 Check Plant "Search" Button Functionality
//* TC-PLANT-0025 Check Code "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 14/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        14/03/2023   Gobithan     Orginal Version
//*           			   17/03/2023   Gobithan	 Edited 
//* TC-PLANT-0023          13/07/2023   Priyanka     Updated
//* TC-PLANT-0024          13/07/2023   Priyanka     Updated
//* TC-PLANT-0025          13/07/2023   Priyanka     Updated
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

public class SearchPlantField extends DriverIntialization {

	static PlantPage plantpage = new PlantPage();

	@Test
	public static void function() throws InterruptedException, IOException {
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

			PageFactory.initElements(driver, plantpage);

			SingleSearch.singleSearchMethod(2, PlantPage.plantsearchbox, "Master Module", "Plant", "TC-PLANT-0023", 1,
					2);

		}

		Logout.LogoutFunction();
	}

}
