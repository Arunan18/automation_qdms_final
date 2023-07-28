/*****************************************************************************************************************************************
 * Description
 *------------
 * Test Configure - Manage Test Configuration Tab-Equation Column, Equation Icon's Pop-Up: Action Column: "Edit" Pop up, "Edit Equation" 
 * Heading Properties
 *****************************************************************************************************************************************
 *
 * Author           : Shangeetha
 * Date Written     : 17/07/2023 
 * 
 *
 * 
 * Test Case Number       Date         Intis          Comments
 * ================       ====         =====          ========
 * MTC-MT-255           17/07/2023   M.Shangeetha   Original Version           	                                
 ****************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigActionEditEquationHeading extends DriverIntialization{
	static ManageTestsPage testPage = new ManageTestsPage();
	@Test
	public static void manageTestConfigActionEditPopup() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Equation Column, Equation Icon                
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-255");
		Thread.sleep(2000);

		// Calling The Method To Check The Edit Icon Pop-Up, "Edit Equation" Heading Properties
		methodLocateAndClick(NavigateManageTestFromLogin.excelDataValue.get(1));

		// Refresh
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodLocateAndClick(String searchCode) {

		try {	

			// Locate the "Edit" Icon
			WebElement EditIcon = driver.findElement(By.xpath("//*[text()='"+searchCode+"']/following-sibling::td[4]/span/a[1]/span"));
			testCase = extent.createTest("Locate the element 'Edit' Icon");		
			testCase.log(Status.INFO, "Located the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	


			// Click on 'Edit' Icon
			EditIcon.click();
			Thread.sleep(1000);
			testCase = extent.createTest("Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Clicked on the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	

			//Check 'Edit' Icon Pop-Up Heading Properties	
			editIconPopUpHeadingProperties();			

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate the element 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate Click on the element, 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");		
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate and Click on the element 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}


	public static void editIconPopUpHeadingProperties() {
		PageFactory.initElements(driver, testPage);
		//Get Edit Icon Pop-Up Heading, "Edit Equation" Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests","MTC-MT-255-02", ManageTestsPage.eqIconPopEditPopUpHeading,"Edit Icon Pop-Up,'Edit Equation' Heading Properties");

	}
}
