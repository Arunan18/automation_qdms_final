/***********************************************************************************
* Description
*------------
*Production Sample New Status
* *****************************************************
*
* Author           : S.Quenthan
* Date Written     : 02.05.2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-PRODUCT-SAM-0148-155 02.05.2023   Quenthan     Orginal Version

************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleNewStatusTest extends DriverIntialization {
	@Test
   public static void newStatus() throws InterruptedException, IOException {
	   LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.productionSampleNavigation();
		Thread.sleep(2000);
		SampleStatus.sampleStatus("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0148",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 19, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div/div/li/div/span");
		Logout.LogoutFunction();
}

}
