/***********************************************************************************
* Description
*------------
* inComming Sample Multi Search
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  TC-INC-SAM-0017      28/04/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.testcases.inprocesssample.ProcessSampleMultiSearch;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncomingSampleMultiSearch extends DriverIntialization {
	@Test
public static void Multi() throws InterruptedException, IOException {
	IncomingSamplePage hj=new IncomingSamplePage();
	PageFactory.initElements(driver, hj);
	LoginTest.Login();
	SampleNavigateTest.sampleNavigation();
	SampleNavigateTest.rawMaterialSampleMainNavigation();
	SampleNavigateTest.incommingSampleNavigation();
	Thread.sleep(2000);
	
	ProcessSampleMultiSearch.multiSearch("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0017-01",IncomingSamplePage.processSampleTable,1);
	Logout.LogoutFunction();
}
}
