/***********************************************************************************
* Description
*------------
* TC-PRODUCT-SAM-0216	Production Sample Raw Material Pagination


***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 11/05/2023 
*
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PRODUCT-SAM-0216   11/05/2023   RAHUL.S       Original Version
*
************************************************************************************/ 
package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSamplePaginationFunction extends PaginationMethods {
	static ProductionSamplePage productionsample = new ProductionSamplePage();

	@Test
	public static void pagination() throws InterruptedException, IOException {
		PageFactory.initElements(driver, productionsample);
		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"I--PRODUCTION SAMPLE CARD DISPLAYED", "II--PRODUCTION SAMPLE CARD ENABLED",
				productionsample.sampletext, "SAMPLES",
				"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

		/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES",
				productionsample.topnavfinishproduct, "I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
				productionsample.productionwindowheadding,
				"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES",
				productionsample.productionsampleLeftNav, "I--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"II--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", productionsample.productionwindowheadding,
				"Production Sample", "III--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* ADD PRODUCTION SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_04-- ADD PRODUCTION SAMPLE BUTTON PROPERTIES",
				productionsample.addproductionsample, "I-- ADD PRODUCTION SAMPLE BUTTON DISPLAYED",
				"II-- ADD PRODUCTION SAMPLE BUTTON ENABLED", productionsample.addproductionheading,
				"Add Production Sample",
				"III-- ON CLICK THE ADD PRODUCTION SAMPLE BUTTON IT'S SHOWES THE ADD PRODUCTION SAMPLE WINDOW");

		/* RADIO BUTTON DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.singleclick("STEP_05-- SINGLE RADIO BUTTON PROPERTIES", productionsample.singleradiobtn,
				"I-- SINGLE RADIO BUTTON DISPLAYED", "II-- SINGLE RADIO BUTTON ENABLED");
		// GETTING DATA FROM EXCEL
		excel();

		/* PLANT FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_06-- PLANT FIELD PROPERTIES", productionsample.plant,
				"I-- PLANT FIELD DISPLAYED", "II-- PLANT FIELD ENABLED", Plant, "III-- DATA SUCCESSFULLY SELECTED");

		/* FINISH PRODUCT FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_07-- FINISH PRODUCT FIELD PROPERTYS ",
				productionsample.finishproduct, "I-- FINISH PRODUCT FIELD DISPLAYED",
				"II-- FINISH PRODUCT FIELD ENABLED", finishproduct, "III-- DATA SUCCESSFULLY SELECTED");

		/* MIX DESIGN FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethoddropdown("STEP_08-- MIX DESIGN FIELD PROPERTYS ", productionsample.mixdesign,
				"I--  MIX DESIGN FIELD DISPLAYED", "II--  MIX DESIGN FIELD ENABLED",
				"//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + mixdesign + "']",
				"III-- DATA SUCCESSFULLY SELECTED");
		Thread.sleep(2000);

		// CHECKING THE DATA COUNT--STEP-09
		try {

			paginationCount();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// CHECKING THE PAGINATION FUNCTIONALITY-STEP-10,11,12 & 13
		try {
			paginationFun();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// CLICK THE CANCEL BUTTON
		ProductionSamplePage.cancelbtn.click();
		Thread.sleep(2000);

		//LOGOUT
		Logout.LogoutFunction();
	}
}
