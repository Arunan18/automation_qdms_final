/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Designation Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (9) 	  	 	  TC-DES-0019      	  	  13/03/2023       	 Volta			Original Version
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class DesignationPagination extends DriverIntialization {
	
	@Test
	public static void desiPagination() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();

		if (MasterMainNavigationsTest.clickDesignation) {
			MasterMainNavigationsTest.clickDesignation = false;
			
//			2.CHECKING PAGINATION MAIN METHOD
			pagination();
			
		}
				
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	     	4.LOGOUT
			Logout.LogoutFunction();
	
		}
		
	}

	/*************************************************************************************************************
	 * @category MAIN METHOD FOR PAGINATION
	 *************************************************************************************************************/
	public static void pagination() {
		
//		CHECK DESIGNATION PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Designation", "TC-DES-0019-01", 
				"Checking Material State Pagination Functionality");
	
	}
	
}
