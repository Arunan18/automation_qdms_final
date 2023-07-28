//*************************************************************************************************
//* Description
//*------------
//* Unit Edit form Validation
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-UNIT-0031        22/02/2023   Priyanka     Orginal Version
//*  
//************************************************************************************

package com.qa.automation.qdms.testcases.unit;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class UntEditValidation extends DriverIntialization {

	@Test

	public void UnitEditValidFunctinality() throws InterruptedException, IOException {

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

			UnitMethods.editInputUnitValue("TC-UNIT-0031", "Unit", "");

		}

		Logout.LogoutFunction();
	}

}
