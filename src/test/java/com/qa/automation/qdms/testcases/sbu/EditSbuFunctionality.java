/***********************************************************************************
* Description
*------------
* Edit SBU Button Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 13/03/2023
* 
*
* 
* Test Case Number   		  	   	  Date         Intis        Comments
* ================    		   		  ====         =====        ========
*   TC-SBU-0038				         13/03/2023     Arunan     Orginal Version

************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EditSbuFunctionality extends DriverIntialization {

	@Test
	public static void editSbu() {
		SbuMethods.navigateSbu("TC-SBU-0038 - SBU Edit Function");

		if (MasterMainNavigationsTest.clickSbu) {
			SbuMethods.editSbu("Master Module", "SBU", "TC-SBU-0038");
		}
		SbuMethods.logout();

	}
}
