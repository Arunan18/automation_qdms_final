//***********************************************************************************
//* Description
//*------------
//* Checking Source Edit Functionality in First Page
//***********************************************************************************
//*
//* Author           : YOGALINGAM KAJENTHIRAN
//* Date Written     : 11/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Author        Comments
//* ================       ====         =====        ========
//* TC-SRC-0040           11/03/2023   KAJAN.Y    	 Original Version
//* 				      05/04/2023   KAJAN.Y   	 rework Version
//* 					  12.07.2023   Sasikala.A    Modified (All)
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class CheckingSourceEditFunctionalityinFirstPage extends DriverIntialization {

	@Test
	public static void SourceEditFunction() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}

		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.navigateMaterialMain();
		}

		if (MasterMainNavigationsTest.clickMaterialMain) {
			MasterMainNavigationsTest.navigateSource();
		}

		if (MasterMainNavigationsTest.clickSource) {

			SourceMethod.editSource("Master Module", "Source", "TC-SRC-0040");

		}
		driver.navigate().refresh();
		MultiSearchMethods.Logout();
	}

}
