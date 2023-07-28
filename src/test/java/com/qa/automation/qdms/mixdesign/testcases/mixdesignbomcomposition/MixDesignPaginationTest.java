//***********************************************************************************
//* Description
//*------------
//* MIX DESIGN PAGINATION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 21/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-MIX-DES-0016        21/04/2023    WATHI     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.mixdesign.testcases.mixdesignbomcomposition;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.mixdesign.commonmethods.MixDesignNavigation;
import com.qa.automation.qdms.mixdesign.pages.MixDesignPage;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MixDesignPaginationTest extends MixDesignMainTests {

	@Test
	public static void mixDesignPagination() throws InterruptedException, IOException {
		
		testCase = extent.createTest("TESTCASE-TC-MIX-DES-0016");

		LoginTest.Login();

		MixDesignNavigation.mixDesignNavigation();

		MixDesignNavigation.mixBomDesignComposition();

		MixDesignMainTests.pagiantion();

		Logout.LogoutFunction();

	}

}
