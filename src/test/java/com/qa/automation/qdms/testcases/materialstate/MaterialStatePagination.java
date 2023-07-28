/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Material State Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (9) 	  	 	  TC-MATSTA-0017      	  24/02/2023       	 Niluxy			Original Version
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialStatePagination extends DriverIntialization {
@Test
	public void matStatePagination() throws InterruptedException, IOException {	
	
//	1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
	MaterialStatePageMethods.materialStatePageNavigation();
	
	if (MasterMainNavigationsTest.clickMaterialState) {
		
		MasterMainNavigationsTest.clickMaterialState = false;
		
//		2.CHECKING PAGINATION MAIN METHOD
		pagination();

	}
	
//	3.REFRESH
	driver.navigate().refresh();
	Thread.sleep(1000);
	
	if (LoginTest.login) {
		
		LoginTest.login = false;
		
//    	4.LOGOUT
		Logout.LogoutFunction();

	}
}

	/*************************************************************************************************************
	 * @category MAIN METHOD FOR PAGINATION
	 *************************************************************************************************************/
   	public static void pagination() {
	
//		CHECK MATERIAL STATE PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Material State", "TC-MATSTA-0017-01", "Checking Material State Pagination Functionality");

   	}

}
