/***************************************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------------------------
* Checking Employee / First Name Search Functionality
****************************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ==========================================================================================================================
* 	No	 ||			Test Case Number 	 ||  	Date  	    ||  		   Intis    	  	||   	Comments
* ==========================================================================================================================
*  (2) 	  			TC-EMP-0017		      	     -	       		 Priyanka,Rahul & Wathi  	   	Original Version
*  			(TC-EMP-0019,TC-EMP-0021)		  14/07/2023                Jathu Jana     			Modified Version (Rework) 				  							 
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

public class EmployeeFirstNameSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR EMPLOYEE PAGE
	static EmployeePage ep = new EmployeePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO EMPLOYEE PAGE
		EmployeePageMethods.employeePageNavigation();
		
		if (MasterMainNavigationsTest.clickEmployee) {
			MasterMainNavigationsTest.clickEmployee = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			firstNameSearchFunctionality();

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
	 * @category MAIN METHOD FOR FIRST NAME SEARCH FUNCTIONALITY
	 * @throws InterruptedException 
	 * @throws IOException 
	 *******************************************************************************************************************************************/
	public static void firstNameSearchFunctionality() throws IOException, InterruptedException{

//		POM INITIALIZATION
		PageFactory.initElements(driver, ep);
		
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		SingleSearch.singleSearchMethod( 1, EmployeePage.SearchPopTextBox, "Master Module", "Employee", 
				"TC-EMP-0017", 1, 2);

	}
	
}
