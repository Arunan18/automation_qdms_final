//***********************************************************************************
//* Description
//*------------
//* EQUIPMENT PAGINATION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-EQU-0024            01/03/2023   WATHI     Orginal Version
//*                        12/07/2023   Priyanka  Updated with pagination common method
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EquipmentPaginationTest extends DriverIntialization {

	EquipmentPage equipmentpage = new EquipmentPage();

	@Test
	public void EquipmentPaginationTestcases() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, equipmentpage);

			Paginationmethods.pagination("Master Module", "Equipment", "TC-EQU-0024", EquipmentPage.PreviousPageBtn,
					EquipmentPage.NextPageBtn, EquipmentPage.PaginationSecoundPage, EquipmentPage.DefaultPaginationPage,
					EquipmentPage.PageDropdown, EquipmentPage.bef, 4, EquipmentPage.aft, "EQUIPMENT ");

		}

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}