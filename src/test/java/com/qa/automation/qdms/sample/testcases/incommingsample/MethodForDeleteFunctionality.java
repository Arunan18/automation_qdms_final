//***********************************************************************************
//* Description
//*------------
//*Incoming Sample Delete Functionality  - Method
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0016           19/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;
 
public class MethodForDeleteFunctionality extends DriverIntialization {
	IncomingSampleDeleteFunctionality Delete = new IncomingSampleDeleteFunctionality();
	
	@Test
	public void method () throws InterruptedException, IOException { 
		PageFactory.initElements(driver, Delete);
		
//___________________________________________________________
//  LOGIN
//___________________________________________________________	
		
		LoginTest.Login();  
		
//___________________________________________________________
//   NAVIGATE TO INCOMPING SMAPLE
//___________________________________________________________			
		IncomingSampleDeleteFunctionality.navigateToIncomingSample();
		
//___________________________________________________________
//   EXCEL METHOD
//___________________________________________________________			
		
		IncomingSampleDeleteFunctionality.ExcelMethod();
	
//___________________________________________________________
//   STEP:1 DELETE ICON ENABLE , DISPLAY
//   STEP:2 DELETE POPUP ALERT DISPLAY , CLICK			
//___________________________________________________________			
		
		IncomingSampleDeleteFunctionality.SeachDataToDelete();
		
//___________________________________________________________
//   STEP:3 AFTER DELETE VERIFY DATA TO BE DELETEDT OR NOT
//___________________________________________________________			
		
		IncomingSampleDeleteFunctionality.verifyDeletedData();
		 
		   
		
	}

}
