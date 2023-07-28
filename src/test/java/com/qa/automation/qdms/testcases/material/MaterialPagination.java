/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Material Pagination 
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	 TC-MAT-0063      	  	  08/03/2023       Sasikala 		Original Version
*				   		 				  07/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.materialstate.MaterialStatePageMethods;

public class MaterialPagination extends DriverIntialization{
	
	@Test
	public void materialPagination() throws InterruptedException, IOException {	
	
//	1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
	MaterialStatePageMethods.materialPageNavigation();
	
	if (MasterMainNavigationsTest.clickMaterialMain) {		
		MasterMainNavigationsTest.clickMaterialMain = false;
		
//		2.CLICK MATERIAL SUB MODULE
		MasterMainNavigationsTest.navigateMaterial();
		if (MasterMainNavigationsTest.clickMaterial) {
			
			MasterMainNavigationsTest.clickMaterial = false;
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
	
//		CHECK MATERIAL PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Material", "TC-MAT-0063-01", 
				"➢ Checking Source Pagination Functionality");

   	}

}
