/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Material Sub Category Pagination
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	 TC-MATSC-0030      	  23/02/2023       Sayanthan		Original Version
*  										  02/03/2023 	   Shadurshi		Modified version		
*				   		 				  12/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.materialsubcategory;

import java.io.IOException;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.materialstate.MaterialStatePageMethods;

public class MaterialSubCatergoryPagination extends DriverIntialization {
	
	@Test
	public void matSubCategoryPagination() throws InterruptedException, IOException {	
	
//	1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
	MaterialStatePageMethods.materialPageNavigation();
	
	if (MasterMainNavigationsTest.clickMaterialMain) {		
		MasterMainNavigationsTest.clickMaterialMain = false;
		
//		2.CLICK MATERIAL SUB CATEGORY SUB MODULE
		MasterMainNavigationsTest.navigateMaterialSubCategory();
		if (MasterMainNavigationsTest.clicksubCategory) {	
			MasterMainNavigationsTest.clicksubCategory = false;
			
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
	
//		CHECK MATERIAL SUB CATEGORY PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Material Sub Category",
				"TC-MATSC-0030-01", "Checking Material Sub Category Pagination Functionality");

   	}

}
