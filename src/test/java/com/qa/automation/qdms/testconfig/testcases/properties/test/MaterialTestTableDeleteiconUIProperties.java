/**********************************************************************************
* Description
*------------
*Material Test Table "Delete" icon UI Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 14/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-Test-0052          14/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;


	public class MaterialTestTableDeleteiconUIProperties extends DriverIntialization {
//		

		@Test
		public static void MaterialTestTableDeleteiconUIPropertie() throws InterruptedException, IOException {

			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test", "TC-Test-0052-01");
			//icon properties 
			deleTeiconIcon(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
			// Logout
			Logout.LogoutFunction();

		} 

		public static void deleTeiconIcon(String data) {
			// icon Properties
			PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test",
					"TC-Test-0052-02",
					driver.findElement(By.xpath("//td[text()='"+ data +"']//following-sibling::td[1]/span/a[2]")),
					"Material Test Table Delete icon UI Properties");
		}
	}
 





