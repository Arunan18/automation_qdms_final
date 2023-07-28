//***********************************************************************************
//* Description
//*------------
//* Key test fail and various non key test status - Status
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INP-SAM-0207      01/05/2023   Sayan     Orginal Version
//*  
//*  
//*  {208,209,210,211,212,213,214,215,216,217,218,219,220,221,222}
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;

import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Fail_InProcessSample extends DriverIntialization {
	
	
static InprocessSamplePage InProcessSamplePg = new InprocessSamplePage();
	
	@Test
	
	public static void allNonKeyTestProcess() throws InterruptedException, IOException {
		
		PageFactory.initElements(driver, InProcessSamplePg);
		
		
        LoginTest.Login();
        
        Thread.sleep(500);
        InprocessSamplePage.Sample.click();
		
		Thread.sleep(500);
		InprocessSamplePage.InprocessSample.click();
		
		
		Thread.sleep(5000);
		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-INP-SAM-0207", InprocessSamplePage.StatusColumn, 1, 16, 18, InprocessSamplePage.InproBeforeSearch, InprocessSamplePage.InproAfterSearch);
		
		
		MultiSearchMethods.Logout();
		
	}

	

}
