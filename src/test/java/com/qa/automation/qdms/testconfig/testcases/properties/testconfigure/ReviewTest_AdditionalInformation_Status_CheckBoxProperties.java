/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - Additional Information -"Status" Check Box  Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 10/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0851           23/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;

public class ReviewTest_AdditionalInformation_Status_CheckBoxProperties extends DriverIntialization{


@Test
	public void modalproperties() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0851-01", 2);
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0851-01");
		ArrayList<String> data=TestConfiRev_MaterialSubHeadingProperties.adddata;


//		Check Properties
		propertiesAdditionalInformationSCheckBoxSubheading(data.get(1));

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesAdditionalInformationSCheckBoxSubheading(String box) {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]//td[1][contains(text(),'"+box+"')]/following-sibling::td[3]//input/.."))));
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0851-02", driver.findElement(By.xpath("//main/div/div/div[2]/div/div[2]/div/div[7]/div[1]//td[1][contains(text(),'"+box+"')]/following-sibling::td[3]//input/..")), "Step-4--Additional Information Status Check Box Properties");

	}














}
