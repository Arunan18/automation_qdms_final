package com.qa.automation.qdms.testconfig.testcases.test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class SingleSearchMethod  extends DriverIntialization{

	 public static void Beforecountcheck() throws InterruptedException  {
			
		 // CHECK THE DATA COUNT IN TABLE AFTER RESET		
		
		 ActionCommonMethod.countDataTable(TestConfigPage.tableContainer);
			int counts = ActionCommonMethod.countOfData;
			System.out.println("count--" + counts);

			try {
				testCase = extent.createTest("BEFORE RESET TABLE  DATA TOTAL COUNT");
				Thread.sleep(2000);
				testCase.log(Status.PASS, "TEST PASS ☑");
				testCase.log(Status.PASS, "TEST PASS ☑" + counts);

			} catch (AssertionError e) {

				testCase = extent.createTest("BEFORE RESET TABLE  DATA TOTAL COUNT");
				Thread.sleep(2000);
				testCase.log(Status.PASS, "TEST FAIL ");
				testCase.log(Status.PASS, "TEST FAIL " + counts);
			}
	 }


public static void Aftercountcheck() throws InterruptedException  {
	
	 // CHECK THE DATA COUNT IN TABLE AFTER RESET		
	
		PropertiesCommonMethods.CountOfData(TestConfigPage.tableContainer);
		int counts = PropertiesCommonMethods.count;
		System.out.println("count--" + counts);

		try {
			testCase = extent.createTest("AFTER RESET TABLE  DATA TOTAL COUNT");
			Thread.sleep(2000);
			testCase.log(Status.PASS, "TEST PASS ☑");
			testCase.log(Status.PASS, "TEST PASS ☑" + counts);

		} catch (AssertionError e) {

			testCase = extent.createTest("AFTER RESET TABLE  DATA TOTAL COUNT");
			Thread.sleep(2000);
			testCase.log(Status.PASS, "TEST FAIL ");
			testCase.log(Status.PASS, "TEST FAIL " + counts);
		
}
}
}