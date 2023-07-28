/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Material / Material Main Category Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||      Intis      	||   	Comments
* ================================================================================================================
*  (3) 	  			TC-MAT-0026		      	  16/03/2023	       Rahul  	   		Original Version
*  			(TC-MAT-0027,TC-MAT-0028)		  14/04/2023	       Rahul  	   		Modified Version
*  			                        		  14/07/2023         Jathu Jana     	Modified Version (Rework) 				  							 
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialMainCategorySearchFunctionality extends MaterialSearchFunctionality {
	
//	PAGE OBJECT MODEL FOR MATERIAL PAGE
	static MaterialPage mp = new MaterialPage();	
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL PAGE
		MaterialPageMethods.materialPageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterial) {
			MasterMainNavigationsTest.clickMaterial = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			materialMainCategorySearchFunctionality();

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
	
	/*******************************************************************************************************************************************
	 * @category MAIN METHOD FOR MATERIAL MAIN CATEGORY SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void materialMainCategorySearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, mp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 2, MaterialPage.SearchPopTextBox, "Master Module", "Material", 
				"TC-MAT-0026", 1, 2);

	}
	
}
