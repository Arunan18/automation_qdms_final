//***********************************************************************************
//* Description
//*------------
//* Select Key Test InComing Sample - NEW
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 03/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0239      03/05/2023   Sayan     Orginal Version
//*  
//*  
//*  {240,241,242,243,244,245,246,247}
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class New_SelectKeyTestInComingSample extends DriverIntialization {

	static IncomingSamplePage InCommingSamplePg = new IncomingSamplePage();

	@Test
	public static void inComingSample_New() throws InterruptedException, IOException {

		PageFactory.initElements(driver, InCommingSamplePg);

		LoginTest.Login();

		Thread.sleep(500);
		IncomingSamplePage.MainSample.click();

		SampleKeyTest.keyTest("Samples Module", "Incoming Sample", "TC-INC-SAM-0239",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 22, 16, 18);

		MultiSearchMethods.Logout();
		
	}

}
