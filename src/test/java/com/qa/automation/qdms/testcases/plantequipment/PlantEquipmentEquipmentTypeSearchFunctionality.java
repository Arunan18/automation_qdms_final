/*************************************************************************************************************************************
* DESCRIPTION
*-------------------------------------------------------------------------------------------------------------------------------------
* Checking Plant Equipment / Equipment Type Search Functionality
**************************************************************************************************************************************
*
* @author 	 : Jathu Jana
* 
* ====================================================================================================================================
* 	No	 ||			Test Case Number 	 	 ||  	Date      ||      Intis     ||  	 Comments
* ====================================================================================================================================
*  (1) 	  		    TC-PLA-EQU-0050		      	   20/03/2023	    Vithusha		Original Version
*  			(TC-PLA-EQU-0051,TC-PLA-EQU-0052)	   17/07/2023      Jathu Jana     	Modified version (Rework)
**************************************************************************************************************************************/

package com.qa.automation.qdms.testcases.plantequipment;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.PlantEquipmentPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentTypeSearchLastPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantEquipmentEquipmentTypeSearchFunctionality extends DriverIntialization {
	
//	PAGE OBJECT MODEL FOR PLANT EQUIPMENT PAGE
	static PlantEquipmentPage pep = new PlantEquipmentPage();
	
	@Test
	public static void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO PLANT EQUIPMENT PAGE
		PlantEquipmentPageMethods.plantEquipmentPageNavigation();;
		
		if (MasterMainNavigationsTest.plntEquipmentclick) {
			MasterMainNavigationsTest.plntEquipmentclick = false;
		
//			2.CHECKING FUNCTIONALITY MAIN METHOD
			typeSearchFunctionanlity();
				
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
	 * @category MAIN METHOD FOR TYPE SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void typeSearchFunctionanlity() throws IOException, InterruptedException {

//		DATA FROM EXCEL
		PlantEquipmentAddMethods.dataFromPlanEqupment("Plant Equipment", "TC-PLA-EQU-0050-01");

//		POM INITIALIZATION
		PageFactory.initElements(driver, pep);
		 
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		EquipmentTypeSearchLastPage.singledropDownearch(PlantEquipmentPage.SearchPopTextBox,3,PlantEquipmentAddMethods.equipData.get(0),"➢ Plant Equipment / Equipment Type ",
				PlantEquipmentAddMethods.equipData.get(1),PlantEquipmentAddMethods.equipData.get(2),PlantEquipmentAddMethods.equipData.get(3));
		
	}
	
}
