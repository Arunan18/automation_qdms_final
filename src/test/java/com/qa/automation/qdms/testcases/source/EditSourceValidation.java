
//****************************************************************************************
//		DESCRIPTION
//------------------
//					SOURCE EDIT VALIDATION FUNCTION
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   10:03:2023	
//****************************************************************************************
//* Test Case Number      		Date          Intis        Comments
//* =====================       ======       ========      ========
//*  TC-SRC-0047		      10:03:2023   @SASIKALA     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class EditSourceValidation extends DriverIntialization {
	
	


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

			SourceMethod.editSource("Master Module", "Source", "TC-SRC-0047");

		}
		driver.navigate().refresh();
		MultiSearchMethods.Logout();
	}

}
