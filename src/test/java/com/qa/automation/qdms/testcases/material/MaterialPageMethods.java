/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* MATERIAL / MATERIAL  - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.material;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialPageMethods extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR MATERIAL PAGE
	static MaterialPage mp = new MaterialPage();	
	
//	AFTER ADD MATERIAL STATUS DECLARE
	public static boolean clickAddMatButton = false;

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO MATERIAL SUB MODULE PAGE
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
				
				if (MasterMainNavigationsTest.clickMaterialMain) {
					MasterMainNavigationsTest.clickMaterialMain = false;
					
//					4.CLICK MATERIAL SUB MODULE
					MasterMainNavigationsTest.navigateMaterial();	
					MasterMainNavigationsTest.clickMaterial = true;	
					
				}			
				
			}
			
		}

	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD MATERIAL POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMaterialNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		DIRECTLY NAVIGATE MATERIAL PAGE
		materialPageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterial) {
			MasterMainNavigationsTest.clickMaterial= false;
			
			addMatButtonClick();
		}
	}

	/******************************************************************************************************************************************
	 * No(8)   ||    TestCase No : TC-MAT-0091 	||   @author Jathu Jana   ||   Date : 27/07/2023 
	 * @category METHOD FOR ADD MATERIAL BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMatButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, mp);
		
//		CLICK ADD MATERIAL WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Material Button Functionality ", MaterialPage.addMaterialButton , "Button");
		clickAddMatButton  = true;
		
	}
	
}
