/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Delete Designation Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 	 ||  	Date      ||      Intis     	||   Comments
* ================================================================================================================
*  (10) 	  	TC-DES-0046 , TC-DES-0050	       	   -		      Volta				Original Version
*  			 									   18/07/2023       Jathu Jana     		Modified version (Rework)
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DesignationDeleteFunctionality extends DriverIntialization{

	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
		if (MasterMainNavigationsTest.clickDesignation) {
			MasterMainNavigationsTest.clickDesignation = false;
			
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
	 * @category MAIN METHOD FOR DELETE DESIGNATION FUNCTIONALITY
	 *******************************************************************************************************************/
	public static void deleteFunctionanlity(){

//		CHECKING DELETE FUNCTION BY DELETE FUNCTIONALITY COMMON METHOD
		deleteFunction.clickDelete("Master Module", "Designation", "TC-DES-0046", "Designation ");

	}
	
}
