/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Edit Material State Cancel Button Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (5) 	  	 	  TC-MATSTA-0039      	  21/03/2023       Niluxy			Original Version
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


public class EditMaterialStateCancelButtonFunctionality extends DriverIntialization {

//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialStatePageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterialState) {
			
			MasterMainNavigationsTest.clickMaterialState = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			searchEditDataClickAndCheckEditMatStateCancelButtonFunctionanlity();
	
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
	 * @category MAIN METHOD FOR SEARCH EDIT DATA AND CHECKING EDIT MATERIAL STATE CANCEL FUNCTIONALITY
	 * @throws InterruptedException
	 * @throws IOException
	 **************************************************************************************************************************************/
	public static void searchEditDataClickAndCheckEditMatStateCancelButtonFunctionanlity() throws InterruptedException, IOException {
		
//		GET DATA BY EXCEL FOR EDIT MATERIAL STATE ICON
		DataFromExcelByAnyColumn.getExcelDataForIcon("Master Module","Material State","TC-MATSTA-0039-01", 1, 1, 1, "edit");
		
//		CLICK THAT EDIT MATERIAL STATE ICON
		DataFromExcelByAnyColumn.getElement();
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		CHECKING EDIT MATERIAL STATE CANCEL FUNCTION
		if (DataFromExcelByAnyColumn.status) {
			
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Edit Material State Cancel Button Functionality ",
					MaterialStatePage.popUpModelFirstButton , MaterialStatePage.popUpModel );

		}
		
	}
	
}
