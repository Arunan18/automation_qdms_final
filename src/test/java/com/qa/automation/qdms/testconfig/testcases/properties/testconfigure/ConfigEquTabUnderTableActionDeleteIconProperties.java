
/***************************************************************************************************************
 * Description
 *------------
 * Test Configure - Configure Test Table-  Configure Equation Tab - Equation Type- Action Column
 * "Delete Icon" Properties
 ***************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 08/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0610			 08/07/2023   Shangeetha    Original Version  
 **************************************************************************************************************/


package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigEquTabUnderTableActionDeleteIconProperties extends DriverIntialization{
	
	@Test
	public static void configureEquation() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0610");

		// Calling The Method For Navigate To Test Configure Module-Configure Equation Tab
		TestConfigMethods.navigate_TestConfigureTabs(3);
        Thread.sleep(1000);
        
		// Calling The Method To Check The Delete Icon Properties
		methodDeleteIconProperties(NavigateManageTestFromLogin.excelDataValue.get(1));

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodDeleteIconProperties(String searchCode) {		
		// Get Delete Icon Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure","TC-TCN-0610-02",driver.findElement(By.xpath("//td[text()='"+ searchCode +"']/following-sibling::td[3]//span[@class='anticon anticon-delete']")),"'Delete' Icon Properties");
	}
}
