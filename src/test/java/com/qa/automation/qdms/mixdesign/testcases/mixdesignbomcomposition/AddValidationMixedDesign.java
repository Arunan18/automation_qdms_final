/***********************************************************************************
* Description
*------------
* 

Mix Design  Add Validation 
TC-MIX-DES-0010

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* 
* Date Written     : 27/04/2023
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* 
*TC-MIX-DES-0010    27/04/2023     RAHUL.S       Original Version
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;

import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddValidationMixedDesign extends AddmixedDesignMethods {
	static MixDesignPage mixed = new MixDesignPage();
	@Test
	public static void addValidation() throws InterruptedException,IOException{
		PageFactory.initElements(driver, mixed);
		/* LOGIN */
		LoginTest.Login();
		//CLICK MIXED DESGIN CARD
		mixedDesignCard();
		//CLICK MIXED DESIGN ADD BUTTON
		mixedDesignAddButton();
		//CHECK VALIDATION FROM  EXCEL
		validexcel();
		Thread.sleep(2000);
		MixDesignPage.mixedDesignReturnButton.click();
		//LOG OUT
		Logout.LogoutFunction();
		
	}

}
