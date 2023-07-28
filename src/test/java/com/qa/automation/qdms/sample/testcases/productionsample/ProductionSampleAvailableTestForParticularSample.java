//***********************************************************************************
//* Description
//*------------
//* ProductionSampleAvailableTestForParticularSample
//***********************************************************************************
//*
//* Author           : yogalingam kajenthiran
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRODUCT-SAM-0019    24/04/2023     kajan     Original Version
//*						
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.sample.commonmethods.Avilabletestcheck;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProductionSampleAvailableTestForParticularSample {
	@Test
	public void IncomingSampleAvailableTestForParticularIncomingSample() throws InterruptedException, IOException {
		LoginTest.Login();
		Thread.sleep(2000);
		SampleNavigateTest.sampleNavigation();
		Thread.sleep(2000);
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		SampleNavigateTest.incommingSampleNavigation();
		Thread.sleep(2000);
		Avilabletestcheck.AvilableTest("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0019","Production Sample",1,18);
	}

}
