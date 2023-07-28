/***********************************************************************************
* Description
*------------
*TC-MIX-DES-0065	Add Proportion in mix design screen Validation

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 02/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0009   02/05/2023     RAHUL.S       Original Version
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddProportionValidation extends ProportionMethods {
	static MixDesignPage mixed = new MixDesignPage();
	@Test
	public static void valid() throws InterruptedException,IOException{
		PageFactory.initElements(driver, mixed);
		
		/* LOGIN */
		LoginTest.Login();

		// CLICK THE MIXED DESIGN CARD
		AddmixedDesignMethods.mixedDesignCard();

		Thread.sleep(3000);
		//GET DATA FROM EXCEL
		excelvalid();
		//LOG OUT
		Logout.LogoutFunction();
		
		
		
		
		
	}

}
