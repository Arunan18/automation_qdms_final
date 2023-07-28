//***********************************************************************************
//* Description
//*------------
//*  PlantEquipment -- > Plant Field Search
//*  This Script includes TC-DEL-0018 , TC-DEL-0020, TC-DEL-0022
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 23/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PLA-EQU-0018       23/03/2023   Gobithan     Orginal Version
//* TC-PLA-EQU-0020       23/03/2023   Gobithan     
//* TC-PLA-EQU-0022       23/03/2023   Gobithan  
//* TC-PLA-EQU-0018       17/07/2023   Priyanka     Updated
//* TC-PLA-EQU-0020        
//* TC-PLA-EQU-0022       
//*
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

public class PlantEquipmentPlantSearch extends DriverIntialization {

	static PlantEquipmentPage plantEquipment = new PlantEquipmentPage();

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

			MasterMainNavigationsTest.navigatePlantEquipment();

		}

		if (MasterMainNavigationsTest.plntEquipmentclick) {

			PageFactory.initElements(driver, plantEquipment);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0018-01");

			EquipmentSearchFuncation.singleSearchMethoid(PlantEquipmentPage.SearchBoxPlant, 1,
					PlantEquipmentAddMethods.equipData.get(0), "Plant Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		Logout.LogoutFunction();
	}

}
