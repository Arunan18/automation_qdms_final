//***********************************************************************************
//* Description
//*------------
//* Key test Process and various non key test status - Status
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 02/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0157     02/05/2023   Sayan     Orginal Version
//*  
//*  
//*  { 158,159,160,161,162,163,164,165,166,167,
//*    168,169,170,171,172,173,174,175,176,177 }
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;

import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Process_ProductionSample extends DriverIntialization {
	
	
static ProductionSamplePage ProductionSamplePg = new ProductionSamplePage();
	
	@Test
	
	public static void productionSampleProcess() throws InterruptedException, IOException {
		
		PageFactory.initElements(driver, ProductionSamplePg);
		
		
        LoginTest.Login();
        
        Thread.sleep(500);
        ProductionSamplePage.samplexpath.click();
		
		Thread.sleep(500);
		ProductionSamplePage.topnavfinishproduct.click();
		
		Thread.sleep(500);
		ProductionSamplePage.productionsampleLeftNav.click();
		
		Thread.sleep(1000);
		SampleStatus.sampleStatus("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0157", ProductionSamplePage.colummstatus, 1, 19, 18, ProductionSamplePage.ProKeyBefore, ProductionSamplePage.ProKeyAfter);
		
		
		MultiSearchMethods.Logout();
		
		
		
	}
	

}
