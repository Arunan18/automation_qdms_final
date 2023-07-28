//***********************************************************************************
//* Description
//*------------
//* EDIT VALIDATION IN SBU
//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 29/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-SBU-0039          29/03/2023   RAHUL.S    Original Version
//*						31/03/2023     RAHUL.S   MODIFIED TO EXCEL
//************************************************************************************
package com.qa.automation.qdms.testcases.sbu;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.SbuPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class EditValidation extends MethodsOfSBU {
	static SbuPage singlesearch = new SbuPage();
	@Test
	public static void EditValidationSbu() throws InterruptedException, IOException {

		
		PageFactory.initElements(driver, singlesearch);
	try {
		Thread.sleep(2000);
		//LOGIN
		LoginTest.Login();
		//CLICK THE MASTER CARD
		MasterTest.MasterCard();
		//CLICK THE PLANT TAB
		plantTab();
		Thread.sleep(2000);
		//CLICK THE SBU BUTTON
		sbuButton();
		Thread.sleep(2000);
		//SPECIFIC DATA PICK AND CLICK THE EDIT BUTTON
		dataPick();
		Thread.sleep(2000);
		//FROM EXCEL CHECKING THE VALIDATION
		excelcall();
	}
		catch (Exception e) {	
		}
		try {
		Thread.sleep(2000);
		//CLICK THE CANCEL BUTTON
		SbuPage.cancelSbuButton.click();
		//LOGOUT
		Logout.LogoutFunction();
	}catch (Exception e) {
		testCase.log(Status.INFO, "TEST DID NOT WORK");
		Logout.LogoutFunction();
	}
	}
}
