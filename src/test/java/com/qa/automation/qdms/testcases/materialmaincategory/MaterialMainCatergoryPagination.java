/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Material Main Category / Main Type Search Functionality
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	 TC-MATMC-0027      	  02/03/2023       Mithushiga		Original Version
*  										  08/03/2023	   Mithushiga		Modified version
*  										  07/04/2023	   Quenthan			Modified version
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.materialstate.MaterialStatePageMethods;

public class MaterialMainCatergoryPagination extends DriverIntialization {
	
	@Test
	public void matMainCategoryPagination() throws InterruptedException, IOException {	
	
//	1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
	MaterialStatePageMethods.materialPageNavigation();
	
	if (MasterMainNavigationsTest.clickMaterialMain) {		
		MasterMainNavigationsTest.clickMaterialMain = false;
		
//		2.CLICK MATERIAL MAIN CATEGORY SUB MODULE
		MasterMainNavigationsTest.navigateMaterialMainCategory();
		if (MasterMainNavigationsTest.matmaincat) {
			MasterMainNavigationsTest.matmaincat = false;
			
//			3.CHECKING PAGINATION MAIN METHOD
			pagination();
			
		}

	}
	
//	3.REFRESH
	driver.navigate().refresh();
	Thread.sleep(1000);
	
	if (LoginTest.login) {
		
		LoginTest.login = false;
		
//    	4.LOGOUT
		Logout.LogoutFunction();

	}
}

	/*************************************************************************************************************
	 * @category MAIN METHOD FOR PAGINATION
	 *************************************************************************************************************/
   	public static void pagination() {
	
//		CHECK MATERIAL MAIN CATEGORY PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Material Main Category", "TC-MATMC-0027-01", 
				"Checking Material Main Category Pagination Functionality");

   	}

}
