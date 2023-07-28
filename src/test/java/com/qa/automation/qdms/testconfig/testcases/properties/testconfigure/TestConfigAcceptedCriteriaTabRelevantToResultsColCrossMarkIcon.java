
/******************************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, "Material" Option, Second Table,"Relevant To Result" Column: 
 * "Cross Mark" Icon Properties
 ******************************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 13/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0674		    13/07/2023      Shangeetha    Original Version  
 *****************************************************************************************************************************************/


package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigAcceptedCriteriaTabRelevantToResultsColCrossMarkIcon extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0674");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(2000);
		
		// Calling The Method To Check The "Cross" Icon Properties
		methodCrossIconProperties(NavigateManageTestFromLogin.excelDataValue.get(1));

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodCrossIconProperties(String searchCode) {		
		// Get "Cross" Icon Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure","TC-TCN-0674-02",driver.findElement(By.xpath("//td[text()='"+ searchCode +"']/following-sibling::td[4]/span")),"'Cross' Icon Properties");
	}
}




