/***********************************************************************************
* Description
*------------
* Customer Multiple Search Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 01/03/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-MAT-0141          01/03/2023     Arunan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.material;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialMultiSearchTest extends DriverIntialization {
	MaterialPage sp = new MaterialPage();
	EquipmentPage mi=new EquipmentPage();

	@Test
	public void materialMultiSearch() throws InterruptedException{
		PageFactory.initElements(driver, mi);

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
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Material", "TC-MAT-0141-01", EquipmentPage.table, 1);
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
