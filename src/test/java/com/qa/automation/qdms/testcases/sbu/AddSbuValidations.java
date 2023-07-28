/***********************************************************************************
* Description
*------------
* Check Add SBU Form Validation
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 13/03/2023
* 
*
* 
* Test Case Number   		  	   	  Date         Intis        Comments
* ================    		   		  ====         =====        ========
*  TC-SBU-0031  			       13/03/2023     Arunan     Orginal Version

************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class AddSbuValidations extends DriverIntialization {


	@Test
	public static void addSbuFunctionality(){

		SbuMethods.navigateSbu("TC-SBU-0031 - SBU Add Validation");
		
		if (MasterMainNavigationsTest.clickSbu) {
			SbuMethods.inputSbuValue("TC-SBU-0031", "SBU","validation");
		}
		SbuMethods.logout();
		 
	}
}
