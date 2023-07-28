//***********************************************************************************
//* Description
//*------------
//* Select Key Test Production Sample - PASS
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 05/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PRODUCT-SAM-0255   05/05/2023    Sayan     Orginal Version
//*  
//*  
//*  {256,257,258,259,260,261,262,263,264}
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

public class Pass_SelectKeyTestProductionSample extends DriverIntialization{

	static ProductionSamplePage ProductionSamplePg = new ProductionSamplePage();
	
	@Test
	public static void productionSample_Pass() throws InterruptedException, IOException {
		
		
PageFactory.initElements(driver, ProductionSamplePg);
		
		
        LoginTest.Login();
        
        Thread.sleep(500);
        ProductionSamplePage.samplexpath.click();
		
		Thread.sleep(500);
		ProductionSamplePage.topnavfinishproduct.click();
		
		Thread.sleep(500);
		ProductionSamplePage.productionsampleLeftNav.click();
		
		SampleKeyTest.keyTest("Samples Module", "Production Sample", "TC-PRODUCT-SAM-0255",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 24, 19, 18);
		
		MultiSearchMethods.Logout();
		
	}
	
	
}
