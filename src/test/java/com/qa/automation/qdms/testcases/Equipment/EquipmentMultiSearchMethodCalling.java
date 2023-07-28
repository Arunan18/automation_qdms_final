//***********************************************************************************
//* Description
//*------------
//*MULTI SEARCH MIDDLE PAGE EQUIPMENT
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 06/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   TC-EQU-0064        10/04/2023    RAHUL.S      Original Version
//*TC-EQU-0053
//************************************************************************************
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;


public class EquipmentMultiSearchMethodCalling extends SingleSearchMiddlePage {
	@Test
	public static void multiSearch() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		EquipmentPage singleSearchMiddle = new EquipmentPage();
		PageFactory.initElements(driver, singleSearchMiddle);
	testCase = extent.createTest("TC-EQU-0055:- Checking  Equipment Field Search Functionality");
		
		EquipmentAddValidationTest.naviCationToEqu();
		
		if (MasterMainNavigationsTest.Equipmentclick) {
			
			ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Equipment", "TC-EQU-0064-01", EquipmentPage.table, 1);
		}
		
		if (EquipmentAddValidationTest.continu) {
			EquipmentAddValidationTest.continu=false;
			driver.navigate().refresh();
			MultiSearchMethods.Logout();
			
		}
		
		
	}
}
