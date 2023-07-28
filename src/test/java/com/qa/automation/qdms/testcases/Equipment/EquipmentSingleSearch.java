//***********************************************************************************
//* Description
//*------------
//* Equipment Single Search
//* This Script includes TC-EQU-0012 , TC-EQU-0013 , TC-EQU-0014 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 07/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-EQU-0020          07/03/2023   Gobithan     Orginal Version
//* TC-EQU-0055          07/03/2023   Gobithan     Orginal Version
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class EquipmentSingleSearch extends DriverIntialization {
	static EquipmentPage equipmentt = new EquipmentPage();

	@Test
	public static void function() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, equipmentt);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0012-01");

			EquipmentSearchFuncation.singleSearchMethoid(EquipmentPage.SearchBoxEquipment, 1,
					PlantEquipmentAddMethods.equipData.get(0), "Equipment Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}

}
