//***********************************************************************************
//* Description
//*------------
//* EDIT FORM CANCEL BUTTON FUNCTIONALITY - TESTCASE
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 07/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*    TC-ROL-0033       07/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.role;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.RolePage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class EditRoleCancelButtonFunctionality extends DriverIntialization {
	static RolePage rp = new RolePage();

	@Test
	public static void addRoleFunctionality() throws InterruptedException {
		PageFactory.initElements(driver, rp);

		AddRoleFunction.navigaterole("TC-ROL-0033 - Role Edit Cancel Button Function");

		if (MasterMainNavigationsTest.clickEmployeeMain) {
			ActionCommonMethod.actionS(0, 1, RolePage.table, "edit", "Master Module.xlsx", "Role", "TC-ROL-0033-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(RolePage.CancelButton, RolePage.editPopUP,
					"CHECKING THE EDIT CANCEL BUTTON", "CHECKING THE POPUP");

		}
		AddRoleFunction.logout();

	}
}
