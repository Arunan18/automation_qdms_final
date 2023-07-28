/***********************************************************************************
* Description
*------------
* IN Comming Sample Progress Status Test
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 02.05.2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  // TC-INC-SAM-0182       02.05.2023   Quenthan     Orginal Version
* TC-INC-SAM-0183
* TC-INC-SAM-0184
* TC-INC-SAM-0185
* TC-INC-SAM-0186
* TC-INC-SAM-0187
* TC-INC-SAM-0188
* TC-INC-SAM-0189
* TC-INC-SAM-0190
* TC-INC-SAM-0191
* TC-INC-SAM-0192
* TC-INC-SAM-0193
* TC-INC-SAM-0194
* TC-INC-SAM-0195
* TC-INC-SAM-0196
* TC-INC-SAM-0197
* TC-INC-SAM-0198
* TC-INC-SAM-0199
* TC-INC-SAM-0200
* TC-INC-SAM-0201
* TC-INC-SAM-0202
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class inCommingSamplesProcessStatus extends DriverIntialization {
	@Test
	public static void statusCheck() throws InterruptedException, IOException {

		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();
		// TC-INC-SAM-0182
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0182",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0183
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0183",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0184
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0184",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0185
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0185",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0186
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0186",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0187
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0187",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0188
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0188",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0189
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0189",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0190
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0190",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0191
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0191",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0193
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0193",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0194
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0194",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0196
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0196",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0198
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0198",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0199
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0199",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0200
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0200",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");

		// TC-INC-SAM-0201
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0201",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 16, 18,
				"//div[@class='ant-modal-body']/div/div[", "]/div[1]/div/li/span");
//		Logout.LogoutFunction();

	}

}
