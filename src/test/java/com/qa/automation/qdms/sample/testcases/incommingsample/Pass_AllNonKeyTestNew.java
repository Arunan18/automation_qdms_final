//***********************************************************************************
//* Description
//*------------
//* All key test pass and all non key test is new - Status
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0206                    28/04/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class Pass_AllNonKeyTestNew extends DriverIntialization{
	
	static IncomingSamplePage InCommingSamplePg = new IncomingSamplePage();
	
	@Test
	
	public static void allNonKeyTestNew() throws InterruptedException, IOException {
		
	
			PageFactory.initElements(driver, InCommingSamplePg);
			
	        LoginTest.Login();
			
			Thread.sleep(500);
			IncomingSamplePage.MainSample.click();;
			
			
			Thread.sleep(5000);
			SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0206", IncomingSamplePage.StatusColumn, 1, 16, 18, IncomingSamplePage.InComKeyBefore, IncomingSamplePage.InComKeyAfter);
			
		
		
		
	}

}
