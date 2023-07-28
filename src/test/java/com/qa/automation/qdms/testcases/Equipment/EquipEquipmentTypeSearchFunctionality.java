/*************************************************************************************************************************************
* DESCRIPTION
*-------------------------------------------------------------------------------------------------------------------------------------
* Checking Equipment / Equipment Type Search Functionality
**************************************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ====================================================================================================================================
* 	No	 ||				Test Case Number 	 		 ||  	Date      ||      Intis     ||  	 Comments
* ====================================================================================================================================
*  (2) 	  				  TC-EQU-0056		      	      09/03/2023	       Gobi			Original Version
*  			(TC-EQU-0020,TC-EQU-0022,TC-EQU-0023)	      14/07/2023       	Jathu Jana     	Modified version (Rework)
*  													
**************************************************************************************************************************************/

package com.qa.automation.qdms.testcases.Equipment;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EquipmentPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;

public class EquipEquipmentTypeSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR EQUIPMENT PAGE
	static EquipmentPage ep = new EquipmentPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO EQUIPMENT PAGE
		EquipmentPageMethods.equipmentPageNavigation();;
		
		if (MasterMainNavigationsTest.Equipmentclick) {
			MasterMainNavigationsTest.Equipmentclick = false;
		
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			equipmentTypeSearchFunctionanlity();
				
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
	 * @category MAIN METHOD FOR EQUIPMENT TYPE SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void equipmentTypeSearchFunctionanlity() throws IOException, InterruptedException {

//		DATA FROM EXCEL
		PlantEquipmentAddMethods.dataFromPlanEqupment("Equipment", "TC-EQU-0056-01");

//		POM INITIALIZATION
		PageFactory.initElements(driver,ep);
		 
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		EquipmentTypeSearchLastPage.singledropDownearch(EquipmentPage.SearchPopTextBox,3,PlantEquipmentAddMethods.equipData.get(0),"➢ Equipment / Equipment Type Search Box ",
				PlantEquipmentAddMethods.equipData.get(1),PlantEquipmentAddMethods.equipData.get(2),PlantEquipmentAddMethods.equipData.get(3));
		
	}	
}
