//***********************************************************************************
//* Description
//*------------
//* PLANT ADD FUNCTIONALITY
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 08/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-PLANT-0061          08/03/2023   RAHUL.S    Original Version
//*                        05/07/2023   RAHUL.S    updated
//************************************************************************************
package com.qa.automation.qdms.testcases.plant;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class AddPlantMethodCalling extends AddPlant {
	static boolean per = false;

	@Test
	public static void methodCalling() throws InterruptedException, IOException {
		PlantPage addPlant = new PlantPage();
		PageFactory.initElements(driver, addPlant);

		testCase = extent.createTest("TC-PLANT-0061 -- ADD PLANT FUNCTIONALITY");
		// LOGIN

		LoginTest.Login();

		// CLICK THE MASTER CARD
		MasterTest.MasterCard();
//****************************************************************************************
//		STEP-01--PLANT TAB IS DISPLAYED   &	STEP-02--PLANT TAB IS ENABLED  
//****************************************************************************************			
		try {
			buttonClick(PlantPage.plantTab, "STEP-01--PLANT TAB IS DISPLAYED", "STEP-02--PLANT TAB IS ENABLED",
					"PLANT TAB");

			// *******************************************************************************
			// STEP-03--ADD PLANT BUTTON IS DISPLAYED & STEP-04--ADD PLANT BUTTON IS ENABLED
			// *******************************************************************************
			AddPlant.buttonClick(PlantPage.clickplant, "STEP-03--PLANT SIDE BUTTON IS DISPLAYED",
					"STEP-04--PLANT SIDE BUTTON IS ENABLED", "PLANT SIDE BUTTON");

//*******************************************************************************		
//STEP-05--ADD PLANT BUTTON IS DISPLAYED  &	 STEP-06--ADD PLANT BUTTON IS ENABLED
//*******************************************************************************
			buttonClick(PlantPage.addPlantButton, "STEP-05--ADD BUTTON IS DISPLAYED", "STEP-06--ADD BUTTON IS ENABLED",
					"ADD PLANT");

			excelcall();

// ****************************************************************************************
// STEP-21--SAVE BUTTON IS DISPLAYED AND STEP-22--SAVE BUTTON IS ENABLED
// ****************************************************************************************		
			buttonClick(PlantPage.saveButton, "STEP-21--SAVE BUTTON IS DISPLAYED", "STEP-22--SAVE BUTTON IS ENABLED",
					"SAVE BUTTON");
			Thread.sleep(2000);

			if (PlantPage.saveButton.isDisplayed()) {
				errorMessage();
				per = true;

			}

//**********************************************************************************************************************	
//STEP-08-- CONFIRM THE ADDED WILL BE IN THE FIRST ROW 
//**********************************************************************************************************************		
			if (per == false) {
				confirmAdd();
				if (per == true) {
					tableConfirm();
				}
			}

			driver.navigate().refresh();
			// LOGOUT
			Logout.LogoutFunction();

		} catch (Exception e) {
			driver.navigate().refresh();
			// LOGOUT
			Logout.LogoutFunction();

		}

	}
}
