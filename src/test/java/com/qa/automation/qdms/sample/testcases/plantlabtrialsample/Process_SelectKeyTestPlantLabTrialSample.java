//***********************************************************************************
//* Description
//*------------
//* Select Key Test Plant Lab Trial Sample - PROCESS
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 04/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0175      04/05/2023   Sayan     Orginal Version
//*  
//*  
//*  {176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196}
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Process_SelectKeyTestPlantLabTrialSample extends DriverIntialization {

	static PlantLabTrailSamplePage PlantLabTriallSamplePg = new PlantLabTrailSamplePage();

	@Test

	public static void plantLabSample_Process() throws InterruptedException, IOException {

		PageFactory.initElements(driver, PlantLabTriallSamplePg);

		LoginTest.Login();

// CHECKNIG SAMPLE MODULE IS DISPLAYED && CHECKNIG SAMPLE MODULE BUTTON IS
// ENABLED
// ---------------------------------------------------------------------------------

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 20, " CHECKING SAMPLE MODULE");

// CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && CHECKNIG FINISH PRODUCT MENU IS
// ENABLED
// ------------------------------------------------------------------------------

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 20,
				" CHECKING FINISH PRODUCT MENU");

// CHECKNIG PLANT LAB TRIAL SAMPLE BUTTON IS DISPLAYED && CHECKNIG PLANT LAB
// TRIAL SAMPLE BUTTON IS ENABLED
// -----------------------------------------------------------------------------

		SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath(), 20,
				" CHECKING PLANT LAB TRIAL SAMPLE BUTTON");

//		CHECKING SELECT KEY TEST
//		-------------------------

		SampleKeyTest.keyTest("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0175",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 4, 14, 10, 8);

//		LOGOUT
//		-------
		
		MultiSearchMethods.Logout();

	}

}
