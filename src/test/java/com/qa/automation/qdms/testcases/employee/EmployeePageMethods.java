/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* EMPLOYEE / EMPLOYEE  - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.employee;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EmployeePageMethods extends DriverIntialization{

//	PAGE OBJECT MODEL FOR EMPLOYEE PAGE
	public static EmployeePage ep = new EmployeePage();
	
//	ADD EMPLOYEE BUTTON STATUS DECLARE
    public static boolean clickAddEmployee = false;

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO EMPLOYEE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void employeePageNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		1.LOGIN SYSTEM
		LoginTest.Login();
		
		if (LoginTest.login) {
			
//			2.CLICK MASTER CARD 
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {				
				MasterMainNavigationsTest.clickMaster = false;
							
//				3.CLICK EMPLOYEE 
				MasterMainNavigationsTest.navigateEmployeeMain();
				
				if (MasterMainNavigationsTest.clickEmployeeMain) {
					MasterMainNavigationsTest.clickEmployeeMain = false;
					
//					4.CLICK EMPLOYEE SUB MODULE
					MasterMainNavigationsTest.navigateEmployee();	
					MasterMainNavigationsTest.clickEmployee = true;	
					
				}			
				
			}
			
		}

	}
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD EMPLOYEE POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void  addEmployeeNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		employeePageNavigation();
		
		if (MasterMainNavigationsTest.clickEmployee) {
			MasterMainNavigationsTest.clickEmployee = false;
			
			addEmployeenButtonClick();
			clickAddEmployee = true;
		}
	}
	
	/******************************************************************************************************************************************
	 * No(8)   ||    TestCase No : TC-EMP-0072 	||   @author Jathu Jana   || Date : 26/07/2023
	 * @category METHOD FOR ADD EMPLOYEE BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addEmployeenButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, ep);
		
//		CLICK ADD EMPLOYEE WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Employee Button Functionality ", EmployeePage.addEmpButton , "Button ");
		clickAddEmployee = true;
		
	}
	
}
