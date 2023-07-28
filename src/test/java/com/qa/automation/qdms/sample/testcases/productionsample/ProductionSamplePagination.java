//***************************************************************************************************************
//* Description
//*------------
//* PRODUCTION SAMPLE PAGINATION
//****************************************************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-PRODUCT-SAM-0016   19/04/2023   Gobithan     Original Version
//*TC-PRODUCT-SAM-0016   12/05/2023   Rahul.S      Modified Version(Changed the Xpaths,change the data in excel)
//******************************************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSamplePagination extends DriverIntialization {
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static Logout logout = new Logout();

	@Test
	public static void function() throws InterruptedException, IOException {
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, methods);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"01--PRODUCTION SAMPLE CARD DISPLAYED", "02--PRODUCTION SAMPLE CARD ENABLED",
				productionsample.sampletext, "SAMPLES", "03--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

		/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES",
				productionsample.topnavfinishproduct, "01--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED",
				"02--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED", productionsample.plantlabwindowheadding,
				productionsample.productionwindowheadding,
				"03--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- PRODUCTION SAMPLE PROPERTIES",
				productionsample.productionsampleLeftNav, "01--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--PRODUCTION SAMPLE LEFT NAVIGATION BUTTON ENABLED", productionsample.productionwindowheadding,
				"Production Sample", "03--ON CLICK THE PRODUCTION SAMPLE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PRODUCTION SAMPLE PAGINATION */
		Paginationmethods.pagination("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0016",
				productionsample.previousbtn, productionsample.nextbtn, productionsample.secondpage,
				productionsample.firstpage, productionsample.dropdown, productionsample.beforr, 4,
				productionsample.after, "MANGE TEST PAGINATION");

		/* LOGOUT FROM FINISH PRODUCT SAMPLE */
		logout.LogoutFunction();
	}

}
