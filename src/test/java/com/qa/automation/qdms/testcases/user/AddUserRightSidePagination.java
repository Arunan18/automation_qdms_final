/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add User PopUp Right Side Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (8) 	  	 	  TC-USER-0077      	  16/03/2023         Wathi			Original Version
*				   		 				  17/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class AddUserRightSidePagination extends DriverIntialization {

//	PAGE OBJECT MODEL FOR USER PAGE
	static UserPage up = new UserPage();	
	
	@Test
	public static void rightPagination() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO ADD USER POPUP
		UserPageMethods.addUserNavigation();

		if (UserPageMethods.clickAddUser) {
			UserPageMethods.clickAddUser = false;
			
//			2.CHECKING PAGINATION MAIN METHOD
			addUserRightSidePaginationMtd();
							
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
	 * @throws InterruptedException
	 *************************************************************************************************************/	
	public static void addUserRightSidePaginationMtd() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		POM INITIALIZATION
		PageFactory.initElements(driver,up);
		
//		SELECT EMPLOYEE(CLICK EMPLOYEE CHECKBOX)
		functionality.clicking(UserPage.addUserPopLeftSideEmployeeBox, "Check Box");
		
//		CLICK ALLOCATION ARROW BUTTON
		if (functionality.Clicking) {
			functionality.Clicking = false;
			
			functionality.FunctionCheckWithClick("Clicking Allocation Arrow Button with Checking Function",
					UserPage.addUserPopEmployeeAllocationArrowButtonForRight, "Arrow Button");
			
			if (functionality.Clicking) {
				functionality.Clicking = false;
				
//				CALL PAGINATION METHOD
				pagination();
				
			}
			
		}
		
	}

	/*************************************************************************************************************
	 * @category METHOD FOR PAGINATION
	 *************************************************************************************************************/
	public static void pagination() {
		
//		CHECK ADD USER RIGHT SIDE PAGINATION USING PAGINATION COMMON METHOD    
		materialMethodes.paginationWithoutPageSelection("Master Module", "User", "TC-USER-0077-01", 
				"Checking Add User PopUp Right Side Pagination Functionality");
	
	}
	
}