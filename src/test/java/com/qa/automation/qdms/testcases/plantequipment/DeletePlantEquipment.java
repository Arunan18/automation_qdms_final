//***********************************************************************************
//* Description
//*------------
//* Delete Plant Equipment 
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 09/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        09/03/2023   Gobithan     Orginal Version
//* TC-PLA-EQU-0093        26/07/2023   Priyanka     Updated
//***********************************************************************************

package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeletePlantEquipment extends DriverIntialization {

	@Test
	public void deletePlantEquipment() throws InterruptedException, IOException {

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

			deleteFunction.clickDelete("Master Module", "Plant Equipment", "TC-PLA-EQU-0093", "PLANT EQUIPMENT");

		}

		Logout.LogoutFunction();

	}

}
