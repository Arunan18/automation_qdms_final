//***********************************************************************************
//* Description
//*------------
//* Plane Equipment Single Search
//***********************************************************************************
//*
//* Author           : yogalingam kajenthiran
//* Date Written     : 14/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PLA-EQU-0035     14/03/2023     kajan     Original Version
//*						 03/04/2023		kajan	   rework Version
//* TC-PLA-EQU-0024       17/07/2023   Priyanka     Updated
//* TC-PLA-EQU-0025        
//* TC-PLA-EQU-0026       
//************************************************************************************

package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentSearchFuncation;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class CheckingPlantEquipmentFieldSearchFunctionalityinFirstPageEquipment extends DriverIntialization {

	PlantEquipmentPage plantequipment = new PlantEquipmentPage();

	@Test
	public void plantEquipmentSingleSearch() throws InterruptedException, IOException {
		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}

		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateEqupmentMain();

		}

		if (MasterMainNavigationsTest.mainEqupment) {

			MasterMainNavigationsTest.navigatePlantEquipment();

		}

		if (MasterMainNavigationsTest.plntEquipmentclick) {

			PageFactory.initElements(driver, plantequipment);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0024-01");

			EquipmentSearchFuncation.singleSearchMethoid(PlantEquipmentPage.SearchBoxEquipment, 2,
					PlantEquipmentAddMethods.equipData.get(0), "Equipment Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();

	}

}
