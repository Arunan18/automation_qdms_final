/***********************************************************************************
* Description
*------------
* Plant Lab Trial Sample MultiSearch
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  TC-P-LAB-SAM-0017     28/04/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class PlantLabTrialSampleMultiSearch extends DriverIntialization {
	@Test
	public static void multiSearch() throws InterruptedException, IOException {
		IncomingSamplePage hj=new IncomingSamplePage();
		PageFactory.initElements(driver, hj);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.labTrialSampleNavigation();
		Thread.sleep(2000);
		
		ProcessSampleMultiSearch.multiSearch("Samples Module.xlsx", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0017-01",IncomingSamplePage.processSampleTable,1);
		Logout.LogoutFunction();
		
	}

}


