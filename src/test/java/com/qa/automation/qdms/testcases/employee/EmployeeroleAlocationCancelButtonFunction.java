/***********************************************************************************
* Description
*------------
*TC-EMP-0101--Check  Employee role allocation "Cancel" Button Functionality

***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-EMP-0101	     26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/

package com.qa.automation.qdms.testcases.employee;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.EmployeePage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class EmployeeroleAlocationCancelButtonFunction extends DriverIntialization{

	static EmployeePage employeePg = new EmployeePage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, employeePg);
		testCase = extent.createTest("TC-EMP-0101	Check  Employee role allocation Cancel Button Functionality");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateEmployeeMain();

		}
		if (MasterMainNavigationsTest.clickEmployeeMain) {
			MasterMainNavigationsTest.clickEmployeeMain = false;
			MasterMainNavigationsTest.navigateEmployee();
		}
		if (MasterMainNavigationsTest.clickEmployee) {
			MasterMainNavigationsTest.clickEmployee = false;
			ActionCommonMethod.actionS(4, 9, EmployeePage.employeeTable, "idcard", "Master Module.xlsx", "Employee",
					"TC-EMP-0101-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(EmployeePage.employeeCancelButton, EmployeePage.popUpModel,
					"CHECKING THE role allocation CANCEL BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}


}
