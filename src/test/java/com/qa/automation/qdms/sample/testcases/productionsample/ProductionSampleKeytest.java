package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.KeyTestCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleKeytest extends DriverIntialization {
	@Test
	public static void keyTest() throws InterruptedException, IOException {
		
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		KeyTestCommonMethods.keyTest("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0017-01", "TC-PRODUCT-SAM-0017-08", 0, 23, 1);
		Logout.LogoutFunction();
		
	}

}
