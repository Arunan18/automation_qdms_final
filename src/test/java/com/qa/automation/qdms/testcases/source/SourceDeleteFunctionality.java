/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Delete Source Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 	||  	Date      ||      Intis      	||   	Comments
* ================================================================================================================
*  (4) 	  			 TC-SRC-0052		      	   	 -		     	Gobithan			Original Version
*  												 18/07/2023       Jathu Jana     		Modified Version (Rework) 				  							 
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.source;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SourceDeleteFunctionality extends DriverIntialization {

	@Test
	public static void function() throws InterruptedException, IOException {
		
//		1.DIRECTLY NAVIGATE TO SOURCE PAGE
		SourcePageMethods.sourcePageNavigation();
		
		if (MasterMainNavigationsTest.clickSource) {
			MasterMainNavigationsTest.clickSource = false;
			
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
	 * @category MAIN METHOD FOR DELETE SOURCE FUNCTIONALITY
	 ***********************************************************************************/
	public static void deleteFunctionanlity(){

//		CHECKING DELETE FUNCTION BY DELETE FUNCTIONALITY COMMON METHOD
		deleteFunction.clickDelete("Master Module", "Source", "TC-SRC-0052", "Source ");
		
	}
	
}


