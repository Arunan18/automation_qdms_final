
/***********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Review Test - Material Accepted Value -"Relevant To Result" Data Icon Properties
*
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-TCN-0829           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;

public class ReviewTestMAV_RelevantToResult_Icon extends DriverIntialization{


@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	
		TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0829-01", 2);
		
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0829-01");
		


//		Check Properties
		propertiesMaterialAcceptedValue_Value_Icon(TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));

		Logout.LogoutFunction();

	}

	public static void propertiesMaterialAcceptedValue_Value_Icon(String data) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0829-02", driver.findElement(By.xpath("//main/div/div/div[2]/div/div[2]/div/div[5]/div[1]//td[text()='"+data+"']/following-sibling::td[4]/span")), "Step-4--Material Accepted Value 'Value' Sub Heading Properties");

	}


	

}
