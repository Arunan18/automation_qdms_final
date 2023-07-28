
/***********************************************************************************
* Description
*------------
* MATERIAL MAINCATEGORY MULTI SEARCH FUNCTIONALITY
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 03/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*   TC-MATMC-0054
TC-MATMC-0055                     03/04/2023   VITHUSHA.M    Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.materialmaincategory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialMainCategoryMultisearch extends DriverIntialization {

	static SourcePage sourcepage = new SourcePage();

	static EquipmentPage materialPage = new EquipmentPage();

	@Test
	public static void materialsearch() throws InterruptedException  {
		PageFactory.initElements(driver, materialPage);
	boolean contnew=false;
extent.createTest("TC-MATMC-0055:-MATERIAL MAINCATEGORY MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateMaterialMain();
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.navigateMaterialMainCategory();
					if (MasterMainNavigationsTest.matmaincat) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Material Main Category", "TC-MATMC-0054-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	}
}
