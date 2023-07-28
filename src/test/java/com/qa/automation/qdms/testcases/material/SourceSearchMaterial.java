/***********************************************************************************
* Description
*------------
* Source Search and Reset functionality In Material
***********************************************************************************
*
* Author           : Single search
* Date Written     : 06/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* 	TC-MAT-0054	          					          Orginal Version
*	TC-MAT-0055
*	TC-MAT-0056
************************************************************************************/
package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.customer.customerSearchPlant;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class SourceSearchMaterial extends DriverIntialization{
	MaterialPage sp= new MaterialPage();
	@Test
public void materialMultiSearch() throws InterruptedException, IOException {
		PageFactory.initElements(driver, sp);
	boolean contnew=false;

		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateMaterialMain();
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.navigateMaterial();
					
					
					if (MasterMainNavigationsTest.clickMaterial) {
						PlantEquipmentAddMethods.dataFromPlanEqupment("Material", "TC-MAT-0055-01");
						customerSearchPlant.singleSearchIcon(MaterialPage.materialSorceTextBox, 10,
								PlantEquipmentAddMethods.equipData.get(0), "Supplier Category Search Box",
								PlantEquipmentAddMethods.equipData.get(1),
								PlantEquipmentAddMethods.equipData.get(2));
					}
				}
			}
		}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
	
}
}
