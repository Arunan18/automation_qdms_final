//***********************************************************************************
//* Description
//*------------
//* EQUIPMENT VALIDATION MESSAGES
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-EQU-0034             01/03/2023   WATHI     Orginal Version
//*						   06/07/2023  Qunethan   Modified
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.master.MasterTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class EquipmentAddValidationTest extends EquipmentMainTests {
public static	boolean	continu=false;
	

	@Test
	public static void validationtestEquipments () throws IOException, InterruptedException {
		
	PageFactory.initElements(driver, equipment);

	testCase = extent.createTest("TESTCASE- TC-EQU-0034");

	EquipmentAddValidationTest.naviCationToEqu();
	
	if (MasterMainNavigationsTest.Equipmentclick) {
		//STEP 2-CHECK THE PROPERTIES OF "ADD EQUIPMENT" BUTTON
		EquipmentMainTests.addequipmentbutton();
		//STEP 3-CHECK THE VALIDATION MESSAGES
		EquipmentMainTests.ValidationEquipment();
	}
	if (continu) {
		EquipmentAddValidationTest.continu=false;
		MultiSearchMethods.Logout();
		
	}

}
	public static void naviCationToEqu(){
		try {
			LoginTest.Login();
			LoginTest.login = true;
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Login", true, false, "Login");
		}
		if (LoginTest.login) {
			LoginTest.login=false;
			MasterMainNavigationsTest.navigateMaster();
			EquipmentAddValidationTest.continu=true;
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.clickMaster=false;
				MasterMainNavigationsTest.navigateEqupmentMain();
				if (MasterMainNavigationsTest. mainEqupment) {
					MasterMainNavigationsTest. mainEqupment=false;
					MasterMainNavigationsTest.navigateEquipment();
				}
				
			}
		}
		
	}

}
