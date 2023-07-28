/***********************************************************************************
* Description
*------------
* PLANTEQUIPMENT MODEL MULTISEARCH METHODS
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 03/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-PLA-EQU-0096        03/04/2023   VITHUSHA.M    Orginal Version
*  TC-PLA-EQU-0112
************************************************************************************/
package com.qa.automation.qdms.testcases.plantequipment;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantEquipmentMultipleSearc extends DriverIntialization {
	@Test
	public static void plantequMultiSearch() {
		EquipmentPage nj=new EquipmentPage();
		PageFactory.initElements(driver, nj);
		extent.createTest("TC-PLA-EQU-0096:- Check Multi Search Functionality");
		PlantEquipmentAddTest.plantEquipmentNavication();
		if (MasterMainNavigationsTest.plntEquipmentclick) {
			ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Plant Equipment", "TC-PLA-EQU-0096-01", EquipmentPage.table, 1);
			
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
