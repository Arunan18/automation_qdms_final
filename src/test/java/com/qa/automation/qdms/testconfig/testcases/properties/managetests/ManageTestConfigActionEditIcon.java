/********************************************************************************************************************************
 * Description
 *------------
 * Test Configure - Manage Test Configuration Tab-Equation Column, Equation Icon's Pop-Up: Action Column: "Edit" Icon Properties 
 ********************************************************************************************************************************
 *
 * Author           : Shangeetha
 * Date Written     : 17/07/2023 
 * 
 *
 * 
 * Test Case Number       Date         Intis          Comments
 * ================       ====         =====          ========
 * MTC-MT-253           17/07/2023   M.Shangeetha   Original Version               
 *******************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigActionEditIcon extends DriverIntialization{
	static ManageTestsPage testPage = new ManageTestsPage();
	@Test
	public static void manageTestConfigActionEditIcon() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Equation Column, Click on Equation Icon        
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 9, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-253");
		Thread.sleep(2000);

		// Calling The Method To Check The Edit Icon Properties
		methodEditIconProperties(NavigateManageTestFromLogin.excelDataValue.get(1));

		// Refresh
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Log Out Of The System.
		Logout.LogoutFunction();


	}
	public static void methodEditIconProperties(String SearchData) {
		
		PageFactory.initElements(driver, testPage);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-253-02", driver.findElement(By.xpath("//*[text()='"+SearchData+"']/following-sibling::td[4]/span/a[1]/span")),"Action Column: Edit Icon UI Properties");
	}

}