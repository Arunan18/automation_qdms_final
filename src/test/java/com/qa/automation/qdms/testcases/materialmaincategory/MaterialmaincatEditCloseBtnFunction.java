/***********************************************************************************
* Description
*------------
* TC-MATMC-0053--Check  Material Main Category\"Cancel\" Button Functionality
***********************************************************************************
*
* Author           :RAHUL.S
* Date Written     : 26/07/2023 
* 
*
* 
* Test Case Number     Date         AUTHOR        Comments
* ================     ====         =====        ========
* TC-MATMC-0053	     26/07/2023     RAHUL.S     ORIGINAL Version

************************************************************************************/
package com.qa.automation.qdms.testcases.materialmaincategory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.pages.master.MaterialMainCategoryPage;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;
import com.qa.automation.qdms.testcases.material.materialMethodes;

public class MaterialmaincatEditCloseBtnFunction extends DriverIntialization{
	static MaterialMainCategoryPage plntMaMaqPg = new MaterialMainCategoryPage();

	@Test
	public static void deleteCancel() throws InterruptedException {
		PageFactory.initElements(driver, plntMaMaqPg);
		testCase = extent
				.createTest("TC-MATMC-0053--Check  Material Main Category\"Close\" Button Functionality");
		LoginTest.Login();
		if (LoginTest.login) {
			MasterMainNavigationsTest.navigateMaster();
		}
		if (MasterMainNavigationsTest.clickMaster) {
			MasterMainNavigationsTest.clickMaster = false;
			MasterMainNavigationsTest.navigateMaterialMain();

		}
		if (MasterMainNavigationsTest.clickMaterialMain) {
			MasterMainNavigationsTest.clickMaterialMain = false;
			MasterMainNavigationsTest.navigateMaterialMainCategory();
		}
		if (MasterMainNavigationsTest.matmaincat) {
			MasterMainNavigationsTest.matmaincat = false;
			ActionCommonMethod.actionS(0, 4, MaterialMainCategoryPage.materialMainTable, "edit", "Master Module.xlsx",
					"Material Main Category", "TC-MATMC-0053-01", 1);
			materialMethodes.cancelOrCloseButtonFunction(MaterialMainCategoryPage.popclose,
					MaterialMainCategoryPage.addmatpopup, "CHECKING THE edit Close BUTTON", "CHECKING THE POPUP");

		}
		if (LoginTest.login) {
			Logout.LogoutFunction();

		}

	}

}
