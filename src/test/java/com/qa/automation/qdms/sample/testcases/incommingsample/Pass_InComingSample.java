//***********************************************************************************
//* Description
//*------------
//* All key test pass and various non key test status - Status
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0204      01/05/2023   Sayan     Orginal Version
//*  
//*  
//*  {205,206,207,208,209,210,211,212,213}
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
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Pass_InComingSample extends DriverIntialization{
	
	
static IncomingSamplePage InCommingSamplePg = new IncomingSamplePage();
	
	@Test
	
	public static void inComingSamplePass() throws InterruptedException, IOException {
		
		PageFactory.initElements(driver, InCommingSamplePg);
		
		
        LoginTest.Login();
		
		Thread.sleep(500);
		IncomingSamplePage.MainSample.click();
		
		
		Thread.sleep(5000);
		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0204", IncomingSamplePage.StatusColumn, 1, 16, 18, IncomingSamplePage.InComKeyBefore, IncomingSamplePage.InComKeyAfter);
		
		
		MultiSearchMethods.Logout();
		
	}

	

}
