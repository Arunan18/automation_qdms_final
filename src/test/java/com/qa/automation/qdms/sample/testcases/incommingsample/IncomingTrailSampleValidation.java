/*************************************************************************************************
* Description
*------------
* TC-INC-SAM-0168	Check Incoming Sample Trail Validation

* 
*************************************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 15/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-INC-SAM-0012       15/05/2023   Rahul.S     Original Version
*  
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncomingTrailSampleValidation extends IncomingSampleTrailMethod {
	static IncomingSamplePage incomingsample = new IncomingSamplePage();

	@Test
	public static void incomingSampleTrailValidation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, incomingsample);
		// LOGIN
		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.rawMaterialSampleMainNavigation();

		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.incommingSampleNavigation();

		// SELECT A PARTICULAR DATA FROM EXCEL
		excel();

		// CLICK THE TEST AND RESULT ICON
		testAndResultClick();

		// CLICK THE TEST CARD
		Thread.sleep(2000);
		clickTest();

		// CHECKING THE VALIDATION
		validation();

		// LOGOUT
		Logout.LogoutFunction();

	}
}
