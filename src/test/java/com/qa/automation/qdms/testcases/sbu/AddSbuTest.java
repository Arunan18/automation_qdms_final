/***********************************************************************************
* Description
*------------
* Add SBU Functionality
* Add SBU Button Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 13/03/2023
* 
*
* 
* Test Case Number   		  	   	  Date         Intis        Comments
* ================    		   		  ====         =====        ========
*   TC-SBU-0030                       13/03/2023     Arunan     Orginal Version
*   TC-SBU-0030                 	  05/07/2023     Arunan     Upadated Version
 
************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class AddSbuTest extends DriverIntialization {

	@Test
	public static void addSbuFunctionality() {

		SbuMethods.navigateSbu("TC-SBU-0030 - SBU Add Function");

		if (MasterMainNavigationsTest.clickSbu) {
			SbuMethods.inputSbuValue("TC-SBU-0030", "SBU", "add");
		}
		SbuMethods.logout();

	}
}
