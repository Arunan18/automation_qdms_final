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
* TC-CUS-0090          01/03/2023     Arunan     Orginal Version
*TC-CUS-0092
************************************************************************************/
package com.qa.automation.qdms.testcases.customer;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class CustomerMultiSearchTest extends DriverIntialization {
	

	@Test
	public void customerMultiSearch() throws InterruptedException, IOException {

		 EquipmentPage sourcepage = new EquipmentPage();
		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-CUS-0090 :- Customer MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateCustomerMain();
				if (MasterMainNavigationsTest.clickCustomermain) {
					MasterMainNavigationsTest.navigateCustomer();
					if (MasterMainNavigationsTest.clickCustomer) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Customer", "TC-CUS-0090-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
	}
}
