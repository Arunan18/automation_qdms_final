/***********************************************************************************
* Description
*------------
* TC-MIX-DES-0064	Add Proportion in mix design screen
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 02/05/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
*  TC-MIX-DES-0064     02/05/2023     RAHUL.S       Original Version
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddProportionFunction extends ProportionMethods {
	static MixDesignPage mixed = new MixDesignPage();

	@Test
	public static void addProp() throws InterruptedException, IOException {
		PageFactory.initElements(driver, mixed);
		/* LOGIN */
		LoginTest.Login();

		// CLICK THE MIXED DESIGN CARD
		AddmixedDesignMethods.mixedDesignCard();
		Thread.sleep(3000);
		// EXCEL
		excelProp();
		Thread.sleep(3000);
		// CLICK THE PROPORTION OF THE PARTICULAR PLANT
		plant();
		Thread.sleep(2000);
		// CLICK THE RAW MATERIAL CHECK BOX
		rawMaterialChecbox();
		Thread.sleep(2000);
		// GIVE DATA TO QUANDITY
		quandity();
		Thread.sleep(2000);
		// GIVE DATA TO UNIT
		unit();
		Thread.sleep(2000);
		// CLICK THE SUBMIT BUTTON
		submitButton();
		Thread.sleep(2000);
		// CLICK THE RAW MATERIAL ICON
		rawMaterialEdit();
		Thread.sleep(2000);
		// CONFIRM THE ADD DATA BY CLICKING THE RAW MATERIAL
		addConfirm();
		Thread.sleep(2000);
		//CLICK CLOSE BUTTON
		closeButton();
		//LOGOUT
		Logout.LogoutFunction();
		

	}
}
