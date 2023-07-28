/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Material Page - Sub Module Material State Button Functionality 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (8) 	  	 	  TC-MATSTA-0002      	  13/03/2023       	 Niluxy			Original Version
*				   		 				  11/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialstate;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.GetMultiDataForTasks;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.pages.master.MaterialStatePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class MaterialStateButtonFunctionality extends DriverIntialization{

//	PAGE OBJECT MODEL FOR MATERIAL STATE PAGE
	public static MaterialStatePage msp = new MaterialStatePage();

//	DATA ARRAY LIST
	public static ArrayList<String> excelDataArray = GetMultiDataForTasks.adddata;
	
	@Test
	public static void function() throws InterruptedException {	

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
						
//					4.CHECKING MAIN METHOD
					materialStateButtonFunction();
					
				}
				
			}
			
		}
				
//		5.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	    	6.LOGOUT
			Logout.LogoutFunction();
	
		}
	}
	
	/***************************************************************************************
	 * @category METHOD FOR CHECKING FUNCTIONALITY MAIN METHOD
	 * @throws InterruptedException
	 ***************************************************************************************/
	public static void materialStateButtonFunction() throws InterruptedException {
		
//		POM INITIALIZATION
		PageFactory.initElements(driver, msp);
		
//		2.CLICK SUB MODULE MATERIAL STATE BUTTON WITH FUNCTION CHECKING AND NAVIGATE TO MATERIAL STATE PAGE
		functionality.FunctionCheckWithClick("Checking Material State Button Functionality", 
				MaterialStatePage.materialStateSubModule, "Button");
		
		if (functionality.Clicking) {
			functionality.Clicking = false;
			
//			GET DATA FROM EXCEL
			GetMultiDataForTasks.Data("Master Module.xlsx", "Material State", "TC-MATSTA-0002-01");
			
//			NAVIGATION AND COMPARATION
			functionality.NavigateAndComparePage(MaterialStatePage.mainTableTitle, excelDataArray.get(0));
			
		}

	}	

}
