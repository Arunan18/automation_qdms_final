/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* EMPLOYEE / DESIGNATION  - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class UserPageMethods extends DriverIntialization{

//	WAIT
	static WebDriverWait wait = new WebDriverWait(driver, 10);

//	PAGE OBJECT MODEL FOR USER PAGE
	static UserPage up = new UserPage();
	
//	ADD USER CLICK STATUS
    public static boolean clickAddUser;

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO USER PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void userPageNavigation() throws InterruptedException {
		
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
					
//					4.CLICK USER SUB MODULE
					MasterMainNavigationsTest.navigateUser();	
					MasterMainNavigationsTest.clickUser = true;	
					
				}			
				
			}
			
		}
		
	}
	
	/******************************************************************************************************************************************
	* @author Jathu Jana
	* @category METHOD FOR DIRECTLY NAVIGATE TO ADD USER POPUP
	* @throws InterruptedException
	*****************************************************************************************************************************************/
	public static void addUserNavigation() throws InterruptedException {
		
//		WEB DRIVER WAIT
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		POM INITIALIZATION
		PageFactory.initElements(driver,up);

//		DIRECTLY NAVIGATE TO USER PAGE
		userPageNavigation();
		
		if (MasterMainNavigationsTest.clickUser) {
			MasterMainNavigationsTest.clickUser = false;
			
//			ADD USER BUTTON CLICK METHOD
			addUserButtonClick();
		}
		
	}
	
	/******************************************************************************************************************************************
	 * No(11)   ||    TestCase No : TC-USER-0065	||   @author Jathu Jana   || Date: 26/07/2023
	 * @category METHOD FOR ADD USER BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addUserButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, up);
		
//		CLICK ADD USER WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add User Button Functionality ",
				UserPage.addUserButton , "Button");
		clickAddUser = true;
		
	}
	
}
