/***********************************************************************************
* Description
*------------
* Mix Design  Add Functionality(TC-MIX-DES-0009)

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0009   26/04/2023   RAHUL.S    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddMixedDesignFunction extends AddmixedDesignMethods {
	static MixDesignPage mixed = new MixDesignPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	@Test
	public static void add() throws InterruptedException,IOException{
		PageFactory.initElements(driver, mixed);
		PageFactory.initElements(driver, methods);
		try {
		/* LOGIN */
		LoginTest.Login();
		mixedDesignCard();
		mixedDesignAddButton();
		addexcel();
		/*PLANT FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethodselect("STEP_05-- PLANT FIELD PROPERTIES ", MixDesignPage.plantTextBoxR, "I--  PLANT FIELD DISPLAYED", "II--  PLANT FIELD ENABLED" , plant, "III--PLANT DATA SUCCESSFULLY SELECTED");
		/*SUBCATEGORY FIELD DISPLAYED & ENABED & SELECTED*/
		SampleCommonMethods.fieldmethodselect("STEP_06-- SUBCATEGORY FIELD PROPERTIES ",MixDesignPage.subCategoryTextBox, "I--  SUBCATEGORY FIELD DISPLAYED", "II--  SUBCATEGORY FIELD ENABLED" , subCatetory, "III--SUBCATEGORY DATA SUCCESSFULLY SELECTED");
		finishProduct();
		//DATE VALUE
		try {
		SelectDate.dateSelectT("Samples Module.xlsx","Mix Design","TC-MIX-DES-0009-01",4,MixDesignPage.dateTextBox);
		testCase = extent.createTest("STEP-08--DATE TEXTBOX IS DISPLAYED AND SELECTED");
		testCase.log(Status.PASS, "TEST PASS ☑");
		}catch (Exception e) {
			testCase = extent.createTest("STEP-08--DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		//CHECKING STATUS
		status();
		//CLICKING PARTICULAR CHECK BOX
		proption();
		//CHECKING QUANDITY FIELD AND SEND DATA
		quandity();
		//CHECKING UNIT FIELD AND SEND DATA
		unit();
		//CLICK SAVE BUTTON
		saveButtton();
		//CONFIRM THE ADD BY CLICKING THE FIRST ROW EDIT BUTTON
		confirmAdd();
		//CLICKING THE RETURN BUTTON
		returnButtton();
		//LOGOUT
		Logout.LogoutFunction();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}	
}

