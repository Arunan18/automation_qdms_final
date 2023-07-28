//***********************************************************************************
//* Description
//*------------
//*Copy Paste Mix Design  - Method
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 20/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MIX-DES-0020       20/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MethodForMixDesignCopPaste extends DriverIntialization {
	MixDesignCopyPasteFunctionality copyPaste = new MixDesignCopyPasteFunctionality();
	
	@Test
	public void method() throws InterruptedException, IOException {
		PageFactory.initElements(driver, copyPaste);
		
//________________________________________________________
//   LOGIN
//_________________________________________________________		
		
		LoginTest.Login();
		
//_________________________________________________________
//    NAVIGATE TO MIX DESIGN COMPOSITION
//_________________________________________________________		
		
		MixDesignCopyPasteFunctionality.NavigatetoMixDesignComposition();
//_________________________________________________________
//    EXCEL METHOD
//_________________________________________________________		
				
					
		MixDesignCopyPasteFunctionality.ExcelMethod();
		
//_________________________________________________________

//  STEP:1 ADD BUTTON VISIBLE AND ENABLE
		
//  STEP:2 GET TEXT FROM TIME FIELD

//  STEP:3 SAVE BUTTON VISIBLE AND ENABLE
			
//_________________________________________________________		
				
			
		MixDesignCopyPasteFunctionality.copyPasteFunctionality();
//_________________________________________________________

//  STEP:4 AFTER SAVE GET TEXT DATE - CREATION DATE
		
//  STEP:5 COMPARE WITH DATE FIELD  
		
//  STEP:7 NEW STATUS BAR VISIBLE 
		
//_________________________________________________________		
				 
					 
		MixDesignCopyPasteFunctionality.afterValidate();
//_________________________________________________________
//   LOGOUT
//_________________________________________________________		
				
				
		MixDesignCopyPasteFunctionality.Logout();
		
	}

}
