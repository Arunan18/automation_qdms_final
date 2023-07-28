/***********************************************************************************
* Description
*------------
* Incoming Sample Key test 
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 21/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  TC-INC-SAM-0019       21/04/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.KeyTestCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncomingSampleKeytest  extends DriverIntialization{
	@Test
	public static void keytest() throws InterruptedException, IOException {
		
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();
		
		KeyTestCommonMethods.keyTest("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0019-01", "TC-INC-SAM-0019-08",  0, 21, 1);
	
		Logout.LogoutFunction();
	
	}
}
