//**********************************************************************************
//* Description
//*------------
//* TC-MAT-0038 - Check Plant "Search" TextBox Functionality
//* TC-MAT-0039 - Check Plant "Search" Button Functionality
//* TC-MAT-0040	- Check Plant "Reset" Button Functionality
//***********************************************************************************
//*
//* Author           :  Sasikala Ambalavanar 
//* Date Written     :  14.07.2023 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-MAT-0038           14.07.2023    Sasikala     
//* TC-MAT-0039
//* TC-MAT-0040
//************************************************************************************

package com.qa.automation.qdms.testcases.material;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.SingleSearch;
import com.qa.automation.qdms.pages.master.MaterialPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.master.MasterMainNavigationsTest;

public class PlantSearchMethodCalling extends DriverIntialization{
	static MaterialPage MaterialPg = new MaterialPage();

	@Test
	public static void SupplierSearchFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, MaterialPg);

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

			PageFactory.initElements(driver, MaterialPg);

			SingleSearch.singleSearchMethod(5, MaterialPage.searchtextbox, "Master Module", "Material", "TC-MAT-0039",
					1, 2);

		}

		Logout.LogoutFunction();
	}

}
