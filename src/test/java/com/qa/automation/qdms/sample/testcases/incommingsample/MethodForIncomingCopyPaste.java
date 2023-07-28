//***********************************************************************************
//* Description
//*------------
//*Copy Paste Incoming Sample  - METHOD
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 17/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0016           17/04/2023   Saranka     Original Version
//*
//************************************************************************************package com.qa.automation.qdms.sample.testcases.incommingsample;

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MethodForIncomingCopyPaste extends DriverIntialization {
	IncomingSampleCopyPasteFunctionality copyPaste = new IncomingSampleCopyPasteFunctionality();

	@Test
	public void Method() throws InterruptedException, IOException {
		PageFactory.initElements(driver, copyPaste);

//_______________________________________________________
//   LOGIN
//_______________________________________________________		

		LoginTest.Login();

//_______________________________________________________
// NAVIGATE TO INCOMING SAMPLE
//_______________________________________________________		

		IncomingSampleCopyPasteFunctionality.NavigateToIncomingSample();

//_________________________________________________________
//  EXCEL METHOD
//_______________________________________________________		

		IncomingSampleCopyPasteFunctionality.ExcelMethod();

//_________________________________________________________

//   SEARCH DATA AND COPY THAT SEARCH DATA UNCTIONALITY

//   STEP:1 ADD INCOMING SAMPLE BUTTON DISPLAY , ENABLE

//   STEP:2 BEFORE SAVE GET TEXT FROM TIME FIELD

//	 STEP:3 SAVE BUTTON DISPLAY , ENABLE

//   STEP:4 GET TEXT FROM TABLE DATA TIME FIELD	

//__________________________________________________________		

		IncomingSampleCopyPasteFunctionality.CopyPasteFunctionality();

//__________________________________________________________

//  STEP:5 COMPARE TIME AFTER SAVE AND BEFORE SAVE

//  STEP:6 STATUS BAR (NEW) DISPLAY,ENABLE,COLOR,TEXT SPELLING	

//_________________________________________________________	

		IncomingSampleCopyPasteFunctionality.afterValidateSaveData();

	}

}
