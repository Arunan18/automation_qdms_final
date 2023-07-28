/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* MATERIAL / MATERIAL SUB CATEGORY PAGE - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 14/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialsubcategory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialSubCategoryPageMethods extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR MATERIAL MAIN CATEGORY PAGE
	static MaterialSubCategoryPage mscp = new MaterialSubCategoryPage();
	
//	AFTER ADD MATERIAL SUB CATEGORY STATUS DECLARE
	public static boolean clickAddMatSubCatButton = false;	

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO MATERIAL SUB CATEORY SUB MODULE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void materialSubCategoryPageNavigation() throws InterruptedException {
		
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

//					4.CLICK MATERIAL SUB CATEGORY
					MasterMainNavigationsTest.navigateMaterialSubCategory();	
					MasterMainNavigationsTest.clicksubCategory = true;	
					
				}
									
			}
			
		}

	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD MATERIAL SUB CATEORY POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMaterialSubCategoryNavigation() throws InterruptedException {
		
//		DIRECTLY NAVIGATE TO MATERIAL SUB CATEORY SUB MODULE PAGE
		materialSubCategoryPageNavigation();
		
		if (MasterMainNavigationsTest.clicksubCategory) {
			MasterMainNavigationsTest.clicksubCategory = false;
			
//			CLICK ADD MATERIAL SUB CATEORY
			addMatSubCatButtonClick();
			
		}
	}
	
	/******************************************************************************************************************************************
	 * No(7)   ||    TestCase No : TC-MATSC-0032	||   @author Jathu Jana   || 	Date : 26/07/2023
	 * @category METHOD FOR ADD MATERIAL SUB CATEGORY BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMatSubCatButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, mscp);
		
//		CLICK ADD MATERIAL SUB CATEGORY WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Material Sub Category Button Functionality ",
				MaterialSubCategoryPage.addMatSubCatButton , "Button");
		clickAddMatSubCatButton   = true;
		
	}
	
}
