/***********************************************************************************
* Description
*------------
* CHEK EDIT EQUIPMENT FORM VALIDATION
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 22/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-EQU-0042            07/04/2023  VITHUSHA.M    Orginal Version
*										   
************************************************************************************/
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class EquipmentEditValidation extends DriverIntialization {
	
	static EquipmentPage equipment = new EquipmentPage();
	

	@Test
	public static void validationtestEquipments() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, equipment);

		testCase = extent.createTest("TC-EQU-0042:- Check Edit  Equipment  Form Validation");
		
		EquipmentAddValidationTest.naviCationToEqu();
		
		if (MasterMainNavigationsTest.Equipmentclick) {
		/****************************************************************************************
		 * EDIT  EQUIPMENT TYPE AFTER EQUIPMENT DEPENDED
		 ****************************************************************************************/
			
		EquipmentEditPageWise.ValidationEquipment();
		}
		if (EquipmentAddValidationTest.continu) {
			EquipmentAddValidationTest.continu=false;
			driver.navigate().refresh();
			MultiSearchMethods.Logout();
			
		}
	}
}
