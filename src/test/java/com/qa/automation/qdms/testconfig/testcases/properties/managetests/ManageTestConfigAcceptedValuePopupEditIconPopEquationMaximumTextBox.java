
/*****************************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Manage Test Configuration Tab,Accepted Value Pop up Screen,  -Second Table,"Action" Column: "Edit" Icon Pop-Up,
 *  "Equation Maximum Value's", Text Box Properties
 ****************************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 14/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * MTC-MT-223		    14/07/2023      Shangeetha    Original Version  
 **************************************************************************************************************************************/

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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigAcceptedValuePopupEditIconPopEquationMaximumTextBox extends DriverIntialization{
	static ManageTestsPage testPage = new ManageTestsPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Accepted Value Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-223");
		Thread.sleep(2000);

		// Calling The Method To Check The Edit Icon Pop-Up: 'Equation Maximum Value's'' Text Box Properties
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
			WebElement EditIcon = driver.findElement(By.xpath("//td[text()='"+ searchCode +"']/following-sibling::td[5]/span/a/span"));
			testCase = extent.createTest("Locate the element 'Edit' Icon");		
			testCase.log(Status.INFO, "Located the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	


			// Click on 'Edit' Icon
			EditIcon.click();
			Thread.sleep(1000);
			testCase = extent.createTest("Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Clicked on the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	

			//Get Edit Icon Pop-Up: 'Equation Maximum Value's'' Text Box Properties	
			methodTextBoxProperties();			

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate the element 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate Click on the element, 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL");		
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate and Click on the element 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void methodTextBoxProperties() {
		PageFactory.initElements(driver, testPage);
		//Get Edit Icon Pop-Up: 'Equation Maximum Value's' Text Box Properties
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-223-02", ManageTestsPage.tableTwoActionColEditPopEquationMaximumTextBox, "'Equation Maximum Value's' Text Box Properties");

	}
}

