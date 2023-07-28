/***********************************************************************************
* Description
*------------
*PlantLabTrail Fail Status
* *****************************************************
*
* Author           : S.Quenthan
* Date Written     : 02.05.2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0138-152  02.05.2023   Quenthan     Orginal Version

************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class PlantLabTrailFailStatusTest extends DriverIntialization {
	@Test
	public static void failStatus() throws InterruptedException, IOException {
		LoginTest.Login();
		SampleNavigateTest.sampleNavigation();
		SampleNavigateTest.finishProductSampleMainNavigation();
		SampleNavigateTest.labTrialSampleNavigation();

		driver.findElement(By.xpath("(//td[contains(@class,'ant-table-cell')])[1]")).click();

		ScrollRight.scroll(4);

		SampleStatus.sampleStatus("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0138",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 4, 10, 8,
				"//div[@class='ant-modal-body']/div/div[", "]/div/div/li/div/span");
		Logout.LogoutFunction();
	}

}
