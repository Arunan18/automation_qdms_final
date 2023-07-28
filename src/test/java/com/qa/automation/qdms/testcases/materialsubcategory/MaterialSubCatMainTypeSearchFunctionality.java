/*************************************************************************************************************************************
* DESCRIPTION
*-------------------------------------------------------------------------------------------------------------------------------------
* Checking Material Sub Category / Main Type Search Functionality
**************************************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ====================================================================================================================================
* 	No	 ||			Test Case Number 	 	 ||  	Date      ||  		    Intis     			||  	 Comments
* ====================================================================================================================================
*  (5) 	  			TC-MATSC-0027		      	     -  	    	Jathu, Shadurshi & Quenthan			Original Version
*  			(TC-MATSC-0028,TC-MATSC-0029)	      14/07/2023       	Jathu Jana     						Modified version (Rework)
*  													
**************************************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialsubcategory;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialSubCategoryPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentTypeSearchLastPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class MaterialSubCatMainTypeSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR MATERIAL SUB CATEGORY PAGE
	static MaterialSubCategoryPage mscp = new MaterialSubCategoryPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL SUB CATEGORY PAGE
		MaterialSubCategoryPageMethods.materialSubCategoryPageNavigation();
		
		if (MasterMainNavigationsTest.clicksubCategory) {
			MasterMainNavigationsTest.clicksubCategory = false;
		
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			mainTypeSearchFunctionanlity();
				
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

	/*******************************************************************************************************************
	 * @category MAIN METHOD FOR MAIN TYPE SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void mainTypeSearchFunctionanlity() throws IOException, InterruptedException {

//		DATA FROM EXCEL
		PlantEquipmentAddMethods.dataFromPlanEqupment("Material Sub Category", "TC-MATSC-0027-01");

//		POM INITIALIZATION
		PageFactory.initElements(driver, mscp);
		 
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		EquipmentTypeSearchLastPage.singledropDownearch(MaterialSubCategoryPage.SearchPopTextBox,4,PlantEquipmentAddMethods.equipData.get(0),"➢ Material Sub Category / Main Type Search Box ",
				PlantEquipmentAddMethods.equipData.get(1),PlantEquipmentAddMethods.equipData.get(2),PlantEquipmentAddMethods.equipData.get(3));
		
	}	
}