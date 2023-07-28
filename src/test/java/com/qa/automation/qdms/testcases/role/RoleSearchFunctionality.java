/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Role Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||      Intis      	||   	Comments
* ================================================================================================================
*  (2) 	  			TC-ROL-0009		      	  07/06/2023	       Saranka  	   	Original Version
*  			(TC-ROL-0011,TC-ROL-0013)		  14/07/2023         Jathu Jana     	Modified Version (Rework) 				  							 
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.role;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class RoleSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR ROLE PAGE
	static RolePage rp = new RolePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO ROLE PAGE
		RolePageMethods.rolePageNavigation();
		
		if (MasterMainNavigationsTest.clickRole) {
			MasterMainNavigationsTest.clickRole = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			roleSearchFunctionality();

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
	 * @category MAIN METHOD FOR ROLE SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void roleSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, rp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 1, RolePage.SearchPopTextBox, "Master Module", "Role", 
				"TC-ROL-0009", 1, 2);

	}
	
}
