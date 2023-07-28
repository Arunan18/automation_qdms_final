//***********************************************************************************
//* Description
//*------------
//* TC-PLANT-0031 Check Plant Manager "Search" TextBox Functionality(Input)
//* TC-PLANT-0032 Check Plant Manager "Search" Button Functionality
//* TC-PLANT-0033 Check Plant Manager "Reset" Button Functionality
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
//* Manager Reset          17/03/2023   Gobithan     Edit
//* TC-PLANT-0031          13/07/2023   Priyanka     Updated
//* TC-PLANT-0032          13/07/2023   Priyanka     Updated
//* TC-PLANT-0033          13/07/2023   Priyanka     Updated
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

public class SearchPlantManager extends DriverIntialization {

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

			SingleSearch.singleSearchMethod(4, PlantPage.SearchTextBox, "Master Module", "Plant", "TC-PLANT-0031", 1,
					2);

		}

		Logout.LogoutFunction();
	}

}
