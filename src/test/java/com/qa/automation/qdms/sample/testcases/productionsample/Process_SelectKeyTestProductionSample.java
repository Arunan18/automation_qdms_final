//***********************************************************************************
//* Description
//*------------
//* Select Key Test Production Sample - Process
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 09/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0232   09/05/2023    Sayan     Original Version
//*  
//*  
//*  {233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252}
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.productionsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Process_SelectKeyTestProductionSample extends DriverIntialization {

	static ProductionSamplePage ProductionSamplePg = new ProductionSamplePage();

	@Test
	public static void productionSample_Process() throws InterruptedException, IOException {

		PageFactory.initElements(driver, ProductionSamplePg);

		LoginTest.Login();

		Thread.sleep(500);
		ProductionSamplePage.samplexpath.click();

		Thread.sleep(500);
		ProductionSamplePage.topnavfinishproduct.click();

		Thread.sleep(500);
		ProductionSamplePage.productionsampleLeftNav.click();

		SampleKeyTest.keyTest("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0232",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 24, 19, 18);

		MultiSearchMethods.Logout();

	}

}
