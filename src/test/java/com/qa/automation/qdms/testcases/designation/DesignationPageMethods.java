/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* EMPLOYEE/DESIGNATION PAGE - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 04/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DesignationPageMethods extends DriverIntialization{

//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();
	
//	ADD DESIGNATION BUTTON STATUS DECLARE
	public static boolean clickAddDesignation = false;
	
//	DESIGNATION PAGE POPUP MODEL SECOND BUTTON STATUS DECLARE
	public static boolean clickPopUpModelSecondButton = false;
	
//	DESIGNATION PAGE POPUP MODEL FIRST BUTTON STATUS DECLARE
	public static boolean clickPopUpModelFirstButton = false;
    
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO DESDIGNATION PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void designationPageNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		1.LOGIN SYSTEM
		LoginTest.Login();
		
		if (LoginTest.login) {
			
//		2.CLICK MASTER CARD 
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				
				MasterMainNavigationsTest.clickMaster = false;	
				
//		3.CLICK EMPLOYEE (GO TO DESIGNATION BY DEFAULT)
				MasterMainNavigationsTest.navigateEmployeeMain();
				
				if (MasterMainNavigationsTest.clickEmployeeMain) {
					
					MasterMainNavigationsTest.clickEmployeeMain = false;
					
//		4.CLICK DESIGNATION
					MasterMainNavigationsTest.navigateDesignation();	
					MasterMainNavigationsTest.clickDesignation = true;	
							
				}
				
			}
			
		}

	}
	

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD DESDIGNATION POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addDesiNavigation() throws InterruptedException {
			
//		1.LOGIN SYSTEM
		LoginTest.Login();
		
		if (LoginTest.login) {
			
//		2.CLICK MASTER CARD 
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {
				
				MasterMainNavigationsTest.clickMaster = false;
			
//		3.CLICK EMPLOYEE (GO TO DESIGNATION BY DEFAULT)
				MasterMainNavigationsTest.navigateEmployeeMain();
				
				if (MasterMainNavigationsTest.clickEmployeeMain) {
					
					MasterMainNavigationsTest.clickEmployeeMain = false;
					
//		4.CLICK DESIGNATION
					MasterMainNavigationsTest.navigateDesignation();
					
					if (MasterMainNavigationsTest.clickDesignation) {
						
						MasterMainNavigationsTest.clickDesignation = false;
						
//		5.CLICK ADD DESIGNATION
						addDesignationButtonClick();	
						clickAddDesignation = true;
						
					}
							
				}
				
			}
			
		}
		
	}
	
	/******************************************************************************************************************************************
	 * No(1)   ||    TestCase No : TC-DES-0027 	||   @author Jathu Jana 
	 * @category METHOD FOR ADD DESIGNATION BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addDesignationButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CLICK ADD DESIGNATION WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Designation Button Functionality ", DesignationPage.addDesignationButton , "Button ");
		clickAddDesignation = true;
		
	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR DESIGNATION PAGE - CLICK ANY POPUP MODEL SAVE / EDIT /UPDATE BUTTON (WITH FUNCTIONALITY CHECKING)
	 * @param TestCaseDescription
	 * @throws InterruptedException 
	 *****************************************************************************************************************************************/
	public static void popUpModelSecondButtonFunctionAndClick(String TestCaseDescription) throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CLICK POPUP SECOND BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick(TestCaseDescription, DesignationPage.popUpModelSecondButton , "Button ");
		clickPopUpModelSecondButton = true;
		Thread.sleep(1500);		
	}
	
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR DESIGNATION PAGE - CLICK ANY POPUP MODEL CANCEL BUTTON (WITH FUNCTIONALITY CHECKING)
	 * @param TestCaseDescription
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void popUpModelFirstButtonFunctionAndClick(String TestCaseDescription) throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CLICK POPUP FIRST BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick(TestCaseDescription, DesignationPage.popUpModelFirstButton , "Button ");
		clickPopUpModelFirstButton = true;
		
	}
	
}
