/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Material Sub Category / Prefix Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 	 ||  	Date      ||      Intis     	||   Comments
* ================================================================================================================
*  (4) 	  			TC-MATSC-0023		      	 08/03/2023	   	    Shadurshi 			Original Version
*  			(TC-MATSC-0024,TC-MATSC-0025)		 11/04/2023			Quenthan			Modified Version
*  				  							     14/07/2023       	Jathu Jana     		Modified Version (Rework)
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

public class MaterialSubCatPrefixSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR MATERIAL SUB CATEGORY PAGE
	static MaterialSubCategoryPage mscp = new MaterialSubCategoryPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL SUB CATEGORY PAGE
		MaterialSubCategoryPageMethods.materialSubCategoryPageNavigation();
		
		if (MasterMainNavigationsTest.clicksubCategory) {
			MasterMainNavigationsTest.clicksubCategory = false;
		
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			prefixSearchFunctionanlity();
				
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
	 * @category MAIN METHOD FOR SEARCH PREFIX SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void prefixSearchFunctionanlity() throws IOException, InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, mscp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod(3, MaterialSubCategoryPage.SearchPopTextBox, "Master Module", "Material Sub Category", 
				"TC-MATSC-0023", 1, 2);

	}	

}