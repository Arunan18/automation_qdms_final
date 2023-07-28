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
//*  TC-PLA-EQU-0039     03/04/2023   kajan     rework Version
//*  TC-PLA-EQU-0045     17/07/2023   Priyanka     Updated
//*  TC-PLA-EQU-0046        
//*  TC-PLA-EQU-0047       
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

public class CheckingPlantEquipmentFieldSearchFunctionalityinFirstPageModel extends DriverIntialization {

	PlantEquipmentPage plantEquipment = new PlantEquipmentPage();

	@Test
	public void SearchFunctionalityinModel() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, plantEquipment);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0045-01");

			EquipmentSearchFuncation.singleSearchMethoid(PlantEquipmentPage.SearchBoxModal, 6,
					PlantEquipmentAddMethods.equipData.get(0), "Model Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();
	}

}
