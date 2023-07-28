//***********************************************************************************
//* Description
//*------------
//* SINGLESEARCH- PLANT FIELD FUNCTIONALITY 
//***********************************************************************************
//*
//* Author           : NILUXY KRISHNATHAVAM
//* Date Written     : 19/04/2023
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-P-LAB-SAM-0025   19/04/2023   NILUXY.K    Orginal Version
//*TC-P-LAB-SAM-0027
//TC-P-LAB-SAM-0029
//TC-P-LAB-SAM-0031
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;

public class PlantFieldSearchMethods extends DriverIntialization {
	static int aftercount = 0;
	static int beforecount = 0;
	static int finalBeforeCount = 0;

	PlantLabTrailSamplePage labtrailpage = new PlantLabTrailSamplePage();
	PropertiesCommonMethods countmethod = new PropertiesCommonMethods();

	public static void Beforecountcheck(String colname) throws InterruptedException {

		// CHECK THE DATA COUNT IN TABLE AFTER RESET

		PropertiesCommonMethods.CountOfData(PlantLabTrailSamplePage.tableContainer);
		 beforecount = PropertiesCommonMethods.count;
		System.out.println("count--" + beforecount);

		try {
			testCase = extent.createTest(colname + "BEFORE SEARCH TABLE  DATA TOTAL COUNT");
			Thread.sleep(2000);
			testCase.log(Status.PASS, "TEST PASS ☑");
			testCase.log(Status.PASS, "TEST PASS ☑" + beforecount);

		} catch (AssertionError e) {

			testCase = extent.createTest(colname + "BEFORE SEARCH TABLE  DATA TOTAL COUNT");
			Thread.sleep(2000);
			testCase.log(Status.PASS, "TEST FAIL ");
			testCase.log(Status.PASS, "TEST FAIL " + beforecount);
		}
	}

	public static void aftercountcheck(String colname) throws InterruptedException {

		// CHECK THE DATA COUNT IN TABLE AFTER RESET

		PropertiesCommonMethods.CountOfData(PlantLabTrailSamplePage.tableContainer);
		int aftercount = PropertiesCommonMethods.count;
		System.out.println("count--" + aftercount);
		

		try {
			// ExpectedTextVisible=false;
			Assert.assertEquals(aftercount, beforecount);
			testCase = extent.createTest(colname + "AFTER SEARCH TABLE  DATA TOTAL COUNT");
			testCase.log(Status.INFO, "Actual Visible :- " + aftercount);
			testCase.log(Status.INFO, "Expected Visible :- " + beforecount);
			testCase.log(Status.PASS, " Unit deleted Succesfully");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualVisible :- " + aftercount);
			testCase.log(Status.INFO, "Expected Visible :- " + beforecount);
			testCase.log(Status.FAIL, "Wrong");
		}
	}

}
