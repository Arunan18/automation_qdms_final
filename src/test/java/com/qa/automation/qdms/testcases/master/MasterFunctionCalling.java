//***********************************************************************************
//* Description
//*------------
//*MASTER FUNCTION CALLING TEST
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 26/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-MC-0002            26/03/2023   RAHUL.S     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.master;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MasterFunctionCalling extends MassterFunction {

	@Test
	public static void masterButton() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, masterButn);
		// LOGIN
		LoginTest.Login();

		// MASTER BUTTON
		masterButton();
		// HOME LOGO
		homeButton();
		// MASTER NAME
		masterLogo();
		// LOGOUT
		Logout.LogoutFunction();
	}
}
