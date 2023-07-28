/***********************************************************************************
* Description
*------------
* ADD VALIDATION FOR PLANT
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 07/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLANT-0062          10/04/2023   RAHUL.S     MODIFIED
*                        17/04/2023   RAHUL.S     MODIFIED
************************************************************************************/
package com.qa.automation.qdms.testcases.plant;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class PlantAddValidationMethodCalling extends AddValidationPlant {

	static boolean per = false;

	@Test
	public static void methodCalling() throws InterruptedException, IOException {
		PlantPage addPlant = new PlantPage();
		PageFactory.initElements(driver, addPlant);

		testCase = extent.createTest("TC-PLANT-0062 -- ADD PLANT VALIDATION FUNCTIONALITY");
		// LOGIN
		try {
			LoginTest.Login();

			// CLICK THE MASTER CARD
			MasterTest.MasterCard();
			// ****************************************************************************************
			// STEP-01--PLANT TAB IS DISPLAYED & STEP-02--PLANT TAB IS ENABLED
			// ****************************************************************************************

			buttonClick(PlantPage.plantTab, "PLANT TAB IS DISPLAYED", "PLANT TAB IS ENABLED", "PLANT TAB");

			// *******************************************************************************
			// STEP-03--ADD PLANT BUTTON IS DISPLAYED & STEP-04--ADD PLANT BUTTON IS ENABLED
			// *******************************************************************************
			AddPlant.buttonClick(PlantPage.clickplant, "PLANT SIDE BUTTON IS DISPLAYED", "PLANT SIDE BUTTON IS ENABLED",
					"PLANT SIDE BUTTON");

			// *******************************************************************************
			// STEP-05--ADD PLANT BUTTON IS DISPLAYED & STEP-06--ADD PLANT BUTTON IS ENABLED
			// *******************************************************************************
			buttonClick(PlantPage.addPlantButton, "ADD BUTTON IS DISPLAYED", "ADD BUTTON IS ENABLED", "ADD PLANT");

			excelcall();

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
