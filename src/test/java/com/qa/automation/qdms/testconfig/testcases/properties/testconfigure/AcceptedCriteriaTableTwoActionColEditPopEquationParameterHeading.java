
/**********************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, Second Table,"Action" Column: "Edit" Icon Pop-Up,
 * "Equation Parameter", Heading Properties
 **********************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 12/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0682		    12/07/2023      Shangeetha    Original Version  
 ********************************************************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

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
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedCriteriaTableTwoActionColEditPopEquationParameterHeading extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0682");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(2000);

		// Calling The Method To Check The Edit Icon Pop-Up: 'Equation Parameter' Heading Properties
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
			WebElement EditIcon = driver.findElement(By.xpath("//td[text()='"+ searchCode +"']/following-sibling::td[5]//span[@class='anticon anticon-edit']"));
			testCase = extent.createTest("Locate the element 'Edit' Icon");		
			testCase.log(Status.INFO, "Located the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	


			// Click on 'Edit' Icon
			EditIcon.click();
			Thread.sleep(1000);
			testCase = extent.createTest("Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Clicked on the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	

			//Get Edit Icon Pop-Up: 'Equation Parameter' Heading Properties	
			equationParameterHeadingProperties();			

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

	public static void equationParameterHeadingProperties() {
		PageFactory.initElements(driver, testPage);
		//Get Edit Icon Pop-Up: 'Equation Parameter' Heading Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure","TC-TCN-0682-02", TestConfigPage.tableTwoActionColEditPopEquationParameterLabel,"'Equation Parameter' Label Properties");

	}	
}
