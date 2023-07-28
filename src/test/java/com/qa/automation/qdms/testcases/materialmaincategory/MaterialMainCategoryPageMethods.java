/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* MATERIAL / MATERIAL MAIN CATERGORY  - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 26/07/2023		||		Original Version
*
**********************************************************************************************************/
package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialMainCategoryPageMethods extends DriverIntialization{

//	PAGE OBJECT MODEL FOR MATERIAL MAIN CATEGORY PAGE
	static MaterialMainCategoryPage mmcp = new MaterialMainCategoryPage();	
	
//	AFTER ADD MATERIAL MAIN CATEGORY STATUS DECLARE
	public static boolean clickAddMatMainCatButton = false;

	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO MATERIAL SUB MODULE PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	
	public static void materialMainCategoryPageNavigation() throws InterruptedException, IOException {	
		
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
					
//					4.CLICK MATERIAL MAIN CATEGORY
					MasterMainNavigationsTest.navigateMaterialMainCategory();
					MasterMainNavigationsTest.matmaincat= true;
				}

			}
			
		}
		
	}
	
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD MATERIAL MAIN CATEGORY POPUP
	 * @throws InterruptedException
	 * @throws IOException 
	 *****************************************************************************************************************************************/
	public static void addMaterialMainCategoryNavigation() throws InterruptedException, IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		DIRECTLY NAVIGATE MATERIAL PAGE
		materialMainCategoryPageNavigation();
		
		if (MasterMainNavigationsTest.matmaincat) {
			MasterMainNavigationsTest.matmaincat= false;
			
//			CLICK ADD MATERIAL MAIN CATEGORY  
			addMatMainCatButtonClick();
		}
	}

	/******************************************************************************************************************************************
	 * No(4)   ||    TestCase No : TC-MATMC-0029 	||   @author Jathu Jana  ||  Date : 27/07/2023
	 * @category METHOD FOR ADD MATERIAL MAIN CATEGORY BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addMatMainCatButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, mmcp);
		
//		CLICK ADD MATERIAL MAIN CATEGORY WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Material Main Category Button Functionality ",
														MaterialMainCategoryPage.addMaterialMainCatButton , "Button");
		clickAddMatMainCatButton  = true;
		
	}
	
}
