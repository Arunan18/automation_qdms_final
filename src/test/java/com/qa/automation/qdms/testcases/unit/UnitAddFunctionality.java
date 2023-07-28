//*************************************************************************************************
//* Description
//*------------
//* Unit Add Functionality 
//* 30/03/2023 (Author : Priyanka)  update excel sheet and method for UnitFunctionality () method
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-UNIT-0021         22/02/2023   Priyanka     Original Version
//*  TC-UNIT-0021         30/03/2023   Priyanka     update excel 
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.unit;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class UnitAddFunctionality extends DriverIntialization {

	@Test
	public void UnitFunctionality() throws InterruptedException, IOException {
		testCase = extent.createTest("TC-UNIT-0021 - Unit Add Function".toUpperCase());
		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateMaterialMain();
		}

		if (MasterMainNavigationsTest.clickMaterialMain) {
			MasterMainNavigationsTest.navigateUnit();

		}

		if (MasterMainNavigationsTest.clickUnit) {

			UnitMethods.inputUnitValue("TC-UNIT-0021", "Unit", "");

		}

		Logout.LogoutFunction();

	}

}
