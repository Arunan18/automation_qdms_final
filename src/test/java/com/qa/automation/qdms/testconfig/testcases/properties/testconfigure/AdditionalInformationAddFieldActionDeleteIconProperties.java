//*****************************************************************************************************************************************************
//* Description
//*------------
//* Test Configure Configure Test Table Top Bar Additional Information Add Field Action Delete Icon Properties
//*****************************************************************************************************************************************************
//*
//* Author           :M.Mathushan
//* Date Written     :14/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0795			14/07/2023    M.Mathushan   Original Version  
//*                    
//*****************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AdditionalInformationAddFieldActionDeleteIconProperties extends DriverIntialization {

	@Test
	public static void informationAddFieldActionDeleteIconProperties()
			throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0795");
		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0795-01");

		// Calling The Method For Navigate To Test Configure Module-Additional
		// Information

		TestConfigMethods.navigate_TestConfigureTabs(7);
		Thread.sleep(2000);


		// Check InformationAdditional Information Add Field Action Edit Icon Caption
		// Status Check box Properties
		addFieldActionDeleteIconProperties(TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	// Check InformationAdditional Information Add Field Action Delete Icon Status Properties
	public static void addFieldActionDeleteIconProperties(String Value) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0795-02",
				driver.findElement(By.xpath("//*[text()='"+Value+"']/following-sibling::td[4]/span/a[2]")),
				"Additional Information  Add Field Status Add Field Action Delete Icon Properties");

	}
}
