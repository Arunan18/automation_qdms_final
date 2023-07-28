/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Role Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	  TC-ROL-0014      	  	  09/04/2023       	 Saranka			Original Version
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.role;

import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.designation.DesignationPageMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class RolePagination extends DriverIntialization {
	
	@Test
	public static void rolePagination() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();

		if (MasterMainNavigationsTest.clickDesignation) {
			MasterMainNavigationsTest.clickDesignation = false;
			
//			2.CLICK ROLE SUB MODULE
			MasterMainNavigationsTest.navigateRole();
			if (MasterMainNavigationsTest.clickRole) {		
				MasterMainNavigationsTest.clickRole = false;
				
//				3.CHECKING PAGINATION MAIN METHOD
				pagination();
				
			}
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
		
//		CHECK ROLE PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Role", "TC-ROL-0014-01", 
				"Checking Role Pagination Functionality");
	
	}
	
}
