
/***********************************************************************************
* Description
*------------
* IN Process Sample PAss Status
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  TC-PRO-SAM-0201       28/04/2023   Quenthan     Orginal Version
*TC-PRO-SAM-0198
*TC-PRO-SAM-0199
* TC-PRO-SAM-200
* TC-PRO-SAM-0202
* TC-PRO-SAM-0203
* TC-PRO-SAM-0204
* TC-PRO-SAM-0205
* TC-PRO-SAM-0206
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class inProcessSamplePassStatus extends DriverIntialization {
	@Test
	public static void statusChange() throws InterruptedException, IOException {
		ProcessSampleMultiSearch lk = new ProcessSampleMultiSearch();
		PageFactory.initElements(driver, lk);
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.inprocessSampleNavigation();
		Thread.sleep(2000);
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0201",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);
		// TC-PRO-SAM-0198
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0198",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//		TC-PRO-SAM-0199
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0199",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//		 TC-PRO-SAM-200
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0200",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//		TC-PRO-SAM-0202
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0202",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//		TC-PRO-SAM-0203
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0203",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//		TC-PRO-SAM-0204
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0204",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//		TC-PRO-SAM-0205
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0205",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
		driver.navigate().refresh();
		Thread.sleep(1000);

//	TC-PRO-SAM-0206	
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0206",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		Logout.LogoutFunction();
	}

}
