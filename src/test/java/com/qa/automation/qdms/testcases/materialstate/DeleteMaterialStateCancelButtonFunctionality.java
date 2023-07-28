/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Delete Material State Cancel Button Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (6) 	  	 	  TC-MATSTA-0045      	  22/03/2023       Niluxy			Original Version
*				   		 				  07/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.DataFromExcelByAnyColumn;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteMaterialStateCancelButtonFunctionality extends DriverIntialization {

//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialStatePageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterialState) {
			
			MasterMainNavigationsTest.clickMaterialState = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			searchDeleteDataClickAndCheckDeleteMatStateCancelButtonFunctionanlity();
	
		}
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	    	4.LOGOUT
			Logout.LogoutFunction();
	
		}
	}


	/**************************************************************************************************************************************
	 * @category MAIN METHOD FOR SEARCH DELETE DATA AND CHECKING DELETE MATERIAL STATE FUNCTIONALITY
	 * @throws InterruptedException
	 * @throws IOException
	 **************************************************************************************************************************************/
	public static void searchDeleteDataClickAndCheckDeleteMatStateCancelButtonFunctionanlity() throws InterruptedException, IOException {
		
//		GET DATA BY EXCEL FOR DELETE MATERIAL STATE ICON
		DataFromExcelByAnyColumn.getExcelDataForIcon("Master Module","Material State","TC-MATSTA-0045-01", 1, 1, 1, "delete");
		
//		CLICK THAT DELETE MATERIAL STATE ICON
		DataFromExcelByAnyColumn.getElement();
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CHECKING DELETE MATERIAL STATE CANCEL FUNCTION
		if (DataFromExcelByAnyColumn.status) {
			
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Delete Material State Cancel Button Functionality ",
					MaterialStatePage.innerPopUpFirstButton , MaterialStatePage.innerPopUp );
	
		}
	}
	
}
