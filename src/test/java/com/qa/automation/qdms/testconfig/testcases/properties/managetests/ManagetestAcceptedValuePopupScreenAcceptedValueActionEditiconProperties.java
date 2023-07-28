/*************************************************************************************************************************************************************************
* Description
*------------
*Test Configure Manage Test Configuration Tab Accepted Value Pop up Screen Accepted Value Action Edit icon Properties
**************************************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*  MTC-MT-213           17/07/2023   M.Mathushan    Original Version
*
*****************************************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;

import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class ManagetestAcceptedValuePopupScreenAcceptedValueActionEditiconProperties extends DriverIntialization {
	
	@Test

	public static void popupScreenAcceptedValueActionEditiconProperties() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-213");

		// Scorall Down
		for (int down = 0; down < 10; down++) {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
		}

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Manage_Tests", "MTC-MT-213-01");

		// Check the Accepted Value Pop up Screen Accepted Value Action Edit Icon
		// Properties
		acceptedValueActionEditiconProperties(TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));

		// Click the Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	// Check the Accepted Value Pop up Screen Accepted Value Action Edit Icon
	// Properties
	public static void acceptedValueActionEditiconProperties(String Value) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-213-02",
				driver.findElement(By.xpath("//div[@class='ant-modal-content']//td[1][text()='" + Value
						+ "']/following-sibling::td[5]/span/a[1]/span")),
				"Manage Test Configuration Tab Accepted Value Action Edit Icon Properties");

	}
}
