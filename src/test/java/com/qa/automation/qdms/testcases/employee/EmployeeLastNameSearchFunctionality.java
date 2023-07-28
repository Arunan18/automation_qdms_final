/***************************************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------------------------
* Checking Employee / Last Name Search Functionality
****************************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ==========================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||  		   Intis    	  	||   	Comments
* ==========================================================================================================================
*  (3) 	  			TC-EMP-0023		      	     -	       			 Priyanka & Wathi  	   		Original Version
*  			(TC-EMP-0024,TC-EMP-0025)		  14/07/2023                Jathu Jana     			Modified Version (Rework) 				  							 
****************************************************************************************************************************/

package com.qa.automation.qdms.testcases.employee;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;


public class EmployeeLastNameSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR EMPLOYEE PAGE
	static EmployeePage ep = new EmployeePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO EMPLOYEE PAGE
		EmployeePageMethods.employeePageNavigation();
		
		if (MasterMainNavigationsTest.clickEmployee) {
			MasterMainNavigationsTest.clickEmployee = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			lastNameSearchFunctionality();

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
	 * @category MAIN METHOD FOR LAST NAME SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void lastNameSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, ep);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 2, EmployeePage.SearchPopTextBox, "Master Module", "Employee", 
				"TC-EMP-0023", 1, 2);

	}
	
}
