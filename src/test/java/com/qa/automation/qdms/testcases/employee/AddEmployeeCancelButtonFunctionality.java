/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Add Material Sub Category Cancel Button Functionality
******************************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 		  ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  (9) 	  	        	TC-EMP-0086	     	     26/07/2023	  	  Jathu Jana		Original Version
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.employee;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddEmployeeCancelButtonFunctionality extends DriverIntialization{

//	PAGE OBJECT MODEL FOR EMPLOYEE PAGE
	public static EmployeePage ep = new EmployeePage();
	
	@Test
	public static void function() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO ADD EMPLOYEE POPUP
		EmployeePageMethods.addEmployeeNavigation();

		if (EmployeePageMethods.clickAddEmployee) {
			EmployeePageMethods.clickAddEmployee = false;
			
//			2.CHECKING FUNCTIONALITY >>>>>>	
			
//			POM INITIALIZATION
			PageFactory.initElements(driver, ep);	
			
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Add Employee Cancel Button Functionality ",
					EmployeePage.popUpModelFirstButton ,EmployeePage.popUpModel);

				
		}
		
		
//		3.REFRESH
		driver.navigate().refresh();;
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	     	4.LOGOUT
			Logout.LogoutFunction();
	
		}
		
	}

}
