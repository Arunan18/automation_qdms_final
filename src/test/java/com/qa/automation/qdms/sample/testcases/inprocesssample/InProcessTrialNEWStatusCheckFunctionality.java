
//****************************************************************************************
//		DESCRIPTION
//------------------
//					IN-PROCESS TRAIL SAMPLE NEW STATUS FILED CHECK FUNCTIONALITY
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   15:05:2023	
//****************************************************************************************
//* Test Case Number      	Date          Intis        Comments
//* =================       ======      ========       ========
//* TC-PRO-SAM-0303  	   15:05:2023     @SASIKALA     Original Version
//****************************************************************************************************************

/*
* TC-PRO-SAM-0303	Check when do the Test trial Check the Status Filed New  
*/

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.TrailStatusCommonMethod;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class InProcessTrialNEWStatusCheckFunctionality extends DriverIntialization {
	static InprocessSamplePage InProPg = new InprocessSamplePage();

	static String SampleCode = null;
	static String TestName = null;
	static String statusText = null;

	@Test(priority = 0)
	public static void TrailWayFunction() throws InterruptedException, IOException {

// LOGIN FUNCTION
		LoginTest.Login();

// CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, "STEP 1 - CHECKING SAMPLE MODULE");

// CHECKNIG RAW MATERIAL MENU IS DISPLAYED && STEP-02 CHECKNIG RAW MATERIAL MENU IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 20,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG IN PROCESS SAMPLE BUTTON IS ENABLED
		SampleActionMethods.clicking(SampleNavigationPage.inprocessSampleXpath(), 20,
				"STEP 3 - CHECKING IN PROCESS SAMPLE BUTTON");

//*************************COMMON METHOD TO TRAIL STATUS*******************************
		TrailStatusCommonMethod.TesttrailStatusChange("Samples Module", "Process Sample", "TC-PRO-SAM-0303");

//***************LOGOUT*********************
		Thread.sleep(1000);
		MultiSearchMethods.Logout();

	}
}