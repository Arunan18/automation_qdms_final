/***********************************************************************************
* Description
*------------
* If sample Already conducted Check the To trail - (Update trail - one Trail)
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 16/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0285     18/05/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.TrailsTestFinishProduct;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class UpdateTrail_Multi extends DriverIntialization {
	@Test
public static void updateMulti() throws InterruptedException, IOException {


		/**********************************************************************************
		 * STEP-01--Navigate Page
		 **********************************************************************************/

		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
        Thread.sleep(1000);
		/**********************************************************************************
		 * STEP-02--Make Single Update Trail Test 
		 **********************************************************************************/
        TrailsTestFinishProduct.trailsTest("Samples Module.xlsx", "Production Sample", "TC-PRODUCT-SAM-0286",
				driver.findElement(By.xpath("//div[@class='ant-table-container']")), 17);
        Thread.sleep(1500);
Logout.LogoutFunction();
		
		
	
		
		
	
	
}
}
