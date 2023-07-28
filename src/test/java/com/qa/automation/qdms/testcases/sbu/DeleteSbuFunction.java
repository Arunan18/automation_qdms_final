/***********************************************************************************
* Description
*------------
* Delete SBU Button Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 13/03/2023
* 
*
* 
* Test Case Number   		  	   	  Date         Intis        Comments
* ================    		   		  ====         =====        ========
*   TC-SBU-0044				        13/03/2023     Arunan     Orginal Version

************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class DeleteSbuFunction extends DriverIntialization {
	static SbuPage sp = new SbuPage();
	static String sbuName = null;
	static String des = null;
	static DataFormatter dataValue = new DataFormatter();

	@Test
	public static void deleteSbu() {

		PageFactory.initElements(driver, sp);

		SbuMethods.navigateSbu("TC-SBU-0044 - SBU Delete Function");

		if (MasterMainNavigationsTest.clickSbu) {
			deleteFunction.clickDelete("Master Module", "SBU", "TC-SBU-0044", "SBU");
		}

		if (LoginTest.login) {
			MultiSearchMethods.Logout();
		}

	}

}
