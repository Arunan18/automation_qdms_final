//***********************************************************************************
//* Description
//*------------
//* Employee Delete Functionality
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 30/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        30/03/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.employee;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class DeleteEmployee extends DriverIntialization {

	@Test
	public static void deleteEmployeeFunction() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateEmployeeMain();
		}
		if (MasterMainNavigationsTest.clickEmployeeMain) {

			MasterMainNavigationsTest.navigateEmployee();
		}
		if (MasterMainNavigationsTest.clickEmployee) {

			deleteFunction.clickDelete("Master Module", "Employee", "TC-EMP-0099", "EMPLOYEE");

		}

		Logout.LogoutFunction();

	}

}
