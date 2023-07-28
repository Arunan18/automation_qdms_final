/***********************************************************************************
* Description
*------------
* EQUIPMENT EDIT FUNCTIONALITY
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 06/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-EQU-0041            06/04/2023   VITHUSHA.M    Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class EquipmentEditFirstPage extends DriverIntialization {

	static EquipmentPage equipment = new EquipmentPage();

	@Test
	public void equipmentedit() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, equipment);

		testCase = extent.createTest("TC-EQU-0041:- equipment edit in the last page");
		
		EquipmentAddValidationTest.naviCationToEqu();
		
		if (MasterMainNavigationsTest.Equipmentclick) {
		/****************************************************************************************
		 * EDIT  EQUIPMENT TYPE AFTER EQUIPMENT DEPENDED
		 ****************************************************************************************/
		PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0041-01");
		String equipment=null;
		try {
			equipment = PlantEquipmentAddMethods.equipData.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		SelectDate.click(0, 3, EquipmentPage.table, "edit",equipment);		

		if (SelectDate.clickDon) {
			EquipmentEditPageWise.editdata();
		}
		
		}
		if (EquipmentAddValidationTest.continu) {
			EquipmentAddValidationTest.continu=false;
			driver.navigate().refresh();
			MultiSearchMethods.Logout();
			
		}
	}
}
