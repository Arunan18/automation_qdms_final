/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking User Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	  TC-USER-0057      	  01/03/2023       	 Wathi			Original Version/
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;  

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;



public class UserPagination extends DriverIntialization{
	
	@Test
	public static void userPagination() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO USER PAGE
		UserPageMethods.userPageNavigation();

		if (MasterMainNavigationsTest.clickUser) {
			MasterMainNavigationsTest.clickUser = false;
				
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
		
//		CHECK USER PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "User", "TC-USER-0057-01", 
				"Checking User Pagination Functionality");
	
	}
	
}
