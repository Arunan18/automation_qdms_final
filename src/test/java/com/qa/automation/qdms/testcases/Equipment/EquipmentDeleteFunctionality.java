//***********************************************************************************
//* Description
//*------------
//* DELETE DEPENDED EQUIPMENT
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-EQU-0051             01/03/2023   WATHI     Orginal Version
//*                        11/7/2023    Quenthan     modifi
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class EquipmentDeleteFunctionality extends EquipmentMainTests {

	@Test
	public void deleteEquipmentAfterDepend() throws IOException, InterruptedException {

		PageFactory.initElements(driver, equipment);

		testCase = extent.createTest(
				"TESTCASE-TC-EQU-0051 :-Should not be able to delete Equipment after depended (Plant Equipment, Equipment Calibration)");

		EquipmentAddValidationTest.naviCationToEqu();

		if (MasterMainNavigationsTest.Equipmentclick) {
			// STEP 1-CHECK THE NUMBR OF DATA BEFORE DELETE
			EquipmentMainTests.elementNumberBoeforeSearch();

			// STEP 2- CALL THE EXCEL
			EquipmentMainTests.exceldatadepending();

			// STEP 3- CLICK ON DELETE ICON
			EquipmentMainTests.deleteElementdepending();

			// STEP 4- CHECK THE CANNOT BE DELETED POPUP MESSAGE
			EquipmentMainTests.cannotDeleteValidation();

		}
		if (EquipmentAddValidationTest.continu) {
			EquipmentAddValidationTest.continu = false;
			MultiSearchMethods.Logout();

		}

	}
}