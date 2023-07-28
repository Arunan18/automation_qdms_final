//**************************************************************************************************************************
//* Description
//*------------
//*Test Configure Configure Test Table  Top Bar Additional Information Add Field Status Check Box Properties
//**************************************************************************************************************************
//*
//* Author           :M.Mathushan
//* Date Written     :13/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0783			13/07/2023    M.Mathushan   Original Version  
//*                    
//**************************************************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AdditionalInformationAddFieldStatusCheckBoxProperties extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();

	@Test
	public static void informationAddFieldStatusCheckBoxProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0783");
		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0783-01");

		// Calling The Method For Navigate To Test Configure Module-Additional
		// Information

		TestConfigMethods.navigate_TestConfigureTabs(7);
		Thread.sleep(2000);

		// Check Test Configure Module Additional Information Add Field Status Check Box
		// Properties

		addFieldStatusCheckBoxProperties(TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	// Check Test Configure Module Additional Information Add FieldStatus Check Box
	// Properties
	public static void addFieldStatusCheckBoxProperties(String value) {
		

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0783-02",
				driver.findElement(By.xpath("//*[text()='" + value + "']/following-sibling::td[3]/label/span")),
				"Additional Information  Add Field Status Check Box PropertiesProperties");

	}
}
