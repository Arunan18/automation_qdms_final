//***********************************************************************************
//* Description
//*------------
//* Edit Functionality - Test case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 04/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0031          04/04/2023   Saranka     Original Version
//*                      18/07/2023   RAHUL.S     MODIFIED
//************************************************************************************

package com.qa.automation.qdms.testcases.role;

import org.testng.annotations.Test;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class EditRoleFunction extends CheckAddRoleFunctionality {

	@Test
	public static void editRole() throws InterruptedException {
		navigaterole("TC-ROL-0031 - Role Edit Function");

		if (MasterMainNavigationsTest.clickEmployeeMain) {
			editRole("Master Module", "Role", "TC-ROL-0031");
		}
		logout();

	}
}
