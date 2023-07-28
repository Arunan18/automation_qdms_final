/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Designation Search Functionality
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||     Intis     ||   Comments
* ========================================================================================================
*  (7) 	  		 TC-DES-0014		      	       	  -		 Volta			Original Version
*  			(TC-DES-0016,TC-DES-0018)	  10/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DesignationSearchFunctionality extends DriverIntialization{

//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	static DesignationPage dp = new DesignationPage();

	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
		if (MasterMainNavigationsTest.clickDesignation) {
			MasterMainNavigationsTest.clickDesignation = false;
			
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
	 * @category MAIN METHOD FOR SEARCH DESIGNATION FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void designationSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 1, DesignationPage.SearchPopTextBox, "Master Module", "Designation", 
				"TC-DES-0014", 1, 2);

	}
}
