
//****************************************************************************************
//		DESCRIPTION
//------------------
//					SOURCE RESET ALL TEST
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   09:03:2023	
//****************************************************************************************
//* Test Case Number        Date         Intis        Comments
//* =================      ======      ========       ========
//* TC-SRC-0055			  09:03:2023   @SASIKALA     Original Version
//*	TC-SRC-0056					  06:07:2023   @Sasikala     Modified
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SourceMultiSearchResetAllFunction extends DriverIntialization {
static	EquipmentPage sourcepage = new EquipmentPage();
@Test 
	public static void multiSearch() throws InterruptedException {


		PageFactory.initElements(driver, sourcepage);
	boolean contnew=false;
	extent.createTest("TC-SRC-0056:- Source MULTI SEARCH FUNCTIONALITY,RESET ALL");
		LoginTest.Login();  
		contnew=true;
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				MasterMainNavigationsTest.navigateMaterialMain();
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.navigateSource();
					if (MasterMainNavigationsTest.clickSource) {
						
						ProcessSampleMultiSearch.multiSearch("Master Module.xlsx", "Source", "TC-SRC-0055-01", EquipmentPage.table, 1);
						
					}
					
				}}}
		if (contnew) {	
			driver.navigate().refresh();
			Logout.LogoutFunction();
		}
		
	
	
		
	}
	
	
}
