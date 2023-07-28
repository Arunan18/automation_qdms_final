/*************************************************************************************************
* Description
*------------
* TC-PRODUCT-SAM-0302	Check Production Sample Trail Validation



* 
*************************************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 17/05/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-PRODUCT-SAM-0302  17/05/2023   Rahul.S     Original Version
*  
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleTrailValidation extends ProductionSampleTrailFunction {
	static ProductionSamplePage inprocess = new ProductionSamplePage();

	@Test
	public static void InValidation() throws InterruptedException, IOException {
		PageFactory.initElements(driver, inprocess);

		// LOGIN
		LoginTest.Login();

		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();

		// RAW MATERIAL
		SampleNavigateTest.finishProductSampleMainNavigation();

		// INPROCESS SAMPLE NAVIGATION
		SampleNavigateTest.productionSampleNavigation();

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
