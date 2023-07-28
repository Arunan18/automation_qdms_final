//***********************************************************************************
//* Description
//*------------
//* Select Key Test InComing Sample - NEW
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 04/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRO-SAM-0278      04/05/2023   Sayan     Orginal Version
//*  
//*  
//*  {279,280,281,282,283,284,285,286,287,288,289,290,291,292,293}
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Fail_SelectKeyTestInProcessSample extends DriverIntialization {

	static InprocessSamplePage InProcessSamplePg = new InprocessSamplePage();
	
	@Test

	public static void inProcessSample_Fail() throws InterruptedException, IOException {

		PageFactory.initElements(driver, InProcessSamplePg);

		LoginTest.Login();

		Thread.sleep(500);
		InprocessSamplePage.Sample.click();

		Thread.sleep(500);
		InprocessSamplePage.InprocessSample.click();
		
		
		SampleKeyTest.keyTest("Samples Module", "Process Sample", "TC-PRO-SAM-0278",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 20, 16, 18);

		MultiSearchMethods.Logout();
		
	}

}
