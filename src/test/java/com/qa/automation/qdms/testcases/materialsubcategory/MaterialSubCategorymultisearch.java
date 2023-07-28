
/***********************************************************************************
* Description
*------------
* MATERIALSUB CATEGORY FUNCTIONALITY
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 03/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*   TC-MATSC-0060       03/04/2023   VITHUSHA.M    Orginal Version
*TC-MATSC-0070
************************************************************************************/
package com.qa.automation.qdms.testcases.materialsubcategory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialSubCategorymultisearch extends DriverIntialization {
	static EquipmentPage sourcepage = new EquipmentPage();

	

	@Test
	public void subsearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-MATSC-0060:- MATERIAL SUBCATEGORY MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateMaterialMain();
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.navigateMaterialSubCategory();
					if (MasterMainNavigationsTest.clicksubCategory) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Material Sub Category", "TC-MATSC-0060-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	}
}
