
/****************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, Second Table,"Action" Column: "Edit" Icon Properties
 ****************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 11/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0676		    11/07/2023      Shangeetha    Original Version  
 ***************************************************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigAcceptedCriteriaTabActionColEditcon extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0676");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(2000);
		
		// Calling The Method To Check The Edit Icon Properties
		methodEditIconProperties(NavigateManageTestFromLogin.excelDataValue.get(1));

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodEditIconProperties(String searchCode) {		
		// Get Edit Icon Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure","TC-TCN-0676-02",driver.findElement(By.xpath("//td[text()='"+ searchCode +"']/following-sibling::td[5]//span[@class='anticon anticon-edit']")),"'Edit' Icon Properties");
	}
}


