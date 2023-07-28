/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Designation - Cancel Button Functionality
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||     Intis     ||   Comments
* ========================================================================================================
*  (3) 	  	 	  TC-DES-0030      	      13/03/2023		 Volta			Original Version
*				   		 				  05/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddDesignationCancelButtonFunctionality extends DriverIntialization{

//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();
	
//	ADD DESIGNATION CANCEL BUTTON STATUS DECLARE
	public static boolean clickCancelStatus;
	
	@Test
	public static void function() throws InterruptedException {	
		
//		1.DIRECTLY NAVIGATE TO ADD DESIGNATION POPUP
		DesignationPageMethods.addDesiNavigation();
		
		if (DesignationPageMethods.clickAddDesignation) {
			
			DesignationPageMethods.clickAddDesignation = false;
			
//		2.CHECKING FUNCTIONALITY MAIN METHOD >>>>>>
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, dp);

			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Designation Cancel Button Functionality ",
					DesignationPage.popUpModelFirstButton ,DesignationPage.popUpModel);

		}
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	     4.LOGOUT
	     Logout.LogoutFunction();
	        
		}
		
	}
		
}
