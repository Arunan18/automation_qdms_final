/*****************************************************************************************************************
* DESCRIPTION
*-----------------------------------------------------------------------------------------------------------------
* Checking Material Main Category / Main Type Pagination
******************************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ================================================================================================================
* 	No	 ||			Test Case Number 		  ||  	Date      ||      Intis     ||   Comments
* ================================================================================================================
*  (2) 	  	 		 TC-MATMC-0024      	     09/03/2023		   Mithusika		Original Version
*  			 (TC-MATMC-0025,TC-MATMC-0026)	     14/07/2023        Sasikala  		Modified Version
*  												 25/07/2023	  	  Jathu Jana		Modified version (Rework)
******************************************************************************************************************/

package com.qa.automation.qdms.testcases.materialmaincategory;


import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.testcases.Equipment.EquipmentTypeSearchLastPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.materialstate.MaterialStatePageMethods;
import com.qa.automation.qdms.testcases.plantequipment.PlantEquipmentAddMethods;


public class MaterialMainCategoryMainTypeSearchFunctionality extends DriverIntialization {

//	PAGE OBJECT MODEL FOR MATERIAL MAIN CATEGORY PAGE
	static MaterialMainCategoryPage mmcp = new MaterialMainCategoryPage();
	
	@Test
	public void function() throws InterruptedException, IOException {	
		
//		1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
		MaterialStatePageMethods.materialPageNavigation();
		
		if (MasterMainNavigationsTest.clickMaterialMain) {		
			MasterMainNavigationsTest.clickMaterialMain = false;
			
//			2.CLICK MATERIAL MAIN CATEGORY SUB MODULE
			MasterMainNavigationsTest.navigateMaterialMainCategory();
			if (MasterMainNavigationsTest.matmaincat) {
				MasterMainNavigationsTest.matmaincat = false;
				
//				3.CHECKING FUNCTIONALITY MAIN METHOD
				mainCategoryMainTypeSearchFunctionanlity();
				
			}
	
		}
		
//		4.REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		if (LoginTest.login) {
			
			LoginTest.login = false;
			
//	    	5.LOGOUT
			Logout.LogoutFunction();
	
		}
}

	/*******************************************************************************************************************
	 * @category MAIN METHOD FOR MAIN TYPE SEARCH FUNCTIONALITY
	 * @throws IOException 
	 * @throws InterruptedException 
	 *******************************************************************************************************************/
	public static void mainCategoryMainTypeSearchFunctionanlity() throws IOException, InterruptedException {

//		DATA FROM EXCEL
		PlantEquipmentAddMethods.dataFromPlanEqupment("Material Main Category", "TC-MATMC-0024-01");

//		POM INITIALIZATION
		PageFactory.initElements(driver, mmcp);
			 
//		CHECKING SEARCH FUNCTION SEARCH FUNCTIONALITY COMMON METHOD
		EquipmentTypeSearchLastPage.singledropDownearch(MaterialMainCategoryPage.SearchPopTextBox,3,PlantEquipmentAddMethods.equipData.get(0),"➢ Material Main Category / Main Type",
				PlantEquipmentAddMethods.equipData.get(1),PlantEquipmentAddMethods.equipData.get(2),PlantEquipmentAddMethods.equipData.get(3));

	}

}

