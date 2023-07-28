/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Material Close Button Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (4) 	  	 	  TC-MATSTA-0030      	  22/03/2023       Niluxy			Original Version
*				   		 				  07/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddMaterialStateCloseButtonFunctionality extends DriverIntialization {

//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();
	
//	ADD MATERIAL STATE CLOSE BUTTON STATUS DECLARE
	public static boolean clickCloseStatus;
	
	@Test
	public static void function() throws InterruptedException {	
		
//		1.DIRECTLY NAVIGATE TO ADD MATERIAL STATE POPUP
		MaterialStatePageMethods.addMatStateNavigation();
		
		if (MaterialStatePageMethods.clickAddMatState) {
			
			MaterialStatePageMethods.clickAddMatState = false;
			
//		2.CHECKING FUNCTIONALITY MAIN METHOD >>>>>>
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, msp);
			
//			CHECKING ADD MATERIAL STATE CLOSE BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Material State Close Button Functionality ",
					MaterialStatePage.popUpModelCloseButton ,MaterialStatePage.popUpModel);

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
