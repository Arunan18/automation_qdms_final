/***********************************************************************************
* Description
*------------
* EDIT VALIDATION CHECKING IN PLANT
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 08/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLANT-0071          08/03/2023   RAHUL.S    Original Version
*                        18/04/2023   RAHUL.S    MODIFIED
*                        20/07/2023   RAHUL.S    UPDATED
************************************************************************************/
package com.qa.automation.qdms.testcases.plant;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class EditValidationMethodCalling extends EditValidation {
	@Test
	public static void editValidation() throws InterruptedException, IOException {

		// ********************************************************************************************************
		// THIS METHOD IS FOR LOGIN AND CLICKING THE MASTER AND GO TO PLANT
		// ********************************************************************************************************
		PlantPage editValidationplantpg = new PlantPage();
		PageFactory.initElements(driver, editValidationplantpg);
		// LOGIN
		LoginTest.Login();

		// CLICK THE MASTER CARD
		MasterTest.MasterCard();
		Thread.sleep(2000);
		// CLICK PLANT TAB
		MasterMainNavigationsTest.navigatePlantMain();
		Thread.sleep(2000);
		// CLICK PLANT NAVIGATION
		MasterMainNavigationsTest.navigatePlant();
		Thread.sleep(2000);
		// DATA GETTING FROM EXCEL TO PICK THE DATA
		dataPick();
		Thread.sleep(2000);
		// CHECK THE INTERMEDIATE POINT
		beforeEdit();
		Thread.sleep(2000);
		// EDIT VALIDATION IN PLANT NAME
		editValidationForPlant();
		Thread.sleep(2000);
		try {
			if (PlantPage.cancelButton.isDisplayed()) {
				PlantPage.cancelButton.click();
			}
		} catch (Exception e) {

		}
		// LOGOUT
		Logout.LogoutFunction();

	}
}
