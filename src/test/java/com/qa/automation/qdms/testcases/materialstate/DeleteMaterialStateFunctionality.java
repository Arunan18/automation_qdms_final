/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Delete Material State Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||				Test Case Number 		    ||  	Date      ||      Intis     	||   Comments
* ================================================================================================================
*  (10) 	    		TC-MATSTA-0043 					   	  -		      Niluxi & Kajan		Original Version
*  			    TC-MATSTA-0046,TC-MATSTA-0052	   		 18/07/2023       	Jathu Jana     		Modified version (Rework)
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteMaterialStateFunctionality extends DriverIntialization {

	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialStatePageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterialState) {
			MasterMainNavigationsTest.clickMaterialState = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			deleteFunctionanlity();

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
	 * @category MAIN METHOD FOR DELETE MATERIAL STATE FUNCTIONALITY
	 *******************************************************************************************************************/
	public static void deleteFunctionanlity(){

//		CHECKING DELETE FUNCTION BY DELETE FUNCTIONALITY COMMON METHOD
		deleteFunction.clickDelete("Master Module", "Material State", "TC-MATSTA-0043", "Material State ");

	}
	
}
