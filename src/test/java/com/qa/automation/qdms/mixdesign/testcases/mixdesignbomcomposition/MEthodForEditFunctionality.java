//***********************************************************************************
//* Description
//*------------
//*Edit Functionality  Mix Design  - Method
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 21/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MIX-DES-0011      21/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MEthodForEditFunctionality extends DriverIntialization {
	MixDesignEditFunctionality editFun = new MixDesignEditFunctionality();

	@Test
	public void methodEdit() throws InterruptedException, IOException {
		PageFactory.initElements(driver, editFun);

// __________________________________________________________________
// LOGIN
// _______________________________________________________________

		LoginTest.Login();

// __________________________________________________________________
// NAVIAGATE TO MIX DESIGN COMPOSITION
// _______________________________________________________________

		MixDesignEditFunctionality.NaviagetToMixDesignComposition();

// __________________________________________________________________
// EXCEL METHOD
// _______________________________________________________________

		MixDesignEditFunctionality.ExcelMethod();

// __________________________________________________________________

// STEP:1 EDIT ICON IS VISIBLE

// STEP:2 EDIT ICON IS ENABLE

// STEP:3 EDIT FORM IS DISPLAT AND CLCIKED

// STEP:4 DATA IS EDIDTED OR NOT

// STEP:5 SAVE BUTTON IS VISIBLE AND ENABLE

// _______________________________________________________________

		MixDesignEditFunctionality.SeachDataToEdit();

// ______________________________________________________________
// STEP:6 AFTER EDIT DATA IS VISIBLE
// STEP:7 AFTER EDIT DATA IS GET TEXT
// ______________________________________________________________

		MixDesignEditFunctionality.afterValidateData();

// ___________________________________________________________
// LOGOUT
// __________________________________________________________

		MixDesignEditFunctionality.Logout();
	}

}
