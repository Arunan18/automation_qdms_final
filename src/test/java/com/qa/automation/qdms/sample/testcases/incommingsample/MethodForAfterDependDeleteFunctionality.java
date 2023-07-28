//***********************************************************************************
//* Description
//*------------
//*Incoming Sample After Depend Delete Functionality  - Method
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 24/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-INC-SAM-0016        24/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MethodForAfterDependDeleteFunctionality  extends DriverIntialization{
	AfterDependDeleteFunctionality deletemethodfun = new AfterDependDeleteFunctionality();
	@Test
	public void methodForDeleteDepend() throws IOException, InterruptedException {
		PageFactory.initElements(driver, deletemethodfun);

//______________________________________________________________
//   LOGIN
//_______________________________________________________________		
		
		LoginTest.Login();
		
//______________________________________________________________
//  NAVIAGATE TO INCOMING SAMPLE
//_______________________________________________________________
		
		AfterDependDeleteFunctionality.navigateToIncomingSample();
		
//______________________________________________________________
//  EXCECL METHOD
//_______________________________________________________________		
		 
		AfterDependDeleteFunctionality.ExcelMethod();
		
//______________________________________________________________
		
//  STEP:1 DELETE ICON IS VISIBLE 

//         DELETE ICON IS ENABLE
		
//         DELETE POP UP VISIBLE 
		
// STEP:2  DELTE ICON IS CLCIKED	
		
// STEP:3 CAN'T DLETET THIS MODULE ALERT MESSAGE VISIBLE"
		
// STEP:4   CHECK ALERT MESSAGE SPELLING		
		
//_______________________________________________________________		
		
		AfterDependDeleteFunctionality.SeachDataToDelete(); 
		
//______________________________________________________________
//  STEP:5 AFTER CLICK DELETE BUTTON VERIFY DATA IS THERE OR NOT
//______________________________________________________________		
		
		AfterDependDeleteFunctionality.verifyDataNotDeleted();
		
//____________________________________________________________
//  LOGOUT
//___________________________________________________________
		
		AfterDependDeleteFunctionality.Logout();
		
		
	}

}
