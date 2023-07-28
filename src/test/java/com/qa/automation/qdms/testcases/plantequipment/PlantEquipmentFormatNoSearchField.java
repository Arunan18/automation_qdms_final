/***********************************************************************************
* Description
*------------
* Check Format No "Search" Button Functionality
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 20/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLA-EQU-0055       20/03/2023   VITHUSHA.M    Orginal Version
* TC-PLA-EQU-0054 
* TC-PLA-EQU-0054      17/07/2023   Priyanka     Updated
* TC-PLA-EQU-0055        
* TC-PLA-EQU-0056       
************************************************************************************/
package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentSearchFuncation;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;


public class PlantEquipmentFormatNoSearchField extends DriverIntialization {

	static EquipmentPage equipmentPage = new EquipmentPage();

	@Test
	public void typeFieldSearch() throws InterruptedException, IOException {

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

			PageFactory.initElements(driver, equipmentPage);

			PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0054-01");

			EquipmentSearchFuncation.singleSearchMethoid(PlantEquipmentPage.SearchBoxFormatNo, 9,
					PlantEquipmentAddMethods.equipData.get(0), "Format No Search Box",
					PlantEquipmentAddMethods.equipData.get(1), PlantEquipmentAddMethods.equipData.get(2));

		}

		//LOGOUT FUNCTION
		Logout.LogoutFunction();

	}
}
