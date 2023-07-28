/***********************************************************************************
* Description
*------------
* USER MODEL MULTISEARCH FUNCTIONALITY
***********************************************************************************
*
* Author           : VITHUSHA MOHAN
* Date Written     : 03/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-USER-0078           03/04/2023   VITHUSHA.M    Orginal Version
*TC-USER-0063
************************************************************************************/
package com.qa.automation.qdms.testcases.user;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class UsermultiSearch extends DriverIntialization {


	@Test
	public void user() throws InterruptedException, IOException {




		 EquipmentPage sourcepage = new EquipmentPage();
		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-USER-0078 :- User MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateEmployeeMain();
				if (MasterMainNavigationsTest.clickEmployeeMain) {
					MasterMainNavigationsTest.navigateUser();
					if (MasterMainNavigationsTest.clickUser) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "User", "TC-USER-0078-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
	
	
	
	}

}
