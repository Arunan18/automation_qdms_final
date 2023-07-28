//***********************************************************************************
//* Description
//*------------
//*Copy Paste Inprocess Sample  - METHOD
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 18/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0016           18/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MethodInprocessSampleCompyPaste extends DriverIntialization {
	ProcessSampleCopyPasteFunctionality method = new ProcessSampleCopyPasteFunctionality();
 
	@Test
	public void MethodForInProcessSamplCopyPaste() throws InterruptedException, IOException {

//_________________________________________________________
//   LOGIN
//________________________________________________________

		LoginTest.Login();
//________________________________________________________
//  NAVIGATE TO PROCESS SAMPLE
//________________________________________________________

		ProcessSampleCopyPasteFunctionality.NavigateToInProcessSamplePage();

//____________________________________________________________
//  EXCEL METHOD
//______________________________________________________________		

		ProcessSampleCopyPasteFunctionality.ExcelMethod();  

//_______________________________________________________________

//   SEARCH DATA AND COPY THAT SEARCH DATA UNCTIONALITY

//   STEP:1 ADD INCOMING SAMPLE BUTTON DISPLAY , ENABLE

//   STEP:2 BEFORE SAVE GET TEXT FROM TIME FIELD

//	 STEP:3 SAVE BUTTON DISPLAY , ENABLE

//   STEP:4 GET TEXT FROM TABLE DATA TIME FIELD	

//________________________________________________________________

		ProcessSampleCopyPasteFunctionality.copyPasteFunctionality(); 

//___________________________________________________________________

//  STEP:5 COMPARE TIME AFTER SAVE AND BEFORE SAVE

//  STEP:6 STATUS BAR (NEW) DISPLAY,ENABLE,COLOR,TEXT SPELLING

//___________________________________________________________________		

		ProcessSampleCopyPasteFunctionality.afterValidateSaveData(); 
 
	}

}
