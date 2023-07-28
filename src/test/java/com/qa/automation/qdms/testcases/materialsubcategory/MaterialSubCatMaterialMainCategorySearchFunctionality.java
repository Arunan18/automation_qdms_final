/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Material Sub Category / Material Main Category Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 	 ||  	Date      ||      Intis     	||   Comments
* ================================================================================================================
*  (3) 	  			TC-MATSC-0019		      	     -		   	    Sayanthan 			Original Version
*  			(TC-MATSC-0020,TC-MATSC-0021)	     14/07/2023       	Jathu Jana     		Modified version (Rework)
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialsubcategory;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialSubCatMaterialMainCategorySearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR MATERIAL SUB CATEGORY PAGE
	static MaterialSubCategoryPage mscp = new MaterialSubCategoryPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL SUB CATEGORY PAGE
		MaterialSubCategoryPageMethods.materialSubCategoryPageNavigation();
		
		if (MasterMainNavigationsTest.clicksubCategory) {
			MasterMainNavigationsTest.clicksubCategory = false;
		
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			materialMainCategorySearchFunctionanlity();
				
		}
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
	
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	    	4.LOGOUT
			Logout.LogoutFunction();
	
		}
		
	}

	/*******************************************************************************************************************
	 * @category MAIN METHOD FOR MATERIAL MAIN CATEGORY SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void materialMainCategorySearchFunctionanlity() throws IOException, InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, mscp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod(2, MaterialSubCategoryPage.SearchPopTextBox, "Master Module", "Material Sub Category", 
				"TC-MATSC-0019", 1, 2);

	}	

}
