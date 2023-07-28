/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add User Close Button Functionality 
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||  	 Comments
* ========================================================================================================
*  (13) 	  	        	     		  26/07/2023         Jathu Jana 		Original Version
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddUserCloseButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR USER PAGE
	static UserPage up = new UserPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD USER POPUP
		UserPageMethods.addUserNavigation();
		
		if (UserPageMethods.clickAddUser) {
			UserPageMethods.clickAddUser = false ;	
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, up);

//			CHECKING ADD USER CLOSE BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add User Close Button Functionality ",
					UserPage.popUpModelCloseButton ,UserPage.popUpModel);

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
	
}
