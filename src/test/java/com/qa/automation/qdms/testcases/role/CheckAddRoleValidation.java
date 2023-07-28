/***********************************************************************************
* Description
*------------
*ADD ROLE VALIDATION
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 10/03/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-ROL-0022           10/03/2023   RAHUL.S    Original Version
*                       11/04/2023   RAHUL.S    MODIFIED VERSION
*                       19/07/2023   RAHUL.S    changed every code
************************************************************************************/
package com.qa.automation.qdms.testcases.role;

import java.io.IOException;

import org.testng.annotations.Test;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class CheckAddRoleValidation extends CheckAddRoleFunctionality {
	@Test
	public static void addValidationRole() throws InterruptedException, IOException {

		navigaterole("TC-ROL-0022- Role Add Validation");

		if (MasterMainNavigationsTest.clickEmployeeMain) {
			inputRoleValue("TC-ROL-0022", "Role", "validation");
		}
		logout();

	}

}
