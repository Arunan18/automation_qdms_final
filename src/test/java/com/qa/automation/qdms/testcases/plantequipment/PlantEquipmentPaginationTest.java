
//***********************************************************************************
//* Description
//*------------
//* Plant Equipment Pagination Functionality 
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PLA-EQU-0063       22/02/2023   Priyanka     Orginal Version
//*                        12/07/2023   Priyanka     Updated with pagination Commno Method
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantEquipmentPaginationTest extends DriverIntialization {

	PlantEquipmentPage plantequipmentpage = new PlantEquipmentPage();

	@Test
	public void PlantEquipmentPaginationTestcases() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateEqupmentMain();

		}
		if (MasterMainNavigationsTest.mainEqupment) {

			MasterMainNavigationsTest.navigateEquipment();

		}

		if (MasterMainNavigationsTest.Equipmentclick) {

			PageFactory.initElements(driver, plantequipmentpage);

			Paginationmethods.pagination("Master Module", "Plant Equipment", "TC-PLA-EQU-0063",
					PlantEquipmentPage.PreviousPageBtn, PlantEquipmentPage.NextPageBtn,
					PlantEquipmentPage.PaginationSecoundPage, PlantEquipmentPage.DefaultPaginationPage,
					PlantEquipmentPage.PageDropdown, PlantEquipmentPage.bef, 4, PlantEquipmentPage.aft,
					"PLANT EQUIPMENT ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}
}
