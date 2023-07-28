/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Material / SBU Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||      Intis      	||   	Comments
* ================================================================================================================
*  (7) 	  			TC-MAT-0050		      	  30/03/2023	     Sayanthan  	   	Original Version
*  			(TC-MAT-0051,TC-MAT-0052)		  14/07/2023         Jathu Jana     	Modified Version (Rework) 				  							 
*  			                        		  
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialSBUSearchFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR MATERIAL PAGE
	static MaterialPage mp = new MaterialPage();	
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL PAGE
		MaterialPageMethods.materialPageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterial) {
			MasterMainNavigationsTest.clickMaterial = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			SBUSearchFunctionality();

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
	 * @category MAIN METHOD FOR SBU SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void SBUSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, mp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 9, MaterialPage.SearchPopTextBox, "Master Module", "Material", 
				"TC-MAT-0050", 1, 2);

	}
	
}
