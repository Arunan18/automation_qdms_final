/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* EMPLOYEE / ROLE  - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.role;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class RolePageMethods extends DriverIntialization{

//	PAGE OBJECT MODEL FOR SOURCE PAGE
	static RolePage rp = new RolePage();
	
//	AFTER ADD ROLE STATUS DECLARE
	public static boolean clickAddRoleButton = false;	

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ROLE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void rolePageNavigation() throws InterruptedException {
		
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
					
//					4.CLICK ROLE SUB MODULE
					MasterMainNavigationsTest.navigateRole();	
					MasterMainNavigationsTest.clickRole = true;	
					
				}			
				
			}
			
		}

	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD ROLE POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addRolePageNavigation() throws InterruptedException {
		
//		DIRECTLY NAVIGATE TO ROLE PAGE
		rolePageNavigation();
		
		if (MasterMainNavigationsTest.clickRole) {
			MasterMainNavigationsTest.clickRole = false;
			
//			CLICK ADD ROLE 	
			addRoleButtonClick();
			
		}
		
	}

	/******************************************************************************************************************************************
	 * No(3)   ||    TestCase No : TC-ROL-0016	||   @author Jathu Jana 	||	 Date : 26/07/2023
	 * @category METHOD FOR ADD ROLE BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addRoleButtonClick() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, rp);
		
//		CLICK ADD ROLE WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Role Button Functionality ",RolePage.addRoleButton , "Button");
		clickAddRoleButton   = true;
		
	}


}
