/***************************************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------------------------
* Checking User / Designation Search Functionality
****************************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ==========================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||  	  Intis    		 ||   	Comments
* ==========================================================================================================================
*  (5) 	  			TC-USER-0030		      20/03/2023       	    Vithusha 	 	     Original Version
*  			(TC-USER-0031,TC-USER-0032)		  14/07/2023           Jathu Jana     	     Modified Version (Rework) 				  							 
****************************************************************************************************************************/

package com.qa.automation.qdms.testcases.user;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class UserDesignationSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR USER PAGE
	static UserPage up = new UserPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO USER PAGE
		UserPageMethods.userPageNavigation();
		
		if (MasterMainNavigationsTest.clickUser) {
			MasterMainNavigationsTest.clickUser = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			designationSearchFunctionality();

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
	 * @category MAIN METHOD FOR DESIGNATION SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void designationSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, up);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod(4, UserPage.SearchPopTextBox, "Master Module", "User", 
				"TC-USER-0030", 1, 2);

	}
	
}
