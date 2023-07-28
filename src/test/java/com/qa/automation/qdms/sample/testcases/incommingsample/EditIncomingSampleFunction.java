/***********************************************************************************
* Description
*------------
*Incoming Sample Edit Functionality (Able to edit Incoming sample only for NEW Status)
(TC-INC-SAM-0013)

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0009   28/04/2023   RAHUL.S    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditIncomingSampleFunction extends IncomingSampleMethods {
	static IncomingSamplePage incomingsample = new IncomingSamplePage();
	@Test
	public static void editIncomingSample() throws InterruptedException ,IOException{
		PageFactory.initElements(driver, incomingsample);
		// LOGIN
		LoginTest.Login();
		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();
		// RAW MATERIAL
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.incommingSampleNavigation();
		Thread.sleep(2000);
		//DATA PICK AND EDIT
		dataPick();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		//CLICK THE EDIT SAVE BUTTON
		editSaveButton();
		Thread.sleep(2000);
		//STATUS CHECKING
		editStatusConfirmation();
		Thread.sleep(2000);
		//EDIT CONFIRMATION
		editConfirmation();
		Thread.sleep(2000);
		//CLICK THE CANCEL BUTTON
		IncomingSamplePage.addCancelButton.click();
		Thread.sleep(2000);
		//LOGOUT
		Logout.LogoutFunction();
		
	}

}
