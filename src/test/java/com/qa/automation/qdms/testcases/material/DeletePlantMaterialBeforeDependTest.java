/***********************************************************************************
* Description
*------------
* Material Delete Material Before Depend Functionality
***********************************************************************************
*
* Author           : Suntharalingam Arunan
* Date Written     : 08/03/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*   TC-MAT-0145       08/03/2023      Arunan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.deleteFunction;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class DeletePlantMaterialBeforeDependTest extends DriverIntialization {

	@Test
	public static void deleteMaterialBeforeDepend() throws InterruptedException, IOException {

		LoginTest.Login();

		if (LoginTest.login) {

			MasterMainNavigationsTest.navigateMaster();

		}
		if (MasterMainNavigationsTest.clickMaster) {

			MasterMainNavigationsTest.navigateMaterialMain();

		}

		if (MasterMainNavigationsTest.clickMaterialMain) {

			MasterMainNavigationsTest.navigateMaterial();

		}

		if (MasterMainNavigationsTest.clickMaterial) { 

			deleteFunction.clickDelete("Master Module", "Material", "TC-MAT-0080", "MATERIAL");

		}

		Logout.LogoutFunction();
	}

}
