/***********************************************************************************
* Description
*------------
* Check Edit Plant Equipment Functionality (Equipment Edit Functionality)
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 08/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PLA-EQU-0087        08/04/2023   VITHUSHA.M    Orginal Version
*TC-PLA-EQU-0080					   Quenthan		Modified Version(Rework)
************************************************************************************/
package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantEquipmentEdit extends DriverIntialization {
	static PlantEquipmentPage plantEquipmentPage = new PlantEquipmentPage();
	static PlantEquipmentAddMethods addMethods=new PlantEquipmentAddMethods();
	static EquipmentPage equipmentPage = new EquipmentPage();
	@Test
	
	public static void plantedit() throws InterruptedException, IOException {
		PageFactory.initElements(driver, plantEquipmentPage);
		PageFactory.initElements(driver, equipmentPage);
		extent.createTest("TC-PLA-EQU-0087:- Check Edit Plant Equipment Functionality");
		PlantEquipmentAddTest.plantEquipmentNavication();
		
		if (MasterMainNavigationsTest.plntEquipmentclick) {
			MasterMainNavigationsTest.plntEquipmentclick=false;
			PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0087-01");
			SelectDate.click(3, 10, EquipmentPage.table, "edit",PlantEquipmentAddMethods.equipData.get(2));
			
			if (SelectDate.clickDon) {
				PlantEquipmentAddMethods.editplant();
				
			}
		}
		if (PlantEquipmentAddTest.continu) {
			try {
				driver.navigate().refresh();
				Logout.LogoutFunction();
			} catch (Exception e) {
			}
			
		}
	}
}