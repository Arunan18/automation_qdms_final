/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Delete Designation - Cancel Button Functionality
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||     Intis     ||   Comments
* ========================================================================================================
*  (6) 	  	 	  TC-DES-0048      	      13/03/2023		 Volta			Original Version
*				   		 				  06/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.DataFromExcelByAnyColumn;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteDesignationCancelButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();
		
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
		if (MasterMainNavigationsTest.clickDesignation) {
			
			MasterMainNavigationsTest.clickDesignation = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			searchDeleteDataClickAndCheckEditDesiCancelButtonFunctionanlity();
	
		}
		
//		3.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	     	4.LOGOUT
			Logout.LogoutFunction();
	
		}
	}


	/**************************************************************************************************************************************
	 * @category MAIN METHOD FOR SEARCH DELETE DATA AND CHECKING DELETE DESIGNATION FUNCTIONALITY
	 * @throws InterruptedException
	 * @throws IOException
	 **************************************************************************************************************************************/
	public static void searchDeleteDataClickAndCheckEditDesiCancelButtonFunctionanlity() throws InterruptedException, IOException {
		
//		GET DATA BY EXCEL FOR DELETE DESIGNATION ICON
		DataFromExcelByAnyColumn.getExcelDataForIcon("Master Module","Designation","TC-DES-0048-01", 1, 1, 2, "delete");
		
//		CLICK THAT DELETE DESIGNATION ICON
		DataFromExcelByAnyColumn.getElement();
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CHECKING DELETE DESIGNATION CANCEL FUNCTION
		if (DataFromExcelByAnyColumn.status) {
			
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Delete Designation Cancel Button Functionality ",
					DesignationPage.innerPopUpFirstButton , DesignationPage.innerPopUp );

		}
		
	}
		
}
