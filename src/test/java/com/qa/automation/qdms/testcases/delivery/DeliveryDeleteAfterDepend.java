//***********************************************************************************
//* Description
//*------------
//* Delivery Delete After Depend
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/03/2023
//* 

//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        01/03/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testcases.delivery;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class DeliveryDeleteAfterDepend extends DriverIntialization {

static DeliveryTest DeliveryDelete = new DeliveryTest();
static Logout logout = new Logout();
	
	@Test
	public static void function() throws InterruptedException, IOException
	{
		
		/**********************************************************************************************
		* 									Delivery Add Login
		**********************************************************************************************/
		LoginTest.Login();
		
		/**********************************************************************************************
		* 									Delete Method for Delivery After Depend
		**********************************************************************************************/
		DeliveryTest.daliverydeleteafterdepended();
		
		/**********************************************************************************************
		* 									Delivery Add Logout
		**********************************************************************************************/
		logout.LogoutFunction();
	
	}
}
