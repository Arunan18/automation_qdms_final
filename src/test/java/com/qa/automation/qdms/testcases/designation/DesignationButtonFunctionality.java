/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Designation Page - Sub Module Designation Button Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (8) 	  	 	  TC-DES-0005      	 	  13/03/2023       	 Volta			Original Version
*				   		 				  11/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.designation;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.GetMultiDataForTasks;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.DesignationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DesignationButtonFunctionality extends DriverIntialization{

//	PAGE OBJECT MODEL FOR DESIGNATION PAGE
	public static DesignationPage dp = new DesignationPage();

//	DATA ARRAY LIST
	public static ArrayList<String> excelDataArray = GetMultiDataForTasks.adddata;
	
	@Test
	public static void function() throws InterruptedException {
		
//		1.DIRECTLY NAVIGATE TO DESIGNATION PAGE
		DesignationPageMethods.designationPageNavigation();

		if (MasterMainNavigationsTest.clickDesignation) {
			MasterMainNavigationsTest.clickDesignation = false;
			
//			2.CHECKING MAIN METHOD
			desiButtonFunction();
			
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
	
	/***************************************************************************************
	 * @category METHOD FOR CHECKING FUNCTIONALITY MAIN METHOD
	 * @throws InterruptedException
	 ***************************************************************************************/
	public static void desiButtonFunction() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, dp);
		
//		2.CLICK SUB MODULE DESIGNATION BUTTON WITH FUNCTION CHECKING AND NAVIGATE TO DESIGNATION PAGE
		functionality.FunctionCheckWithClick("Checking Designation Button Functionality", 
				DesignationPage.desiSubModule, "Button");
		
		if (functionality.Clicking) {
			functionality.Clicking = false;
			
//			GET DATA FROM EXCEL
			GetMultiDataForTasks.Data("Master Module.xlsx", "Designation", "TC-DES-0005-01");
			
//			NAVIGATION AND COMPARATION
			functionality.NavigateAndComparePage(DesignationPage.mainTableTitle, excelDataArray.get(0));
			
		}

	}
	
}
