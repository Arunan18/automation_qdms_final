/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Employee Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	  TC-EMP-0066      	  	  30/03/2023       Sayanthan		Original Version
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.employee;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.designation.DesignationPageMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class EmployeePagination extends DriverIntialization {
	
	@Test
	public static void employeePagination() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();

		if (MasterMainNavigationsTest.clickDesignation) {
			MasterMainNavigationsTest.clickDesignation = false;
			
//			2.CLICK EMPLOYEE SUB MODULE
			MasterMainNavigationsTest.navigateEmployee();
			if (MasterMainNavigationsTest.clickEmployee) {		
				MasterMainNavigationsTest.clickEmployee = false;
				
//				3.CHECKING PAGINATION MAIN METHOD
				pagination();
				
			}
		}
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	     	4.LOGOUT
			Logout.LogoutFunction();
	
		}
		
	}

	/*************************************************************************************************************
	 * @category MAIN METHOD FOR PAGINATION
	 *************************************************************************************************************/
	public static void pagination() {
		
//		CHECK EMPLOYEE PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Employee", "TC-EMP-0066-01", 
				"Checking Employee Pagination Functionality");
	
	}
	
}
