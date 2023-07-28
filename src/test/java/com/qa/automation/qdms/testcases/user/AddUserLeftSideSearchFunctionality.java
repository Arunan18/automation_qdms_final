/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add User PopUp Left Side Search Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (9) 	  	 	  TC-USER-0103      	  14/03/2023   		 Wathi			Original Version
*				   		 				  25/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddUserLeftSideSearchFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR USER PAGE
	static UserPage up = new UserPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD USER POPUP
		UserPageMethods.addUserNavigation();

		if (UserPageMethods.clickAddUser) {
			UserPageMethods.clickAddUser = false;
			
//			2.CHECKING SEARCH FUNCTIONALITY MAIN METHOD
			searchFunctionality();

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
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR LEFT SIDE SEARCH FUNCTIONALITY
	 ******************************************************************************************************************************************/
	 public static void searchFunctionality() {
		
//		POM INITAILIZATION
		PageFactory.initElements(driver, up);
		
//		CHECKING SEARCH FUNCTION BY COMMON METHOD
		SingleSearch.userSingleSearchMethod(3, UserPage.leftSearch, "Master Module", "User", "TC-USER-0103", 1, 2, 1);	
			
	}
	
}
