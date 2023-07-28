/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Add Material Close Button Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||      Intis      	||   	Comments
* ================================================================================================================
*  (10) 	  		  TC-MAT-0109       	  26/07/2023         Jathu Jana   	   		Original Version
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddMaterialCloseButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR MATERIAL PAGE
	static MaterialPage mp = new MaterialPage();	
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD MATERIAL POPUP
		MaterialPageMethods.addMaterialNavigation();
	
//		2.CHECKING METHOD
		if (MaterialPageMethods.clickAddMatButton) {
			MaterialPageMethods.clickAddMatButton = false;
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, mp);

//			CHECKING ADD MATERIAL CLOSE BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Material Close Button Functionality ",
					MaterialPage.popUpModelCloseButton ,MaterialPage.popUpModel);

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
