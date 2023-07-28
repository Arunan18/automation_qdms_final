//***********************************************************************************
//* Description
//*------------
//*Copy Paste Plant Lab Trail Sample  - Method
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 18/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-P-LAB-SAM-0022    18/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MethodForCopyPaste extends DriverIntialization {
	PlantLabTrialSampleCopyPasteFunctionality methodLapTrial = new PlantLabTrialSampleCopyPasteFunctionality();

	@Test
	public void methodCopyPaste() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methodLapTrial);
 
//_________________________________________________________
//  LOGIN
//_________________________________________________________

		LoginTest.Login();

//________________________________________________________
//  NAVIGATE TO PLANT LAB TRAIL
//________________________________________________________

		PlantLabTrialSampleCopyPasteFunctionality.navigateToPlantTrailSample();

//________________________________________________________
//   EXCEL METHOD
//________________________________________________________

		PlantLabTrialSampleCopyPasteFunctionality.ExcelMethod(); 

//________________________________________________________________

//   SEARCH DATA AND COPY THAT SEARCH DATA UNCTIONALITY

//   STEP:1 ADD PLANT LAB TRAIL BUTTON DISPLAY , ENABLE

//   STEP:2 BEFORE SAVE GET TEXT FROM DATE FIELD

//	 STEP:3 SAVE BUTTON DISPLAY , ENABLE  

//   STEP:4 GET TEXT FROM TABLE DATA DATE FIELD	

//_____________________________________________________________________

		PlantLabTrialSampleCopyPasteFunctionality.copyPasteFunctionality(); 
 
//________________________________________________________________________

//  STEP:5 COMPARE TIME AFTER SAVE AND BEFORE SAVE

//  STEP:6 STATUS BAR (NEW) DISPLAY,ENABLE,COLOR,TEXT SPELLING

//________________________________________________________________________		

		PlantLabTrialSampleCopyPasteFunctionality.afterValidateSaveData();
		
//__________________________________________________________________________
//    LOGOUT
//__________________________________________________________________________
		
		PlantLabTrialSampleCopyPasteFunctionality.Logout();  
	}

}
