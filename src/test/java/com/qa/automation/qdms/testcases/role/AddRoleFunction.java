//***********************************************************************************
//* Description
//*------------
//*Check Add Role Functionality - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 03/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-ROL-0016           03/04/2023   Saranka     Original Version
//*                       18/07/2023   RAHUL.S     Modified(change the methods)
//************************************************************************************
package com.qa.automation.qdms.testcases.role;

import org.testng.annotations.Test;

import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class AddRoleFunction extends CheckAddRoleFunctionality {

	@Test
	public static void addRoleFunctionality() throws InterruptedException {

		navigaterole("TC-ROL-0016 - Role Add Function");

		if (MasterMainNavigationsTest.clickEmployeeMain) {
			inputRoleValue("TC-ROL-0016", "Role", "add");
		}
		logout();

	}
}
