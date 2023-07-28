/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* MATERIAL / SOURCE  - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.source;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SourcePageMethods extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR SOURCE PAGE
	static SourcePage sp = new SourcePage();
	
//	AFTER ADD SOURCE STATUS DECLARE
	public static boolean clickAddSourceButton = false;	

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO SOURCE SUB MODULE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void sourcePageNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		1.LOGIN SYSTEM
		LoginTest.Login();
		
		if (LoginTest.login) {
			
//			2.CLICK MASTER CARD 
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {				
				MasterMainNavigationsTest.clickMaster = false;
							
//				3.CLICK MATERIAL (GO TO MATERIAL MAIN CATEGORY BY DEFAULT)
				MasterMainNavigationsTest.navigateMaterialMain();
				
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.clickMaterialMain = false;
					
//					4.CLICK SOURCE SUB MODULE
					MasterMainNavigationsTest.navigateSource();	
					MasterMainNavigationsTest.clickSource = true;	
					
				}			
				
			}
			
		}

	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD SOURCE POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addSourcePageNavigation() throws InterruptedException {
		
//		DIRECTLY NAVIGATE TO SOURCE PAGE
		sourcePageNavigation();
		
		if (MasterMainNavigationsTest.clickSource) {
			MasterMainNavigationsTest.clickSource = false;
			
//		CLICK ADD SOURCE 	
			addSourceButtonClick();
			
		}
		
	}

	/******************************************************************************************************************************************
	 * No(6)   ||    TestCase No : TC-SRC-0025	||   @author Jathu Jana 	||	 Date : 26/07/2023
	 * @category METHOD FOR ADD SOURCE BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addSourceButtonClick() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		CLICK ADD SOURCE WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Source Button Functionality ",
				SourcePage.addSourceButton , "Button");
		clickAddSourceButton   = true;
		
	}

}
