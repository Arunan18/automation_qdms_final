//***********************************************************************************
//* Description
//*------------
//* IncomingSampleAvailableTestForParticularIncomingSample
//***********************************************************************************
//*
//* Author           : yogalingam kajenthiran
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0021     24/04/2023     kajan     Original Version
//*						
//************************************************************************************


package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.Avilabletestcheck;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class IncomingSampleAvailableTestForParticularIncomingSample extends DriverIntialization {
	
	@Test
	public void IncomingSampleAvailableTestForParticularIncomingSample() throws InterruptedException, IOException {
		LoginTest.Login();
		Thread.sleep(2000);
		SampleNavigateTest.sampleNavigation();
		Thread.sleep(2000);
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();
		Thread.sleep(2000);
		Avilabletestcheck.AvilableTest("Samples Module", "Incoming Sample", "TC-INC-SAM-0021","INCOMING SAMPLE",1,18);
	}

}
