/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Role Close Button Functionality 
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||  	 Comments
* ========================================================================================================
*  (5) 	  	     TC-ROL-0026  	     	  26/07/2023         Jathu Jana 		Original Version
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.role;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddRoleCloseButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR ROLE PAGE
	static RolePage rp = new RolePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD ROLE POPUP
		RolePageMethods.addRolePageNavigation();
		
		if (RolePageMethods.clickAddRoleButton) {
						
//			POM INITIALIZATION
			PageFactory.initElements(driver, rp);

//			CHECKING ADD ROLE CLOSE BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Role Close Button Functionality ",
					RolePage.popUpModelCloseButton ,RolePage.popUpModel);

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
