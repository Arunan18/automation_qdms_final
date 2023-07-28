/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add User PopUp Right Side Search Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (10) 	   	  TC-USER-0104      	  14/03/2023         Wathi			Original Version
*				   		 				  25/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddUserRightSideSearchFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR USER PAGE
	static UserPage up = new UserPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD USER POPUP
		UserPageMethods.addUserNavigation();

		if (UserPageMethods.clickAddUser) {
			UserPageMethods.clickAddUser = false;
			
//			2.CHECKING SEARCH FUNCTIONALITY MAIN METHOD
			rightSideSearchFunctionality();

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
	 * @category MAIN METHOD FOR RIGHT SIDE SEARCH FUNCTIONALITY
	 * @throws InterruptedException
	 *************************************************************************************************************/	
	public static void rightSideSearchFunctionality() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		POM INITIALIZATION
		PageFactory.initElements(driver,up);
		
//		SELECT EMPLOYEE(CLICK EMPLOYEE CHECKBOX)
		functionality.clicking(UserPage.addUserPopUpLeftSideUserSelectBox, "Check Box");
		
//		CLICK ALLOCATION ARROW BUTTON
		if (functionality.Clicking) {
			functionality.Clicking = false;
			
			functionality.FunctionCheckWithClick("Clicking Allocation Arrow Button with Checking Function",
					UserPage.addUserPopEmployeeAllocationArrowButtonForRight, "Arrow Button");
			
			if (functionality.Clicking) {
				functionality.Clicking = false;
				
//				CALL SEARCH FUNCTION METHOD
				searchFunctionality();
				
			}
			
		}
		
	}
	
	/*******************************************************************************************************************************************
	 * @category METHOD FOR SEARCH FUNCTIONALITY
	 ******************************************************************************************************************************************/
	 public static void searchFunctionality() {
		
//		POM INITAILIZATION
		PageFactory.initElements(driver, up);
		
//		CHECKING SEARCH FUNCTION BY COMMON METHOD
		SingleSearch.userSingleSearchMethod(2, UserPage.rightSearch, "Master Module", "User", "TC-USER-0104", 1, 2, 2);	
			
	}
	
}
