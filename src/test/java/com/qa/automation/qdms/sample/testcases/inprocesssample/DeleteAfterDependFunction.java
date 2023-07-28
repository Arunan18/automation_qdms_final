/***********************************************************************************
* Description
*------------
*TC-PRO-SAM-0014	Process Sample Delete Functionality after Depended



***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 12/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-PRO-SAM-0014     12/05/2023     RAHUL.S       Original Version
*                                                    
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class DeleteAfterDependFunction extends DeleteAfterDependMethods{
	static InprocessSamplePage inprocesssample = new InprocessSamplePage();
	
	@Test
	public static void deleteAfterDepend() throws InterruptedException,IOException{
		PageFactory.initElements(driver, inprocesssample);
		
		try {
		/* LOGIN */
		LoginTest.Login();
		
		Thread.sleep(1500);
		/* CLICK THE SAMPLE CARD*/
		InprocessSamplePage.Sample.click();
		
		/* CLICK THE SAMPLE RAW MATERIAL SAMPLE*/
		InprocessSamplePage.RawMaterialTopbar.click();
		
		/*CLICK THE INPROCESS SAMPLEA*/
		InprocessSamplePage.InprocessSample.click();
		
		//Getting data from excel
		addexcel();
		
		//DATA COUNT BEFORE CLICK THE DELETE OK BUTTON
		dataCountBeforeDelete();
		
		//CLICK DELETE ICON
		Thread.sleep(2000);
		deleteClick();
		
		//CLICK OK BUTTON
		Thread.sleep(2000);
		clickOkButton();
		
		//CONFIRM WITH THE ALERT MESSAGE
		Thread.sleep(2000);
		alertMessage();
		
		//DATA COUNT AFTER DEPEND
		Thread.sleep(2000);
		dataCountAfterDelete();
		
		//CONFIRM THE DELETE AFTER DEPEND
		confirm();
		
		//REFRESH
		driver.navigate().refresh();
		
		//LOGOUT
		Logout.LogoutFunction();
		
	} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
