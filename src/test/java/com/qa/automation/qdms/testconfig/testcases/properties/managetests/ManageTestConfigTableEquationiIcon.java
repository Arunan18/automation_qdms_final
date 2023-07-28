/******************************************************************************************
 * Description
 *------------
 *Test Configure - Manage Test Configuration Tab,Equation Column: Equation Icon  Properties  
 *******************************************************************************************
 *
 * Author           : Shangeetha
 * Date Written     : 17/07/2023 
 * 
 *
 * 
 * Test Case Number       Date         Intis          Comments
 * ================       ====         =====          ========
 * MTC-MT-244           17/07/2023   M.Shangeetha   Original Version   					             
 *****************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class ManageTestConfigTableEquationiIcon extends DriverIntialization{

	@Test
	public static void managetestConfigAdditonalInformationHeading() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Equation Column,
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 9);
		
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Manage_Tests", "MTC-MT-244-01");
		// Calling The Method To Check The Equation Icon's Pop Up Properties
		equationIcon(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0),TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));
		

		// Log Out Of The System.
		Logout.LogoutFunction();

	}  
		

	public static void equationIcon(String SearchData,String SearchData1) {

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-244-02", driver.findElement(By.xpath("//tr[td[text()='"+SearchData+"'] and td[text()='"+SearchData1+"'] ] //td[10]")),"Equation Icon UI Properties");
	}

}
