//***********************************************************************************
//* Description
//*------------
//* MIX DESIGN MULTI-SEARCH 
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 20/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-MIX-DES-0015        20/04/2023    WATHI     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.sample.commonmethods.SampleMultisearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterTest;

public class MixDesignmultiSearchTest extends MixDesignMainTests {

	@Test
	public static void mixdesignmultisearch () throws InterruptedException, IOException
	{
		
		testCase = extent.createTest("TESTCASE-TC-MIX-DES-0015");
		
		LoginTest.Login();
		
		MixDesignNavigation.mixDesignNavigation();
		
		MixDesignNavigation.mixBomDesignComposition();
		
		MixDesignMainTests.mixdesignmultiplesearch();
		
		Logout.LogoutFunction();
		
		

	}
	
}
