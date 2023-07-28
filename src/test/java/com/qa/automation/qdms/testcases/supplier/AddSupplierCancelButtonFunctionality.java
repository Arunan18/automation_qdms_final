/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Add Suppliear Cancel Button Functionality 
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||  	 Comments
* ========================================================================================================
*  (4) 	  	     TC-SUPCAT-0027			 26/07/2023         Jathu Jana 		Original Version
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.supplier;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddSupplierCancelButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR SUPPLIER PAGE
	static SupplierPage sp = new SupplierPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD SUPPLIER POPUP
		SupplierPageMethods.addSupplierPageNavigation();
		
		if (SupplierPageMethods.clickAddSuppButton) {
						
//			POM INITIALIZATION
			PageFactory.initElements(driver, sp);

//			CHECKING ADD SUPPLIER CANCEL BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Supplier Cancel Button Functionality ",
					SupplierPage.popUpModelFirstButton ,SupplierPage.popUpModel);

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
