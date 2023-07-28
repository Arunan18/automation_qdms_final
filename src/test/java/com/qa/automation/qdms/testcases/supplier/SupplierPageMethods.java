/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* SUPPLIER /SUPPLIER PAGE - METHODS 
**********************************************************************************************************
*
* @author 	 : Jathu Jana		||		Date : 19/07/2023		||		Original Version
*
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.supplier;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.SupplierPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SupplierPageMethods extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR SUPPLIER PAGE
	static SupplierPage sp = new SupplierPage();
	public static boolean clickPopUpModelSecondButton = false;
	public static boolean clickPopUpModelFirstButton = false;
	public static boolean clickAddSuppButton = false;
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO SUPPLIER PAGE
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void supplierPageNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
//		1.LOGIN SYSTEM
		LoginTest.Login();
		
		if (LoginTest.login) {
			
//		2.CLICK MASTER CARD 
			MasterMainNavigationsTest.navigateMaster();
			
			if (MasterMainNavigationsTest.clickMaster) {	
				MasterMainNavigationsTest.clickMaster = false;	
				
//		3.CLICK SUPPLIER (GO TO SUPPLIER BY DEFAULT)
				MasterMainNavigationsTest.navigateSupplierMain();
				
				if (MasterMainNavigationsTest.clickSuppliermain) {
					MasterMainNavigationsTest.clickSuppliermain = false;
					
//		4.CLICK SUPPLIER SUB MODULE
					MasterMainNavigationsTest.navigateSupplier();	
					MasterMainNavigationsTest.supplierClick = true;	
							
				}
				
			}
			
		}

	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category METHOD FOR DIRECTLY NAVIGATE TO ADD SUPPLIER POPUP
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addSupplierPageNavigation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		supplierPageNavigation();
		if (MasterMainNavigationsTest.supplierClick) {
			
			addSupButtonClick();
			
		}
		
	}
	/******************************************************************************************************************************************
	 * No(1)   ||    TestCase No : TC-SUP-0054 	||   @author Jathu Jana 
	 * @category METHOD FOR ADD SUPPLIER BUTTON CLICKING (WITH FUNCTIONALITY CHECKING)
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void addSupButtonClick() throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		CLICK ADD SUPPLIER WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick("➢ Checking Add Supplier Button Functionality ", SupplierPage.addSupButton , "Button");
		clickAddSuppButton  = true;
		
	}
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR SUPPLIER PAGE - CLICK ANY POPUP MODEL SAVE / EDIT /UPDATE BUTTON (WITH FUNCTIONALITY CHECKING)
	 * @param TestCaseDescription
	 * @throws InterruptedException 
	 *****************************************************************************************************************************************/
	public static void popUpModelSecondButtonFunctionAndClick(String TestCaseDescription) throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		CLICK POPUP SECOND BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick(TestCaseDescription, SupplierPage.popUpModelSecondButton , "Button ");
		clickPopUpModelSecondButton = true;
		Thread.sleep(1500);		
	}
	
	
	/******************************************************************************************************************************************
	 * @author Jathu Jana
	 * @category THE METHOD FOR SUPPLIER PAGE - CLICK ANY POPUP MODEL CANCEL BUTTON (WITH FUNCTIONALITY CHECKING)
	 * @param TestCaseDescription
	 * @throws InterruptedException
	 *****************************************************************************************************************************************/
	public static void popUpModelFirstButtonFunctionAndClick(String TestCaseDescription) throws InterruptedException {

//		POM INITIALIZATION
		PageFactory.initElements(driver, sp);
		
//		CLICK POPUP FIRST BUTTON WITH FUNCTION CHECKING
		functionality.FunctionCheckWithClick(TestCaseDescription, SupplierPage.popUpModelFirstButton , "Button ");
		clickPopUpModelFirstButton = true;
		
	}
	
}
