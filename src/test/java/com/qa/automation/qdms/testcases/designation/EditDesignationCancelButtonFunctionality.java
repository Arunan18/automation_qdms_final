/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Edit Designation - Cancel Button Functionality
**********************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||     Intis     ||   Comments
* ========================================================================================================
*  (5) 	  	 	  TC-DES-0039      	      13/07/2023		 Volta			Original Version
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

public class EditDesignationCancelButtonFunctionality extends DriverIntialization{
	
//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();
		
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();
		
		if (MasterMainNavigationsTest.clickDesignation) {
			
			MasterMainNavigationsTest.clickDesignation = false;
			
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			searchEditDataClickAndCheckEditDesiCancelButtonFunctionanlity();
	
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
	 * @category MAIN METHOD FOR SEARCH EDIT DATA AND CHECKING EDIT DESIGNATION CANCEL FUNCTIONALITY
	 * @throws InterruptedException
	 * @throws IOException
	 **************************************************************************************************************************************/
	public static void searchEditDataClickAndCheckEditDesiCancelButtonFunctionanlity() throws InterruptedException, IOException {
		
//		GET DATA BY EXCEL FOR EDIT DESIGNATION ICON
		DataFromExcelByAnyColumn.getExcelDataForIcon("Master Module","Designation","TC-DES-0039-01", 1, 1, 2, "edit");
		
//		CLICK THAT EDIT DESIGNATION ICON
		DataFromExcelByAnyColumn.getElement();
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		CHECKING EDIT DESIGNATION CANCEL FUNCTION
		if (DataFromExcelByAnyColumn.status) {
			
			functionality.checkingCancelOrCloseFunctionanlity("➢ Checking Edit Designation Cancel Button Functionality ",
					DesignationPage.popUpModelFirstButton , DesignationPage.popUpModel );

		}	
	}
			
}
