/***********************************************************************************
* Description
*------------
* InProcess Sample Key test 
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 21/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  TC-PRO-SAM-0017       21/04/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.KeyTestCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProcessSampleKeyTest extends DriverIntialization{
	@Test
	public static void processsample() throws InterruptedException, IOException {
		
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.inprocessSampleNavigation();
		
		KeyTestCommonMethods.keyTest("Samples Module.xlsx", "Process Sample", "TC-PRO-SAM-0017-01", "TC-PRO-SAM-0017-09", 0, 19, 1);
		Logout.LogoutFunction();
	}

}
