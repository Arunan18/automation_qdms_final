//***********************************************************************************
//* Description
//*------------
//* Cancel Btn Functionality Test And Trial Plant Lab Trial Sample
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-P-LAB-SAM-0161   08/05/2023    Sayan     Orginal Version
//*  
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CancelBtnFunctionTestAndResultPlantLabTrial extends DriverIntialization {
	
	
	static PlantLabTrailSamplePage PlantLabTrailSamplePg = new PlantLabTrailSamplePage();
	
	@Test
	
	public static void cancelBtnFunction() throws InterruptedException, IOException {
		
		
		PageFactory.initElements(driver, PlantLabTrailSamplePg);

		LoginTest.Login();

//		NAVIGATE TO THE PLANT lAB TRIAL PAGE
//		--------------------------------------
		
		Thread.sleep(500);
		PlantLabTrailSamplePage.Sample.click();

		Thread.sleep(500);
		PlantLabTrailSamplePage.FinishProductTopbar.click();
		
		Thread.sleep(500);
		PlantLabTrailSamplePage.PlantLabTrialSample.click();
		
		
		CommonElementsPlantLabTrial.selectSampleExcelData();
		
//		SEARCH THE DATA IN THE TABLE
//		------------------------------
		
		CommonElementsPlantLabTrial.searchFinishProSample();
		
//		CLICK THE TEST AND TRIAL OF THE PARTICULAR FINISH SAMPLE
//		----------------------------------------------------------
		
		CommonElementsPlantLabTrial.testAndTrialFinishSample();
		
//		CLICKING THE OK BUTTON OF THE MODAL
//		-------------------------------------
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ant-btn']")).click();
		
		
//		CONFIRM THE OK BUTTON FUNCTIONLITY
//		-----------------------------------
		
		CommonElementsPlantLabTrial.modalClose();
		
           
		MultiSearchMethods.Logout();
	}
	
}

