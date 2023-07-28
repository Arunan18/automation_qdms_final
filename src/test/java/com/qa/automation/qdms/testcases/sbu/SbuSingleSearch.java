/***********************************************************************************
* Description
*------------
*SEARCH IN SBU
***********************************************************************************
*
* Author           : Arunan
* Date Written     : 12/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-SBU-0011		   12/0/2023      Arunan     Check "Search" TextBox Functionality (Input)
* TC-SBU-0013          12/0/2023      Arunan     Check "Search" Button Functionality
* TC-SBU-0015          12/0/2023      Arunan     Check "Reset" Button Functionality
*
************************************************************************************/
package com.qa.automation.qdms.testcases.sbu;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class SbuSingleSearch extends DriverIntialization {

	@Test
	public static void singleSearch() {
		SbuPage sp = new SbuPage();
		PageFactory.initElements(driver, sp);

		SbuMethods.navigateSbu("TC-SBU-0013 - SBU Single Search Function");

		if (MasterMainNavigationsTest.clickSbu) {
			com.qa.automation.qdms.commonmethods.SingleSearch.singleSearchMethod(1,
					SbuPage.SearchTextBox,  "Master Module", "SBU", "TC-SBU-0013", 1, 2);
		}

		SbuMethods.logout();
	}

}
