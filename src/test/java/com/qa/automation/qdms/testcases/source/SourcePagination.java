/*********************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------------
* Checking Source Pagination
**********************************************************************************************************
*
* @author 	 : 	Jathu Jana
* 
* ========================================================================================================
* 	No	 ||		Test Case Number 	  ||  	Date      ||      Intis     ||   Comments
* ========================================================================================================
*  (1) 	  	 	 TC-SRC-0023         	  08/03/2023       Sasikala 		Original Version
*				   		 				  07/07/2023       Jathu Jana       Modified version (Rework)
**********************************************************************************************************/

package com.qa.automation.qdms.testcases.source;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;
import com.qa.automation.qdms.testcases.materialstate.MaterialStatePageMethods;

public class SourcePagination extends DriverIntialization {
	
	@Test
	public void matSourcePagination() throws InterruptedException, IOException {	
	
//	1.DIRECTLY NAVIGATE TO MATERIAL STATE PAGE
	MaterialStatePageMethods.materialPageNavigation();
	
	if (MasterMainNavigationsTest.clickMaterialMain) {		
		MasterMainNavigationsTest.clickMaterialMain = false;
		
//		2.CLICK SOURCE SUB MODULE
		MasterMainNavigationsTest.navigateSource();
		if (MasterMainNavigationsTest.clickSource) {
				
			MasterMainNavigationsTest.clickSource = false;
			
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
	
//		CHECK SOURCE PAGINATION USING PAGINATION COMMON METHOD
		materialMethodes.paginationnew("Master Module", "Source", "TC-SRC-0023-01", 
				"Checking Source Pagination Functionality");

   	}

}
