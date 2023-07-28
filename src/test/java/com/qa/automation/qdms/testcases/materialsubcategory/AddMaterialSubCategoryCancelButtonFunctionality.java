/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Add Material Sub Category Cancel Button Functionality
******************************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 		  ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  (8) 	  	 		 TC-MATSC-0043		          26/07/2023	  	 Jathu Jana		Original Version
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialsubcategory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddMaterialSubCategoryCancelButtonFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR MATERIAL SUB CATEGORY PAGE
	static MaterialSubCategoryPage mmcp = new MaterialSubCategoryPage();	
	
	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO ADD MATERIAL SUB CATEGORY POPUP
		MaterialSubCategoryPageMethods.addMaterialSubCategoryNavigation();
	
//		2.CHECKING METHOD
		if (MaterialSubCategoryPageMethods.clickAddMatSubCatButton) {
			MaterialSubCategoryPageMethods.clickAddMatSubCatButton = false;
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, mmcp);

//			CHECKING ADD MATERIAL SUB CATEGORY CANCEL BUTTON FUNCTIONALITY
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Material Sub Category Cancel Button Functionality ",
					MaterialSubCategoryPage.popUpModelFirstButton ,MaterialSubCategoryPage.popUpModel);

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
