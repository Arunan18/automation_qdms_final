/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Add Material Main Category Cancel Button Functionality
******************************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 		  ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  (4) 	  	 		  TC-MATMC-0040	      	      26/07/2023	  	  Jathu Jana		Original Version
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddMaterialMainCategoryCancelButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR MATERIAL MAIN CATEGORY PAGE
	static MaterialMainCategoryPage mmcp = new MaterialMainCategoryPage();	
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD MATERIAL MAIN CATEGORY POPUP
		MaterialMainCategoryPageMethods.addMaterialMainCategoryNavigation();
	
//		2.CHECKING METHOD
		if (MaterialMainCategoryPageMethods.clickAddMatMainCatButton) {
			MaterialMainCategoryPageMethods.clickAddMatMainCatButton = false;
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, mmcp);

//			CHECKING ADD MATERIAL MAIN CATEGORY CANCEL BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Material Main Category Cancel Button Functionality ",
					MaterialMainCategoryPage.popUpModelFirstButton ,MaterialMainCategoryPage.popUpModel);

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
