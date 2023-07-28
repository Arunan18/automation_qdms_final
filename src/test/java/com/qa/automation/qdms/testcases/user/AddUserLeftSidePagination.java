/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add User PopUp Left Side Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (7) 	  	 	  TC-USER-0076      	  17/03/2023        Priyanka		Original Version
*				   		 				  17/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;

import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddUserLeftSidePagination extends DriverIntialization {
	
	@Test
	public static void leftPagination() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO ADD USER POPUP
		UserPageMethods.addUserNavigation();

		if (UserPageMethods.clickAddUser) {
			UserPageMethods.clickAddUser = false;
			
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
		
//		CHECK ADD USER LEFT SIDE PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationWithoutPageSelection("Master Module", "User", "TC-USER-0076-01", 
				"Checking Add User PopUp Left Side Pagination Functionality");
	
	
	}
	
}
