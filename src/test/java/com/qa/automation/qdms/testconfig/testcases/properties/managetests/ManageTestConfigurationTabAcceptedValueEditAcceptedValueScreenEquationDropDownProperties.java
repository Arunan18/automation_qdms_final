/*************************************************************************************************************************************************************************
* Description
*------------
*Test Configure Manage Test Configuration Tab Accepted Value Pop up Screen Edit Accepted Value Screen Equation Drop Down Properties
**************************************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  MTC-MT-220           17/07/2023   M.Mathushan    Original Version
*
*****************************************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class ManageTestConfigurationTabAcceptedValueEditAcceptedValueScreenEquationDropDownProperties
		extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test

	public static void acceptedValueEditAcceptedValueScreenEquationDropDownProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-220");

		// Scorall Down
		for (int down = 0; down < 10; down++) {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
		}

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Manage_Tests", "MTC-MT-220-01");
		
		//Click the Edit Icon
		acceptedvalueeditbutton();

		// Check the Accepted Value Pop up Screen Accepted Value Action Edit Accepted Equation Drop down UI Properties
		editAcceptedValueScreenEquationDropDownProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	// Check the Accepted Value Pop up Screen Accepted Value Action Edit Accepted Equation Dropdown UI Properties
	public static void editAcceptedValueScreenEquationDropDownProperties() throws InterruptedException {
		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-220-02",
				ManageTestsPage.acceptedValueActionEditacceptedequationdropdownUIProperties,
				"Manage Test Configuration Tab Accepted Value Action Edit Accepted Equation dropdown UI Properties","1");
	}

	// Click the Accepted Value Edit Button
	public static void acceptedvalueeditbutton() throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//div[@class='ant-modal-content']//td[1][text()='"
					+ TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)
					+ "']/following-sibling::td[5]/span/a[1]/span")).click();
			testCase = extent.createTest("Click the Accepted Value Edit Icon Button");
			testCase.log(Status.PASS, "TEST PASS");
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Not Identify the Accepted Value Edit Icon Button");
			testCase.log(Status.PASS, "TEST FAIL");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Not Click the Accepted Value Edit Icon Button");
			testCase.log(Status.PASS, "TEST FAIL");
		} catch (Exception e) {
			testCase = extent.createTest("Not Click the Accepted Value Edit Icon Button");
			testCase.log(Status.PASS, "TEST FAIL");
		}
	}
}
