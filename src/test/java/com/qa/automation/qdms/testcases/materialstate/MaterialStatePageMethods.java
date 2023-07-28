/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* MATERIAL/MATERIAL STATE PAGE - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 07/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialStatePageMethods extends DriverIntialization{

//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();

//	ADD MATERIAL STATE BUTTON STATUS DECLARE
	public static boolean clickAddMatState = false;
	
//	MATERIAL STATE PAGE POPUP MODEL SECOND BUTTON STATUS DECLARE
	public static boolean clickPopUpModelSecondButton = false;
	
//	MATERIAL STATE PAGE POPUP MODEL FIRST BUTTON STATUS DECLARE
	public static boolean clickPopUpModelFirstButton = false;
  
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO MATERIAL PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void materialPageNavigation() throws InterruptedException {
		
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
				MasterMainNavigationsTest.clickMaterialMain = true;
				
			}
			
		}

	}
		
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void materialStatePageNavigation() throws InterruptedException {
		
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
					
//					4.CLICK MATERIAL STATE
					MasterMainNavigationsTest.navigateMaterialState();	
					MasterMainNavigationsTest.clickMaterialState = true;	
							
				}
				
			}
			
		}

	}
	

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD MATERIAL STATE POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMatStateNavigation() throws InterruptedException {
			
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
		
//					4.CLICK MATERIAL STATE
					MasterMainNavigationsTest.navigateMaterialState();	
					
					if (MasterMainNavigationsTest.clickMaterialState) {
						
						MasterMainNavigationsTest.clickMaterialState =false;
						
//						5.CLICK ADD MATERIAL STATE
						addMaterialStateButtonClick();	
						clickAddMatState = true;
					}	
							
				}
				
			}
			
		}
		
	}
	
	/******************************************************************************************************************************************
	 * No(1)   ||    TestCase No : TC-MATSTA-0019 	||   @author Jathu Jana 
	 * @category METHOD FOR ADD MATERIAL STATE BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMaterialStateButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CLICK ADD DESIGNATION WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Material State Button Functionality ", MaterialStatePage.addMaterialStateButton, "Button");
		clickAddMatState = true;
		
	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR MATERIAL STATE PAGE - CLICK ANY POPUP MODEL SAVE / EDIT /UPDATE BUTTON (WITH FUNCTIONALITY CHECKING)
	 * @param TestCaseDescription
	 * @throws InterruptedException 
	 *****************************************************************************************************************************************/
	public static void popUpModelSecondButtonFunctionAndClick(String TestCaseDescription) throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CLICK POPUP SECOND BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick(TestCaseDescription, MaterialStatePage.popUpModelSecondButton , "Button");
		clickPopUpModelSecondButton = true;
		Thread.sleep(2000);
	}
	
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR MATERIAL STATE PAGE - CLICK ANY POPUP MODEL CANCEL BUTTON (WITH FUNCTIONALITY CHECKING)
	 * @param TestCaseDescription
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void popUpModelFirstButtonFunctionAndClick(String TestCaseDescription) throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CLICK POPUP FIRST BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick(TestCaseDescription, MaterialStatePage.popUpModelFirstButton , "Button");
		clickPopUpModelFirstButton = true;
		
	}

}



