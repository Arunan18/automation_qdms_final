/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Material State Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 	 ||  	Date      ||      Intis     	||   Comments
* ================================================================================================================
*  (7) 	  			TC-MATSTA-0011		      	     -		   	  Niluxi & Volta		Original Version
*  			(TC-MATSTA-0009,TC-MATSTA-0016)	     11/07/2023       	Jathu Jana     		Modified version (Rework)
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialStateSearchFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	static MaterialStatePage msp = new MaterialStatePage();

	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialStatePageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterialState) {
			MasterMainNavigationsTest.clickMaterialState = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			materialStateSearchFunctionanlity();

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
	 * @category MAIN METHOD FOR MATERIAL STATE SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void materialStateSearchFunctionanlity() throws IOException, InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 1, MaterialStatePage.SearchPopTextBox, "Master Module", "Material State", 
				"TC-MATSTA-0011", 1, 2);

	}
	
}
