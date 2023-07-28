//*****************************************************************************************************************************************************
//* Description
//*------------
//* Test Configure Configure Test Table Top Bar Additional Information Add Field Action Edit Icon Caption Text Box UI Properties
//*****************************************************************************************************************************************************
//*
//* Author           :M.Mathushan
//* Date Written     :14/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0791			14/07/2023    M.Mathushan   Original Version  
//*                    
//*****************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AdditionalInformationAddFieldActionEditIconCaptionTextBoxUIProperties extends DriverIntialization {

	@Test
	public static void informationAddFieldActionEditIconCaptionTextBoxUIProperties()
			throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0791");
		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Configure", "TC-TCN-0791-01");

		// Calling The Method For Navigate To Test Configure Module-Additional
		// Information

		TestConfigMethods.navigate_TestConfigureTabs(7);
		Thread.sleep(2000);

		// Click the Edit Icon
		editiconclick();

		// Check InformationAdditional Information Add Field Action Edit Icon Caption
		// Text Box
		// UI Properties
		addFieldActionEditIconCaptionTextBoxUIProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	// Check InformationAdditional Information Add Field Action Edit Icon Caption Text Box UI Properties
	public static void addFieldActionEditIconCaptionTextBoxUIProperties() {
		
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0791-02",
				driver.findElement(By.xpath("//input[@value='"+TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)+"']")),
				"Additional Information  Add Field Status Add Field Action Edit Icon Caption Text Box UI Properties");
		
	}

	// Edit Icon Click
	public static void editiconclick() {

		try {
			driver.findElement(By.xpath("//*[text()='" + TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)
					+ "']/following-sibling::td[4]/span/a[1]")).click();
			testCase = extent.createTest("Click The  Additional Information Add Field Action Edit Icon");
			testCase.log(Status.PASS, "Test Pass");
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Not Visible Additional Information Add Field Action Edit Icon");
			testCase.log(Status.FAIL, "Test Fail");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Not Click Additional Information Add Field Action Edit Icon");
			testCase.log(Status.FAIL, "Test Fail");
		} catch (Exception e) {
			testCase = extent.createTest("Not Click Additional Information Add Field Action Edit Icon");
			testCase.log(Status.FAIL, "Test Fail");
		}
	}

}
