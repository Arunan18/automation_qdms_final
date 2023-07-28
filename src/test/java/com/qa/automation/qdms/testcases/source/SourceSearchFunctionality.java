/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Source / Source Search Functionality
******************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date      	||      Intis     		||   Comments
* ================================================================================================================
*  (2) 	  			TC-SRC-0010		      	  	   -	   	   	Sasikala & Gobi			Original Version
*  			(TC-SRC-0012,TC-SRC-0014)		   14/07/2023       Jathu Jana     			Modified Version (Rework) 				  							 
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.source;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SourceSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR SOURCE PAGE
	static SourcePage sp = new SourcePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO SOURCE PAGE
		SourcePageMethods.sourcePageNavigation();
		
		if (MasterMainNavigationsTest.clickSource) {
			MasterMainNavigationsTest.clickSource = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			sourceSearchFunctionality();

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
	 * @category MAIN METHOD FOR SOURCE SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void sourceSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 1, SourcePage.SearchPopTextBox, "Master Module", "Source", 
				"TC-SRC-0010", 1, 2);

	}
}
