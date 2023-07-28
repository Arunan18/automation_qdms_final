/***********************************************************************************
* Description
*------------
* Process Sample Edit Validation 
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 17/4/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
* TC-PRO-SAM-0010        17/04/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.inprocesssample;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.material.CheckAddMaterialCancelButtonFunctionalityTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
   @Test
public class ProcessSampleEditValidation extends DriverIntialization {
	
	public static void editValidation() throws InterruptedException {
		InprocessSamplePage lg = new InprocessSamplePage();
		PageFactory.initElements(driver, lg);
		CheckAddMaterialCancelButtonFunctionalityTest.Login();
		Thread.sleep(2000);
		
		
		// Step-1--Chech Visible,Enable Of Sample Card and Click Sample Card
		extent.createTest("Step-1--Chech Visible,Enable Of Sample Card and Click Sample Card⏬");
		ActionCommonMethod.visbleEnable(SampleNavigationPage.sampleXpath(), "Sample Card");
		SampleNavigationPage.sampleXpath().click();
		Thread.sleep(2000);
		
		
		// Step-2--Check Visible,Enable Of In Process Sample Button And Click
		extent.createTest("Step-2--Check Visible,Enable Of In Process Sample Button And Click⏬");
		ActionCommonMethod.visbleEnable(SampleNavigationPage.inprocessSampleXpath(), "Inprocess Sample Button");
		SampleNavigationPage.inprocessSampleXpath().click();
		Thread.sleep(2000);
		
	
		
		// Step-3--Sample Code Text Box Validation
				extent.createTest("Step-3--Sample Code Text Box Validation⏬");
				ActionCommonMethod.editValidation("Samples Module.xlsx", "Process Sample", "TC-PRO-SAM-0012-01",0,20,InprocessSamplePage.processSampleTable,
						InprocessSamplePage.sampleCodeTextBox, InprocessSamplePage.sampleCodeTextBoxErr,
						InprocessSamplePage.addArocessSampleSave);

				driver.navigate().refresh();
				MultiSearchMethods.Logout();
	}
	

}
